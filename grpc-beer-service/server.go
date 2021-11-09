package main

import (
	"context"

	pb "github.com/lreimer/from-rest-to-grpc/grpc-beer-service/proto"
	"google.golang.org/protobuf/types/known/emptypb"
)

type Server struct {
	pb.UnimplementedBeerServiceServer
}

// Get the list of all beers
func (s *Server) GetBeers(context.Context, *emptypb.Empty) (*pb.GetBeersResponse, error) {
	return &pb.GetBeersResponse{}, nil
}

// Get a single beer by Asin
func (s *Server) GetBeer(context.Context, *pb.GetBeerRequest) (*pb.GetBeerResponse, error) {
	return &pb.GetBeerResponse{}, nil
}

// Create a new beer
func (s *Server) CreateBeer(context.Context, *pb.CreateBeerRequest) (*emptypb.Empty, error) {
	return &emptypb.Empty{}, nil
}

// Update an existing beer
func (s *Server) UpdateBeer(context.Context, *pb.UpdateBeerRequest) (*emptypb.Empty, error) {
	return &emptypb.Empty{}, nil
}

// Delete an existing beeer
func (s *Server) DeleteBeer(context.Context, *pb.DeleteBeerRequest) (*emptypb.Empty, error) {
	return &emptypb.Empty{}, nil
}
