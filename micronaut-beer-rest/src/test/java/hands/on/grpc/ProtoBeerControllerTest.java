package hands.on.grpc;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import hands.on.grpc.BeerProtos.GetBeerRequest;
import io.micronaut.http.client.annotation.*;
import jakarta.inject.Inject;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;

@MicronautTest
public class ProtoBeerControllerTest {

    @Inject
    @Client("/proto")
    HttpClient client;

    @Test
    public void testProtoBeers() throws Exception {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange("/beers").status());
    }

    @Test
    @Disabled("Can get the Protobuf marshalling to work")
    public void testProtoBeer() throws Exception {
        MutableHttpRequest<GetBeerRequest> request = HttpRequest.POST("/beers", 
            BeerProtos.GetBeerRequest.newBuilder().setAsin("B07B2YW1TW").build())
            .accept("application/x-protobuf").contentType("application/x-protobuf");

        HttpResponse<Object> response = client.toBlocking().exchange(request);
        assertEquals(HttpStatus.OK, response.status());
    }
}
