package it326.r4s;

import java.util.ArrayList;

public interface CollectionSearch<Searchable> {
    
    public ArrayList<Searchable> searchFor(String searchString);
}
