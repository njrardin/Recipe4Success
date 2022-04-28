package it326.r4s.view;

import java.util.Scanner;
/**
 * Utilites for R4S view classes
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class ViewUtilities {
    
    public static Scanner scan = new Scanner(System.in); //TODO: better version of this mess

    /**
     * Displays provided options and gets the user's selection
     * @param title - the title of the option menu
     * @param prompt - the question with which the options are provided
     * @param options - a String[] of the options
     * @return an int representing the selected option starting with the first option as 1, (e.g. selecting options[0] returns 1)
     */
    public static int getOptionFromCLI(String title, String prompt, String[] options) {
        Scanner newScan = scan;

        System.out.printf("%50s%n", "-- " + title + " --");
        System.out.println();
        System.out.println(prompt);
        for(int i = 0; i < options.length; i++){
            System.out.println((i + 1) + ") " + options[i]);
        }
        System.out.println();
        
        int selection = -1;
        do{
            System.out.println("Please select an option by entering the corresponding number:");
            try{
                selection = Integer.parseInt(newScan.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input, selection must be a number:");
                continue;
            }
        } while( !(0 < selection && selection <= options.length));

        return selection;
    }
}
