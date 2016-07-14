package com.javalearn.test.level06.lesson05.task03;

/* 10 000 объектов Cat и Dog
Создать в цикле 10 000 объектов Cat и Dog.
(Java-машина должна начать уничтожать неиспользуемые, и метод finalize хоть раз да вызовется).
*/

public class Solution
{
    public static void main(String[] args)
    {
        Cat.count = 0;
        Dog.count = 0;
        for(int i = 0;i < 5000;i++)
        {
            Cat b = new Cat();
            Dog a = new Dog();
        }


System.out.print("Программа выполнена");
    }
}
class Cat
{
    public static int count;
    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
        System.out.println("Cat destroyed " + Integer.toString(count));
    }

    public  Cat()
    {count++;}
}

class Dog
{
    public static int count;
    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
        System.out.println("Dog destroyed "+ Integer.toString(count));
    }

    public  Dog()
    {count++;}
}