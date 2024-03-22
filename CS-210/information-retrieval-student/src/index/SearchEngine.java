/*
 * Copyright 2023 Marc Liberatore.
 */

package index;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.HashSet;

import comparators.TfIdfComparator;
import documents.DocumentId;

/**
 * A simplified document indexer and search engine.
 * 
 * Documents are added to the engine one-by-one, and uniquely identified by a
 * DocumentId.
 *
 * Documents are internally represented as "terms", which are lowercased
 * versions of each word
 * in the document.
 * 
 * Queries for terms are also made on the lowercased version of the term. Terms
 * are
 * therefore case-insensitive.
 * 
 * Lookups for documents can be done by term, and the most relevant document(s)
 * to a specific term
 * (as computed by tf-idf) can also be retrieved.
 *
 * See:
 * - <https://en.wikipedia.org/wiki/Inverted_index>
 * - <https://en.wikipedia.org/wiki/Search_engine_(computing)>
 * - <https://en.wikipedia.org/wiki/Tf%E2%80%93idf>
 * 
 * @author Marc Liberatore
 *
 */
public class SearchEngine {

	Map<String, Set<DocumentId>> sd;
	Map<DocumentId, Map<String, Integer>> dsi;

	public SearchEngine() {
		sd = new HashMap<>();
		dsi = new HashMap<>();
	}

	/**
	 * Inserts a document into the search engine for later analysis and retrieval.
	 * 
	 * The document is uniquely identified by a documentId; attempts to re-insert
	 * the same
	 * document are ignored.
	 * 
	 * The document is supplied as a Reader; this method stores the document
	 * contents for
	 * later analysis and retrieval.
	 * 
	 * @param documentId
	 * @param reader
	 * @throws IOException iff the reader throws an exception
	 */
	public void addDocument(DocumentId documentId, Reader reader) throws IOException {
		Scanner sc = new Scanner(reader);
		sc.useDelimiter("\\W+");
		while (sc.hasNext()) {
			String s = sc.next().toLowerCase();
			if (sd.get(s) == null) // add document to string->document map for current string
				sd.put(s, new HashSet<>());
			sd.get(s).add(documentId);
			Map<String, Integer> sCount = dsi.get(documentId);
			if (sCount == null) { // add the document and the first word and its count if this is a new doc
				sCount = new HashMap<>();
				sCount.put(s, 1);
				dsi.put(documentId, sCount);
			} else if (!sCount.containsKey(s)) // if the document exists, add the word if it hasn't been read before in
												// this doc
				sCount.put(s, 1);
			else // if this word has already been read in this document, increment the count
				sCount.put(s, sCount.get(s) + 1);
		}
	}

	/**
	 * Returns the set of DocumentIds contained within the search engine that
	 * contain a given term.
	 * 
	 * @param term
	 * @return the set of DocumentIds that contain a given term
	 */
	public Set<DocumentId> indexLookup(String term) {
		term = term.toLowerCase();
		return sd.get(term) != null ? sd.get(term) : new HashSet<>();
	}

	/**
	 * Returns the term frequency of a term in a particular document.
	 * 
	 * The term frequency is number of times the term appears in a document.
	 * 
	 * See
	 * 
	 * @param documentId
	 * @param term
	 * @return the term frequency of a term in a particular document
	 * @throws IllegalArgumentException if the documentId has not been added to the
	 *                                  engine
	 */
	public int termFrequency(DocumentId documentId, String term) throws IllegalArgumentException {
		if (!dsi.containsKey(documentId)) // if we don't have the documentId, throw Exception
			throw new IllegalArgumentException();
		return dsi.get(documentId).getOrDefault(term, 0); // return the amount of times the word appeared in the document
	}

	/**
	 * Returns the inverse document frequency of a term across all documents in the
	 * index.
	 * 
	 * For our purposes, IDF is defined as log ((1 + N) / (1 + M)) where
	 * N is the number of documents in total, and M
	 * is the number of documents where the term appears.
	 * 
	 * @param term
	 * @return the inverse document frequency of term
	 */
	public double inverseDocumentFrequency(String term) {
		int n = dsi.keySet().size();
		int m = sd.get(term) != null ? sd.get(term).size() : 0;
		return Math.log(((double) (1 + n) / (1 + m)));
	}

	/**
	 * Returns the tfidf score of a particular term for a particular document.
	 * 
	 * tfidf is the product of term frequency and inverse document frequency for the
	 * given term and document.
	 * 
	 * @param documentId
	 * @param term
	 * @return the tfidf of the the term/document
	 * @throws IllegalArgumentException if the documentId has not been added to the
	 *                                  engine
	 */
	public double tfIdf(DocumentId documentId, String term) throws IllegalArgumentException {
		return termFrequency(documentId, term) * inverseDocumentFrequency(term);
	}

	/**
	 * Returns a sorted list of documents, most relevant to least relevant, for the
	 * given term.
	 * 
	 * A document with a larger tfidf score is more relevant than a document with a
	 * lower tfidf score.
	 * 
	 * Each document in the returned list must contain the term.
	 * 
	 * @param term
	 * @return a list of documents sorted in descending order by tfidf
	 */
	public List<DocumentId> relevanceLookup(String term) {
		if (sd.get(term) == null)
			return new ArrayList<>();
		List<DocumentId> l = new ArrayList<>(sd.get(term));
		l.sort(new TfIdfComparator(this, term));
		return l;
	}
}
