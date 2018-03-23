package net.spacive.school;

import net.spacive.school.models.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface ReqresService {

    @GET("users")
    Call<Page<UserProfile>> listUsers(@Query("page") int page);

    @GET("users/{id}")
    Call<Single<UserProfile>> singleUser(@Path("id") int userId);

    @GET("unknown")
    Call<Page<Resource>> listResources(@Query("page") int page);

    @GET("unknown/{id}")
    Call<Single<Resource>> singleResource(@Path("id") int userId);

    @POST("users")
    Call<User> createUser(@Body User user);

    // or @PATCH("users/{id}")
    @PUT("users/{id}")
    Call<User> updateUser(@Path("id") int userId, @Body User user);

    @DELETE("users/{id}")
    Call<Void> deleteUser(@Path("id") int userId);
}
