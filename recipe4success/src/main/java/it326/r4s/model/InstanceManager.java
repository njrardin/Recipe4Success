package it326.r4s.model;

/**
 * An abstract class that saves and loads portable objects.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 4/30/22
 */
public abstract class InstanceManager<T extends Portable> {
    private static String parentDirectory = System.getenv("APPDATA") + "/r4s/";

    /**
     * Constructs a default instance manager.
     */
    public InstanceManager() {}

    /**
     * Loads a portable object.
     * @return the loaded object.
     */
    public abstract T load();

    /**
     * Saves a portable object. 
     * @param portable the portable object to be saved.
     * @throws Exception if there was a problem saving the portable object.
     */
    public abstract void save(T portable) throws Exception;

    /**
     * Gets the parent directory to save and load portable objects to/from.
     * @return the parent directory.
     */
    public static String getParentDirectory() {
        return parentDirectory;
    }    
}
