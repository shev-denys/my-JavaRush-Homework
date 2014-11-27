package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        // Создай по два объекта каждого класса тут
Man man1 = new Man("mn1",1,"ad1");
        Man man2 = new Man("mn2",1,"ad2");

        Woman wm1 = new Woman("mn1",1,"ad1");
        Woman wm2 = new Woman("mn2",1,"ad2");
        // Выведи их на экран тут

        System.out.println(man1.name + " " + man1.age + " " + man1.address);
        System.out.println(man2.name + " " + man2.age + " " + man2.address);
        System.out.println(wm1.name + " " + wm1.age + " " + wm1.address);
        System.out.println(wm2.name + " " + wm2.age + " " + wm2.address);
    }
    public static class  Man
    {
       public String name,  address;
       public int age;

       public  Man(String name )
        {this.name = name;}

        public Man(int age )
        {this.age = age;}

        public  Man(String name,int age )
        {this.age = age;this.name = name;}

        public Man(String name,int age, String address )
        {this.age = age;this.name = name;this.address = address;}
    }

    public static class  Woman
    {
        String name,  address;
        int age;

        public  Woman(String name )
        {this.name = name;}

        public Woman(int age )
        {this.age = age;}

        public Woman(String name,int age )
        {this.age = age;this.name = name;}

        public Woman(String name,int age, String address )
        {this.age = age;this.name = name;this.address = address;}
    }

    // Напиши тут свои классы
}
