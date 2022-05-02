package it326.r4s.model;

/**
 * A class that saves and loads food item pool objects.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 4/30/22
 */
public class FoodItemPoolManager extends InstanceManager<FoodItem.Pool> {
    private static final String foodItemPoolFileName = "FoodItemPool.json";
    private String foodItemPoolDirectory;
    private Importer<FoodItem.Pool> importer;
    private Exporter<FoodItem.Pool> exporter;
    private Category.Pool categoryPool;

    /**
     * Constructs a default food item pool manager.
     */
    public FoodItemPoolManager() {
        foodItemPoolDirectory = InstanceManager.getParentDirectory() + foodItemPoolFileName;
        importer = ImporterProducer.getImporter(ImporterProducer.Type.JSON, FoodItem.Pool.class);
        exporter = ExporterProducer.getExporter(ExporterProducer.Type.JSON, FoodItem.Pool.class);
        categoryPool = Category.Pool.getInstance();
    }

    /**
     * Loads a food item pool object.
     */
    @Override
    public FoodItem.Pool load() {
        FoodItem.Pool pool = null;

        // Tries to load the food item pool and returns an empty one if unsuccessful.
        try {
            pool = importer.importFrom(foodItemPoolDirectory);
            rebuildFoodItemCategories(pool);
        } catch (Exception e) {
            pool = FoodItem.Pool.getInstance();
        }
        
        return pool;
    }

    /**
     * Saves a food item pool object.
     */
    @Override
    public void save(FoodItem.Pool portable) throws Exception {
        exporter.exportTo(portable, foodItemPoolDirectory);
    }

    /**
     * Gets the file name to save and load food item pool objects to/from.
     * @return the file name.
     */
    public static String getFoodItemPoolFileName() {
        return foodItemPoolFileName;
    }
    
    /**
     * Rebuilds the food item category references.
     * @param foodItemPool the food item pool to rebuild.
     */
    private void rebuildFoodItemCategories(FoodItem.Pool foodItemPool) {
        for (FoodItem foodItem : foodItemPool.getFoodItems()) {
            for (Category category : foodItem.getCategories()) {
                foodItem.removeCategory(category);
                foodItem.addCategory(categoryPool.getCategory(Category.Type.FOODITEM, category.getName()));
            }
        }
    }
}
