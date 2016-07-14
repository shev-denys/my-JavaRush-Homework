package com.javalearn.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        public String name;
        public int age;
        public String secondname;
        public Human mother;
        public Human father;
        public boolean sex;

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, int age, String secondname, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.secondname = secondname;
            this.sex = sex;
        }

        public Human(String name, Human mother, Human father)
        {

            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        public Human(String name, Human mother, Human father, String secondname, int age, boolean sex)
        {

            this.name = name;
            this.mother = mother;
            this.father = father;
            this.secondname = secondname;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, String secondname, boolean sex, int age)
        {

            this.name = name;
            this.secondname = secondname;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, Human mother, Human father, boolean sex)
        {

            this.name = name;
            this.mother = mother;
            this.father = father;
            this.sex = sex;
        }

        public Human(String name, String secondname, boolean sex)
        {
            this.name = name;
            this.secondname = secondname;
            this.sex = sex;
        }

        public Human(String name, String secondname)
        {

            this.name = name;
            this.secondname = secondname;
        }

        public Human(String name, Human father, boolean sex)
        {
            this.name = name;
            this.father = father;
            this.sex = sex;
        }

        public Human(String name, int age, boolean sex)
        {

            this.name = name;
            this.age = age;
            this.sex = sex;
        }
    }
}
