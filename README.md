# NYPL-Journal-System
A hypothetical software system for the New York Public Library to import, store, browse and analyze scientific journals.

The system stores information on journals (and their publisher) containing multiple articles each with (potentially) multiple authors.

Articles also contain information about their citations, enabling cross reference and calculation of the _Hirsh-Index_ for each author.

Hirsh-Index is a metric to measure a researcher’s impact. Data on journals and articles is imported from CSV text files. 

- Journal
    - name
    - publisher
    - ISSN number
    - Articles (ArrayList) (must have at least one article)
    - .isFullIssue() → wether the journal has more than 2 articles
- Publisher
    - name
    - location
- Article
    - title
    - authors (ArrayList) (at least one author)
- Author
    - name