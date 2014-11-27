package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import com.javarush.test.level06.lesson08.task05.StringHelper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> listpar = new ArrayList<String>();
        ArrayList<Object> listval = new ArrayList<Object>();
        try
        {
            String str = reader.readLine();
            String s = str.substring(str.indexOf("?") + 1);

            while (!s.equals(""))
            {
                String par = "";
                if (s.contains("&"))
                    par = s.substring(0, s.indexOf("&"));
                else
                    par = s;

                if (par.contains("="))
                {
                    listpar.add(par.substring(0, par.indexOf("=")));

                    if (("obj").equals(par.substring(0, par.indexOf("="))))
                    {
                        String temp = par.substring(par.indexOf("=") + 1);
                        try
                        {
                            listval.add(Double.parseDouble(temp));
                        }
                        catch (Exception e)
                        {
                            listval.add(temp);
                        }


                    }
                } else
                    listpar.add(par);

                if (s.contains("&"))
                    s = s.substring(s.indexOf("&") + 1);
                else s = "";

            }


            //alert(s);

            for (String pr : listpar)
            {
                System.out.print(pr);
                System.out.print(" ");

            }

            System.out.println();

            for (Object pr : listval)
            {
                if (pr instanceof String)
                    alert(pr.toString());
                else
                    alert((Double) pr);
            }
        }
        catch (Exception e)
        {
        }
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
