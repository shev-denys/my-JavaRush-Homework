package com.javarush.test.level17.lesson02.task02;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Вместе быстрее? Ща проверим :)
1. Разберись, что и как работает
2. Создай public static нить SortThread, которая в методе run отсортирует статический
массив testArray используя метод sort
*/

public class Solution {
    public static int countThreads = 10;
    public static int[] testArray = new int[10000];

    static {
        for (int i = 0; i < Solution.testArray.length; i++) {
            testArray[i] = i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Date d1 = new Date();
        initThreads();
      Date d2 = new Date();
        long dif = d2.getTime() - d1.getTime();
        System.out.println(dif);
    }

    public static void initThreads() throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>(countThreads);
        for (int i = 0; i < countThreads; i++) threads.add(new SortThread());
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int k = array[i];
                    array[i] = array[j];
                    array[j] = k;
                }
            }
        }
    }
    public static  class SortThread extends Thread
    {
        @Override
        public void run()
        {
            super.run();
            sort(testArray);
        }
    }
}
