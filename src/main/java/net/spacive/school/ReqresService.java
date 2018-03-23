package net.spacive.school;

import net.spacive.school.models.Page;
import net.spacive.school.models.Resource;
import net.spacive.school.models.Single;
import net.spacive.school.models.UserProfile;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ReqresService {

    @GET("users")
    Call<Page<UserProfile>> listUsers(@Query("page") int page);

    @GET("users/{id}")
    Call<Single<UserProfile>> singleUser(@Path("id") int userId);

    @GET("unknown")
    Call<Page<Resource>> listResources(@Query("page") int page);

    @GET("unknown/{id}")
    Call<Single<Resource>> singleResource(@Path("id") int userId);

}
