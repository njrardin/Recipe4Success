package it326.r4s;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.experimental.runners.Enclosed;
import org.junit.runners.Parameterized.*;
import org.junit.runner.RunWith;

import it326.r4s.UnitConverter.*;

@RunWith(Enclosed.class)
public class IngredientTest {
    
    //Inner class used to run parameterized tests for testing correct quantity conversion in the method changeUnit() in Ingredient.java
    @RunWith(Parameterized.class)
    public static class testChangeUnitQuanities{
        
        private Unit initialUnit;
        private Unit newUnit;
        private double initialQuantity;
        private double expextedNewQuantity;

        //Initializes this class with different specified parameters each time
        public testChangeUnitQuanities(Unit initialUnit, Unit newUnit, double initialQuantity, double expextedNewQuantity){
            this.initialUnit = initialUnit;
            this.newUnit = newUnit;
            this.initialQuantity = initialQuantity;
            this.expextedNewQuantity = expextedNewQuantity;
        }

        //The sets of parameters with which testChangeUnitQuantities is initialized. Each set is ran once when the test class is run
        @Parameters
        public static Collection checkConversionData(){
            return Arrays.asList(new Object[][]{
                {Unit.TEASPOON, Unit.TABLESPOON, 5, 1.666667},
                {Unit.KILOGRAM, Unit.GRAM, 10, 10000},
                {Unit.GALLON, Unit.CUP, -2, -1},
                {Unit.GALLON, Unit.POUND, 10, -1}
            });
        }

        //Actual test for Ingredient.changeUnit() which checks for correct quantity conversion
        @Test
        public void quantityConverted(){

            Ingredient theIngredient = new Ingredient(new FoodItem(), initialQuantity, initialUnit);

            theIngredient.changeUnit(newUnit);

            double returnedQuantity = theIngredient.getQuantity();
            
            assertEquals(expextedNewQuantity, returnedQuantity, 0.01);

        }

    }

    //Inner class used to run parameterized tests for testing correct unit conversion in the method changeUnit() in Ingredient.java
    @RunWith(Parameterized.class)
    public static class testChangeUnitUnits{
        
        private Unit initialUnit;
        private Unit newUnit;

        //Initializes this class with different specified parameters each time
        public testChangeUnitUnits(Unit initialUnit, Unit newUnit){
            this.initialUnit = initialUnit;
            this.newUnit = newUnit;
        }

        //The sets of parameters with which testChangeUnitQuantities is initialized. Each set is ran once when the test class is run
        @Parameters
        public static Collection checkConversionData(){
            return Arrays.asList(new Object[][]{
                {Unit.TEASPOON, Unit.TABLESPOON},
                {Unit.KILOGRAM, Unit.GRAM},
                {Unit.GALLON, Unit.CUP},
                {Unit.GALLON, Unit.POUND}
            });
        }

        //Actual test for Ingredient.changeUnit() which checks for correct quantity conversion
        @Test
        public void unitConverted(){

            final double TEST_QUANTITY = 10; //should be irrelevant but is changable here
            Ingredient theIngredient = new Ingredient(new FoodItem(), TEST_QUANTITY, initialUnit);

            theIngredient.changeUnit(newUnit);

            Unit returnedUnit = theIngredient.getUnit();
            
            assertEquals(newUnit, returnedUnit);
        }

    }

}
