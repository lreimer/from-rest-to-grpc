package hands.on.grpc;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProtoMapper {
    ProtoMapper INSTANCE = Mappers.getMapper(ProtoMapper.class);

    Beer protoBeerToBeer(BeerProtos.Beer beer);

    default Beer.Type protoBeerTypeToBeerType(BeerProtos.Beer.BeerType beerType) {
        return Beer.Type.valueOf(beerType.name());
    }

    BeerProtos.Beer beerToProtoBeer(Beer beer);

    default BeerProtos.Beer.BeerType beerTypeToProtoBeerType(Beer.Type beerType) {
        return BeerProtos.Beer.BeerType.valueOf(beerType.name());
    }
}
