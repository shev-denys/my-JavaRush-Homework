package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Admin on 10.11.2014.
 */
public class Singleton
{
    private static Singleton INSTANCE = null;
    private Singleton() {}

    static Singleton getInstance() {
        if (INSTANCE==null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}
