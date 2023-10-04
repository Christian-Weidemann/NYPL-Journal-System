package org.nypl.journalsystem.hindex.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;

import org.nypl.journalsystem.Author;
import org.nypl.journalsystem.LibrarySystem;
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
	* 
	* Test results:
	* When all citation counts are greater than h-index, returns h-index too small by 1.
	* When when h-index equals number of papers in argument, returns h-index too small by 1.
	* Throws <java.lang.NullPointerException> instead of <java.security.InvalidParameterException> when author is null.
	* 
	*/
	
//	@Test
//	public void negativeCitations() {
//		int[] input = {-1000,-1,-1};
//		int result = calculator.calculateHIndex(input);
//		assertEquals(0, result);
//	}
//	
//	@Test
//	public void zeroCitations() {
//		int[] input = {};
//		int result = calculator.calculateHIndex(input);
//		assertEquals(0, result);
//	}
//	
//	@Test
//	public void nullCitations() {
//		// Unexpected exception type thrown, expected: <java.security.InvalidParameterException> but was: <java.lang.NullPointerException>
//		assertThrows(InvalidParameterException.class, () -> {calculator.calculateHIndex(null);});
//	}
//	
//	@Test
//	public void CitationCounts1() {
//		// org.opentest4j.AssertionFailedError: expected: <3> but was: <2>
//		
//		int[] input = {10,10,10};
//		int result = calculator.calculateHIndex(input);
//		assertEquals(3, result);
//	}
//	
//	@Test
//	public void CitationCounts2() {
//		// org.opentest4j.AssertionFailedError: expected: <4> but was: <3>
//		int[] input = {10,10,10,10};
//		int result = calculator.calculateHIndex(input);
//		assertEquals(4, result);
//	}
//	
//	@Test
//	public void CitationCounts3() {
//		// org.opentest4j.AssertionFailedError: expected: <4> but was: <3>
//		int[] input = {5,5,5,4};
//		int result = calculator.calculateHIndex(input);
//		assertEquals(4, result);
//	}


	/** public int calculateHIndex(IAuthor arg0, ILibrarySystem arg1)
	* 
	* @param author The author for whom to calculate the h-index.
	* @param librarySystem The library system to determine citations.
	* @return The h-index of the author.
	* @throws InvalidParameterException if author is null.
	*/
	
	@Test
	public void nullCitations2() {
		Author author = new Author("hi");
		LibrarySystem libsys = new LibrarySystem();
		assertThrows(InvalidParameterException.class, () -> {calculator.calculateHIndex(author,libsys);});
	}

	
	
}
