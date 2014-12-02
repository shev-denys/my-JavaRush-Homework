package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
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

        for(byte b: buffer)
        {
            if (b >= 65 && b <= 90) num++;

            if (b >= 97 && b <= 122) num++;
        }


        System.out.println(num);

        inputStream.close();

    }
}
