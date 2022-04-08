package ru.gamespring;

import org.springframework.context.ApplicationEvent;

public class EventNumber extends ApplicationEvent {
    private final int eventNumber;
    public EventNumber(int eventNumber) {
        super(eventNumber);
        this.eventNumber = eventNumber;
    }

    public int getNumber(){
        return eventNumber;
    }


}
