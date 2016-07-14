package com.javalearn.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        //Открываем поток, читающий из файла
        InputStream inputStream = new FileInputStream(fileName);

        //пока файл содержит данные
        //печатаем их
        //обязательно делаем вывод такой, чтобы печатались символы
        while (inputStream.available()>0){
            System.out.print((char)inputStream.read());
        }

        //закрываем 2 потока
        inputStream.close();
        reader.close();
    }
}
