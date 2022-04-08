package it326.r4s;

import java.util.Collection;

public interface EntitySearcher {
    
    public Collection<Searchable> searchFor(Collection<Searchable> collectionToSearch, String searchString);
    
    public Collection<Searchable> searchFor(Collection<Searchable> collectionToSearch, Collection<String> prioritizedSearchItems);
}
