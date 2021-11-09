package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
	"os"
)

func main() {
	http.HandleFunc("/", indexHandleFunc)

	http.HandleFunc("/api/beers", beersHandleFunc)
	http.HandleFunc("/api/beers/", beerHandleFunc)

	http.ListenAndServe(port(), nil)
}

func port() string {
	port := os.Getenv("PORT")
	if len(port) == 0 {
		port = "8080"
	}
	return ":" + port
}

func indexHandleFunc(w http.ResponseWriter, r *http.Request) {
	w.WriteHeader(http.StatusOK)
	fmt.Fprintf(w, "REST in Peace. Long live gRPC.")
}

func beersHandleFunc(w http.ResponseWriter, r *http.Request) {
	switch method := r.Method; method {
	case http.MethodGet:
		beers := AllBeers()
		writeJSON(w, beers)
	case http.MethodPost:
		body, err := ioutil.ReadAll(r.Body)
		if err != nil {
			w.WriteHeader(http.StatusInternalServerError)
		}
		beer := readJSON(body)
		asin, created := CreateBeer(beer)
		if created {
			w.Header().Add("Location", "/api/beers/"+asin)
			w.WriteHeader(http.StatusCreated)
		} else {
			w.WriteHeader(http.StatusConflict)
		}
	default:
		w.WriteHeader(http.StatusBadRequest)
		w.Write([]byte("Unsupported request method."))
	}
}

func beerHandleFunc(w http.ResponseWriter, r *http.Request) {
	asin := r.URL.Path[len("/api/beers/"):]

	switch method := r.Method; method {
	case http.MethodGet:
		beer, found := GetBeer(asin)
		if found {
			writeJSON(w, beer)
		} else {
			w.WriteHeader(http.StatusNotFound)
		}
	case http.MethodPut:
		body, err := ioutil.ReadAll(r.Body)
		if err != nil {
			w.WriteHeader(http.StatusInternalServerError)
		}
		beer := readJSON(body)
		exists := UpdateBeer(asin, beer)
		if exists {
			w.WriteHeader(http.StatusOK)
		} else {
			w.WriteHeader(http.StatusNotFound)
		}
	case http.MethodDelete:
		DeleteBeer(asin)
		w.WriteHeader(http.StatusOK)
	default:
		w.WriteHeader(http.StatusBadRequest)
		w.Write([]byte("Unsupported request method."))
	}
}

func readJSON(data []byte) Beer {
	beer := Beer{}
	err := json.Unmarshal(data, &beer)
	if err != nil {
		panic(err)
	}
	return beer
}

func writeJSON(w http.ResponseWriter, i interface{}) {
	b, err := json.Marshal(i)
	if err != nil {
		panic(err)
	}
	w.Header().Add("Content-Type", "application/json; charset=utf-8")
	w.Write(b)
}
