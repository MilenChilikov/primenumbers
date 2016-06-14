package com.java.primenumbers.resources;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersRunnable implements Runnable {

	private Integer from;
	private Integer to;
	private List results;

	PrimeNumbersRunnable(Integer from, Integer to) {
		this.from = from;
		this.to = to;
		this.results = new ArrayList();
	}

	public List getResults() {
		return this.results;
	}

	public void run() {
		for(int i=from; i<=to; i++) {
    		if(CheckPrime.isPrime(i)) {
    			results.add(i);
    		}
    	}
	}
}