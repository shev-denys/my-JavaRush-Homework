package com.javalearn.test.level19.lesson10.home04;

import java.io.*;
import java.util.*;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        Scanner reader = new Scanner(new File((new BufferedReader(new InputStreamReader(System.in)).readLine())));  //при дебаге необходимо добавлять "windows-1251" чтоб было видно символы
        while (reader.hasNext())
        {
            String str = reader.nextLine();
            String[] array = str.split(" ");
            int count =0;

            for (String word:array)
                if (words.contains(word))
                    count++;
            if (count==2)
                System.out.println(str);
      }
        reader.close();
    }
}
