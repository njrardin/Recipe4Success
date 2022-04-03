package it326.r4s;

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
        public void unitConverted(Unit initialUnit, Unit newUnit, double testQuantity){

            Ingredient theIngredient = new Ingredient(new FoodItem(), 10, initialUnit);

            theIngredient.changeUnit(newUnit);


            
        }
    }

}
