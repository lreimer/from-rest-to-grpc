package hands.on.grpc;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Objects;

@Path("/beers")
public class BeerResource {

    @Inject
    BeerRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response all() {
        return Response.ok(repository.all()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Beer beer) {
        String asin = repository.create(beer);
        URI location = UriBuilder.fromResource(BeerResource.class)
                .path("/{asin}")
                .resolveTemplate("asin", asin)
                .build();
        return Response.created(location).build();
    }

    @GET
    @Path("/{asin}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("asin") String asin) {
        Beer beer = repository.find(asin);
        return Response.ok(beer).build();
    }

    @PUT
    @Path("/{asin}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("asin") String asin, Beer beer) {
        if (!Objects.equals(asin, beer.getAsin())) {
            // return Response.status(Response.Status.BAD_REQUEST).build();
            // throw new WebApplicationException("ASIN must match path parameter.", Response.Status.BAD_REQUEST);
            throw new BadRequestException("ASIN must match path parameter.");
        }
        repository.update(asin, beer);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{asin}")
    public Response delete(@PathParam("asin") String asin) {
        repository.delete(asin);
        return Response.ok().build();
    }
}