package com.javalearn.test.level26.lesson02.task01;

import java.util.*;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {

       Arrays.sort(array);

        final double mediana;
        int middle = array.length / 2;
        if(array.length % 2 == 1)
            mediana = array[middle];
        else
            mediana = ( array[middle-1] + array[middle] ) / 2.0;


        Comparator<Integer> compInt = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                int diff =(int) (Math.abs(mediana-o1) - Math.abs(mediana - o2));
                return diff==0?o1-o2:diff;
            }
        };

        Arrays.sort(array,compInt);


        return array;
    }


}
