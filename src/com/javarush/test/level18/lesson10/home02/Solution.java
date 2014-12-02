package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String fileName = args[0];

        FileInputStream inputStream = new FileInputStream(fileName);

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);

        int num=0;
           byte pr = (byte)' ';
        for(byte b: buffer)
        {
            if (b == pr) num++;

        }


        System.out.println( (double)Math.round(100.0*(double)num/buffer.length*100)/100);

        inputStream.close();

    }
}
