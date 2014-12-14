package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {


        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String nameFileIn = bufer.readLine();
        String nameFileOut = bufer.readLine();
        bufer.close();

        BufferedReader fr = new BufferedReader(new FileReader(nameFileIn));
        BufferedOutputStream fw = new BufferedOutputStream(new FileOutputStream(nameFileOut));

        while (fr.ready())
        {
            String s = fr.readLine();
            byte[] arr = s.getBytes();
            byte point = (byte)'.';
            byte zn = (byte)'!';
            for (int i =0; i < arr.length;i++)
                if (arr[i]== point)
                    arr[i] = zn;

            fw.write(arr);
        }
        fr.close();
        fw.close();
    }
}
