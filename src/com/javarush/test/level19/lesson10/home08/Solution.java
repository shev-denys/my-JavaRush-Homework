package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String fileName1 = new BufferedReader(new InputStreamReader(System.in)).readLine();

        Scanner reader = new Scanner(new File(fileName1));

        while (reader.hasNext())
        {
            String str = reader.nextLine();
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(str);
            stringBuilder.reverse();
            System.out.println(stringBuilder);
        }


        reader.close();

    }
}
