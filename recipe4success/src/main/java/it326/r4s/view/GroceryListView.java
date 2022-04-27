package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.GroceryListController;

public class GroceryListView {

    GroceryListController grlController;

    public GroceryListView(GroceryListController grlController) {
        this.grlController = grlController;
    }

    public void execute(){
        
        displayHeader();

        Scanner scanner = ViewUtilities.scan;
        String input = "";

        displayOptions();

        while (true) {
            input = scanner.nextLine().toLowerCase();
            System.out.println();

            switch (input) {
                case "1":
                    grlController.printGroceryList();
                    break;
                case "2":
                    grlController.exportGroceryList();
                    break;
                case "3":
                    grlController.addItem();
                    break;
                case "4":
                    grlController.removeItem();
                    break;
                case "5":
                    grlController.moveToPantry();
                    break;
                case "6":
                    grlController.organizeGroceryList();
                    break;
                case "7":
                    grlController.viewGroceryList();
                    break;
                case "8":
                    return;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
        }
    }

    private void displayHeader() {
        System.out.println("-------------------------------------------------------------------------------------\n"
                         + "-------------------------------------------------------------------------------------\n"
                         + "---                                                                               ---\n"
                         + "---                               -- Grocery List --                              ---\n"
                         + "---                                                                               ---\n"
                         + "-------------------------------------------------------------------------------------\n"
                         + "-------------------------------------------------------------------------------------\n");
    }

    private void displayOptions() {
        System.out.println();
        System.out.println("                               -- Grocery List Options --");
        System.out.println();
        System.out.println("\t1) Print Grocery List");
        System.out.println("\t2) Export Grocery List");
        System.out.println("\t3) Add item to Grocery List");
        System.out.println("\t4) Remove item from Grocery List");
        System.out.println("\t5) Move entire Grocery List to Pantry");
        System.out.println("\t6) Organize Grocery List");
        System.out.println("\t7) View Grocery List");
        System.out.println("\t8) Go back");
        System.out.println();
    }
}
