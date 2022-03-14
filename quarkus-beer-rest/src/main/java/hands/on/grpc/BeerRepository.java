package hands.on.grpc;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static hands.on.grpc.Beer.Type.*;

@ApplicationScoped
public class BeerRepository {

    Map<String, Beer> beers = new HashMap<>();

    public BeerRepository() {
    }

    @PostConstruct
    public void initialize() {
        beers.put("B079V9ZDNY", new Beer("B079V9ZDNY", "Drunken Sailor", "CREW Republic", "Germany", 6.4f, IndianPaleAle));
        beers.put("B07B2YW1TW", new Beer("B07B2YW1TW", "Hop Junkie", "CREW Republic", "Germany", 3.4f, SessionIpa));
        beers.put("B01AU6LWNC", new Beer("B01AU6LWNC", "Edelstoff Exportbier", "Augustiner Brauerei München", "Germany", 5.6f, Lager));
    }

    public Collection<Beer> all() {
        return beers.values();
    }

    public String create(Beer beer) {
        String asin = beer.getAsin();
        if (beers.containsKey(asin)) {
            throw new WebApplicationException("Beer already exists.", Response.Status.CONFLICT);
        }
        beers.put(asin, beer);
        return asin;
    }


    public Beer find(String asin) {
        Beer beer = beers.get(asin);
        if (beer == null) {
            throw new NotFoundException("Beer not found");
        }
        return beer;
    }

    public void update(String asin, Beer beer) {
        beers.put(asin, beer);
    }


    public void delete(String asin) {
        Beer beer = beers.remove(asin);
        if (beer == null) {
            throw new NotFoundException("Beer not found");
        }
    }
}
