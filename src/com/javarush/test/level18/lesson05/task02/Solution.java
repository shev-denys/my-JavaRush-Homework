package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream( new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (inputStream.available() > 0) {


            byte[] buffer = new byte[inputStream.available()];

            inputStream.read(buffer);
            int count =0;
            for (byte b:buffer)
                if (b==44)
                    count++;
            System.out.println(count);
        }

        inputStream.close();


    }
}
