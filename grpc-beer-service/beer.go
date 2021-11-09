package main

import (
	pb "github.com/lreimer/from-rest-to-grpc/grpc-beer-service/proto"
)

var beers = map[string]*pb.Beer{
	"B079V9ZDNY": {Asin: "B079V9ZDNY", Name: "Drunken Sailor", Brand: "CREW Republic", Country: "Germany", Alcohol: 6.4, Type: pb.Beer_IndianPaleAle},
	"B07B2YW1TW": {Asin: "B07B2YW1TW", Name: "Hop Junkie", Brand: "CREW Republic", Country: "Germany", Alcohol: 3.4, Type: pb.Beer_SessionIpa},
	"B01AU6LWNC": {Asin: "B01AU6LWNC", Name: "Edelstoff Exportbier", Brand: "Augustiner Brauerei München", Country: "Germany", Alcohol: 5.6, Type: pb.Beer_Lager},
}

// AllBeers returns a slice of all Beers
func allBeers() []*pb.Beer {
	values := make([]*pb.Beer, len(beers))
	idx := 0
	for _, beer := range beers {
		values[idx] = beer
		idx++
	}
	return values
}

// GetBeer returns the beer for a given ASIN
func getBeer(asin string) (*pb.Beer, bool) {
	beer, found := beers[asin]
	return beer, found
}

// CreateBeer creates a new Beer if it does not exist
func createBeer(beer *pb.Beer) (string, bool) {
	_, exists := beers[beer.Asin]
	if exists {
		return beer.Asin, false
	}
	beers[beer.Asin] = beer
	return beer.Asin, true
}

// UpdateBeer updates an existing beer
func updateBeer(asin string, beer *pb.Beer) bool {
	_, exists := beers[asin]
	if exists {
		beers[asin] = beer
	}
	return exists
}

// DeleteBeer removes a beer from the map by ASIN key
func deleteBeer(asin string) {
	delete(beers, asin)
}
