package it326.r4s;

import java.util.List;

/**
 * An interface for classes that import and export generic portable objects to/from various file types.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 4/19/22
 * @param <T> the type of the Portable object being ported.
 */
public interface Porter<T extends Portable> {
    /**
     * Imports a single portable object from a file.
     * @param filename the name of the file to be read.
     * @return the imported portable object.
     * @throws Exception if there was a problem importing from the file.
     */
    public T importFrom(String filename) throws Exception;

    /**
     * Imports a list of portable objects from a file.
     * @param filename the name of the file to be read.
     * @return the imported list of portable objects.
     * @throws Exception if there was a problem importing from the file.
     */
    public List<T> importAllFrom(String filename) throws Exception;

    /**
     * Exports a single portable object to a file.
     * @param filename the name of the file to be read.
     * @param portable the portable object to be exported.
     * @throws Exception if there was a problem importing from the file.
     */
    public void exportFrom(String filename, T portable) throws Exception;

    /**
     * Exports a list of portable objects from a file.
     * @param filename the name of the file to be read.
     * @param portables the list of portable objects to be exported.
     * @throws Exception if there was a problem importing from the file.
     */
    public void exportAllFrom(String filename, List<T> portables) throws Exception;
}