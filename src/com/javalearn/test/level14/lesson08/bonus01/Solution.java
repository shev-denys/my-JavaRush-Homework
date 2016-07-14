package com.javalearn.test.level14.lesson08.bonus01;

import com.oracle.jrockit.jfr.InvalidValueException;
import sun.awt.image.ImageFormatException;
import sun.dc.path.PathError;

import javax.xml.soap.SOAPException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception 1
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
//2
        try
        {
            throw new RuntimeException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
//3
        try
        {
            throw new ArithmeticException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
//4
        try
        {
            throw new PathError();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
//5
        try
        {
            throw new ImageFormatException("exc");

        } catch (Exception e)
        {
            exceptions.add(e);
        }
//6
        try
        {
            throw new ParseException("dsf",2);

        } catch (Exception e)
        {
            exceptions.add(e);
        }
//7
        try
        {
            throw new SOAPException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
//8
        try
        {
            throw new SQLException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //9
        try
        {
            throw new DataFormatException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //10
        try
        {
            throw new InvalidValueException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}
