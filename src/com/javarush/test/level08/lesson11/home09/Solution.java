package com.javarush.test.level08.lesson11.home09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            System.out.println(isDateOdd(reader.readLine()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static boolean isDateOdd(String date) throws  Exception
    {

       // Date dd = new Date(reader.readLine());

        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd yyyy", Locale.US);
        String sDate = sdf.format(new Date(System.currentTimeMillis()));
        Date uDate = sdf.parse(date);
        Date uDate0 = sdf.parse(date);
         uDate0.setMonth(0);
        uDate0.setDate(1);
        uDate0.setMinutes(0);
        uDate0.setHours(0);
        uDate0.setSeconds(0);
        uDate.setMinutes(0);
        uDate.setHours(0);
        uDate.setSeconds(0);

        long diff= (uDate.getTime() - uDate0.getTime())/(24*60*60*1000);


        //System.out.println("current date time: " + sDate+"\nuser date: "+uDate);

        return diff%2 == 0;
    }
}
