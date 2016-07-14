package com.javalearn.test.level08.lesson08.task04;

import java.lang.reflect.Array;
import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
  /* public static void main(String[] args)
    {
        HashMap<String, Date> map = createMap();


        for(HashMap.Entry<String, Date> el: map.entrySet())
            System.out.println(el.getKey()+ " - "+ el.getValue()+ " month: "+Integer.toString(el.getValue().getMonth()));

        removeAllSummerPeople(map);
        System.out.println();
        System.out.println();
        for(HashMap.Entry<String, Date> el: map.entrySet())
            System.out.println(el.getKey()+ " - "+ el.getValue()+ " month: "+Integer.toString(el.getValue().getMonth()));
    }*/

    public static HashMap<String, Date> createMap()
    {

        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("January 1 1980"));
        map.put("Сильвестр", new Date("January 1 1980"));
        map.put("Вандамм", new Date("January 1 1980"));
        map.put("Кинконг", new Date("January 3 1980"));
        map.put("Брюсли", new Date("January 1 1980"));
        map.put("Чакнорис", new Date("January 1 1980"));
        map.put("Чичолинна", new Date("January 1 1980"));
        map.put("Мордем", new Date("August 1 1980"));
        map.put("Юсбих", new Date("JUNE 1 1980"));
        map.put("Модем", new Date("July 1 1980"));

        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String,Date> pair = iterator.next();
              if (pair.getValue().getMonth() >= 5 && pair.getValue().getMonth() <= 7){
                iterator.remove();
            }

        }

    }
}
