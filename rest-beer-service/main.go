package main

import (
	"net/http"
	"os"

	"github.com/gin-gonic/gin"
	"github.com/qaware/from-rest-to-grpc/rest-beer-service/proto"
)

func main() {
	engine := gin.Default()

	// configuration for static files and templates
	engine.LoadHTMLFiles("templates/index.html")
	engine.StaticFile("/favicon.ico", "favicon.ico")

	engine.GET("/", func(c *gin.Context) {
		c.HTML(http.StatusOK, "index.html", gin.H{
			"title": "Beer REST Service",
		})
	})

	engine.GET("/api/beers", allBeers)            // get list of beers
	engine.POST("/api/beers", createBeer)         // create new beer
	engine.GET("/api/beers/:asin", getBeer)       // get beer by ASIN
	engine.PUT("/api/beers/:asin", updateBeer)    // update existing beer
	engine.DELETE("/api/beers/:asin", deleteBeer) // delete beer

	engine.Run(port())
}

func port() string {
	port := os.Getenv("PORT")
	if len(port) == 0 {
		port = "8080"
	}
	return ":" + port
}

func allBeers(c *gin.Context) {
	beers := AllBeers()
	c.JSON(http.StatusOK, gin.H{"beers": beers})
}

func createBeer(c *gin.Context) {
	var beer Beer
	if c.BindJSON(&beer) == nil {
		asin, created := CreateBeer(beer)
		if created {
			c.Header("Location", "/api/beers/"+asin)
			c.Status(http.StatusCreated)
		} else {
			c.Status(http.StatusConflict)
		}
	}
}

func getBeer(c *gin.Context) {
	asin := c.Params.ByName("asin")
	beer, found := GetBeer(asin)
	if found {
		if c.Request.Header.Get("Accept") == "application/x-protobuf" {
			pbeer := &proto.Beer{
				Asin:    beer.ASIN,
				Name:    beer.Name,
				Brand:   beer.Brand,
				Country: beer.Country,
				Alcohol: beer.Alcohol,
				Type:    proto.Beer_BeerType(proto.Beer_BeerType_value[string(beer.Type)]),
			}
			c.ProtoBuf(http.StatusOK, &proto.GetBeerResponse{Beer: pbeer})
		} else {
			c.JSON(http.StatusOK, beer)
		}

	} else {
		c.AbortWithStatus(http.StatusNotFound)
	}
}

func updateBeer(c *gin.Context) {
	asin := c.Params.ByName("asin")

	var beer Beer
	if c.BindJSON(&beer) == nil {
		exists := UpdateBeer(asin, beer)
		if exists {
			c.Status(http.StatusOK)
		} else {
			c.Status(http.StatusNotFound)
		}
	}
}

func deleteBeer(c *gin.Context) {
	asin := c.Params.ByName("asin")
	DeleteBeer(asin)
	c.Status(http.StatusOK)
}
