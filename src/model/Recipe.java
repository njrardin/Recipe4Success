package model;
import java.util.*;

public class Recipe extends Entity implements Searchable, Categorizable, Exportable {

    private String name;
    private String description;
    private Date createdOn;
    private IngredientList ingredientList;
    private List<Review> reviews;
    private List<Category> categories;
    private List<String> instructions;


}