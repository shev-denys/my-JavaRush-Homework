package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(fileName1);
        FileOutputStream outputStream1 = new FileOutputStream(fileName2);


        if (inputStream1.available() > 0)
        {
            int count = inputStream1.available();
            byte[] buffer1 = new byte[count];
            inputStream1.read(buffer1);


            String[] mass =  new String( buffer1).split(" ");
            String result = "";

            for(int i =0;i<mass.length; i++)
                result+= Math.round( Double.parseDouble(mass[i]))+" ";
            result = result.substring(0,result.length()-1);
            outputStream1.write(result.getBytes());
        }


        inputStream1.close();
        reader.close();
        outputStream1.close();
    }


}
