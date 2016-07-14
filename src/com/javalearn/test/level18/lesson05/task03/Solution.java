package com.javalearn.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream inputStream = new FileInputStream(reader.readLine());
            FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
            FileOutputStream outputStream2 = new FileOutputStream(reader.readLine());

            if (inputStream.available() > 0)
            {

                int count = inputStream.available();
                byte[] buffer2 = new byte[(count) / 2];
                byte[] buffer1 = new byte[count - count / 2];

                inputStream.read(buffer1);
                inputStream.read(buffer2);
                outputStream1.write(buffer1);
                outputStream2.write(buffer2);


            }
            reader.close();
            inputStream.close();
            outputStream1.close();
            outputStream2.close();
        }
        catch (IOException e){}
    }
}
