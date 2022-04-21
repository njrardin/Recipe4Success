package it326.r4s;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.experimental.runners.Enclosed;
import org.junit.runners.Parameterized.*;

import it326.r4s.model.UnitConverter;
import it326.r4s.model.UnitConverter.Unit;

import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class UnitConverterTest {

    @RunWith(Parameterized.class)
    public static class testConvertUnit_SameUnit{

        private Unit oldUnit;
        private Unit newUnit;
        private double oldUnitQuantity;

        private double expectedReturn;
        private final double DELTA = 0.2;
        
        public testConvertUnit_SameUnit(Unit oldUnit, Unit newUnit, double oldUnitQuantity, double expectedReturn){
            this.oldUnit = oldUnit;
            this.newUnit = newUnit;
            this.oldUnitQuantity = oldUnitQuantity;
            this.expectedReturn = expectedReturn;
        }
        
        @Parameters
        public static Collection<Object[]> testConvertUnit_SameUnit_Data(){
            return Arrays.asList(new Object[][]{
                //{oldunit, newUnit, oldUnitQuantity, expectedReturn}
                {Unit.TEASPOON, Unit.PINT, 16, 0.167},
                {Unit.FLUID_OUNCE, Unit.LITER, 4789, 141.628},
                {Unit.GALLON, Unit.MILLILITER, 20, 75708.236},
                {Unit.CUP, Unit.TABLESPOON, 0.46, 7.36},
                {Unit.QUART, Unit.FLUID_OUNCE, 3.2, 102.4}
            });
        }

        @Test
        public void testConvertUnit(){
            double actualReturn = UnitConverter.convertUnit(oldUnit, oldUnitQuantity, newUnit);

            assertEquals(expectedReturn, actualReturn, DELTA);
        }
    }

    @RunWith(Parameterized.class)
    public static class testConvertUnit_DifferentUnit{

        private Unit oldUnit;
        private Unit newUnit;
        private double oldUnitQuantity;
        private double unitTypeConversionFactor;

        private double expectedReturn;
        private final double DELTA = 0.2;
        
        public testConvertUnit_DifferentUnit(Unit oldUnit, Unit newUnit, double oldUnitQuantity, double unitTypeConversionFactor, double expectedReturn){
            this.oldUnit = oldUnit;
            this.newUnit = newUnit;
            this.oldUnitQuantity = oldUnitQuantity;
            this.expectedReturn = expectedReturn;
            this.unitTypeConversionFactor = unitTypeConversionFactor;
        }
        
        @Parameters
        public static Collection<Object[]> testConvertUnit_DifferentUnit_Data(){
            return Arrays.asList(new Object[][]{
                //{oldunit, newUnit, oldUnitQuantity, unitTypeConversionFactor, expectedReturn}
                {Unit.POUND, Unit.LITER, 2, 0.7, 1.296},
                {Unit.MILLILITER, Unit.POUND, 502, (1/1.38), 1.527}
            });
        }

        @Test
        public void testConvertUnit(){
            double actualReturn = UnitConverter.convertUnit(oldUnit, oldUnitQuantity, newUnit, unitTypeConversionFactor);

            assertEquals(expectedReturn, actualReturn, DELTA);
        }
    }
}
