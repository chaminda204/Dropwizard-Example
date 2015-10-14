package com.chaminda.destination;

import com.chaminda.destination.db.DestinationDao;
import com.chaminda.destination.resources.DestinationResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class DestinationAPIApplication extends Application<DestinationAPIConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DestinationAPIApplication().run(args);
    }

    @Override
    public String getName() {
        return "DestinationAPI";
    }

    @Override
    public void initialize(final Bootstrap<DestinationAPIConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DestinationAPIConfiguration configuration, final Environment environment) {

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");

        final DestinationDao destinationDao = jdbi.onDemand(DestinationDao.class);
        final DestinationResource personResource = new DestinationResource(destinationDao);

        environment.jersey().register(personResource);

    }

}
