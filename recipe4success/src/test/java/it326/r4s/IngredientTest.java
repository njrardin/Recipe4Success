package it326.r4s;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import it326.r4s.model.FoodItem;
import it326.r4s.model.Ingredient;
import it326.r4s.model.UnitConverter.Unit;

@RunWith(Enclosed.class)
public class IngredientTest {
    static FoodItem.Pool fiPool = FoodItem.Pool.getInstance();

    /*
     * Inner class used to run parameterized tests for that the method changeUnit()
     * in Ingredient.java
     * correctly returns either false or true based on the validity of the quantity
     * entered
     */
    @RunWith(Parameterized.class)
    public static class testChangeUnitReturnValidity {

        private double initialQuantity;
        private boolean expectedValidity; // whether that quantity should return true or false

        // Initializes this class with different specified parameters each time
        public testChangeUnitReturnValidity(double initialQuantity, Boolean expectedValidity) {
            this.initialQuantity = initialQuantity;
            this.expectedValidity = expectedValidity;
        }

        // The sets of parameters with which testChangeUnitQuantities is initialized.
        // Each set is ran once when the test class is run
        @Parameters
        public static Collection<Object[]> checkConversionData() {
            return Arrays.asList(new Object[][] {
                    { 5, true },
                    { 10, true },
                    { -2, false },
            });
        }

        // ADD copy constructor test
        @Test
        public void testConstructor() {
            Ingredient ingredient = new Ingredient(fiPool.getFoodItem("Food1"), 2, Unit.CUP);
            assertNotNull(ingredient);
            FoodItem fiChecker = fiPool.getFoodItem("Food1");
            assertEquals(fiChecker, ingredient.getFoodItem());

            Ingredient ingredient2 = new Ingredient("Food2", 4, Unit.OUNCE);
            assertNotNull(ingredient2);
            fiChecker = fiPool.getFoodItem("Food2");
            assertEquals(fiChecker, ingredient2.getFoodItem());

            Ingredient newIngredient = new Ingredient("Food3", 1, Unit.KILOGRAM);
            ingredient2 = new Ingredient(newIngredient);
            assertNotNull(ingredient2);
            fiChecker = fiPool.getFoodItem("Food3");
            assertEquals(fiChecker, ingredient2.getFoodItem());
        }

        // Actual test for Ingredient.changeUnit() which checks for correct quantity
        // conversion
        @Test
        public void quantityConverted() {

            final Unit INIT_UNIT = Unit.TEASPOON; // this should be irrelevant but is changeable here just in case
            Ingredient theIngredient = new Ingredient(fiPool.getFoodItem("Flour"), initialQuantity, INIT_UNIT);

            boolean returnedValidity = theIngredient.changeUnit(INIT_UNIT);

            assertEquals(expectedValidity, returnedValidity);

        }

    }

    // Inner class used to run parameterized tests for testing correct unit
    // conversion in the method changeUnit() in Ingredient.java
    @RunWith(Parameterized.class)
    public static class testChangeUnitUnits {

        private Unit initialUnit;
        private Unit newUnit;

        // Initializes this class with different specified parameters each time
        public testChangeUnitUnits(Unit initialUnit, Unit newUnit) {
            this.initialUnit = initialUnit;
            this.newUnit = newUnit;
        }

        // The sets of parameters with which testChangeUnitQuantities is initialized.
        // Each set is ran once when the test class is run
        @Parameters
        public static Collection<Object[]> checkConversionData() {
            return Arrays.asList(new Object[][] {
                    { Unit.TEASPOON, Unit.TABLESPOON },
                    { Unit.KILOGRAM, Unit.GRAM },
                    { Unit.GALLON, Unit.CUP },
                    { Unit.GALLON, Unit.MILLILITER }
            });
        }

        // Actual test for Ingredient.changeUnit() which checks for correct quantity
        // conversion
        @Test
        public void unitConverted() {

            final double TEST_QUANTITY = 10; // should be irrelevant but is changeable here
            Ingredient theIngredient = new Ingredient(fiPool.getFoodItem("Flour"), TEST_QUANTITY, initialUnit);

            theIngredient.changeUnit(newUnit);

            Unit returnedUnit = theIngredient.getUnit();

            assertEquals(newUnit, returnedUnit);
        }

    }

}
