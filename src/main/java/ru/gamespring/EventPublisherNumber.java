package ru.gamespring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class EventPublisherNumber implements ApplicationContextAware{
    private ApplicationContext context;

    public void publishNumber(int numberGame){
        context.publishEvent(new EventNumber(numberGame));
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
