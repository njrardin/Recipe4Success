package it326.r4s;

import java.util.*;

import it326.r4s.MealPlan;

/**
 * Meal Planner stores all the meal plans of the system
 * 
 * @author Shu Liao (fliao@ilstu.edu)
 * @date 4/17/2022
 */
public class MealPlanner extends Entity {
    // *Instance Variables*\\
    private Collection<MealPlan> mealPlans;
    private int activeMealPlanIndex;

    // *Constructor*\\
    /**
     * Creates a default MealPlanner object.
     */
    public MealPlanner() {
        this.mealPlans = new Collection<MealPlan>();
        this.activeMealPlanIndex = 0;
    }

    /**
     * Creates a MealPlanner object with a specific collection of MealPlan.
     * 
     * @param mealPlans a collection of MealPlan for the MealPlanner.
     */
    public MealPlanner(Collection<MealPlan> mealPlans) {
        this.mealPlans = mealPlans;
        this.activeMealPlanIndex = 0;
    }

    // *Methods*\\
    /**
     * Sets the MealPlanner's active meal plan index.
     * 
     * @param index the new active meal plan index.
     */
    public void setActiveMealPlanIndex(int index) {
        this.activeMealPlanIndex = index;
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
     * @return true when the MealPlan is successfuly add to the MealPlanner, false
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
        String temp = "";
        for (MealPlan plan : mealPlans) {
            temp += plan.getMealPlanName() + "\n";
        }
        return "Meal Plans:\n" + temp;
    }
}
