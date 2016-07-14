package com.javalearn.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName1 = args[0];
        String fileName2 = args[1];
        Scanner reader = new Scanner(new File(fileName1));
        FileWriter fileWriter = new FileWriter(fileName2);
        while (reader.hasNext())
        {
            String str = reader.nextLine();
            String[] array = str.split(" ");


            for (String word:array)
            {
                StringBuilder bld1 = new StringBuilder(word);
                for (int k = 0; k < bld1.length(); k++){
                    if (Character.isDigit(bld1.charAt(k))) {
                        fileWriter.write(word+" ");
                        break;
                    }
                }
            }

        }
        fileWriter.close();
        reader.close();
    }
}
