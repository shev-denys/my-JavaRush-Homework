package com.javalearn.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println((int)5);
        System.out.println((Integer)2);
    }

    public  void print(int i)
    {
        System.out.println(i);
    }

    public  void print(Integer i)
    {
        System.out.println(i);
    }
}
