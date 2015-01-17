package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        Scanner reader = new Scanner(new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        String string ="";
        while (reader.hasNext())
            string+=reader.nextLine()+" ";
        if (string.isEmpty())
            return;

        String[] stringArray = string.split(" ");

        ArrayList<String> list = new ArrayList<>(Arrays.asList(stringArray));

        for (String s:list)
        {
            String invertString = new StringBuilder(s).reverse().toString();
            boolean contains=false;
            for (String sCheck:list)
                if (sCheck.equals(invertString)&&sCheck!=s)
                    contains = true;


            if (contains)
            {
                Pair pair = new Pair();
                pair.first = s;
                pair.second= invertString;
                boolean hasIt = false;
                for(Pair pairIn: result)
                    if(pair.toString().equals(pairIn.toString()))
                        hasIt = true;

                if (!hasIt)
                    result.add(pair);
            }

        }

        for (Pair pair:result)
            System.out.println(pair);

    }

    public static class Pair {
        String first;
        String second;



        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
