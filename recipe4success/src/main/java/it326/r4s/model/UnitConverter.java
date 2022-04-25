package it326.r4s.model;

/*
* TODO #10 - whoever implemented this class needs to write a header description.
* See User.java for good header examples
* 
*/

public class UnitConverter {
    
    public static enum UnitType{
        MASS,
        VOLUME,
        WEIGHT,
        NULL
    }

    public static enum Unit{
        NONE(0,UnitType.NULL),
        //Volume Units (Imperial units are US imperial. UK imperial is different); BASE UNIT = Milliliter
        TEASPOON (4.928, UnitType.VOLUME), 
        TABLESPOON (14.786, UnitType.VOLUME), 
        FLUID_OUNCE (29.573, UnitType.VOLUME), 
        CUP (240.000, UnitType.VOLUME), 
        PINT (473.176, UnitType.VOLUME), 
        QUART (946.353, UnitType.VOLUME), 
        GALLON (3785.410, UnitType.VOLUME), 
        MILLILITER (1.000, UnitType.VOLUME), 
        LITER (1000.000, UnitType.VOLUME), 
        
        //Mass/Weight Units; BASE UNIT = gram
        POUND (453.592, UnitType.WEIGHT), 
        OUNCE (28.350, UnitType.WEIGHT), 
        MILLIGRAM (0.001, UnitType.MASS), 
        GRAM (1.000, UnitType.MASS), 
        KILOGRAM (1000.000, UnitType.MASS);

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
            return convertUnit(oldUnit, oldUnitQuantity, newUnit, 1);
        }
    }

    /**
     * 
     * @param oldUnit - The original unit which is being converted
     * @param oldUnitQuantity - The quantity of substance as measured in the oldUnit, must be valid quantity > 0
     * @param newUnit - The desired new unit
     * @param unitTypeConversionFactor - The conversion factor between units types in terms of (old base unit type)/(new base unit type). (i.e, if oldUnit is a mass and newUnit is a volume, this should be the conversion factor of grams/milliliter)
     * @return
     * @throws IllegalArgumentException
     */
    public static double convertUnit(Unit oldUnit, double oldUnitQuantity, Unit newUnit, double unitTypeConversionFactor) throws IllegalArgumentException{
        if(oldUnitQuantity <= 0){
            throw new IllegalArgumentException();
        }
        else{ 
            return (double) (oldUnitQuantity * oldUnit.amountInBaseUnit * (1 / unitTypeConversionFactor)  * (1 / newUnit.amountInBaseUnit));
        }
    }
}
