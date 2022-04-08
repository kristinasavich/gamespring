package ru.gamespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class EventListenerNumber implements ApplicationListener<EventNumber> {

    private boolean isFind;

    @Override
    public void onApplicationEvent(EventNumber event) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        if (event.getNumber() == Game.number) {
            System.out.println(context.getMessage("win", null, Locale.getDefault()) + " " + event.getNumber() + "!");
            setFind(true);
        } else if (event.getNumber() > Game.number) {
            System.out.println(context.getMessage("numberless", null, Locale.getDefault()));
        } else if (event.getNumber() < Game.number) {
            System.out.println(context.getMessage("numberbigger", null, Locale.getDefault()));
        }
    }

    public boolean getIsFind() {
        return isFind;
    }

    public void setFind(boolean isFind) {
        this.isFind = isFind;
    }

}
