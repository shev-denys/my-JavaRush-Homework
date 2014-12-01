package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream inputStream = new FileInputStream(reader.readLine());
            FileOutputStream outputStream = new FileOutputStream(reader.readLine());

            if (inputStream.available() > 0)
            {

                int count = inputStream.available();
                byte[] buffer = new byte[(count) ];

                inputStream.read(buffer);

                reverse(buffer);
                outputStream.write(buffer);


            }
            reader.close();
            inputStream.close();
            outputStream.close();

        }
        catch (IOException e){}

    }

    public static void reverse(byte[] in) {
        byte tmp;
        for (int i = 0; i < in.length/2; i++) {
            tmp = in[in.length - 1 - i];
            in[in.length - 1 - i] = in[i];
            in[i] = tmp;
        }

    }
}
