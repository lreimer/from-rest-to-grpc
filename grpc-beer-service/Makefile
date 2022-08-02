NAME = grpc-beer-service

default: build

.PHONY: run
run:
	HOST=127.0.0.1 PORT=9090 ./grpc-beer-service

.PHONY: build
image:
	@docker build -t lreimer/$(NAME) .

.PHONY: build
build: grpc-beer-service

grpc-beer-service:
	@buf generate
	@go build

.PHONY: build
clean:
	@rm -f $(NAME)