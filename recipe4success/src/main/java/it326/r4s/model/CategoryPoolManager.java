package it326.r4s.model;

/**
 * A class that saves and loads category pool objects.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 4/30/22
 */
public class CategoryPoolManager extends InstanceManager<Category.Pool> {
    private static final String categoryPoolFileName = "CategoryPool.json";
    private String categoryPoolDirectory;
    private Importer<Category.Pool> importer;
    private Exporter<Category.Pool> exporter;

    /**
     * Constructs a default category pool manager.
     */
    public CategoryPoolManager() {
        categoryPoolDirectory = InstanceManager.getParentDirectory() + categoryPoolFileName;
        importer = ImporterProducer.getImporter(ImporterProducer.Type.JSON, Category.Pool.class);
        exporter = ExporterProducer.getExporter(ExporterProducer.Type.JSON, Category.Pool.class);
    }

    /**
     * Loads a category pool object.
     */
    @Override
    public Category.Pool load() {
        Category.Pool pool = null;

        // Tries to load the category pool and returns an empty one if unsuccessful.
        try {
            pool = importer.importFrom(categoryPoolDirectory);
        } catch (Exception e) {
            pool = Category.Pool.getInstance();
        }

        return pool;
    }

    /**
     * Saves a category pool object.
     */
    @Override
    public void save(Category.Pool portable) throws Exception {
        exporter.exportTo(portable, categoryPoolDirectory);
    }    

    /**
     * Gets the file name to save and load category pool objects to/from.
     * @return the file name.
     */
    public static String getCategoryPoolFileName() {
        return categoryPoolFileName;
    }
}
