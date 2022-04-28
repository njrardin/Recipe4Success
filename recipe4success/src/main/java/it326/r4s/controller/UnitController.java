package it326.r4s.controller;

import it326.r4s.model.UnitConverter.Unit;
import it326.r4s.view.UnitView;

public class UnitController {
    
    UnitView unitView;

    static Unit[] theUnits = 
    {Unit.NONE,
    Unit.TEASPOON,
    Unit.TABLESPOON,
    Unit.FLUID_OUNCE,
    Unit.CUP,
    Unit.PINT,
    Unit.QUART,
    Unit.GALLON,
    Unit.MILLILITER,
    Unit.LITER,
    Unit.POUND,
    Unit.OUNCE,
    Unit.MILLIGRAM,
    Unit.GRAM,
    Unit.KILOGRAM};

    public UnitController(){
        this.unitView = new UnitView();
    }

    public static Unit getUnit(){
        int selection = UnitView.getUnitSelection();

        return theUnits[selection - 1];
    }
}
