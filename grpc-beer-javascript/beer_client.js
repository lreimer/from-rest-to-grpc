const {Empty} = require('./node_modules/google-protobuf/google/protobuf/empty_pb.js')
const {GetBeerRequest, GetBeerResponse} = require('./beer_pb.js')
const {BeerServiceClient} = require('./beer_grpc_web_pb.js')

// use this if we run in browser
// var beerClient = new BeerServiceClient('http://'+window.location.hostname+':18091')

var beerClient = new BeerServiceClient('http://localhost:18091');

var empty = new Empty();
beerClient.allBeers(empty, {}, function(err, response){
    if (err) {
        console.log(err.code);
        console.log(err.message);
    } else {
        console.log(response.getBeersList());
    }
});

var request = new GetBeerRequest();
request.setAsin('B079V9ZDNY')

beerClient.getBeer(request, {}, function(err, response){
    if (err) {
        console.log(err.code);
        console.log(err.message);
    } else {
        console.log(response.getBeer());
    }
});