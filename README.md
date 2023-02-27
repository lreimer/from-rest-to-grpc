# REST in Peace. Long live gRCP!

Demo repository for different REST to gRPC showcases. It contains several different service implementations as well as matching clients.

## Usage

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

## Maintainer

M.-Leander Reimer (@lreimer), <mario-leander.reimer@qaware.de>

## License

This software is provided under the MIT open source license, read the `LICENSE`
file for details.
