package hands.on.grpc;

import hands.on.grpc.protobuf.ProtocolBufferMediaType;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ProtoResourceTest {

    @Test
    public void testBeersEndpoint() {
        given()
                .contentType(ProtocolBufferMediaType.APPLICATION_PROTOBUF)
                .accept(ProtocolBufferMediaType.APPLICATION_PROTOBUF)
                .body(BeerProtos.GetBeersRequest.newBuilder().build().toByteArray())
                .when().post("/api/proto")
                .then()
                .statusCode(200);
    }

}