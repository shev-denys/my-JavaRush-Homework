package com.javalearn.test.level14.lesson08.home09;

/**
 * Created by Admin on 10.11.2014.
 */
public class Hrivna extends Money
{
    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }

    public Hrivna(double amount)
    {
        super(amount);
    }

    @Override
    public double getAmount()
    {
        return super.getAmount();
    }
}
