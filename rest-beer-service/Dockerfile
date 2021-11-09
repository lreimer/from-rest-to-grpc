FROM golang:1.17-bullseye as build

WORKDIR /go/src/app
ADD . /go/src/app

RUN go get -d -v ./...
RUN go build -o /go/bin/rest-beer-service

# Now copy it into our base image.
FROM gcr.io/distroless/base-debian11

ENV GIN_MODE=release
ENV PORT=8080

COPY --from=build /go/src/app/templates /
COPY --from=build /go/src/app/favicon.ico /
COPY --from=build /go/bin/rest-beer-service /

CMD ["/rest-beer-service"]
