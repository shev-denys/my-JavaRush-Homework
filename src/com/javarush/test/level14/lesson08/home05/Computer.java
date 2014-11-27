package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Admin on 09.11.2014.
 */
public class Computer

{


    public Computer()
    {
        this.keyboard = new Keyboard();
        this.mouse = new Mouse();
        this.monitor = new Monitor();
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }

    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;
}
