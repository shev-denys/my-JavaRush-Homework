package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
        FileInputStream inputStream2 = new FileInputStream(reader.readLine());
        FileInputStream inputStream3 = new FileInputStream(reader.readLine());

        if (inputStream2.available() > 0)
        {
            int count = inputStream2.available();
            byte[] buffer1 = new byte[count];
            inputStream2.read(buffer1);
            outputStream1.write(buffer1);
        }

        if (inputStream3.available() > 0)
        {
            int count = inputStream3.available();
            byte[] buffer1 = new byte[count];
            inputStream3.read(buffer1);
            outputStream1.write(buffer1);
        }

        reader.close();
        inputStream2.close();
        inputStream3.close();
        outputStream1.close();

    }
}
