/**
 * @fileoverview gRPC-Web generated client stub for beer
 * @enhanceable
 * @public
 */

// GENERATED CODE -- DO NOT EDIT!


/* eslint-disable */
// @ts-nocheck



const grpc = {};
grpc.web = require('grpc-web');


var google_protobuf_empty_pb = require('google-protobuf/google/protobuf/empty_pb.js')
const proto = {};
proto.beer = require('./beer_pb.js');

/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?grpc.web.ClientOptions} options
 * @constructor
 * @struct
 * @final
 */
proto.beer.BeerServiceClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options.format = 'text';

  /**
   * @private @const {!grpc.web.GrpcWebClientBase} The client
   */
  this.client_ = new grpc.web.GrpcWebClientBase(options);

  /**
   * @private @const {string} The hostname
   */
  this.hostname_ = hostname;

};


/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?grpc.web.ClientOptions} options
 * @constructor
 * @struct
 * @final
 */
proto.beer.BeerServicePromiseClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options.format = 'text';

  /**
   * @private @const {!grpc.web.GrpcWebClientBase} The client
   */
  this.client_ = new grpc.web.GrpcWebClientBase(options);

  /**
   * @private @const {string} The hostname
   */
  this.hostname_ = hostname;

};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.google.protobuf.Empty,
 *   !proto.beer.GetBeersResponse>}
 */
const methodDescriptor_BeerService_AllBeers = new grpc.web.MethodDescriptor(
  '/beer.BeerService/AllBeers',
  grpc.web.MethodType.UNARY,
  google_protobuf_empty_pb.Empty,
  proto.beer.GetBeersResponse,
  /**
   * @param {!proto.google.protobuf.Empty} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.beer.GetBeersResponse.deserializeBinary
);


/**
 * @param {!proto.google.protobuf.Empty} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.RpcError, ?proto.beer.GetBeersResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.beer.GetBeersResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.beer.BeerServiceClient.prototype.allBeers =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/beer.BeerService/AllBeers',
      request,
      metadata || {},
      methodDescriptor_BeerService_AllBeers,
      callback);
};


/**
 * @param {!proto.google.protobuf.Empty} request The
 *     request proto
 * @param {?Object<string, string>=} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.beer.GetBeersResponse>}
 *     Promise that resolves to the response
 */
proto.beer.BeerServicePromiseClient.prototype.allBeers =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/beer.BeerService/AllBeers',
      request,
      metadata || {},
      methodDescriptor_BeerService_AllBeers);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.beer.GetBeerRequest,
 *   !proto.beer.GetBeerResponse>}
 */
const methodDescriptor_BeerService_GetBeer = new grpc.web.MethodDescriptor(
  '/beer.BeerService/GetBeer',
  grpc.web.MethodType.UNARY,
  proto.beer.GetBeerRequest,
  proto.beer.GetBeerResponse,
  /**
   * @param {!proto.beer.GetBeerRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.beer.GetBeerResponse.deserializeBinary
);


/**
 * @param {!proto.beer.GetBeerRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.RpcError, ?proto.beer.GetBeerResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.beer.GetBeerResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.beer.BeerServiceClient.prototype.getBeer =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/beer.BeerService/GetBeer',
      request,
      metadata || {},
      methodDescriptor_BeerService_GetBeer,
      callback);
};


/**
 * @param {!proto.beer.GetBeerRequest} request The
 *     request proto
 * @param {?Object<string, string>=} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.beer.GetBeerResponse>}
 *     Promise that resolves to the response
 */
proto.beer.BeerServicePromiseClient.prototype.getBeer =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/beer.BeerService/GetBeer',
      request,
      metadata || {},
      methodDescriptor_BeerService_GetBeer);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.beer.CreateBeerRequest,
 *   !proto.google.protobuf.Empty>}
 */
