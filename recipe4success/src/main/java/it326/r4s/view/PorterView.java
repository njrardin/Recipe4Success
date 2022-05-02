package it326.r4s.view;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import it326.r4s.model.ExporterProducer;
import it326.r4s.view.utilities.InputAccess;

/**
 * View for all portable objects.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 5/1/22
 */
public class PorterView {
    JFileChooser chooser;
    JFrame frame;    
    InputAccess inputAccess;

    public PorterView() {
        chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        frame = new JFrame("R4S File Porter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);

        inputAccess = new InputAccess();
    }

    public String getExportPath() {
        String exportPath = "";

        // Prompt the user for an export path.
        if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            exportPath = chooser.getSelectedFile().getAbsolutePath();
        }

        return exportPath;
    }

    public String getImportPath() {
        String importPath = "";

        // Prompt the user for an import path.
        if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            importPath = chooser.getSelectedFile().getAbsolutePath();
        }

        return importPath;
    }

    public ExporterProducer.Type getExportType() {
        String[] options = new String[ExporterProducer.Type.values().length];

        int i = 0;
        for (ExporterProducer.Type type : ExporterProducer.Type.values()) {
            options[i++] = type.name();
        }

        return ExporterProducer.Type.values()[inputAccess.getOptionSelection("Export", "Which format do you want to export to?", options) - 1];
    }
}
