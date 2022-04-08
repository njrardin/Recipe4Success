package it326.r4s;

import java.util.Collection;

public interface Searchable {
    /**
     * @return - a collection of all attributes in the object that should be searched as strings in priority order (i.e. the most important attribute for searching is item 1 and the least is item N)
     */
    public Collection<String> getAttributeSearchStrings();
}
