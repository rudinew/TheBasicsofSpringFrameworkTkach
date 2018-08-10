package com.tkach;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

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
        ConfigurableApplicationContext ctx =
                new ClassPathXmlApplicationContext("/spring.xml");

        App app = (App) ctx.getBean("app");

        Client client = ctx.getBean(Client.class);

        app.logEvent("Some event for user 1");
        //App app = new App(new Client("1", "John Smith"), new ConsoleEventLogger());

        //app.client = new Client("1", "John Smith");
        //app.eventLogger = new ConsoleEventLogger();

        ctx.close();
    }

    public void logEvent(String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        Event event = new Event(new Date());
        event.setMsg(message);
        eventLogger.logEvent(event);

    }


}
