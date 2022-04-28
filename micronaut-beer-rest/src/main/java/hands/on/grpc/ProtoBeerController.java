package hands.on.grpc;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import static hands.on.grpc.BeerProtos.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hands.on.grpc.BeerProtos.GetBeerResponse;

@Controller("/proto")
public class ProtoBeerController {

    private static Logger logger = LoggerFactory.getLogger(ProtoBeerController.class);

    @Inject
    BeerRepository repository;

    @Get(uri = "/beers", produces = "application/x-protobuf")
    public HttpResponse<GetBeersResponse> beers() {        
        logger.info("GetProtoBeers() REST API called");
        return HttpResponse.ok(GetBeersResponse.newBuilder().build())
            .contentType("application/x-protobuf");
    }

    @Post(uri = "/beers", produces = "application/x-protobuf", consumes = "application/x-protobuf")
    public HttpResponse<GetBeerResponse> getBeer(GetBeerRequest request) {
        Beer beer = repository.find(request.getAsin());
        GetBeerResponse response = GetBeerResponse.newBuilder()
                .setBeer(BeerProtos.Beer.newBuilder()
                        .setAsin(beer.getAsin())
                        .setName(beer.getName())
                        .setBrand(beer.getBrand())
                        .setCountry(beer.getCountry())
                        .setAlcohol(beer.getAlcohol())
                        .setType(BeerProtos.Beer.BeerType.valueOf(beer.getType().name()))
                ).build();
        return HttpResponse.ok(response).contentType("application/x-protobuf");
    }
}