package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character, Integer>();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(int i=0;i<32;i++)
        {

            alphabet.add( (char) ('а'+i));
        }
        alphabet.add(6,'ё');

        for( Character ch : alphabet)
        map.put(ch,0);


       // map.get('d').hashCode()
        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<10;i++)
        {
            String s = reader.readLine();
            list.add( s.toLowerCase());
        }


        for(String str : list)
            for (Character ch : str.toCharArray())
            {
                if (map.get(ch) != null && alphabet.contains(ch))
                {
                    int num = map.get(ch);
                    map.put(ch, num+1);
                }
                else if (alphabet.contains(ch))
                map.put(ch, 1);
            }

        for(Map.Entry<Character, Integer> entry: map.entrySet())
        {
            System.out.println(entry.getKey()+ " " + entry.getValue());
        }

        //Напишите тут ваш код
    }

}
