package com.javalearn.test.level14.lesson08.home09;

/**
 * Created by Admin on 10.11.2014.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    @Override
    public double getAmount()
    {
        return super.getAmount();
    }

    @Override
    public String getCurrencyName()
    {
        return "USD";
    }
}
