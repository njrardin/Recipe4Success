package it326.r4s;

public class UnitConverter {
    
    public enum Unit{
        TEASPOON, TABLESPOON, FLUID_OUNCE, CUP, PINT, QUART, GALLON, MILLILITER, LITER, 
        POUND, OUNCE, MILLIGRAM, GRAM, KILOGRAM
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
     * @return - The quantity of substance as measured in the newUnit; returns -1 if units are unconvertable
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
