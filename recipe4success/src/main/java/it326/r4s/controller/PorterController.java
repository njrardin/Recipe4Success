package it326.r4s.controller;

import org.apache.commons.io.FilenameUtils;

import it326.r4s.model.ExporterProducer;
import it326.r4s.model.Portable;
import it326.r4s.view.PorterView;

public class PorterController<T extends Portable> {
    private PorterView porterView;
    private Class<T> classT;

    private PorterController(Class<T> classT) {
        this.porterView = new PorterView();
        this.classT = classT;
    }

    public static <S extends Portable> PorterController<S> of(Class<S> type) {
        return new PorterController<S>(type);
    }

    public void export(T portable) {
        String exportPath = porterView.getExportPath();

        if (!exportPath.equals("")) {
            String extension = FilenameUtils.getExtension(exportPath);
            exportPath = FilenameUtils.removeExtension(exportPath);
            ExporterProducer.Type exportType = null;

            // Get the export type.
            if (!extension.equals("")) {
                for (ExporterProducer.Type type : ExporterProducer.Type.values()) {
                    if (extension.equalsIgnoreCase(type.name())) {
                        exportType = type;
                        break;
                    }
                }
            }
            
            // Get type from user.
            if (exportType == null) {
                exportType = porterView.getExportType();
            }

            exportPath += "." + exportType.name().toLowerCase();
            
            try {
                ExporterProducer.getExporter(exportType, classT).exportTo(portable, exportPath);
            } catch (Exception e) {
                System.err.println("An error occurred while exporting.");
            }
        } else {
            System.out.println("No file was selected, exiting ...");
        }   
    }
}
