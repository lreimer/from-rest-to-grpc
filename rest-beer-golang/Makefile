NAME = rest-beer-golang

default: build

image:
	@docker build -t lreimer/$(NAME) .

build:
	@go build 

clean:
	@rm -f $(NAME)