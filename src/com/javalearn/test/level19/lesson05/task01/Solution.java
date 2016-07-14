package com.javalearn.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        while (stream.available()>0){
            byte[] b = new byte[stream.available()];
            stream.read(b);
            for (int i = 0; i < b.length; i++)
            {
                if (i % 2 != 0) outputStream.write(b[i]);
            }
        }
        reader.close();
        stream.close();
        outputStream.close();
    }
}
