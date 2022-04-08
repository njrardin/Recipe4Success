package it326.r4s;

import java.util.ArrayList;
import java.util.Collection;

public class EntitySearcher {
    
    public Collection<Searchable> searchFor(Collection<Searchable> collectionToSearch, String searchString){
        ArrayList<Searchable> itemsThatPassed = new ArrayList<Searchable>();

        //if item has string in any slot, add it to list (ITERATION 1---Has O(N*M) time complexity)
        for (Searchable searchable: collectionToSearch){
            for (String attribute: searchable.getAttributeSearchStrings()){
                if (attribute.toLowerCase().contains(searchString.toLowerCase())){
                    itemsThatPassed.add(searchable);
                    break;
                }
            }
        }
        return itemsThatPassed;
    }
    
    // public Collection<Searchable> searchFor(Collection<Searchable> collectionToSearch, Collection<String> prioritizedSearchItems);
}
