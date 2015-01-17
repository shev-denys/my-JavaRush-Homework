package com.javarush.test.level20.lesson10.bonus01;

import java.util.*;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution
{


    public static void main(String[] args)
    {
        Long t0 = System.currentTimeMillis();
        int n = 146511208;
        int[] numbers = getNumbers(n);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();

    }

    public static int[] getNumbers(int N)
    {
        List<Integer> list = new ArrayList<>();

        int maxStep = 1;
        int k = N;
        while (k > 10)
        {
            k /= 10;
            maxStep++;
        }

        // заполняем 1 раз!! матрицу степеней pow_val
        long pow_val[][] = new long[10][maxStep + 1];
        for (int i = 1; i < 10; i++)
            for (int j = 0; j < maxStep + 1; j++)
                pow_val[i][j] = (long) Math.pow(i, j);



        byte[] massTemp = new byte[100]; //Массив для конвертирования числа в массив пример: 123 -> {1,2,3}
        byte currentLength = 0; //Длина массива
        long tempSum = 0;

        for (int i = 1; i < N; i++)
        {
            currentLength = GetLenghtOfNumberAndConvertToArray(i, massTemp);
            tempSum = 0;
            for (int j = 0; j < currentLength; j++)
            {
                tempSum += pow_val[massTemp[j]][currentLength];
                massTemp[j] = 0;
            }
           if (tempSum == i)
                list.add(i);
        }


        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }

        return result;
    }


    static byte GetLenghtOfNumberAndConvertToArray(int N, byte[] massTemp)
    {
        int n = N;

        byte length = 0;

        while (true)
        {
            massTemp[length] = (byte) (n - ((int) n / 10) * 10);
            length++;
            if (n < 10)
                break;
            n /= 10;
        }

        byte temp;
        for (int i = length; i < length/2; i--)
        {
            temp = massTemp[i];
            massTemp[i] = massTemp[length - i - 1];
            massTemp[length - i - 1] = temp;
        }
        return length;
    }
}
