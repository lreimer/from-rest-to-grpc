import * as grpcWeb from 'grpc-web';

import * as beer_pb from './beer_pb';
import * as google_protobuf_empty_pb from 'google-protobuf/google/protobuf/empty_pb';


export class BeerServiceClient {
  constructor (hostname: string,
               credentials?: null | { [index: string]: string; },
               options?: null | { [index: string]: any; });

  allBeers(
    request: google_protobuf_empty_pb.Empty,
    metadata: grpcWeb.Metadata | undefined,
    callback: (err: grpcWeb.RpcError,
               response: beer_pb.GetBeersResponse) => void
  ): grpcWeb.ClientReadableStream<beer_pb.GetBeersResponse>;

  getBeer(
    request: beer_pb.GetBeerRequest,
    metadata: grpcWeb.Metadata | undefined,
    callback: (err: grpcWeb.RpcError,
               response: beer_pb.GetBeerResponse) => void
  ): grpcWeb.ClientReadableStream<beer_pb.GetBeerResponse>;

  createBeer(
    request: beer_pb.CreateBeerRequest,
    metadata: grpcWeb.Metadata | undefined,
    callback: (err: grpcWeb.RpcError,
               response: google_protobuf_empty_pb.Empty) => void
  ): grpcWeb.ClientReadableStream<google_protobuf_empty_pb.Empty>;

  updateBeer(
    request: beer_pb.UpdateBeerRequest,
    metadata: grpcWeb.Metadata | undefined,
    callback: (err: grpcWeb.RpcError,
               response: google_protobuf_empty_pb.Empty) => void
  ): grpcWeb.ClientReadableStream<google_protobuf_empty_pb.Empty>;

  deleteBeer(
    request: beer_pb.DeleteBeerRequest,
    metadata: grpcWeb.Metadata | undefined,
    callback: (err: grpcWeb.RpcError,
               response: google_protobuf_empty_pb.Empty) => void
  ): grpcWeb.ClientReadableStream<google_protobuf_empty_pb.Empty>;

}

export class BeerServicePromiseClient {
  constructor (hostname: string,
               credentials?: null | { [index: string]: string; },
               options?: null | { [index: string]: any; });

  allBeers(
    request: google_protobuf_empty_pb.Empty,
    metadata?: grpcWeb.Metadata
  ): Promise<beer_pb.GetBeersResponse>;

  getBeer(
    request: beer_pb.GetBeerRequest,
    metadata?: grpcWeb.Metadata
  ): Promise<beer_pb.GetBeerResponse>;

  createBeer(
    request: beer_pb.CreateBeerRequest,
    metadata?: grpcWeb.Metadata
  ): Promise<google_protobuf_empty_pb.Empty>;

  updateBeer(
    request: beer_pb.UpdateBeerRequest,
    metadata?: grpcWeb.Metadata
  ): Promise<google_protobuf_empty_pb.Empty>;

  deleteBeer(
    request: beer_pb.DeleteBeerRequest,
    metadata?: grpcWeb.Metadata
  ): Promise<google_protobuf_empty_pb.Empty>;

}

