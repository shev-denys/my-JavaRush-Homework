package com.javalearn.test.level15.lesson12.home04;

/**
 * Created by Admin on 13.11.2014.
 */
public class Sun implements Planet
{
    private static Sun instance;

    private Sun(){}

    public static Sun getInstance(){
        if(instance == null){
            instance = new Sun();
        }
        return instance;
    }

}
