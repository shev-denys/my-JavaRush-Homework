package com.javalearn.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    String name;
    int age, color;

    public Dog(String name)
    {this.name = name;}

    public Dog(String name, int age)
    {this.name = name;
        this.age = age;}

    public Dog(String name, int age, int color)
    {this.name = name;
        this.age = age;
    this.color = color;}


}
