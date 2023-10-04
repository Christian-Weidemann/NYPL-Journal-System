package org.nypl.journalsystem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.nypl.journalsystem.core.IArticle;
import org.nypl.journalsystem.core.IAuthor;
import org.nypl.journalsystem.core.ILibrarySystem;

public class LibrarySystem implements ILibrarySystem{
	
	HashMap<String, Journal> systemJournals;  // Journals stored in HashMap by ISSN number.
	HashMap<String, Author> systemAuthors;  // Authors stored in HashMap by ID.
	HashMap<String, Article> systemArticles;  // Articles stored in HashMap by ID.
	
	public LibrarySystem() {
		/*
		 *	Initializes system with default journals.
		 */
		this.systemJournals = new HashMap<String, Journal>();
		this.systemAuthors = new HashMap<String, Author>();
		this.systemArticles = new HashMap<String, Article>();
		
		systemJournals.put("0018-1560", new Journal("Higher Education", new Publisher("Springer", "Germany"), "0018-1560", new ArrayList<Article>()));
		systemJournals.put("0346-2511", new Journal("System", new Publisher("Elsevier", "Netherlands"), "0346-2511", new ArrayList<Article>()));
		systemJournals.put("2451-9294", new Journal("Chem", new Publisher("Elsevier", "Netherlands"), "2451-9294", new ArrayList<Article>()));
		systemJournals.put("1476-4687", new Journal("Nature", new Publisher("Nature Research", "Great Britain"), "1476-4687", new ArrayList<Article>()));
		systemJournals.put("0147-2011", new Journal("Society", new Publisher("Springer", "Germany"), "0147-2011", new ArrayList<Article>()));
	}
	
	public void load() throws FileNotFoundException, IOException {
		CSVFormat format = CSVFormat.EXCEL.withIgnoreSurroundingSpaces().withHeader();
		loadAuthors("data/Authors.csv", format);
		loadArticles("data/Articles.csv", format);
	}
	
	protected void loadAuthors(String path, CSVFormat format) throws FileNotFoundException, IOException {
		/*
		 *	Loads author names from file and saves them in "author_map" as ID : Name.
		 */
		CSVParser parser = CSVParser.parse(new FileReader(path), format);
		
		for (CSVRecord record : parser) {
			systemAuthors.put(record.get("ID"), new Author(record.get("Name")));
		};
	}
	
	protected void loadArticles(String path, CSVFormat format) throws FileNotFoundException, IOException {
		/*
		 *	Loads articles from file and assign them to appropriate journal
		 */
		CSVParser parser = CSVParser.parse(new FileReader(path), format);
		
		HashMap<String, String> citationMap = new HashMap<String, String>();
		
		for (CSVRecord record : parser) {
			
			String citationString = record.get("CitedArticleIDs");
			
			String articleID = record.get("ID");
			citationMap.put(articleID, citationString);
			
			Article newArticle = new Article(record.get("Title"), new ArrayList<Author>(), new ArrayList<Article>());
			
			String idString =  record.get("AuthorIDs");
			String[] authorIDs = idString.substring(1, idString.length()-1).split("; ");
			for (String authorID : authorIDs) {
				newArticle.authors.add(systemAuthors.get(authorID));
			}
			systemArticles.put(articleID, newArticle);
			systemJournals.get(record.get("ISSN")).articles.add(newArticle);
		}
		
		for (String articleID : citationMap.keySet()) {
			Article citingArticle = systemArticles.get(articleID);
			
			String citationString = citationMap.get(articleID);
			String[] citationIDs = citationString.substring(1, citationString.length()-1).split(";");
		
			for (String ID : citationIDs) {
				Article citedArticle = systemArticles.get(ID);
				citingArticle.addCitation(citedArticle);
			}
		}
	}
	
	public void listContents() {
		/*
		 *	Prints all journals with their respective articles and authors to the console.
		 */
		for (Journal journal : systemJournals.values()) {
			System.out.println(journal);
		}
	}
	
	public static final void main(String[] args) throws Exception {
		LibrarySystem librarySystem = new LibrarySystem();
		
		librarySystem.load();
		librarySystem.listContents();
	}

	@Override
	public Collection<Author> getAllAuthors() {
		return systemAuthors.values();
	}

	@Override
	public Collection<Journal> getAllJournals() {
		return systemJournals.values();
	}

	@Override
	public ArrayList<Article> getArticlesByAuthor(IAuthor arg0) {
		ArrayList<Article> ArticlesByAuthor = new ArrayList<Article>();
		for (Article a : systemArticles.values()) {
			if (a.authors.contains(arg0) ) {
				ArticlesByAuthor.add(a);
			}
		}
		return ArticlesByAuthor;
	}

	@Override
	public ArrayList<Article> getArticlesCitedByArticle(IArticle arg0) {
		return ((Article) arg0).getCitedArticles();
	}

	@Override
	public ArrayList<Article> getArticlesCitingArticle(IArticle arg0) {
		ArrayList<Article> ArticlesCitingArticle = new ArrayList<Article>();
		for (Article citingArticle : systemArticles.values()) {
			if (citingArticle.getCitedArticles().contains(arg0)) {
				ArticlesCitingArticle.add(citingArticle);
			}
		}
		return ArticlesCitingArticle;
	}
}
