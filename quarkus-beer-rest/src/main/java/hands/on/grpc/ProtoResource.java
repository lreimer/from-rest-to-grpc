package hands.on.grpc;

import hands.on.grpc.protobuf.ProtocolBufferMediaType;
import io.quarkus.logging.Log;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static hands.on.grpc.BeerProtos.*;

@Path("/proto")
@Consumes(ProtocolBufferMediaType.APPLICATION_PROTOBUF)
@Produces(ProtocolBufferMediaType.APPLICATION_PROTOBUF)
public class ProtoResource {
    @Inject
    BeerRepository repository;

    @POST
    public GetBeersResponse getBeers(GetBeersRequest request) {
        // TODO add individual beers to response
        Log.info("Getting all Protobuf beers");
        return GetBeersResponse.newBuilder().build();
    }

    @POST
    public GetBeerResponse getBeer(GetBeerRequest request) {
        Beer beer = repository.find(request.getAsin());
        return GetBeerResponse.newBuilder()
                .setBeer(BeerProtos.Beer.newBuilder()
                        .setAsin(beer.getAsin())
                        .setName(beer.getName())
                        .setBrand(beer.getBrand())
                        .setCountry(beer.getCountry())
                        .setAlcohol(beer.getAlcohol())
                        .setType(BeerProtos.Beer.BeerType.valueOf(beer.getType().name()))
                ).build();
    }

    @POST
    public Response createBeer(CreateBeerRequest request) {
        // maybe implement mapping using MapStruct
        repository.create(new Beer(
                request.getBeer().getAsin(),
                request.getBeer().getName(),
                request.getBeer().getBrand(),
                request.getBeer().getCountry(),
                request.getBeer().getAlcohol(),
                Beer.Type.valueOf(request.getBeer().getType().name())));
        return Response.ok().build();
    }
}
