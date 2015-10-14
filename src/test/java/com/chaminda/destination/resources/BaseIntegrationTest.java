package com.chaminda.destination.resources;


import com.chaminda.destination.DestinationAPIApplication;
import com.chaminda.destination.DestinationAPIConfiguration;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;

public abstract class BaseIntegrationTest {


    @ClassRule
    public static final DropwizardAppRule<DestinationAPIConfiguration> RULE =
            new DropwizardAppRule<DestinationAPIConfiguration>(DestinationAPIApplication.class, "/Users/chaminda/projects/DestinationAPI/src/test/resources/test-config.yml");



}
