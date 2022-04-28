package hands.on.grpc;

import com.google.protobuf.Empty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import jakarta.inject.Singleton;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static hands.on.grpc.BeerProtos.*;

@Singleton
public class BeerGrpcService extends BeerServiceGrpc.BeerServiceImplBase {

    private static Logger logger = LoggerFactory.getLogger(BeerGrpcService.class);

    private Map<String, Beer> beers = new HashMap<>();

    @PostConstruct
    void initialize() {
        beers.put("B079V9ZDNY", Beer.newBuilder().setAsin("B079V9ZDNY").setName("Drunken Sailor").setBrand("CREW Republic").setCountry("Germany").setAlcohol(6.4f).setType(Beer.BeerType.IndianPaleAle).build());
        beers.put("B07B2YW1TW", Beer.newBuilder().setAsin("B07B2YW1TW").setName("Hop Junkie").setBrand("CREW Republic").setCountry("Germany").setAlcohol(3.4f).setType(Beer.BeerType.SessionIpa).build());
        beers.put("B01AU6LWNC", Beer.newBuilder().setAsin("B01AU6LWNC").setName("Edelstoff Exportbier").setBrand("Augustiner Brauerei München").setCountry("Germany").setAlcohol(5.6f).setType(Beer.BeerType.Lager).build());
    }

    @Override
    public void allBeers(Empty request, StreamObserver<GetBeersResponse> responseObserver) {
        logger.info("AllBears gRPC API called");
        GetBeersResponse.Builder builder = GetBeersResponse.newBuilder();
        for (Beer beer : beers.values()) {
            builder.addBeers(beer);
        }

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getBeer(GetBeerRequest request, StreamObserver<GetBeerResponse> responseObserver) {
        logger.info("GetBears gRPC API called");
        Beer beer = beers.get(request.getAsin());
        if (beer == null) {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        } else {
            responseObserver.onNext(GetBeerResponse.newBuilder().setBeer(beer).build());
        }
        responseObserver.onCompleted();

    }

    @Override
    public void createBeer(CreateBeerRequest request, StreamObserver<Empty> responseObserver) {
        logger.info("CreateBear gRPC API called");
        String asin = request.getBeer().getAsin();
        if (beers.containsKey(asin)) {
            responseObserver.onError(new StatusException(Status.ALREADY_EXISTS));
        } else {
            beers.put(asin, request.getBeer());
            responseObserver.onNext(Empty.newBuilder().build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void updateBeer(UpdateBeerRequest request, StreamObserver<Empty> responseObserver) {
        logger.info("UpdateBeer gRPC API called");
        if (beers.containsKey(request.getAsin())) {
            beers.put(request.getAsin(), request.getBeer());
            responseObserver.onNext(Empty.newBuilder().build());
        } else {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        }
        responseObserver.onCompleted();
    }

    @Override
    public void deleteBeer(DeleteBeerRequest request, StreamObserver<Empty> responseObserver) {
        logger.info("DeleteBeer gRPC API called");
        Beer removed = beers.remove(request.getAsin());
        if (removed == null) {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        } else {
            responseObserver.onNext(Empty.newBuilder().build());
        }
        responseObserver.onCompleted();
    }
}
// economics of investment in reliability