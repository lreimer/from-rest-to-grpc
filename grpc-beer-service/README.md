# Beer gRPC Service

```bash
# for Protocol Buffers we need to install the latest generator
$ go install google.golang.org/protobuf/cmd/protoc-gen-go@latest
$ go install google.golang.org/grpc/cmd/protoc-gen-go-grpc@latest

$ export SRC_DIR=$PWD/proto
$ export DST_DIR=$PWD/proto

# call the protoc compiler to generate the Go files
$ protoc --go_out=$DST_DIR --go_opt=paths=source_relative \
         --go-grpc_out=$DST_DIR --go-grpc_opt=paths=source_relative \
         -I=$SRC_DIR $SRC_DIR/beer.proto

# alternatively, we use the Buf utility to do the same
# see https://buf.build
$ buf generate
```
