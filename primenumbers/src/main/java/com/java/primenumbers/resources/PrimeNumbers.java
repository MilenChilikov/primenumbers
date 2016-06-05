package com.java.primenumbers.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


@Path(value = "/primenumbers")
public class PrimeNumbers {
    
    @GET
    public String getGreeting(@QueryParam("limit") int limit, @QueryParam("algoryth") int algoryth) {
    	List results = null;

    	if(algoryth == 1) {
    		results = algorythOne(limit);
    	} else if(algoryth == 2) {
    		results = algorythTwo(limit);
    	} else {
    		// return error
    	}
    	

    	return "Prime numbers from 1 to " + limit + " are: " + results;
    }

    private List algorythOne(int to) {
    	List<Integer> ints = new ArrayList<Integer>();
    	
    	List results = ints.stream().filter(i -> isPrime(i)).parallel().collect(Collectors.toList());
    	/*100
    	1 - 1-25
    	2 - 26 - 50,
    	3 - 51 - 75,
    	4 - 76 - 100*/

    	return null;
    }

    private List algorythTwo(int to) {
    	List results = new ArrayList();
    	int from = 2;

    	for(int i=2; i<=to; i++) {
    		if(isPrime(i)) {
    			results.add(i);
    		}
    	}

    	return results;
    }

    // 2,3,5,7,11,13,17,19,23,29
    // checks if the number is prime or not
    private boolean isPrime(int number) {
    	for(int i=2; i<number; i++) {
    		if(number % i == 0) {
    			return false;
    		}
    	}

    	return true;
    }
}
