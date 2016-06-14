package com.java.primenumbers.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


@Path(value = "/primenumbers")
public class PrimeNumbers {
    
    @GET
    public String getPrimeNumbers(@QueryParam("limit") int limit, @QueryParam("algorithm") int algorithm) {
    	List results = null;

    	if(limit < 1) {
    		return "No limit parameter found";
    	}

    	if(algorithm == 0) {
    		return "No algorithm parameter found";
    	}
    	if(algorithm != 1 && algorithm != 2) {
    		return "Wrong algorithm parameter. Please choose 1 or 2";
    	}

    	if(algorithm == 1) {
    		results = algorithmOne(2, limit);
    	} else if(algorithm == 2) {
    		results = algorithmTwo(limit);
    	}

    	return "Prime numbers from 1 to " + limit + " are: " + results;
    }

    // distribute the work to 4 threads
    private List algorithmOne(int from, int to) {
    	List results = new ArrayList<Integer>();
    	int firstLimit = to/4;
    	int secondLimit = 2*firstLimit; // can be used to/2
    	int thirdLimit = 3*firstLimit;	// can be used to/2 + firstLimit

    	PrimeNumbersRunnable first = new PrimeNumbersRunnable(from, firstLimit);
    	first.run();
    	results.addAll(first.getResults());
    	System.out.println("First threads result: " + first.getResults());

    	PrimeNumbersRunnable second = new PrimeNumbersRunnable(firstLimit+1, secondLimit);
    	second.run();
    	results.addAll(second.getResults());
    	System.out.println("Second threads result: " + second.getResults());

    	PrimeNumbersRunnable third = new PrimeNumbersRunnable(secondLimit+1, thirdLimit);
    	third.run();
    	results.addAll(third.getResults());
    	System.out.println("Third threads result: " + third.getResults());

    	PrimeNumbersRunnable fourth = new PrimeNumbersRunnable(thirdLimit, to);
    	fourth.run();
    	results.addAll(fourth.getResults());
    	System.out.println("Fourth threads result: " + fourth.getResults());

    	return results;
    }

    private List algorithmTwo(int to) {
    	List results = new ArrayList();
    	int from = 2;

    	for(int i=2; i<=to; i++) {
    		if(CheckPrime.isPrime(i)) {
    			results.add(i);
    		}
    	}

    	return results;
    }
}
