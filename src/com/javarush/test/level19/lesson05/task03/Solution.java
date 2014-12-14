package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String nameFileIn = bufer.readLine();
        String nameFileOut = bufer.readLine();
        bufer.close();

        BufferedReader fr = new BufferedReader(new FileReader(nameFileIn));
        FileWriter fileout = new FileWriter(nameFileOut);

        while (fr.ready())
        {
            String s = fr.readLine();
            String[] array = s.split(" ");
            for (String x : array)
            {
                try
                {
                    int chuslo = Integer.parseInt(x);
                    fileout.write(chuslo + " ");
                }
                catch (Exception e)
                {

                }

            }
        }
        fr.close();
        fileout.close();
    }
}
