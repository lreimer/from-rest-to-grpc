package main

import (
	"context"
	"log"
	"os"
	"time"

	pb "github.com/qaware/from-rest-to-grpc/grpc-beer-client/proto"
	"google.golang.org/grpc"
	"google.golang.org/protobuf/types/known/emptypb"
)

func main() {
	// Set up a connection to the server.
	conn, err := grpc.Dial(address(), grpc.WithInsecure())
	if err != nil {
		log.Fatalf("Could not connect to gRPC beer service: %v", err)
	}
	defer conn.Close()

	client := pb.NewBeerServiceClient(conn)
	ctx, cancel := context.WithTimeout(context.Background(), time.Second)
	defer cancel()

	// get list of all beers
	log.Printf("Getting list of all beers")
	beers, err := client.AllBeers(ctx, &emptypb.Empty{})
	if err != nil {
		log.Fatalf("Could not get all beers: %v", err)
	}
	log.Printf("Beers %s", beers.GetBeers())

	// create a new beer
	log.Printf("Creating new beer")
	_, err = client.CreateBeer(ctx, &pb.CreateBeerRequest{Beer: &pb.Beer{
		Asin:    "B01CJPU3XW",
		Name:    "Blauer August",
		Brand:   "Augustiner Brauerei München",
		Country: "Germany",
		Alcohol: 5.2,
		Type:    pb.Beer_Lager,
	}})
	if err != nil {
		log.Fatalf("Could not create new beer: %v", err)
	}

	// get the new beer
	log.Printf("Getting new beer")
	beer, err := client.GetBeer(ctx, &pb.GetBeerRequest{Asin: "B01CJPU3XW"})
	if err != nil {
		log.Fatalf("Could not get beer: %v", err)
	}
	log.Printf("Beer %s", beer.GetBeer())

	// delete the new beer
	log.Printf("Deleting new beer")
	_, err = client.DeleteBeer(ctx, &pb.DeleteBeerRequest{Asin: "B01CJPU3XW"})
	if err != nil {
		log.Fatalf("Could not delete beer: %v", err)
	}
}

func address() string {
	host := os.Getenv("HOST")
	if len(host) == 0 {
		host = "localhost"
	}

	port := os.Getenv("PORT")
	if len(port) == 0 {
		port = "9090"
	}

	return host + ":" + port
}
