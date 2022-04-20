package it326.r4s;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * A class that imports and exports generic portable objects to/from JSON files.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 4/19/22
 * @param <T> the type of the Portable object being ported.
 */
public class JSON_Porter<T extends Portable> implements Porter<T> {
    //* Instance variables *\\
    private Gson gson;
    private Class<T> typeT;

    //* Constructor *\\
    /**
     * Constructs a default JSON porter object.
     * @param type
     */
    private JSON_Porter(Class<T> type) {
        gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        typeT = type;
    }

    //* Public Methods *\\
    public static <T extends Portable> JSON_Porter<T> of(Class<T> type) {
        return new JSON_Porter<T>(type);
    }

    /**
     * Imports a single portable object from a JSON file.
     */
    @Override
    public T importFrom(String filename) throws Exception {
        Reader reader = getReader(filename);
        return gson.fromJson(reader, typeT);
    }

    /**
     * Imports a list of portable objects from a JSON file.
     */
    @Override
    public List<T> importAllFrom(String filename) throws Exception {
        Reader reader = getReader(filename);
        return Arrays.asList(gson.fromJson(reader, typeT.arrayType()));
    }

    /**
     * Exports a single portable object to a JSON file.
     */
    @Override
    public void exportFrom(String filename, T portable) throws Exception {
        // TODO Auto-generated method stub
    }

    /**
     * Exports a list of portable objects from a JSON file.
     */
    @Override
    public void exportAllFrom(String filename, List<T> portables) throws Exception {
        // TODO Auto-generated method stub
    }    

    //* Private Methods *\\
    /**
     * Gets a reader object for the specified file.
     * @param filename the name of the file to be read.
     * @return the reader object.
     * @throws Exception if there was a problem getting a reader object.
     */
    private Reader getReader(String filename) throws Exception {
        return Files.newBufferedReader(Path.of(filename));
    }

    /**
     * Gets a writer object for the specified file.
     * @param filename the name of the file to be written to.
     * @return the writer object.
     * @throws Exception if there was a problem getting a writer object.
     */
    private Writer getWriter(String filename) throws Exception {
        return Files.newBufferedWriter(Path.of(filename));
    }
}
