package com.tkach;

/**
 * Created by Rudoman on 03.08.2018.
 */
public class ConsoleEventLogger implements EventLogger{
    public void logEvent(String msg){
       System.out.println(msg);
    }
}
