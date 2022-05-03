package it326.r4s.model;

import java.io.IOException;
import java.io.Writer;

/**
 * A class that exports portable objects to text files.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 5/3/22
 */
public class TXT_Exporter<T extends Portable> implements Exporter<T>  {
    /**
     * Constructs a default text exporter object.
     */
    public TXT_Exporter() {}

    /**
     * Exports a portable object to a text file.
     */
    @Override
    public void exportTo(T portable, String filename) throws Exception {
        Writer writer = PorterUtilities.getWriter(filename);
        toText(portable, writer);
        writer.close();
    }

    /**
     * Writes a portable object to a text file.
     * @param portable the object to be exported.
     * @param writer the object to write with.
     * @throws IOException if there was a problem writing the object to the file.
     */
    private void toText(T portable, Writer writer) throws IOException {
       writer.write(portable.toString()); 
    }
}
