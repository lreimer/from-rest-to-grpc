package main

// Beer type with ASIN, Name, Country and Alcohol
type Beer struct {
	ASIN    string `json:"asin"`
	Name    string `json:"name"`
	Country string `json:"country"`
	Alcohol int    `json:"alcohol"`
}

var beers = map[string]Beer{
	"B00N3P44OM": {ASIN: "B00N3P44OM", Name: "Windspiel Premium Dry Gin", Country: "Germany", Alcohol: 47},
	"B00IE97JCQ": {ASIN: "B00IE97JCQ", Name: "Granit Bavarian Gin", Country: "Germany", Alcohol: 42},
	"B00A0DF494": {ASIN: "B00A0DF494", Name: "Gin Mare", Country: "Spain", Alcohol: 43},
}

// AllBeers returns a slice of all Beers
func AllBeers() []Beer {
	values := make([]Beer, len(beers))
	idx := 0
	for _, spirit := range beers {
		values[idx] = spirit
		idx++
	}
	return values
}

// GetBeer returns the beer for a given ASIN
func GetBeer(asin string) (Beer, bool) {
	spirit, found := beers[asin]
	return spirit, found
}

// CreateBeer creates a new Beer if it does not exist
func CreateBeer(spirit Beer) (string, bool) {
	_, exists := beers[spirit.ASIN]
	if exists {
		return "", false
	}
	beers[spirit.ASIN] = spirit
	return spirit.ASIN, true
}

// UpdateBeer updates an existing beer
func UpdateBeer(asin string, spirit Beer) bool {
	_, exists := beers[asin]
	if exists {
		beers[asin] = spirit
	}
	return exists
}

// DeleteBeer removes a beer from the map by ASIN key
func DeleteBeer(asin string) {
	delete(beers, asin)
}
