package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.*;
import java.util.Scanner;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = br.readLine();
        br.close();
        Scanner scanner = new Scanner(new FileInputStream(fileIn));

        String input = "";
        while (scanner.hasNext())
        {
            String data = scanner.nextLine();
            input =input+ " " +data;
        }
        scanner.close();
        input = input.toLowerCase();
        input = input.replaceAll("[^a-zA-Z\\s]", " ");
        input = input.replaceAll(System.getProperty("line.separator"), " ");
        input = input.replaceAll(""+(char)10, " ");
        input = input.replaceAll(""+(char)31, " ");
        input = " "+ input+" ";

        int count = 0;

        while (input.contains(" world "))
        {
            input= input.replaceFirst(" world ", " ");
            count++;
        }


        System.out.println(count);
    }
}
