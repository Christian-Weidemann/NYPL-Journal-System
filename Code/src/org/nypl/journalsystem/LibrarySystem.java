package org.nypl.journalsystem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class LibrarySystem {
	
	HashMap<String, Journal> journals;  //	Journals stored in HashMap by ISSN number.
	
	public LibrarySystem() {
		/*
		 *	Initializes system with default journals.
		 */
		this.journals = new HashMap<String, Journal>();
		
		journals.put("0018-1560", new Journal("Higher Education", new Publisher("Springer", "Germany"), "0018-1560", new ArrayList<Article>()));
		journals.put("0346-2511", new Journal("System", new Publisher("Elsevier", "Netherlands"), "0346-2511", new ArrayList<Article>()));
		journals.put("2451-9294", new Journal("Chem", new Publisher("Elsevier", "Netherlands"), "2451-9294", new ArrayList<Article>()));
		journals.put("1476-4687", new Journal("Nature", new Publisher("Nature Research", "Great Britain"), "1476-4687", new ArrayList<Article>()));
		journals.put("0147-2011", new Journal("Society", new Publisher("Springer", "Germany"), "0147-2011", new ArrayList<Article>()));
	}
	
	public void load() throws FileNotFoundException, IOException {
		CSVFormat format = CSVFormat.EXCEL.withIgnoreSurroundingSpaces().withHeader();
		HashMap<String, Author> author_map = loadAuthors("data/Authors.csv", format);
		loadArticles("data/Articles.csv", format, author_map);
	}
	
	protected HashMap<String, Author> loadAuthors(String path, CSVFormat format) throws FileNotFoundException, IOException {
		/*
		 *	Loads author names from file and saves them in "author_map" as ID : Name.
		 */
		HashMap<String, Author> authors = new HashMap<String, Author>();
		
		CSVParser parser = CSVParser.parse(new FileReader(path), format);
		
		for (CSVRecord record : parser) {
			authors.put(record.get("ID"), new Author(record.get("Name")));
		}
		return authors;
	}
	
	protected void loadArticles(String path, CSVFormat format, HashMap<String, Author> author_map) throws FileNotFoundException, IOException {
		/*
		 *	Loads articles from file and assign them to appropriate journal
		 */
		CSVParser parser = CSVParser.parse(new FileReader(path), format);
		
		for (CSVRecord record : parser) {
			
			Article newArticle = new Article(record.get("Title"), new ArrayList<Author>());
			
			String idString =  record.get("AuthorIDs");
			String[] authorIDs = idString.substring(1, idString.length()-1).split("; ");
			
			for (String authorID : authorIDs) {
				newArticle.authors.add(author_map.get(authorID));
			}
			journals.get(record.get("ISSN")).articles.add(newArticle);
		}
	}
	
	public void listContents() {
		/*
		 *	Prints all journals with their respective articles and authors to the console.
		 */
		for (Journal journal : journals.values()) {
			System.out.println(journal);
		}
	}
	
	public static final void main(String[] args) throws Exception {
		LibrarySystem librarySystem = new LibrarySystem();
		
		librarySystem.load();
		librarySystem.listContents();
	}
}
