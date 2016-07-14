package com.javalearn.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[5];
        for (int i = 0; i < 5; i++)
            a[i] = Integer.parseInt(reader.readLine());
        int k, x;

        for (int i = 0; i < 5; i++)
        {    // i - номер текущего шага
            k = i;
            x = a[i];

            for (int j = i + 1; j < 5; j++)    // цикл выбора наименьшего элемента
                if (a[j] < x)
                {
                    k = j;
                    x = a[j];            // k - индекс наименьшего элемента
                }

            a[k] = a[i];
            a[i] = x;    // меняем местами наименьший с a[i]
        }


        for(int i = 0; i < 5; i++)
        System.out.println(a[i]);

    }
}
