package org.nypl.journalsystem.hindex.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;

import org.nypl.journalsystem.core.IAuthor;
import org.nypl.journalsystem.core.ILibrarySystem;
import org.nypl.journalsystem.hindex.CitationCalculator;
import org.nypl.journalsystem.hindex.ICitationCalculator;


public class CitationCalculatorTest {
	private ICitationCalculator calculator;
	
	@BeforeEach
	public void setup() {
		calculator = new CitationCalculator();
	}
	
	@AfterEach
	public void tearDown() {
		calculator = null;
	}
	
	/** public int calculateHIndex(int[] arg0)
	* 
	* @param citationsPerArticle The number of citations for each individual article
	* (represented by one array entry).
	* @return The h-index of the author.
	* @throws InvalidParameterException if citationsPerArticle is null.
	*/
	
	@Test
	public void negativeCitations() {
		int[] input = {-1000,-1,-1};
		int result = calculator.calculateHIndex(input);
		assertEquals(0, result);
	}
	
	@Test
	public void zeroCitations() {
		int[] input = {0,0};
		int result = calculator.calculateHIndex(input);
		assertEquals(0, result);
	}
	
	@Test
	public void nullCitations() {
		// Unexpected exception type thrown, expected: <java.security.InvalidParameterException> but was: <java.lang.NullPointerException>
		assertThrows(InvalidParameterException.class, () -> {calculator.calculateHIndex(null);});
	}
	
	@Test
	public void CitationCounts() {
		int[] input = {0,0,0,0,1,1,3};
		int result = calculator.calculateHIndex(input);
		assertEquals(1, result);
	}
	
	@Test
	public void CitationCounts2() {
		int[] input = {0,1,1,3,3,3,4,4};
		int result = calculator.calculateHIndex(input);
		assertEquals(3, result);
	}
	
	@Test
	public void CitationCounts3() {
		int[] input = {0,1,1,3,3,3,4,4,4};
		int result = calculator.calculateHIndex(input);
		assertEquals(3, result);
	}
	
	@Test
	public void CitationCounts4() {
		int[] input = {0,1,1,3,3,3,4,4,4};
		int result = calculator.calculateHIndex(input);
		assertEquals(3, result);
	}


	

	
	/** public int calculateHIndex(IAuthor arg0, ILibrarySystem arg1)
	* 
	* @param author The author for whom to calculate the h-index.
	* @param librarySystem The library system to determine citations.
	* @return The h-index of the author.
	* @throws InvalidParameterException if author is null.
	*/


	
	
}
