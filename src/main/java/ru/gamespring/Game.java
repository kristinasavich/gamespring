package ru.gamespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;
import java.util.Scanner;

public class Game {
    public static int number;

    public Game() {
    }

    public Game(int number) {
        this.number = number;
    }

    public void startGame() {
        number = 0 + (int) (Math.random() * 1000);
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        EventPublisherNumber publisher = context.getBean(EventPublisherNumber.class);
        EventListenerNumber eventListener = context.getBean(EventListenerNumber.class);
        System.out.println(context.getMessage("hello", null, Locale.getDefault()));
        System.out.println(context.getMessage("gogame", null, Locale.getDefault()));
        while (!eventListener.getIsFind()) {
            int x = new Scanner(System.in).nextInt();
            publisher.publishNumber(x);
        }
    }

    public int getNumber() {
        return number;
    }

}
