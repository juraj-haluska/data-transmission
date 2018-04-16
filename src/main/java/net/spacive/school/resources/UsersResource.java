package net.spacive.school.resources;

import com.codahale.metrics.annotation.Timed;
import net.spacive.school.models.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    private UserProfile getMockUserProfile() {
        return new UserProfile()
                .withFirstName("dfsdfs")
                .withLastName("dfsgfdgd")
                .withId(47);
    }

    @GET
    public Page<UserProfile> getPageOfUsers(@QueryParam("page") Optional<Integer> page) {

        int pageNumber;
        if (page.isPresent()) {
            pageNumber = page.get();
        } else {
            pageNumber = 1;
        }

        List<UserProfile> userProfileList = new ArrayList<>();
        userProfileList.add(getMockUserProfile());

        return new Page<UserProfile>()
                .withPage(pageNumber)
                .withPerPage(13)
                .withTotal(15)
                .withTotalPages(500)
                .withData(userProfileList);
    }

    @GET
    @Path("/{id}")
    public Single<UserProfile> getSingleUSer(@PathParam("id") Integer userId) {
        return new Single<UserProfile>()
                .withData(getMockUserProfile());
    }
}
