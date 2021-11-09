package main

import (
	"context"
	"net/http"
	"os"

	"github.com/golang/glog"
	"github.com/grpc-ecosystem/grpc-gateway/v2/runtime"
	"google.golang.org/grpc"

	gw "github.com/lreimer/from-rest-to-grpc/grpc-beer-gateway/proto"
)

func main() {
	defer glog.Flush()

	if err := run(); err != nil {
		glog.Fatal(err)
	}
}

func run() error {
	ctx := context.Background()
	ctx, cancel := context.WithCancel(ctx)
	defer cancel()

	// Register gRPC server endpoint
	// Note: Make sure the gRPC server is running properly and accessible
	mux := runtime.NewServeMux()
	opts := []grpc.DialOption{grpc.WithInsecure()}
	err := gw.RegisterBeerServiceHandlerFromEndpoint(ctx, mux, grpcServerEndpoint(), opts)
	if err != nil {
		return err
	}

	// Start HTTP server (and proxy calls to gRPC server endpoint)
	return http.ListenAndServe(port(), mux)
}

func port() string {
	port := os.Getenv("PORT")
	if len(port) == 0 {
		port = "8090"
	}
	return ":" + port
}

func grpcServerEndpoint() string {
	endpoint := os.Getenv("GRPC_SERVER_ENDPOINT")
	if len(endpoint) == 0 {
		endpoint = "localhost:9090"
	}
	return endpoint
}
