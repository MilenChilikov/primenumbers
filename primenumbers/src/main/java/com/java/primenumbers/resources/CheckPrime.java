package com.java.primenumbers.resources;

public class CheckPrime {

    // checks if the number is prime or not
    public static boolean isPrime(int number) {
    	for(int i=2; i<=number/i; i++) {
    		if(number % i == 0) {
    			return false;
    		}
    	}

    	return true;
    }
}
