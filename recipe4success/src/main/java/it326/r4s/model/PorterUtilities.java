package it326.r4s.model;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * A class of utilities used for importing and exporting.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 5/3/22
 */
public class PorterUtilities {
    /**
     * Gets a reader object for the specified file.
     * @param filename the name of the file to be read.
     * @return the reader object.
     * @throws Exception if there was a problem getting a reader object.
     */
    public static Reader getReader(String filename) throws Exception {
        return Files.newBufferedReader(Path.of(filename));
    }

    /**
     * Gets a writer object for the specified file and creates all necessary directories.
     * @param filename the name of the file to be written to.
     * @return the writer object.
     * @throws Exception if there was a problem getting a writer object.
     */
    public static Writer getWriter(String filename) throws Exception {
        Path path = Path.of(filename);

        if (path.getNameCount() > 1) {
            try {
                Files.createDirectories(path.getParent());
            } catch (Exception e) {}
        }
             
        return Files.newBufferedWriter(path);
    }
}