const methodDescriptor_BeerService_CreateBeer = new grpc.web.MethodDescriptor(
  '/beer.BeerService/CreateBeer',
  grpc.web.MethodType.UNARY,
  proto.beer.CreateBeerRequest,
  google_protobuf_empty_pb.Empty,
  /**
   * @param {!proto.beer.CreateBeerRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  google_protobuf_empty_pb.Empty.deserializeBinary
);


/**
 * @param {!proto.beer.CreateBeerRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.RpcError, ?proto.google.protobuf.Empty)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.google.protobuf.Empty>|undefined}
 *     The XHR Node Readable Stream
 */
proto.beer.BeerServiceClient.prototype.createBeer =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/beer.BeerService/CreateBeer',
      request,
      metadata || {},
      methodDescriptor_BeerService_CreateBeer,
      callback);
};


/**
 * @param {!proto.beer.CreateBeerRequest} request The
 *     request proto
 * @param {?Object<string, string>=} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.google.protobuf.Empty>}
 *     Promise that resolves to the response
 */
proto.beer.BeerServicePromiseClient.prototype.createBeer =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/beer.BeerService/CreateBeer',
      request,
      metadata || {},
      methodDescriptor_BeerService_CreateBeer);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.beer.UpdateBeerRequest,
 *   !proto.google.protobuf.Empty>}
 */
const methodDescriptor_BeerService_UpdateBeer = new grpc.web.MethodDescriptor(
  '/beer.BeerService/UpdateBeer',
  grpc.web.MethodType.UNARY,
  proto.beer.UpdateBeerRequest,
  google_protobuf_empty_pb.Empty,
  /**
   * @param {!proto.beer.UpdateBeerRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  google_protobuf_empty_pb.Empty.deserializeBinary
);


/**
 * @param {!proto.beer.UpdateBeerRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.RpcError, ?proto.google.protobuf.Empty)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.google.protobuf.Empty>|undefined}
 *     The XHR Node Readable Stream
 */
proto.beer.BeerServiceClient.prototype.updateBeer =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/beer.BeerService/UpdateBeer',
      request,
      metadata || {},
      methodDescriptor_BeerService_UpdateBeer,
      callback);
};


/**
 * @param {!proto.beer.UpdateBeerRequest} request The
 *     request proto
 * @param {?Object<string, string>=} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.google.protobuf.Empty>}
 *     Promise that resolves to the response
 */
proto.beer.BeerServicePromiseClient.prototype.updateBeer =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/beer.BeerService/UpdateBeer',
      request,
      metadata || {},
      methodDescriptor_BeerService_UpdateBeer);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.beer.DeleteBeerRequest,
 *   !proto.google.protobuf.Empty>}
 */
const methodDescriptor_BeerService_DeleteBeer = new grpc.web.MethodDescriptor(
  '/beer.BeerService/DeleteBeer',
  grpc.web.MethodType.UNARY,
  proto.beer.DeleteBeerRequest,
  google_protobuf_empty_pb.Empty,
  /**
   * @param {!proto.beer.DeleteBeerRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  google_protobuf_empty_pb.Empty.deserializeBinary
);


/**
 * @param {!proto.beer.DeleteBeerRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.RpcError, ?proto.google.protobuf.Empty)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.google.protobuf.Empty>|undefined}
 *     The XHR Node Readable Stream
 */
proto.beer.BeerServiceClient.prototype.deleteBeer =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/beer.BeerService/DeleteBeer',
      request,
      metadata || {},
      methodDescriptor_BeerService_DeleteBeer,
      callback);
};


/**
 * @param {!proto.beer.DeleteBeerRequest} request The
 *     request proto
 * @param {?Object<string, string>=} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.google.protobuf.Empty>}
 *     Promise that resolves to the response
 */
proto.beer.BeerServicePromiseClient.prototype.deleteBeer =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/beer.BeerService/DeleteBeer',
      request,
      metadata || {},
      methodDescriptor_BeerService_DeleteBeer);
};


module.exports = proto.beer;

