package it326.r4s.controller;

import it326.r4s.model.UnitConverter.Unit;
import it326.r4s.view.UnitView;

/**
 * Controller for R4S Unit
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/28/22
 */
public class UnitController {
    
    //*Instance variables*\\
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

    //*Constructor*\\
    /**
     * Constructor for R4S's UnitController
     */
    public UnitController(){
        this.unitView = new UnitView();
    }

    //*Methods*\\
    /**
     * gets the appropriate unit enumeration from user response using the unitView
     * @return the unit enumeration selected
     */
    public static Unit getUnit(){
        int selection = UnitView.getUnitSelection();

        return theUnits[selection - 1];
    }
}
