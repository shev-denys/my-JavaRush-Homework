package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Admin on 23.02.2015.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res= ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources." + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        if (currencyManipulator == null) execute();
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            try
            {
                int amount = Integer.parseInt(ConsoleHelper.readString());

                if (!currencyManipulator.isAmountAvailable(amount))
                    throw new NotEnoughMoneyException();

                Map<Integer, Integer> getCash = new TreeMap<Integer, Integer>(new Comparator<Integer>()
                {
                    @Override
                    public int compare(Integer o1, Integer o2)
                    {
                        return o2 - o1;
                    }
                });

                getCash.putAll(currencyManipulator.withdrawAmount(amount));
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));

               /* for (Map.Entry<Integer, Integer> entry : getCash.entrySet())
                {
                    ConsoleHelper.writeMessage(  "\t" + entry.getKey() + " - " + entry.getValue());

                }*/

                break;
            }
            catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }

        }
    }
}
