package com.javalearn.test.level26.lesson15.big01;

import com.javalearn.test.level26.lesson15.big01.command.CommandExecutor;
import com.javalearn.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by Admin on 16.02.2015.
 */
public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javalearn.test.level26.lesson15.big01.resources.";

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);


        try
        {

            Operation operation;
            try
            {
                CommandExecutor.execute(Operation.LOGIN);
            }
            catch (Exception e)
            {
            }
            do
            {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }
            while (!operation.equals(Operation.EXIT));
        }
        catch (InterruptOperationException e)
        {
           /* try
            {
                CommandExecutor.execute(Operation.EXIT);
            }
            catch (InterruptOperationException ignored)
            {
            }*/
            ConsoleHelper.printExitMessage();
        }
    }
}
