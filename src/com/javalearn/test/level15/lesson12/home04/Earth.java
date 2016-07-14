package com.javalearn.test.level15.lesson12.home04;

/**
 * Created by Admin on 13.11.2014.
 */
public class Earth implements Planet
{
    private static Earth instance;

    private Earth(){}

    public static Earth getInstance(){
        if(instance == null){
            instance = new Earth();
        }
        return instance;
    }
}
