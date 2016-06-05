package com.java.primenumbers;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class PrimeNumbersConfiguration extends Configuration {
	private String name;

	public String getName() {
		 return name;
	}

	    public void setName(String name) {
	        this.name = name;
	    }
}
