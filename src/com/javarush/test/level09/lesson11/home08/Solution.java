package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> arr = new ArrayList<int[]>();
        arr.add(new int[5]);
        arr.add(new int[2]);
        arr.add(new int[4]);
        arr.add(new int[7]);
        arr.add(new int[0]);

        for (int i = 0; i < arr.size();i++ )
        {
            for (int j = 0;j < arr.get(i).length;j++)
            {
                arr.get(i)[j] = i*j;
            }
        }
        return arr;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
