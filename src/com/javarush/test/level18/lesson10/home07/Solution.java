package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String id = args[0];
        FileInputStream inputStream1 = new FileInputStream(fileName1);

        if (inputStream1.available() > 0)
        {
            int count = inputStream1.available();
            byte[] buffer1 = new byte[count];
            inputStream1.read(buffer1);


            String[] mass =  new String( buffer1).split( "\r\n");

            for(int i =0;i<mass.length; i++)
            {
                String[] masstov = mass[i].split(" ");
                if (masstov[0].equals(id))
                       {
                    System.out.println(mass[i]);
                }
            }
        }


        inputStream1.close();
        reader.close();


    }

}
