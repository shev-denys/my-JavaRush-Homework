package com.javalearn.test.level26.lesson15.big01.command;

import com.javalearn.test.level26.lesson15.big01.ConsoleHelper;
import com.javalearn.test.level26.lesson15.big01.CurrencyManipulator;
import com.javalearn.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Admin on 23.02.2015.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle("com.javalearn.test.level26.lesson15.big01.resources." + "info_en");
    @Override
    public void execute()
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> map = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (map.size()==0 || map.isEmpty())
            ConsoleHelper.writeMessage(res.getString("no.money"));
        else {
            int count = 0;
            for (CurrencyManipulator currencyManipulator:map )
            {
                if (currencyManipulator.hasMoney())
                {
                    count++;
                    ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode()+ " - " + currencyManipulator.getTotalAmount());
                }
            }
            if (count==0)  ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
