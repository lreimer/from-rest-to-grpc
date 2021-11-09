FROM golang:1.17-bullseye as build

WORKDIR /go/src/app
ADD . /go/src/app

RUN go get -d -v ./...
RUN go build -o /go/bin/grpc-beer-gateway

FROM gcr.io/distroless/base-debian11

ENV GRPC_SERVER_ENDPOINT=grpc-beer-service:9090
ENV PORT=8090

COPY --from=build /go/bin/grpc-beer-gateway /

CMD ["/grpc-beer-gateway"]
