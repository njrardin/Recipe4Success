package it326.r4s.view;

import java.util.Scanner;

/**
 * View for R4S Recipe
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/28/22
 */
public class UnitView {
    
    /**
     * Prompts the user with all possible unit options and asks for a selection
     * @return - an int representing the unit chosen
     */
    public static int getUnitSelection() {
        System.out.println("Please select a unit of measure from the list:");
        System.out.println("");
        System.out.println("1) None");
        System.out.println("2) Teaspoon");
        System.out.println("3) Tablespoon");
        System.out.println("4) Fluid Ounce");
        System.out.println("5) Cup");
        System.out.println("6) Pint");
        System.out.println("7) Quart");
        System.out.println("8) Gallon");
        System.out.println("9) Milliliter");
        System.out.println("10) Liter");
        System.out.println("11) Pound");
        System.out.println("12) Ounce");
        System.out.println("13) Milligram");
        System.out.println("14) Gram");
        System.out.println("15) Kilogram");

        Scanner scan = ViewUtilities.scan;
        int selection = -1;
        do{
            try{
                selection = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Please select an option by typing the corresponding number");
                continue;
            }
        } while(selection >= 15 && selection <=1);
        return selection;
    }
}
