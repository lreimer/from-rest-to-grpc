package main

import (
	"log"
	"net"
	"os"

	pb "github.com/qaware/from-rest-to-grpc/grpc-beer-service/proto"
	"google.golang.org/grpc"
)

func main() {
	lis, err := net.Listen("tcp", address())
	if err != nil {
		log.Fatalf("Failed to listen at %v", err)
	}

	s := grpc.NewServer()
	pb.RegisterBeerServiceServer(s, &Server{})

	log.Printf("gRPC Beer service listening at %v", lis.Addr())
	if err := s.Serve(lis); err != nil {
		log.Fatalf("Failed to serve %v", err)
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
