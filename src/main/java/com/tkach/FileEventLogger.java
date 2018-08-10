package com.tkach;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String filename;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(new File(filename), event.getMsg(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException{
        //this.file = new File(filename);
        File file = new File(filename);
        //
        file.canWrite();

    }
}
