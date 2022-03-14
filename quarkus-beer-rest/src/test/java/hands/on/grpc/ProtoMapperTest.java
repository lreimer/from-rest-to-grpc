package hands.on.grpc;

import org.junit.jupiter.api.Test;

import static hands.on.grpc.Beer.Type.IndianPaleAle;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProtoMapperTest {

    @Test
    void beerToProtoBeer() {
        ProtoMapper mapper = ProtoMapper.INSTANCE;
        BeerProtos.Beer protoBeer = mapper.beerToProtoBeer(new Beer("B079V9ZDNY", "Drunken Sailor", "CREW Republic", "Germany", 6.4f, IndianPaleAle));
        assertEquals("B079V9ZDNY", protoBeer.getAsin());
    }

    @Test
    void protoBeerToBeer() {
        ProtoMapper mapper = ProtoMapper.INSTANCE;
        BeerProtos.Beer protoBeer = BeerProtos.Beer.newBuilder().setAsin("B079V9ZDNY").build();
        Beer beer = mapper.protoBeerToBeer(protoBeer);
        assertEquals("B079V9ZDNY", beer.getAsin());
    }
}