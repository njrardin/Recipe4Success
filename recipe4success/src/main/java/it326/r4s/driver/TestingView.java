package it326.r4s.driver;

import it326.r4s.view.ViewUtilities;

public class TestingView {
    public static void main(String[] args) {
        String title = "title";
        String prompt = "This is a question?";
        String[] options =
        {
            "Option one",
            "Another one",
            "Memememeemmeme",
        };

        int option = ViewUtilities.getOptionFromCLI(title, prompt, options);
        int option2 = ViewUtilities.getOptionFromCLI(title, prompt, options);

        System.out.println("The option chosen: " + option);
        System.out.println("The option2 chosen: " + option2);
    }
}
