package com.javalearn.test.level05.lesson05.task03;

/* Геттеры и сеттеры для класса Dog
Создать class Dog. У собаки должна быть кличка String name и возраст int age.
Создайте геттеры и сеттеры для всех переменных класса Dog.
*/

public class Dog {
    //добавьте переменные класса тут
    private String name;
    private int age;
    //добавьте геттеры и сеттеры тут
    public String getName()
    {
        return this.name;
    }

    public int getAge()
    {
        return this.age;
    }

    public void  setName(String mname)
    {
        this.name = mname;
    }

    public void setAge(int mage)
    {
        this.age = mage;

    }
}
