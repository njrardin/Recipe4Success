package it326.r4s;

import java.lang.Exception.*;

public class UnitConverter {
    
    public static enum UnitType{
        MASS,
        VOLUME,
        WEIGHT,
    }

    public static enum Unit{
        //Volume Units (Imperial units are US imperial. UK imperial is different); BASE UNIT = Milliliter
        TEASPOON (4.92892, UnitType.VOLUME), 
        TABLESPOON (14.7868, UnitType.VOLUME), 
        FLUID_OUNCE (29.5735, UnitType.VOLUME), 
        CUP (240, UnitType.VOLUME), 
        PINT (473.176, UnitType.VOLUME), 
        QUART (946.353, UnitType.VOLUME), 
        GALLON (3785.41, UnitType.VOLUME), 
        MILLILITER (1, UnitType.VOLUME), 
        LITER (1000, UnitType.VOLUME), 
        
        //Mass/Weight Units; BASE UNIT = gram
        POUND (453.592, UnitType.WEIGHT), 
        OUNCE (28.3495, UnitType.WEIGHT), 
        MILLIGRAM (0.001, UnitType.MASS), 
        GRAM (1, UnitType.MASS), 
        KILOGRAM (100, UnitType.MASS);

        public final double amountInBaseUnit;
        public final UnitType unitType;

        Unit(double amountInBaseUnit, UnitType unitType){
            this.amountInBaseUnit = amountInBaseUnit;
            this.unitType = unitType;
        }
        
    }

    /**
     * 
     * @param oldUnit - The original unit which is being converted
     * @param oldUnitQuantity - The quantity of substance as measured in the oldUnit, must be valid quantity > 0
     * @param newUnit - The desired new unit
     * @return - The quantity of substance as measured in the newUnit; throws IllegalArgumentException if units are unconvertable or quantities not valid
     * @throws IllegalArgumentException if units are unconvertable or quantity is not valid
     */
    public static double convertUnit(Unit oldUnit, double oldUnitQuantity, Unit newUnit) throws IllegalArgumentException{
        if(oldUnitQuantity <= 0){
            throw new IllegalArgumentException();
        }
        if(oldUnit.unitType != newUnit.unitType){
            throw new IllegalArgumentException();
        }
        else{ 
            return (double) ( oldUnitQuantity * ( oldUnit.amountInBaseUnit/newUnit.amountInBaseUnit) );
        }
    }

    private static double convertMass(Unit oldUnit, double oldUnitQuantity, Unit newUnit){
        return 0; //Implement
    }

    private static double convertVolume(Unit oldUnit, double oldUnitQuantity, Unit newUnit){
        return 0; //Implement
    }
}
