package com.java.primenumbers;

import com.java.primenumbers.resources.PrimeNumbers;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PrimeNumbersApplication extends Application<PrimeNumbersConfiguration> {

    public static void main(final String[] args) throws Exception {
        new PrimeNumbersApplication().run(args);
    }

    @Override
    public void initialize(final Bootstrap<PrimeNumbersConfiguration> bootstrap) {}

    @Override
    public void run(final PrimeNumbersConfiguration configuration,
                    final Environment environment) {
    	environment.jersey().register(new PrimeNumbers());
    }

}
