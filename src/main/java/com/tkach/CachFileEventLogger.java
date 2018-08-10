package com.tkach;

import java.util.ArrayList;
import java.util.List;

public class CachFileEventLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cashe;


    public CachFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        this.cashe = new ArrayList<>();
    }

    @Override
    public void logEvent(Event event) {

        cashe.add(event);
        if(cashe.size() == cacheSize){
            writeEventsFromCache();
            cashe.clear();
        }
    }

    public void destroy(){
        if ( ! cashe.isEmpty()) {
            writeEventsFromCache();
        }
    }

    private void writeEventsFromCache() {
        cashe.stream().forEach(super::logEvent);
    }
}
