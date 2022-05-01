package it326.r4s.driver;

import it326.r4s.controller.MainMenuController;
import it326.r4s.controller.UserController;
import it326.r4s.model.User;
import it326.r4s.view.utilities.DisplayUtils;
import it326.r4s.view.utilities.InputAccess;
public class R4SDriver {
    public static void main(String[] args) {     
        
        displayWelcome();

        importFileData(); //TODO: Some way to get the user's name and other info the first time they use the app and remember it

        launchMainWindow();

        saveAndExit();
    }

    private static void displayWelcome(){
        System.out.println(DisplayUtils.getHeader("-- WELCOME TO RECIPE 4 SUCCESS --"));
    }

    private static void importFileData() {
        //TODO: Import the User data from files
    }

    private static void launchMainWindow(){

        User user = new User("Name"); //TODO: implement way to get this from user only on first pass through
        UserController userController = new UserController(user);
        MainMenuController mmController = new MainMenuController(userController);
        
        mmController.launchMainMenu();
    }

    private static void saveAndExit() {
        //TODO: Save data from application before exit
 
        System.out.println("Thank you for using Recipe4Success!");
        System.out.println("\n\tapplication exiting...\n\n");

        InputAccess inputAccess = new InputAccess();
        inputAccess.close();
        System.exit(0);
     }
}
