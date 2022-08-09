NAME = grpc-beer-service

default: build

.PHONY: run
run:
	HOST=127.0.0.1 PORT=9090 ./grpc-beer-service

.PHONY: image
image:
	@docker build -t qaware/$(NAME) .

.PHONY: build
build: grpc-beer-service

grpc-beer-service:
	@buf generate
	@go build

.PHONY: clean
clean:
	@rm -f $(NAME)