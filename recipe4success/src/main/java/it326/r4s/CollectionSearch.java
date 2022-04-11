package it326.r4s;

import java.util.ArrayList;
import java.util.Collection;

public interface CollectionSearch<Searchable> {
    
    public ArrayList<Searchable> searchFor(String searchString);

    public ArrayList<Searchable> searchFor(Collection<String> searchStrings);
}
