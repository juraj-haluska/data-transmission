package net.spacive.school;

import net.spacive.school.models.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientApp {

    private final static Logger log = Logger.getLogger(ClientApp.class.getName());

    public static void main(String[] args) throws IOException {

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
                    StringBuilder message = new StringBuilder()
                            .append("multiple users fetched: ")
                            .append(response.body().toString());

                    response.body().data.forEach((userProfile -> {
                        message.append("\n" + userProfile.toString());
                    }));

                    log.log(Level.INFO, message.toString());
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
                    StringBuilder message = new StringBuilder()
                            .append("single user fetched: ")
                            .append(response.body().data.toString());

                    log.log(Level.INFO, message.toString());
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
                    StringBuilder message = new StringBuilder()
                            .append("multiple resources fetched: ")
                            .append(response.body().toString());

                    response.body().data.forEach((resource -> {
                        message.append("\n" + resource.toString());
                    }));

                    log.log(Level.INFO, message.toString());
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
                    StringBuilder message = new StringBuilder()
                            .append("single resource fetched: ")
                            .append(response.body().data.toString());

                    log.log(Level.INFO, message.toString());
                }
            }

            @Override
            public void onFailure(Call<Single<Resource>> call, Throwable throwable) {
                log.log(Level.SEVERE, throwable.getMessage());
            }
        });

        // user manipulation
        User newUser = new User();
        newUser.name = "Test user";
        newUser.job = "api tester";

        Response<User> response = reqresService.createUser(newUser).execute();

        if (response.isSuccessful()) {
            newUser = response.body();
            log.log(Level.INFO, "new user created");
            log.log(Level.INFO, newUser.toString());
        }

        User updatedUser = newUser;
        updatedUser.job = "UI tester";

        response = reqresService.updateUser(
                updatedUser.id,
                updatedUser
        ).execute();

        if (response.isSuccessful()) {
            updatedUser = response.body();
            log.log(Level.INFO, "user updated");
            log.log(Level.INFO, newUser.toString());
        }

        Response<Void> deleteResponse = reqresService.deleteUser(
                updatedUser.id
        ).execute();

        if (deleteResponse.isSuccessful()) {
            log.log(Level.INFO, "user deleted");
        }

    }
}