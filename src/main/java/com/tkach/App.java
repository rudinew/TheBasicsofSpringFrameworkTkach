package com.tkach;

/**
 * The Basics of Spring Framework Tkach
 * https://www.youtube.com/watch?v=y-obHCFTbZ4&index=3&list=PL6jg6AGdCNaWF-sUH2QDudBRXo54zuN1t
 *
 */
public class App 
{
    private Client client;
    private EventLogger eventLogger;

    /*public App() {
    }*/

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args )
    {
       // App app = new App();
        //app.client = new Client("1", "John Smith");
        //app.eventLogger = new ConsoleEventLogger();
       // app.logEvent("Some event for user 1");
    }

    public void logEvent(String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());

        eventLogger.logEvent(message);

    }
}
