package it326.r4s.model;

import java.util.ArrayList;

/**
 * An interface to implement for searching collections of searchable objects
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/13/22
 */
public interface CollectionSearch<Searchable> {
    
    /**
     * Searches for a String and returns an ArrayList of objects that fit the search criteria
     * @param searchString - the string to objects search for
     * @return a collection of objects which are considered to fit the search criteria given the searchString
     */
    public ArrayList<Searchable> searchFor(String searchString);
}
