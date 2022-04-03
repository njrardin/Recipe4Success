package it326.r4s;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;
import it326.r4s.UnitConverter.*;


public class IngredientTest {
    
    @RunWith(Theories.class)
    public class testChangeUnit{
    
        @Theory
        public void unitConverted(Unit initialUnit, Unit finalUnit){
            
            final double INIT_QUANTITY = 10;

            Ingredient ingredient = new Ingredient(new FoodItem(), 10, initialUnit);

            
        }
    }

}
