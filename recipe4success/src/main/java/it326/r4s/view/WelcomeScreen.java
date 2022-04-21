package it326.r4s.view;

public class WelcomeScreen {
    
    public static void executeWelcomeScreen(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("---                                                                               ---");
        System.out.println("---                      -- WELCOME TO RECIPES 4 SUCCESS! --                      ---");
        System.out.println("---                                                                               ---");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");

        welcomeSetup();

        MainMenu.executeMainMenu();
    }

    private static void welcomeSetup(){
        //TODO: Implement the logic for importing all the items and stuff 
    }
}
