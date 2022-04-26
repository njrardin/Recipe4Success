package it326.r4s.controller;

import it326.r4s.model.Pantry;
import it326.r4s.view.PantryView;

public class PantryController {

    private Pantry pantry;
    private PantryView pantryView;

    public PantryController(Pantry pantry){
        this.pantry = pantry;
        this.pantryView = new PantryView(this);
    }

    public void executeView(){
        pantryView.execute();
    }
}
