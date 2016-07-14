package com.javalearn.test.level12.lesson04.task03;

/* Пять методов print с разными параметрами
Написать пять методов print с разными параметрами.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public  void print(int i)
    {
        System.out.println(i);
    }

    public  void print(Integer i)
    {
        System.out.println(i);
    }

    public  void print(String s)
    {
        System.out.println(s);
    }

    public  void print(String s, Integer i)
    {
        System.out.println(s + i);
    }

    public  void print(Integer i, String s)
    {
        System.out.println(s + i);
    }
}
