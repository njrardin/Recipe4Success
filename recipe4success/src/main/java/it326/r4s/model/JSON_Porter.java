package it326.r4s.model;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;

/**
 * A class that imports and exports generic portable objects to/from JSON files.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 4/19/22
 * @param <T> the type of the Portable object being ported.
 */
public class JSON_Porter<T extends Portable> implements Importer<T>, Exporter<T> {
    //* Instance variables *\\
    private Gson gson;
    private Class<T> classT;

    //* Constructors *\\
    /**
     * Constructs a default JSON porter object.
     */
    private JSON_Porter() {
        gson = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .registerTypeAdapter(Category.Pool.class, new InstanceCreator<Category.Pool>() {
                @Override
                public Category.Pool createInstance(Type type) {
                    return Category.Pool.getInstance();
                }                
            })
            .registerTypeAdapter(FoodItem.Pool.class, new InstanceCreator<FoodItem.Pool>() {
                @Override
                public FoodItem.Pool createInstance(Type type) {
                    return FoodItem.Pool.getInstance();
                }
            })
            .create();
        classT = null;
    }

    /**
     * Constructs a JSON porter object of the specified type.
     * @param type the concrete class type (e.g. Recipe.class).
     */
    private JSON_Porter(Class<T> type) {
        this();
        classT = type;
    }

    //* Public Methods *\\
    /**
     * Factory method to get an instance of JSON Porter.
     * @param <S> the type of the Portable object being ported.
     * @param type the concrete class type (e.g. Recipe.class).
     * @return an instance of JSON_Porter<T>.
     */
    public static <S extends Portable> JSON_Porter<S> of(Class<S> type) {
        return new JSON_Porter<S>(type);
    }

    /**
     * Imports a portable object from a JSON file.
     */
    @Override
    public T importFrom(String filename) throws Exception {
        Reader reader = getReader(filename);
        T obj = gson.fromJson(reader, classT);
        reader.close();
        return obj;
    }

    /**
     * Exports a portable object to a JSON file.
     */
    @Override
    public void exportTo(T portable, String filename) throws Exception {
        Writer writer = getWriter(filename);
        gson.toJson(portable, writer);
        writer.close();
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
