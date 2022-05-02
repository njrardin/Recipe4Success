package it326.r4s.controller;

import it326.r4s.model.FoodItem;
import it326.r4s.view.FoodItemView;

public class FoodItemController {
    
    //*Instance Variables*\\
    private FoodItem foodItem;
    private FoodItemView foodItemView;

    //*Constructor*\\
    /**
     * Constructor for R4S's FoodItemController
     * @param fooditem
     */
    public FoodItemController(FoodItem fooditem){
        this.foodItem = fooditem;
        this.foodItemView = new FoodItemView();
    }  

    //*Methods*\\
    /**
     * Getter for the controller's FoodItem
     * @return the FoodItem object
     */
    public FoodItem getFoodItem(){
        return this.foodItem;
    }

    /**
     * Facilitates the process of editing a food item
     * @return
     */
    public boolean editFoodItem(){
        //get name from user
        String name = foodItemView.editName();

        //set the food item
        foodItem = FoodItem.Pool.getInstance().getFoodItem(name);

        return true;
    }
}
