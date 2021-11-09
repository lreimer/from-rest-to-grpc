NAME = grpc-beer-gateway

default: build

image:
	@docker build -t lreimer/$(NAME) .

build:
	@buf generate
	@go build 

clean:
	@rm -f $(NAME)