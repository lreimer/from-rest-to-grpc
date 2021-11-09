FROM golang:1.17-bullseye as build

WORKDIR /go/src/app
ADD . /go/src/app

RUN go get -d -v ./...
RUN go build -o /go/bin/grpc-beer-service

FROM gcr.io/distroless/base-debian11

ENV HOST=0.0.0.0
ENV PORT=9090

COPY --from=build /go/bin/grpc-beer-service /

CMD ["/grpc-beer-service"]
