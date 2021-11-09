package main

// Beer type as string enum
type BeerType string

const (
	IndianPaleAle BeerType = "IPA"
	SessionIpa    BeerType = "SessionIPA"
	Lager         BeerType = "Lager"
)

// Beer structure with ASIN, Name, Country and Alcohol
type Beer struct {
	ASIN    string   `json:"asin"`
	Name    string   `json:"name"`
	Brand   string   `json:"brand"`
	Country string   `json:"country"`
	Alcohol float32  `json:"alcohol"`
	Type    BeerType `json:"type"`
}

var beers = map[string]Beer{
	"B079V9ZDNY": {ASIN: "B079V9ZDNY", Name: "Drunken Sailor", Brand: "CREW Republic", Country: "Germany", Alcohol: 6.4, Type: IndianPaleAle},
	"B07B2YW1TW": {ASIN: "B07B2YW1TW", Name: "Hop Junkie", Brand: "CREW Republic", Country: "Germany", Alcohol: 3.4, Type: SessionIpa},
	"B01AU6LWNC": {ASIN: "B01AU6LWNC", Name: "Edelstoff Exportbier", Brand: "Augustiner Brauerei München", Country: "Germany", Alcohol: 5.6, Type: Lager},
}

// AllBeers returns a slice of all Beers
func AllBeers() []Beer {
	values := make([]Beer, len(beers))
	idx := 0
	for _, beer := range beers {
		values[idx] = beer
		idx++
	}
	return values
}

// GetBeer returns the beer for a given ASIN
func GetBeer(asin string) (Beer, bool) {
	beer, found := beers[asin]
	return beer, found
}

// CreateBeer creates a new Beer if it does not exist
func CreateBeer(beer Beer) (string, bool) {
	_, exists := beers[beer.ASIN]
	if exists {
		return "", false
	}
	beers[beer.ASIN] = beer
	return beer.ASIN, true
}

// UpdateBeer updates an existing beer
func UpdateBeer(asin string, beer Beer) bool {
	_, exists := beers[asin]
	if exists {
		beers[asin] = beer
	}
	return exists
}

// DeleteBeer removes a beer from the map by ASIN key
func DeleteBeer(asin string) {
	delete(beers, asin)
}
