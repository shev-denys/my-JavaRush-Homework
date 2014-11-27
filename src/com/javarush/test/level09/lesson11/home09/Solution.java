package com.javarush.test.level09.lesson11.home09;

import com.javarush.test.level05.lesson09.task02.Cat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> cats= new HashMap<String, Cat>();
        for(int i = 0 ; i < 10; i++)
            cats.put(Integer.toString(i),new Cat(Integer.toString(i)));

        return cats;

    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
       Set<Cat> catSet = new HashSet<Cat>();
        for(Map.Entry<String, Cat> cat: map.entrySet())
            catSet.add(cat.getValue());

        return catSet;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
