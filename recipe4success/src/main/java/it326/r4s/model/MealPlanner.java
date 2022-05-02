package it326.r4s.model;

import java.util.*;
/**
 * Meal Planner stores all the meal plans of the system
 * 
 * @author Shu Liao (fliao@ilstu.edu)
 * @date 4/17/2022
 */
public class MealPlanner extends Entity {
    // *Instance Variables*\\
    private ArrayList<MealPlan> mealPlans;
    private int activeMealPlanIndex;

    // *Constructor*\\
    /**
     * Creates a default MealPlanner object.
     */
    public MealPlanner() {
        this.mealPlans = new ArrayList<MealPlan>();
        this.activeMealPlanIndex = -1;
    }

    /**
     * Creates a MealPlanner object with a specific collection of MealPlan.
     * 
     * @param mealPlans a collection of MealPlan for the MealPlanner.
     */
    public MealPlanner(ArrayList<MealPlan> mealPlans) {
        this.mealPlans = mealPlans;
        this.activeMealPlanIndex = -1;
    }

    // *Methods*\\
    public ArrayList<MealPlan> getMealPlans(){
        return mealPlans;
    }

    /**
     * Sets the MealPlans for the MealPlanner
     * @param mealPlans - a Collection of MealPlans
     */
    public void setMealPlans(ArrayList<MealPlan> mealPlans){
        this.mealPlans = mealPlans;
    }

    /**
     * Sets the MealPlanner's active meal plan index.
     * 
     * @param index the new active meal plan index.
     */
    public boolean setActiveMealPlanIndex(int index) {
        if(index < 0 || mealPlans.size() <= index){ //if out of range
            return false;
        }
        this.activeMealPlanIndex = index;
        return true;
    }

    /**
     * Gets the MealPlanner's active meal plan index.
     * 
     * @return the active meal plan index of the MealPlanner.
     */
    public int getActiveMealPlanIndex() {
        return this.activeMealPlanIndex;
    }

    /**
     * Attempts to add a MealPlan object to the MealPlanner.
     * 
     * @param toAdd the new MealPlan to be added.
     * @return true when the MealPlan is successfully add to the MealPlanner, false
     *         otherwise.
     */
    public boolean addMealPlan(MealPlan toAdd) {
        for (MealPlan meal : mealPlans) {
            if (meal.equals(toAdd)) {
                return false;
            }
        }
        mealPlans.add(toAdd);
        return true;
    }

    /**
     * Attempts to remove a MealPlan object from the MealPlanner.
     * 
     * @param toRemove the MealPlan to be removed.
     * @return true when the MealPlan is successfully remove from the MealPlanner,
     *         false otherwise.
     */
    public boolean removeMealPlan(MealPlan toRemove) {
        for (MealPlan meal : mealPlans) {
            if (meal.equals(toRemove)) {
                mealPlans.remove(toRemove);
                return true;
            }
        }
        return false;
    }

    /**
     * An override for the .toString method of java.objre
     * 
     * @return a string representation of the MealPlanner object.
     */
    @Override
    public String toString() {
        String string = "";
        int i = 1;
        for(MealPlan mealplan: mealPlans){
            if(i == 1){
                string += (i + ") " + mealplan.toString());
            } else {
                string += ("\n" + i + ") " + mealplan.toString());
            }
            i++;
        }
        return string;
    }
}
