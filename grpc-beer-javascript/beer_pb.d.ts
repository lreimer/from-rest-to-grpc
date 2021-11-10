import * as jspb from 'google-protobuf'

import * as google_protobuf_empty_pb from 'google-protobuf/google/protobuf/empty_pb';


export class Beer extends jspb.Message {
  getAsin(): string;
  setAsin(value: string): Beer;

  getName(): string;
  setName(value: string): Beer;

  getBrand(): string;
  setBrand(value: string): Beer;

  getCountry(): string;
  setCountry(value: string): Beer;

  getAlcohol(): number;
  setAlcohol(value: number): Beer;

  getType(): Beer.BeerType;
  setType(value: Beer.BeerType): Beer;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Beer.AsObject;
  static toObject(includeInstance: boolean, msg: Beer): Beer.AsObject;
  static serializeBinaryToWriter(message: Beer, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Beer;
  static deserializeBinaryFromReader(message: Beer, reader: jspb.BinaryReader): Beer;
}

export namespace Beer {
  export type AsObject = {
    asin: string,
    name: string,
    brand: string,
    country: string,
    alcohol: number,
    type: Beer.BeerType,
  }

  export enum BeerType { 
    INDIANPALEALE = 0,
    SESSIONIPA = 1,
    LAGER = 2,
  }
}

export class GetBeersResponse extends jspb.Message {
  getBeersList(): Array<Beer>;
  setBeersList(value: Array<Beer>): GetBeersResponse;
  clearBeersList(): GetBeersResponse;
  addBeers(value?: Beer, index?: number): Beer;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): GetBeersResponse.AsObject;
  static toObject(includeInstance: boolean, msg: GetBeersResponse): GetBeersResponse.AsObject;
  static serializeBinaryToWriter(message: GetBeersResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): GetBeersResponse;
  static deserializeBinaryFromReader(message: GetBeersResponse, reader: jspb.BinaryReader): GetBeersResponse;
}

export namespace GetBeersResponse {
  export type AsObject = {
    beersList: Array<Beer.AsObject>,
  }
}

export class GetBeerRequest extends jspb.Message {
  getAsin(): string;
  setAsin(value: string): GetBeerRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): GetBeerRequest.AsObject;
  static toObject(includeInstance: boolean, msg: GetBeerRequest): GetBeerRequest.AsObject;
  static serializeBinaryToWriter(message: GetBeerRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): GetBeerRequest;
  static deserializeBinaryFromReader(message: GetBeerRequest, reader: jspb.BinaryReader): GetBeerRequest;
}

export namespace GetBeerRequest {
  export type AsObject = {
    asin: string,
  }
}

export class GetBeerResponse extends jspb.Message {
  getBeer(): Beer | undefined;
  setBeer(value?: Beer): GetBeerResponse;
  hasBeer(): boolean;
  clearBeer(): GetBeerResponse;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): GetBeerResponse.AsObject;
  static toObject(includeInstance: boolean, msg: GetBeerResponse): GetBeerResponse.AsObject;
  static serializeBinaryToWriter(message: GetBeerResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): GetBeerResponse;
  static deserializeBinaryFromReader(message: GetBeerResponse, reader: jspb.BinaryReader): GetBeerResponse;
}

export namespace GetBeerResponse {
  export type AsObject = {
    beer?: Beer.AsObject,
  }
}

export class CreateBeerRequest extends jspb.Message {
  getBeer(): Beer | undefined;
  setBeer(value?: Beer): CreateBeerRequest;
  hasBeer(): boolean;
  clearBeer(): CreateBeerRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): CreateBeerRequest.AsObject;
  static toObject(includeInstance: boolean, msg: CreateBeerRequest): CreateBeerRequest.AsObject;
  static serializeBinaryToWriter(message: CreateBeerRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): CreateBeerRequest;
  static deserializeBinaryFromReader(message: CreateBeerRequest, reader: jspb.BinaryReader): CreateBeerRequest;
}

export namespace CreateBeerRequest {
  export type AsObject = {
    beer?: Beer.AsObject,
  }
}

export class UpdateBeerRequest extends jspb.Message {
  getAsin(): string;
  setAsin(value: string): UpdateBeerRequest;

  getBeer(): Beer | undefined;
  setBeer(value?: Beer): UpdateBeerRequest;
  hasBeer(): boolean;
  clearBeer(): UpdateBeerRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): UpdateBeerRequest.AsObject;
  static toObject(includeInstance: boolean, msg: UpdateBeerRequest): UpdateBeerRequest.AsObject;
  static serializeBinaryToWriter(message: UpdateBeerRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): UpdateBeerRequest;
  static deserializeBinaryFromReader(message: UpdateBeerRequest, reader: jspb.BinaryReader): UpdateBeerRequest;
}

export namespace UpdateBeerRequest {
  export type AsObject = {
    asin: string,
    beer?: Beer.AsObject,
  }
}

export class DeleteBeerRequest extends jspb.Message {
  getAsin(): string;
  setAsin(value: string): DeleteBeerRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): DeleteBeerRequest.AsObject;
  static toObject(includeInstance: boolean, msg: DeleteBeerRequest): DeleteBeerRequest.AsObject;
  static serializeBinaryToWriter(message: DeleteBeerRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): DeleteBeerRequest;
  static deserializeBinaryFromReader(message: DeleteBeerRequest, reader: jspb.BinaryReader): DeleteBeerRequest;
}

export namespace DeleteBeerRequest {
  export type AsObject = {
    asin: string,
  }
}

