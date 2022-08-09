NAME = grpc-beer-client

default: build

image:
	@docker build -t qaware/$(NAME) .

build:
	@buf generate
	@go build 

clean:
	@rm -f $(NAME)