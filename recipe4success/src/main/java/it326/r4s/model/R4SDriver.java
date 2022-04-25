package it326.r4s.model;

import it326.r4s.view.MainMenu;
public class R4SDriver {
    public static void main(String[] args) {     
        
        displayWelcome();
        importFileData(); //TODO: Some way to get the user's name and other info the first time they use the app and remember it
        
        MainMenu.executeMainMenu();

        saveAndExit();
    }

    public static void displayWelcome(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("---                                                                               ---");
        System.out.println("---                      -- WELCOME TO RECIPES 4 SUCCESS! --                      ---");
        System.out.println("---                                                                               ---");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
    }

    private static void importFileData() {
       //TODO: Import the User data from files
    }

    private static void saveAndExit() {
        //TODO: Save data from application before exit
 
        System.out.println("Thank you for using Recipe4Success!");
        System.out.println("\n\tapplication exiting...\n\n");

        System.exit(0);
     }
}
