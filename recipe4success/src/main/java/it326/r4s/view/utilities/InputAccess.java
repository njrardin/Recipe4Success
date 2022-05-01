package it326.r4s.view.utilities;

import java.util.Scanner;

public class InputAccess {
    
    //*Static globaly used scanner*\\
    private static Scanner scanner;

    public InputAccess(){
        if(scanner == null){
            scanner = new Scanner(System.in); //initializes static scanner to system.in
        }
    }

    /**
     * Get user input using scanner
     * @return - String representing user input
     */
    public String getInputLine(){
        return scanner.nextLine();
    }

    /**
     * Closes the global scanner object
     */
    public void close() {
        scanner.close();
    }

    /**
     * Displays provided options and gets the user's selection
     * @param title - the title of the option menu
     * @param prompt - the question with which the options are provided
     * @param options - a String[] of the options
     * @return an int representing the selected option starting with the first option as 1, (e.g. selecting options[0] returns 1)
     */
    public int getOptionSelection(String title, String prompt, String[] options) {
        System.out.println();
        System.out.println(DisplayUtils.centerPadString(("-- " + title + " --"), DisplayUtils.CLI_WIDTH));
        System.out.println();
        System.out.println(prompt);
        
        for(int i = 0; i < options.length; i++){
            System.out.println((i + 1) + ") " + options[i]);
        }
        System.out.println();
        
        int selection = -1;
        do{
            System.out.print("Please select an option by entering the corresponding number: ");
            try{
                selection = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Invalid input, selection must be a number: ");
                continue;
            }
        } while( !(0 < selection && selection <= options.length));
        System.out.println("\n");

        return selection;
    }
}
