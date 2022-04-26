package hands.on.grpc;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class BeerResourceTest {

    @Test
    public void testBeerEndpoint() {
        given()
                .when().get("/api/beers")
                .then()
                .statusCode(200);
    }

}