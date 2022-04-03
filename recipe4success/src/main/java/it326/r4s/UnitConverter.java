package it326.r4s;

public class UnitConverter {
    
    public enum Unit{
        //Fill with types
    }

    private final Unit[] massUnits = {
        //Fill with types
    };
    private final Unit[] volumeUnits = {
        //Fill with types
    };

    //returns double of new units value. returns -1 if unconvertable
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
