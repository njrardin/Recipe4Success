package it326.r4s.model;

/**
 * A class that produces importer objects from a list of available types.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 4/30/22
 */
public class ImporterProducer {
    /**
     * An enumeration of available importer types.
     */
    public static enum Type {
        JSON
    }
    
    /**
     * Gets an importer object for the specified type and class.
     * @param <T> the type of the portable object being imported.
     * @param type the type of importer to be created.
     * @param classT the class of the object being imported.
     * @return the constructed importer object.
     */
    public static <T extends Portable> Importer<T> getImporter(Type type, Class<T> classT) {
        Importer<T> importer = null;

        // Construct the specified importer.
        switch (type) {
            case JSON:
                importer = JSON_Porter.of(classT);
                break;
        }

        return importer;
    }
}