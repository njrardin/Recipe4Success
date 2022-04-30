package it326.r4s.model;

/**
 * A class that produces exporter objects from a list of available types.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 4/30/22
 */
public class ExporterProducer {
    /**
     * An enumeration of available exporter types.
     */
    public static enum Type {
        JSON
    }
    
    /**
     * Gets an exporter object for the specified type and class.
     * @param <T> the type of the portable object being exported.
     * @param type the type of exporter to be created.
     * @param classT the class of the object being exported.
     * @return the constructed exporter object.
     */
    public static <T extends Portable> Exporter<T> getExporter(Type type, Class<T> classT) {
        Exporter<T> exporter = null;

        // Construct the specified exporter.
        switch (type) {
            case JSON:
                exporter = JSON_Porter.of(classT);
                break;
        }

        return exporter;
    }
}