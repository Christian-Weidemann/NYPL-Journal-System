package org.nypl.journalsystem.hindex.test;


import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;

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

	/**
	* Calculates the Hirsch-index (h-index) for a given person by the number of citations
	* their articles received.
	*
	* Example: A person with at least 3 published articles with at least 3 citations each,
	* but not at least 4 articles with at least 4 citations each, has an h-index of 3.
	*
	* @param citationsPerArticle The number of citations for each individual article
	* (represented by one array entry).
	* @return The h-index of the author.
	* 
	* @throws InvalidParameterException if citationsPerArticle is null.
	*/
	
	@Test
	public void nullCitations() {
		// Unexpected exception type thrown, expected: <java.security.InvalidParameterException> but was: <java.lang.NullPointerException>
		assertThrows(InvalidParameterException.class, () -> {calculator.calculateHIndex(null);});
	}



	
	
}
