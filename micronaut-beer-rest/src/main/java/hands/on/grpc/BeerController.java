package hands.on.grpc;

import java.util.Collection;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

@Controller("/api")
public class BeerController {

    private static Logger logger = LoggerFactory.getLogger(BeerController.class);

    @Inject
    BeerRepository repository;

    @Get(uri = "/beers", produces = "application/json")
    public Collection<Beer> beers() {
        logger.info("GetBeers() REST API called");
        return repository.all();
    }
    
    @Post(uri = "/beers", consumes = "application/json")
    public HttpResponse<String> create(@Body Beer beer) {
        logger.info("CreateBeer() REST API called");
        String asin = repository.create(beer);
        return HttpResponse.created("/api/beers/" + asin);
    }

    @Get(uri = "/beers/{asin}", produces = "application/json")
    public HttpResponse<Beer> get(String asin) {
        logger.info("GetBeer() REST API called");
        Beer beer = repository.find(asin);
        return HttpResponse.ok(beer);
    }

    @Put(uri = "/beers/{asin}", produces = "application/json", consumes = "application/json")
    public HttpResponse<String> update(String asin, @Body Beer beer) {
        logger.info("UpdateBeer() REST API called");
        if (!Objects.equals(asin, beer.getAsin())) {
            return HttpResponse.badRequest();
        }
        repository.update(asin, beer);
        return HttpResponse.ok();
    }

    @Delete(uri = "/beers/{asin}")
    public HttpResponse<String> delete(String asin) {
        logger.info("DeleteBeer() REST API called");
        repository.delete(asin);
        return HttpResponse.ok();
    }
}