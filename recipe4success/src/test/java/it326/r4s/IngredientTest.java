package it326.r4s;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import org.junit.runner.RunWith;

import it326.r4s.UnitConverter.*;


public class IngredientTest {
    
    @RunWith(Parameterized.class)
    public class testChangeUnit{
    
        @Test
        public void unitConverted(Unit initialUnit, Unit newUnit){

            final double TEST_QUANTITY = 10; //should be irrelevant
            Ingredient theIngredient = new Ingredient(new FoodItem(), TEST_QUANTITY, initialUnit);

            theIngredient.changeUnit(newUnit);

            Unit returnedUnit = theIngredient.getUnit();
            
            assertEquals(newUnit, returnedUnit);

        }

        @Test
        public void quantityConverted(Unit initialUnit, Unit newUnit, double initialQuantity, double expextedNewQuantity){

            Ingredient theIngredient = new Ingredient(new FoodItem(), 10, initialUnit);

            theIngredient.changeUnit(newUnit);

            double returnedQuantity = theIngredient.getQuantity();
            
            assertEquals(expextedNewQuantity, returnedQuantity, 0.01);

        }

        @Parameterized.Parameters
        public static Collection checkConversionData(){
            return Arrays.asList(new Object[][]{
                {Unit.TEASPOON, Unit.TABLESPOON, 5, 1.666667},
                {Unit.KILOGRAM, Unit.GRAM, 10, 10000},
                {Unit.GALLON, Unit.CUP, -2, -1},
                {Unit.GALLON, Unit.POUND, 10, -1}
            });
        }

        
    }

}
