package it326.r4s;

public class UnitConverter {
    
    public enum Unit{
        //Volume Units (Imperial units are US imperial. UK imperial is different); BASE UNIT = Milliliter
        TEASPOON (4.92892), 
        TABLESPOON (14.7868), 
        FLUID_OUNCE (29.5735), 
        CUP (240), 
        PINT (473.176), 
        QUART (946.353), 
        GALLON (3785.41), 
        MILLILITER (1), 
        LITER (1000), 
        
        //Mass/Weight Units; BASE UNIT = gram
        POUND (453.592), 
        OUNCE (28.3495), 
        MILLIGRAM (0.001), 
        GRAM (1), 
        KILOGRAM (100);

        public final double amountInBaseUnit;

        Unit(double amountInBaseUnit){
            this.amountInBaseUnit = amountInBaseUnit;
        }
        
    }

    private final Unit[] massUnits = {
        //Fill with types
    };
    private final Unit[] volumeUnits = {
        //Fill with types
    };

    /**
     * 
     * @param oldUnit - The original unit which is being converted
     * @param oldUnitAmount - The quantity of substance as measured in the oldUnit
     * @param newUnit - The desired new unit
     * @return - The quantity of substance as measured in the newUnit; returns -1 if units are unconvertable or quantitys not valid
     */
    public static double convertUnit(Unit oldUnit, double oldUnitAmount, Unit newUnit){
        return 0; //Implement
    }

    private static double convertMass(Unit oldUnit, double oldUnitAmount, Unit newUnit){
        return 0; //Implement
    }

    private static double convertVolume(Unit oldUnit, double oldUnitAmount, Unit newUnit){
        return 0; //Implement
    }
}
