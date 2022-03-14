package hands.on.grpc;

import com.google.protobuf.Empty;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class BeerGrpcServiceTest {

    @GrpcClient("beer")
    BeerServiceGrpc.BeerServiceBlockingStub client;

    @Test
    public void testAllBeers() {
        BeerProtos.GetBeersResponse allBeers = client.allBeers(Empty.newBuilder().build());
        assertEquals(3, allBeers.getBeersCount());
    }

}
