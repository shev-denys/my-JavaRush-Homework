package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(fileName1);
        FileInputStream inputStream2 = new FileInputStream(fileName2);
        byte[] buffer1=null;
        if (inputStream1.available() > 0)
        {
            int count = inputStream1.available();
            buffer1 = new byte[count];
            inputStream1.read(buffer1);
            inputStream1.close();
        }
        FileOutputStream outputStream1 = new FileOutputStream(fileName1);
        if (inputStream2.available() > 0)
        {
            int count = inputStream2.available();
            byte[] buffer2 = new byte[count];
            inputStream2.read(buffer2);

            outputStream1.write(buffer2,0,count);
           if (buffer1!=null)
            outputStream1.write(buffer1);
        }

        reader.close();
        inputStream2.close();

        outputStream1.close();
    }
}
