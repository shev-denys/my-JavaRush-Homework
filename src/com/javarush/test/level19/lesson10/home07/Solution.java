package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        String fileName1 = args[0];
        String fileName2 = args[1];
        Scanner reader = new Scanner(new File(fileName1));
        FileWriter fileWriter = new FileWriter(fileName2);
        StringBuilder stringBuilder = new StringBuilder();
        while (reader.hasNext())
        {
            String str = reader.nextLine();
            String[] arrStrings = str.split(" ");

            for (int i = 0; i < arrStrings.length; i++)
            {
                String word = arrStrings[i];
                if (word.length() > 6)
                {
                    stringBuilder.append(word);
                    stringBuilder.append(",");
                }
            }

        }
        String s = stringBuilder.toString();
        s = s.substring(0,s.length()-1);
        fileWriter.write(s);
        fileWriter.close();
        reader.close();
    }
}
