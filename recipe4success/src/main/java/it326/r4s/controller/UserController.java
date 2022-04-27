package it326.r4s.controller;

import it326.r4s.model.User;
import it326.r4s.view.UserView;
/**
 * Controller for R4S User
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class UserController {
    
    private static UserController globalUC = null;

    private User theUser;
    private UserView userView;

    private UserController(User theUser){
        this.theUser = theUser;
        this.userView = new UserView();
    }

    public static boolean initUserController(User theUser){
        if (globalUC == null){
            globalUC = new UserController(theUser);
            return true;
        }
        return false;
    }

    public static User getGlobalUser(){
        return globalUC.getUserInternal();
    }

    private User getUserInternal(){
        return theUser;
    }
    
}
