package net.spacive.school.resources;

import net.spacive.school.models.Page;
import net.spacive.school.models.Single;
import net.spacive.school.models.Unknown;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/api/unknown")
@Produces(MediaType.APPLICATION_JSON)
public class UnknownResource {

    private Unknown getMockUnknownResource() {
        return new Unknown()
                .withColor("red")
                .withId(45)
                .withName("fsdfsdf")
                .withPantoneValue("dsfsdfdsf")
                .withYear(78);
    }

    @GET
    public Page<Unknown> getPageOfUnknowns(@QueryParam("page") Integer page) {

        List<Unknown> unknowns = new ArrayList<>();
        unknowns.add(getMockUnknownResource());
        return new Page<Unknown>()
                .withTotalPages(45)
                .withTotal(78)
                .withData(unknowns)
                .withPage(12)
                .withPerPage(23);
    }

    @GET
    @Path("/{id}")
    public Single<Unknown> getSingleUnknown(@PathParam("id") Optional<Integer> unknownId) {
        if (unknownId.get().equals(23)) throw new WebApplicationException(Response.Status.NOT_FOUND);
        return new Single<Unknown>()
                .withData(getMockUnknownResource());
    }
}
