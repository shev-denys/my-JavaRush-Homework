package com.javarush.test.level18.lesson03.task05;



/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fi = new FileInputStream( new BufferedReader(new InputStreamReader(System.in)).readLine());

        int[]  set = new int[fi.available()];
        int index =0;
        while(fi.available() > 0){
            Integer i = fi.read();
            if (!contains(set,i))
            {
                set[index]=(i);
                index++;
            }
        }
        fi.close();

        int[] result = new int[index];

        for (int i=0;i<index;i++)
            result[i] = set[i];

        bubbleSort(result);

        String s="";
        for(int i : result){
                s+=i+" ";

        }

        s= s.substring(0,s.length()-1);
        System.out.println(s);


    }

    public static boolean contains(int[] arr,int num)
    {
        for(int a: arr)
        if (a==num)
            return true;

        return false;
    }

    public static void bubbleSort(int[] arr){

        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){

            if( arr[j] > arr[j+1] ){
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
    }
}
}
