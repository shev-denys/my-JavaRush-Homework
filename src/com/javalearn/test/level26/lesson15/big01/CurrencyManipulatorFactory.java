package com.javalearn.test.level26.lesson15.big01;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 16.02.2015.
 */
public final class CurrencyManipulatorFactory
{
     static Map<String, CurrencyManipulator> manipulators= new HashMap<>();

    private CurrencyManipulatorFactory()
    {
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return manipulators.values();
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if(!manipulators.containsKey(currencyCode)){
            manipulators.put(currencyCode, new CurrencyManipulator(currencyCode));
        }
        return manipulators.get(currencyCode);
    }

}
