package resources;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.java.primenumbers.resources.PrimeNumbers;

public class PrimeNumbersTest {

	private PrimeNumbers primeNumbersResource;

	@Before
    public void setup() {
		primeNumbersResource = new PrimeNumbers();
	}

	@Test
	public void testGetPrimeNumbersShouldReturnRightResult() {
		System.out.println("testGetPrimeNumbersShouldReturnRightResult: Invoke getPrimeNumbers() with right params");
		Integer limit = 25;
		Integer algorythm = 2;
		Integer[] expectedArray = { 2, 3, 5, 7, 11, 13, 17, 19, 23 };

		String result = primeNumbersResource.getPrimeNumbers(limit, algorythm);
		String expected = "Prime numbers from 1 to " + limit + " are: " + Arrays.toString(expectedArray);
		assertEquals(expected, result);
	}

	@Test
	public void testGetPrimeNumbersShouldHandleNoLimitParam() {
		System.out.println("testGetPrimeNumbersShouldHandleNoLimitParam: Invoke getPrimeNumbers() with no limit param");
		// if no limit is set in the url the default(0) value is set
		Integer limit = 0;
		Integer algorythm = 2;

		String result = primeNumbersResource.getPrimeNumbers(limit, algorythm);
		String expected = "No limit parameter found";
		assertEquals(expected, result);
	}

	@Test
	public void testGetPrimeNumbersShouldHandleNoAlgorithmParam() {
		System.out.println("testGetPrimeNumbersShouldHandleNoAlgorithmParam: Invoke getPrimeNumbers() with no algorythm param");
		Integer limit = 30;
		// if no algorythm is set in the url the default(0) value is set
		Integer algorythm = 0;

		String result = primeNumbersResource.getPrimeNumbers(limit, algorythm);
		String expected = "No algorithm parameter found";
		assertEquals(expected, result);
	}

	@Test
	public void testGetPrimeNumbersShouldHandleWrongAlgorithmParam() {
		System.out.println("testGetPrimeNumbersShouldHandleNoAlgorithmParam: Invoke getPrimeNumbers() with wrong algorythm param");
		Integer limit = 30;
		// if algorythm parameter differs 1 or 2 appropriate message should be shown
		Integer algorythm = 6;

		String result = primeNumbersResource.getPrimeNumbers(limit, algorythm);
		String expected = "Wrong algorithm parameter. Please choose 1 or 2";
		assertEquals(expected, result);
	}
}
