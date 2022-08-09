NAME = rest-beer-golang

default: build

image:
	@docker build -t qaware/$(NAME) .

build:
	@go build 

clean:
	@rm -f $(NAME)