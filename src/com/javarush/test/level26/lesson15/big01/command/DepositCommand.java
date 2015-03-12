package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;


/**
 * Created by Admin on 23.02.2015.
 */
class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources." + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] denominations = ConsoleHelper.getValidTwoDigits(currencyCode);

        try
        {
            int denomination = Integer.parseInt(denominations[0]);
            int count = Integer.parseInt(denominations[1]);

            CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode).addAmount(denomination, count);
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), denomination * count, currencyCode.toUpperCase()));
        }
        catch (NumberFormatException e)
        {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }

    }
}
