FROM golang:1.17-bullseye as build

WORKDIR /go/src/app
ADD . /go/src/app

RUN go get -d -v ./...
RUN go build -o /go/bin/rest-beer-golang

FROM gcr.io/distroless/base-debian11
ENV PORT=8081
COPY --from=build /go/bin/rest-beer-golang /
CMD ["/rest-beer-golang"]
