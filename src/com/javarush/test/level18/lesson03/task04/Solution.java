package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fi = new FileInputStream( new BufferedReader(new InputStreamReader(System.in)).readLine());

        HashMap<Integer,Integer> map = new HashMap<>();
        int min=0;
        while (fi.available()>0)
        {
            int temp = fi.read();

            if (map.containsKey(temp))
            {
                int num = map.get(temp);
                map.put(temp, ++num);

            }
            else map.put(temp,1);
        }

        for(Map.Entry<Integer,Integer> set : map.entrySet())
        {
            if (min==0)
                min = set.getValue();

            if(set.getValue()<min)
                min= set.getValue();
        }

        String str ="";
        for(Map.Entry<Integer,Integer> set : map.entrySet())
            if (set.getValue()==min)
            {
                if (!str.equals(""))
                    str+="," +set.getKey();
                else str+="" +set.getKey();

            }
        System.out.print(str);
        fi.close();
    }
}
