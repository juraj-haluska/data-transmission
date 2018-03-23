package net.spacive.school;

import net.spacive.school.models.Page;
import net.spacive.school.models.Resource;
import net.spacive.school.models.Single;
import net.spacive.school.models.UserProfile;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientApp {

    private final static Logger log = Logger.getLogger(ClientApp.class.getName());

    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ReqresService reqresService = retrofit.create(ReqresService.class);



        // users
        reqresService.listUsers(2).enqueue(new Callback<Page<UserProfile>>() {
            @Override
            public void onResponse(Call<Page<UserProfile>> call, Response<Page<UserProfile>> response) {
                if (response.isSuccessful()) {
                    log.log(Level.INFO, "multiple users fetched");
                    log.log(Level.INFO, response.body().toString());

                    response.body().data.forEach((userProfile -> {
                        log.log(Level.INFO, userProfile.toString());
                    }));
                }
            }

            @Override
            public void onFailure(Call<Page<UserProfile>> call, Throwable throwable) {
                log.log(Level.SEVERE, throwable.getMessage());
            }
        });

        reqresService.singleUser(2).enqueue(new Callback<Single<UserProfile>>() {
            @Override
            public void onResponse(Call<Single<UserProfile>> call, Response<Single<UserProfile>> response) {
                if (response.isSuccessful()) {
                    log.log(Level.INFO, "single user fetched");
                    log.log(Level.INFO, response.body().data.toString());
                }
            }

            @Override
            public void onFailure(Call<Single<UserProfile>> call, Throwable throwable) {
                log.log(Level.SEVERE, throwable.getMessage());
            }
        });

        // resources
        reqresService.listResources(2).enqueue(new Callback<Page<Resource>>() {
            @Override
            public void onResponse(Call<Page<Resource>> call, Response<Page<Resource>> response) {
                if (response.isSuccessful()) {
                    log.log(Level.INFO, "multiple resources fetched");
                    log.log(Level.INFO, response.body().toString());

                    response.body().data.forEach((userProfile -> {
                        log.log(Level.INFO, userProfile.toString());
                    }));
                }
            }

            @Override
            public void onFailure(Call<Page<Resource>> call, Throwable throwable) {
                log.log(Level.SEVERE, throwable.getMessage());
            }
        });

        reqresService.singleResource(2).enqueue(new Callback<Single<Resource>>() {
            @Override
            public void onResponse(Call<Single<Resource>> call, Response<Single<Resource>> response) {

                if (response.isSuccessful()) {
                    log.log(Level.INFO, "single resource fetched");
                    log.log(Level.INFO, response.body().data.toString());
                }
            }

            @Override
            public void onFailure(Call<Single<Resource>> call, Throwable throwable) {
                log.log(Level.SEVERE, throwable.getMessage());
            }
        });
    }
}
