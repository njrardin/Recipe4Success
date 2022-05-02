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
        User user = importFileData();
        launchMainWindow(user);
        saveAndExit(user);
    }

    private static void displayWelcome(){
        System.out.println(DisplayUtils.getHeader("-- WELCOME TO RECIPE 4 SUCCESS --"));
    }

    private static User importFileData() {
        new CategoryPoolManager().load();
        new FoodItemPoolManager().load();
        User user = new UserManager().load();
        
        if (user == null) {
            user = askUserForName();
            DemoUtils.prepopulateUser(user);
        }

        return user;
    }

    private static User askUserForName() {
        // TODO implement askUserForName
        return new User("SomeName");
    }

    private static void launchMainWindow(User user){
        UserController userController = new UserController(user);
        MainMenuController mmController = new MainMenuController(userController);
        
        mmController.launchMainMenu();
    }

    private static void saveAndExit(User user) {
        try {
            new UserManager().save(user);
            new CategoryPoolManager().save(Category.Pool.getInstance());
            new FoodItemPoolManager().save(FoodItem.Pool.getInstance());
        } catch (Exception e) {
            System.err.println("An error occurred while saving");
        }
 
        System.out.println("Thank you for using Recipe4Success!");
        System.out.println("\n\tapplication exiting...\n\n");

        InputAccess inputAccess = new InputAccess();
        inputAccess.close();
        System.exit(0);
     }
}
