package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        while (reader.ready()) list.add(reader.readLine());
        if (args[0].equals("-u") || args[0].equals("-d"))
        {
            for (int i = 0; i < list.size(); i++)
            {
                if (list.get(i).trim().length() > 0)
                {
                    if (list.get(i).substring(0, 8).trim().equals(args[1]))
                    {
                        if (args[0].equals("-u"))
                        {
                            Formatter fmt = new Formatter();
                            fmt.format("%-8.8s%-30.30s%-8.8s%-4.4s", args[1], args[2], args[3], args[4]);
                            list.set(i, fmt.toString());
                        }
                        if (args[0].equals("-d"))
                        {
                            list.remove(i);
                            i = 0;
                        }
                    }
                }
            }
            BufferedWriter bufferWritter = new BufferedWriter(new FileWriter(fileName));
            for (String s : list)
            {
                bufferWritter.write(s);
                bufferWritter.newLine();
            }
            bufferWritter.close();
            reader.close();
        }

    }

}
