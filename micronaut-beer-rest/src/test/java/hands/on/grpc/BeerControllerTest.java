package hands.on.grpc;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import io.micronaut.http.client.annotation.*;
import jakarta.inject.Inject;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class BeerControllerTest {

    @Inject
    @Client("/api")
    HttpClient client;

    @Test
    public void testBeers() throws Exception {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange("/beers").status());
    }
}
