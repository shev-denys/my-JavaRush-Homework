package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        ArrayList<Integer> array = new ArrayList<Integer>();
        //Открываем поток, читающий из файла
        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    int a = Integer.parseInt(s);
                    if(a%2==0)
                        array.add(a);
                        //System.out.println(s);
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        //Integer min = array.get(0);
        //for(int i=1; i<array.size();i++)
        Collections.sort(array,new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o1-o2;
            }
        });

        for(int i=0; i<array.size();i++)
            System.out.println(array.get(i));

    }
}
