NAME = rest-beer-service

default: build

image:
	@docker build -t lreimer/$(NAME) .

build:
	@go build 

clean:
	@rm -f $(NAME)