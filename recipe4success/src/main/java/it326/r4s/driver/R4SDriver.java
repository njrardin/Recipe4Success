package it326.r4s.driver;

import it326.r4s.controller.MainMenuController;
import it326.r4s.controller.UserController;
import it326.r4s.model.Category;
import it326.r4s.model.CategoryPoolManager;
import it326.r4s.model.FoodItem;
import it326.r4s.model.FoodItemPoolManager;
import it326.r4s.model.User;
import it326.r4s.model.UserManager;
import it326.r4s.view.utilities.DisplayUtils;
import it326.r4s.view.utilities.InputAccess;
public class R4SDriver {
    public static void main(String[] args) {     
        
        displayWelcome();

        User user = importFileData(); //TODO: Some way to get the user's name and other info the first time they use the app and remember it

        if (user == null) {
            user = new User("SomeName");
        } //TODO: implement way to get this from user only on first pass through

        launchMainWindow(user);

        saveAndExit(user);
    }

    private static void displayWelcome(){
        System.out.println(DisplayUtils.getHeader("-- WELCOME TO RECIPE 4 SUCCESS --"));
    }

    private static User importFileData() {
        return new UserManager().load();
    }

    private static void launchMainWindow(User user){
               
        UserController.initUserController(user);
        UserController userController = UserController.getUserController();
        MainMenuController mmController = new MainMenuController(userController);
        
        mmController.launchMainMenu();
    }

    private static void saveAndExit(User user) {
        try { //TODO: Save data from application before exit
            new UserManager().save(user);
            new CategoryPoolManager().save(Category.Pool.getInstance());
            new FoodItemPoolManager().save(FoodItem.Pool.getInstance());
        } catch (Exception e) {
            // TODO tell the user they are SOL
            System.err.println("An error occured while saving");
            e.printStackTrace();
        }
 
        System.out.println("Thank you for using Recipe4Success!");
        System.out.println("\n\tapplication exiting...\n\n");

        InputAccess inputAccess = new InputAccess();
        inputAccess.close();
        System.exit(0);
     }
}
