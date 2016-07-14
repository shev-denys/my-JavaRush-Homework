package com.javalearn.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       FileInputStream fi = new FileInputStream( new BufferedReader(new InputStreamReader(System.in)).readLine());

        int b = 0;

        while (fi.available()>0)
        {
            int temp = fi.read();
                if(temp > b)
                    b = temp;
        }

        System.out.println(b);
    }
}
