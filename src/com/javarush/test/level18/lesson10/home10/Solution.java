package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Solution
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Map<String, Integer> map = new TreeMap<>();

            String fName;

            while (true)
            {
                fName = reader.readLine();
                if (fName.equals("end")) break;
                map.put(fName, 1);
            }

            for (Map.Entry<String, Integer> set : map.entrySet())
            {
                fName = set.getKey();
                break;
            }

            String fileOutName = getFileName(fName);
            FileOutputStream out = new FileOutputStream(fileOutName);

            FileInputStream inp;
            for (Map.Entry<String, Integer> set : map.entrySet())
            {
                inp = new FileInputStream(set.getKey());
                while (inp.available() > 0)
                {

                    out.write(inp.read());
                }
                inp.close();
            }

            out.close();
            reader.close();
        }
        catch (IOException e)
        {
        }
    }

    static String getFileName(String fName)
    {
        return fName.substring(0, fName.lastIndexOf("."));
    }
}
