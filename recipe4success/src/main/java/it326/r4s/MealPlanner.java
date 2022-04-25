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
    private Collection<MealPlan> mealPlans;
    private int activeMealPlanIndex;

    public MealPlanner() {
        this.mealPlans = new ArrayList<MealPlan>();
        this.activeMealPlanIndex = 0;
    }

    public MealPlanner(Collection<MealPlan> mealPlans) {
        this.mealPlans = mealPlans;
        this.activeMealPlanIndex = 0;
    }

    public void setActiveMealPlanIndex(int index) {
        this.activeMealPlanIndex = index; //TODO: Implement the logic to ensure this is within bounds
    }

    public int getActiveMealPlanIndex() {
        return this.activeMealPlanIndex;
    }

    public boolean addMealPlan(MealPlan toAdd) {
        for (MealPlan meal : mealPlans) {
            if (meal.equals(toAdd)) {
                return false;
            }
        }
        mealPlans.add(toAdd);
        return true;
    }

    public boolean removeMealPlan(MealPlan toRemove) {
        for (MealPlan meal : mealPlans) {
            if (meal.equals(toRemove)) {
                mealPlans.remove(toRemove);
                return true;
            }
        }
        return false;
    }
}
