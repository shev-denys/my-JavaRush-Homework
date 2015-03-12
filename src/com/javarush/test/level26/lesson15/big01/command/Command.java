package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;



/**
 * Created by Admin on 23.02.2015.
 */
 interface Command
{
    public void execute() throws InterruptOperationException;
}
