package com.javalearn.test.level26.lesson15.big01;

import com.javalearn.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle("com.javalearn.test.level26.lesson15.big01.resources."+ "common_en");

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }

    public static String readString() throws InterruptOperationException
    {

        String message = "";
        try
        {
            message = reader.readLine();
            if (message.equalsIgnoreCase(res.getString("operation.EXIT")))
                throw new InterruptOperationException();
        }
        catch (IOException ignored)
        {
        }
        return message;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.currency.code"));
        String currencyCode = readString();
        if (currencyCode.length() != 3)
        {
            writeMessage(res.getString("invalid.data"));
            currencyCode = askCurrencyCode();
        }
        return currencyCode.toUpperCase();
    }


    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        String twoDigitsLine = readString();
        String[] digits = twoDigitsLine.split(" ");
        if (digits.length != 2)
        {
            writeMessage(res.getString("invalid.data"));
            digits = getValidTwoDigits(currencyCode);
        }
        int denomination;
        int amount;
        try
        {
            denomination = Integer.parseInt(digits[0]);
            amount = Integer.parseInt(digits[1]);
            if (denomination <= 0 || amount < 0) throw new NumberFormatException();
        }
        catch (NumberFormatException e)
        {
            writeMessage(res.getString("invalid.data"));
            digits = getValidTwoDigits(currencyCode);
        }
        return digits;
    }

    public static Operation askOperation() throws InterruptOperationException
    {

        while (true)
        {
            writeMessage(res.getString("choose.operation"));
            String line = readString();
            if (checkWithRegExp(line))
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(line));
            else
                writeMessage(res.getString("invalid.data"));
        }

    }

    public static boolean checkWithRegExp(String Name)
    {
        Pattern p = Pattern.compile("^[1-4]$");
        Matcher m = p.matcher(Name);
        return m.matches();
    }

}