NAME = grpc-beer-service

default: build

.PHONY: run
run:
	HOST=127.0.0.1 PORT=9090 ./grpc-beer-service

.PHONY: image
image:
	docker build -t qaware/$(NAME) .

.PHONY: build
build: grpc-beer-service

grpc-beer-service: proto/beer.pb.go
	go build

proto/beer.pb.go:
	buf generate

.PHONY: clean
clean:
	rm proto/*.pb.go
	rm -f $(NAME)