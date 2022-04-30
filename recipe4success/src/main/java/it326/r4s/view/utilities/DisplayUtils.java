package it326.r4s.view.utilities;
;
/**
 * Utilites for R4S view classes
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class DisplayUtils {
    
    //*Globally accessible display variables*\\
    public static final int CLI_WIDTH = 80;
    public static final String HYPHEN_DIVIDER = getHyphenDivider(CLI_WIDTH);
    public static final String EQUALS_DIVIDER = getEqualsDivider(CLI_WIDTH);

    /**
     * Gets a string centered within a given width, padded with whitespace
     * @param theString
     * @param width
     * @return the padded string
     */
    public static String centerPadString(String theString, int width){
        int paddingAmt = (width - theString.length())/2;
        StringBuilder newString = new StringBuilder();
        for(int i = 0; i < (width - theString.length() + 1); i++){
            if(i == paddingAmt){
                newString.append(theString);
            }
            else{
                newString.append(" ");
            }
        }

        return newString.toString();
    }

    /**
     * Gets a header given a title
     * @param title
     * @return the String header
     */
    public static String getHeader(String title){
        
        //creates an internal header line
        StringBuilder headerInternalLineBuilder = new StringBuilder();
        headerInternalLineBuilder.append("===");
        for(int i = 0; i < CLI_WIDTH - 6; i++){
            headerInternalLineBuilder.append(" ");
        }
        headerInternalLineBuilder.append("===");
        String headerInternalLine = headerInternalLineBuilder.toString();
        
        //Creates the title line
        String titleLine = ("===" + centerPadString(title, (CLI_WIDTH - 6)) + "===");
        
        //Construct the header
        StringBuilder header = new StringBuilder();
        header.append("\n\n");
        header.append(EQUALS_DIVIDER + "\n");
        header.append(EQUALS_DIVIDER + "\n");
        header.append(headerInternalLine + "\n");
        header.append(titleLine + "\n");
        header.append(headerInternalLine + "\n");
        header.append(EQUALS_DIVIDER + "\n");
        header.append(EQUALS_DIVIDER + "\n");
        
        return header.toString();
    }

    private static String getHyphenDivider(int length){
        StringBuilder divider = new StringBuilder();
        for(int i = 0; i < length; i++){
            divider.append("-");
        }
        return divider.toString();
    }

    private static String getEqualsDivider(int length){
        StringBuilder divider = new StringBuilder();
        for(int i = 0; i < length; i++){
            divider.append("=");
        }
        return divider.toString();
    }
}
