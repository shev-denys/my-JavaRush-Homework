package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Admin on 28.02.2015.
 */
class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources." + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources." + "login_en");



    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));


            String s1 = ConsoleHelper.readString().trim();
            String s2 = ConsoleHelper.readString().trim();

            if (validCreditCards.containsKey(s1) && s1.length() == 12)
                if (validCreditCards.getString(s1).equals(s2))
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), s1));
                    break;
                }
            ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), s1));
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));

        }
    }
}
