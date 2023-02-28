# REST in Peace. Long live gRCP!

Demo repository for different REST to gRPC showcases. It contains several different service implementations as well as matching clients.

## Running

```shell
# this repo contains several different implementations, choose one

# use Skaffold to spin up the services
skaffold dev --no-prune=false --cache-artifacts=false -f skaffold_quarkus
skaffold dev --no-prune=false --cache-artifacts=false -f skaffold_micronaut
skaffold dev --no-prune=false --cache-artifacts=false -f skaffold_golang

# use Tilt to spin up the services
tilt up -f Tiltfile_quarkus
tilt up -f Tiltfile_micronaut
tilt up -f Tiltfile_golang
```

## Usage

```shell
# call the plain REST service endpoint
http get localhost:18080/api/beers

# call the gRPC service endpoint
grpcurl -plaintext -proto micronaut-beer-grpc/src/main/proto/beer.proto localhost:19090 beer.BeerService/AllBeers

# call the NGINX proxy for the gRPC endpoint
grpcurl -plaintext -proto micronaut-beer-grpc/src/main/proto/beer.proto localhost:18888 beer.BeerService/AllBeers

# call the gRPC gateway service endpoint
http get localhost:18090/api/beers
```

## Maintainer

M.-Leander Reimer (@lreimer), <mario-leander.reimer@qaware.de>

## License

This software is provided under the MIT open source license, read the `LICENSE`
file for details.
