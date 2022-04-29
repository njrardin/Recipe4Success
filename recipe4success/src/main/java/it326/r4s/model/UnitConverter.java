package it326.r4s.model;

/**
 * A UnitConverter for the Recipes4Success application.
 * 
 * @author PLEASE ADD YOUR NAME HERE
 * @date 4/26/2022
 */

public class UnitConverter {

    // *Enumerations*\\
    /**
     * Enumeration for different unit types.
     */
    public static enum UnitType {
        MASS,
        VOLUME,
        WEIGHT,
        NULL
    }

    public static enum Unit{
        NONE(0, "Unit", UnitType.NULL),
        //Volume Units (Imperial units are US imperial. UK imperial is different); BASE UNIT = Milliliter
        TEASPOON (4.928, "Teaspoon", UnitType.VOLUME), 
        TABLESPOON (14.786, "Tablespoon", UnitType.VOLUME), 
        FLUID_OUNCE (29.573, "Fluid ounce", UnitType.VOLUME), 
        CUP (240.000, "Cup", UnitType.VOLUME), 
        PINT (473.176, "Pint", UnitType.VOLUME), 
        QUART (946.353, "Quart", UnitType.VOLUME), 
        GALLON (3785.410, "Gallon", UnitType.VOLUME), 
        MILLILITER (1.000, "Milliliter", UnitType.VOLUME), 
        LITER (1000.000, "Liter", UnitType.VOLUME), 
        
        //Mass/Weight Units; BASE UNIT = gram
        POUND (453.592, "Pound", UnitType.WEIGHT), 
        OUNCE (28.350, "Ounce", UnitType.WEIGHT), 
        MILLIGRAM (0.001, "Milligram", UnitType.MASS), 
        GRAM (1.000, "Gram", UnitType.MASS), 
        KILOGRAM (1000.000, "Killogram", UnitType.MASS);

        public final double amountInBaseUnit;
        public final String stringRep;
        public final UnitType unitType;

        Unit(double amountInBaseUnit, String stringRep, UnitType unitType){
            this.amountInBaseUnit = amountInBaseUnit;
            this.stringRep = stringRep;
            this.unitType = unitType;
        }

        @Override
        public String toString(){
            return stringRep;
        }
        
    }

    // * Methods *\\
    /**
     * Attempts to convert old unit to new unit.
     * 
     * @param oldUnit         The original unit which is being converted.
     * @param oldUnitQuantity The quantity of substance as measured in the
     *                        oldUnit, must be valid quantity > 0.
     * @param newUnit         The desired new unit.
     * @return The quantity of substance as measured in the newUnit; throws
     *         IllegalArgumentException if units are unconvertable or quantities not
     *         valid.
     * @throws IllegalArgumentException if units are unconvertable or quantity is
     *                                  not valid.
     */
    public static double convertUnit(Unit oldUnit, double oldUnitQuantity, Unit newUnit)
            throws IllegalArgumentException {
        if (oldUnitQuantity <= 0) {
            throw new IllegalArgumentException();
        }
        if (oldUnit.unitType != newUnit.unitType) {
            throw new IllegalArgumentException();
        } else {
            return convertUnit(oldUnit, oldUnitQuantity, newUnit, 1);
        }
    }

    /**
     * Attempts to convert old unit to new unit when two units has different unit
     * type.
     * 
     * @param oldUnit                  The original unit which is being converted.
     * @param oldUnitQuantity          The quantity of substance as measured in
     *                                 the oldUnit, must be valid quantity > 0.
     * @param newUnit                  The desired new unit.
     * @param unitTypeConversionFactor The conversion factor between units types
     *                                 in terms of (old base unit type)/(new base
     *                                 unit type). (i.e, if oldUnit is a mass and
     *                                 newUnit is a volume, this should be the
     *                                 conversion factor of grams/milliliter).
     * @return
     * @throws IllegalArgumentException
     */
    public static double convertUnit(Unit oldUnit, double oldUnitQuantity, Unit newUnit,
            double unitTypeConversionFactor) throws IllegalArgumentException {
        if (oldUnitQuantity <= 0) {
            throw new IllegalArgumentException();
        } else {
            return (double) (oldUnitQuantity * oldUnit.amountInBaseUnit * (1 / unitTypeConversionFactor)
                    * (1 / newUnit.amountInBaseUnit));
        }
    }
}
