package it326.r4s;

/**
 * An interface for classes that import generic portable objects from various file types.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 4/19/22
 * @param <T> the type of the Portable object being ported.
 */
public interface Importer<T extends Portable> {
    /**
     * Imports a portable object from a file.
     * @param filename the name of the file to be read.
     * @return the imported portable object.
     * @throws Exception if there was a problem importing from the file.
     */
    public T importFrom(String filename) throws Exception;
}