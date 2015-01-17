package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
                Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
            Нужно создать объединенную версию строк, записать их в список lines
            Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
            Пример:
            [Файл 1]
            строка1
            строка2
            строка3

                    [Файл 2]
            строка1
            строка3
            строка4

                    [Результат - список lines]
            SAME строка1
            REMOVED строка2
            SAME строка3
            ADDED строка4
            */

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(r.readLine()));
        BufferedReader reader2 = new BufferedReader(new FileReader(r.readLine()));
        r.close();
        ArrayList<String> file1 = new ArrayList<>();
        ArrayList<String> file2 = new ArrayList<>();
        while (reader1.ready())
        {
            file1.add(reader1.readLine());
        }
        reader1.close();
        while (reader2.ready())
        {
            file2.add(reader2.readLine());
        }
        reader2.close();

        int i1 = 0, i2 = 0, i1max = file1.size(), i2max = file2.size();
        ;
        while (true)
        {
            if (i1 >= i1max && i2 >= i2max)
                break;
            String f1s1 = new String();
            String f2s1 = new String();
            String f1s2 = new String();
            String f2s2 = new String();

            if (i1 < i1max)
                f1s1 = file1.get(i1);
            if (i2 < i2max)
                f2s1 = file2.get(i2);
            if (i1 < i1max - 1)
                f1s2 = file1.get(i1 + 1);
            if (i2 < i2max - 1)
                f2s2 = file2.get(i2 + 1);


            if (f1s1.equals(f2s1) && !f1s1.equals(""))
            {
                lines.add(new LineItem(Type.SAME, f1s1));
                i1++;
                i2++;
            } else if (f1s2.equals(f2s1) && !f2s1.equals(""))
            {
                lines.add(new LineItem(Type.REMOVED, f1s1));
                i1++;

            } else if (f1s1.equals(f2s2) && !f1s1.equals(""))
            {
                lines.add(new LineItem(Type.ADDED, f2s1));
                i2++;
            } else
            {
                if (i1 < i1max)
                {
                    if (!f1s1.equals(""))
                        lines.add(new LineItem(Type.REMOVED, f1s1));
                    i1++;
                    continue;
                }

                if (i2 < i2max)
                {
                    if (!f2s1.equals(""))
                        lines.add(new LineItem(Type.ADDED, f2s1));
                    i2++;
                    continue;

                }

            }

        }

         /*

                c:\data.txt
                c:\data1.txt

            */



        for (LineItem lineItem : lines)
        {
            System.out.println(lineItem.line + " " + lineItem.type);
        }

    }


    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}
