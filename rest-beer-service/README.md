# Beer REST Service with Gin Framework

More sophisticated REST service implemented in Golang using the Gin Framework.

```bash
# for Protocol Buffers we need to install the latest generator
$ go install google.golang.org/protobuf/cmd/protoc-gen-go@latest

$ export SRC_DIR=$PWD/proto
$ export DST_DIR=$PWD/proto

# call the protoc compiler to generate the Go files
$ protoc -I=$SRC_DIR --go_out=$DST_DIR $SRC_DIR/beer.proto

# alternatively, we use the Buf utility to do the same
# see https://buf.build
```