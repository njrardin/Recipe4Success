package it326.r4s.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.FilenameUtils;

import it326.r4s.model.Category;
import it326.r4s.model.ExporterProducer;
import it326.r4s.model.FoodItem;
import it326.r4s.model.ImporterProducer;
import it326.r4s.model.Ingredient;
import it326.r4s.model.Meal;
import it326.r4s.model.MealPlan;
import it326.r4s.model.Portable;
import it326.r4s.model.Recipe;
import it326.r4s.model.User;
import it326.r4s.view.PorterView;

/**
 * Controller for all portable objects.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 5/1/22
 */
public class PorterController<T extends Portable> {
    private PorterView porterView;
    private Class<T> classT;
    private UserController userController;

    private PorterController(Class<T> classT, UserController userController) {
        this.porterView = new PorterView();
        this.classT = classT;
        this.userController = userController;
    }

    public static <S extends Portable> PorterController<S> of(Class<S> type, UserController userController) {
        return new PorterController<S>(type, userController);
    }

    public void exportTo(T portable) {
        String exportPath = porterView.getExportPath();

        if (!exportPath.equals("")) {
            String extension = FilenameUtils.getExtension(exportPath);
            exportPath = FilenameUtils.removeExtension(exportPath);
            ExporterProducer.Type exportType = null;

            // Get the export type.
            if (!extension.equals("")) {
                for (ExporterProducer.Type type : ExporterProducer.Type.values()) {
                    if (extension.equalsIgnoreCase(type.name())) {
                        exportType = type;
                        break;
                    }
                }
            }
            
            // Get type from user.
            if (exportType == null) {
                exportType = porterView.getExportType();
            }

            exportPath += "." + exportType.name().toLowerCase();
            
            try {
                ExporterProducer.getExporter(exportType, classT).exportTo(portable, exportPath);
            } catch (Exception e) {
                System.err.println("An error occurred while exporting.");
            }
        } else {
            System.out.println("No file was selected, exiting ...");
        }
    }

    public T importFrom() {
        T imported = null;
        String importPath = porterView.getImportPath();

        if (!importPath.equals("")) {
            String extension = FilenameUtils.getExtension(importPath);
            importPath = FilenameUtils.removeExtension(importPath);
            ImporterProducer.Type importType = null;

            // Get the export type.
            if (!extension.equals("")) {
                for (ImporterProducer.Type type : ImporterProducer.Type.values()) {
                    if (extension.equalsIgnoreCase(type.name())) {
                        importType = type;
                        break;
                    }
                }
            }

            if (importType != null) {
                importPath += "." + importType.name().toLowerCase();
            } else {
                System.out.println(extension + " is not a supported import file type, exiting ...");
                return imported;
            }            
            
            try { // This is a really gross implementation, I know, but we are running out of time.
                imported = ImporterProducer.getImporter(importType, classT).importFrom(importPath);
                
                // Rebuild the references.
                if (imported instanceof Recipe) {
                    Recipe recipe = (Recipe) imported;

                    rebuildRecipeCategories(recipe);
                    rebuildIngredients(recipe.getIngredientList().getIngredients());
                } else if (imported instanceof MealPlan) {
                    MealPlan mealPlan = (MealPlan) imported;

                    rebuildMeals(mealPlan);
                } else {
                    throw new Exception(imported.getClass() + " is not yet a supported portable type.");
                }
            } catch (Exception e) {
                System.err.println("An error occurred while importing.");
            }
        } else {
            System.out.println("No file was selected, exiting ...");
        }
        
        return imported;
    }

    private void rebuildMeals(MealPlan mealPlan) {
        User user = userController.getUser();
        FoodItem.Pool foodItemPool = FoodItem.Pool.getInstance();

        for (Meal meal : mealPlan.getMeals()) {
            for (Recipe recipe : user.getRecipeBook().getRecipes()) {
                if (meal.getRecipe().getName().equals(recipe.getName())) {
                    meal.setRecipe(recipe);
                }
            }
            for (Ingredient ingredient : meal.getIngredientList().getIngredients()) {
                ingredient.setFoodItem(foodItemPool.getFoodItem(ingredient.getFoodItem().getName()));
            }            
        }
    }

    private void rebuildRecipeCategories(Recipe recipe) {
        Category.Pool categoryPool = Category.Pool.getInstance();
        Collection<Category> categories = new ArrayList<>(recipe.getCategories());
        
        recipe.clearCategories();
        for (Category category : categories) {
            recipe.addCategory(categoryPool.getCategory(Category.Type.RECIPE, category.getName()));
        }
    }

    private void rebuildIngredients(Collection<Ingredient> ingredients) {
        FoodItem.Pool foodItemPool = FoodItem.Pool.getInstance();

        for (Ingredient ingredient : ingredients) {
            ingredient.setFoodItem(foodItemPool.getFoodItem(ingredient.getFoodItem().getName()));
        }
    }    
}
