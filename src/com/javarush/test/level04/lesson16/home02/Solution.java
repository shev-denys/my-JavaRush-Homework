package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if (a > min(a, min(b, c)) && a < max(a, max(b, c)))
            System.out.print(a);
        else if (b > min(a, min(b, c)) && b < max(a, max(b, c)))
            System.out.print(b);
        else
            System.out.print(c);
    }

    public static int max ( int a, int b)
        {
            if (a > b) return a;
            else return b;
        }

    public static int min(int a, int b)
    {
        if (a < b) return a;
        else return b;
    }
}
