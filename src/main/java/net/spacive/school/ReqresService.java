package net.spacive.school;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import net.spacive.school.resources.UnknownResource;
import net.spacive.school.resources.UsersResource;

public class ReqresService extends Application<ReqresServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new ReqresService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ReqresServiceConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ReqresServiceConfiguration configuration,
                    Environment environment) {

        final UsersResource usersResource = new UsersResource();
        final UnknownResource unknownResource = new UnknownResource();

        environment.jersey().register(usersResource);
        environment.jersey().register(unknownResource);
    }

}