package com.javalearn.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {
        PrintStream consoleStream = System.out;

        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);

        testString.printSomething();

        System.setOut(consoleStream);

        String result = outputStream.toString();
        String[] mass = result.split(" ");
        Integer res=0;
        String oper = "+";
        for(int i=0;i<mass.length;i++)
        {
            try
            {
                if (oper.equals("+")) res+=Integer.parseInt(mass[i]);
                if (oper.equals("-")) res-=Integer.parseInt(mass[i]);
                if (oper.equals("*")) res*=Integer.parseInt(mass[i]);
            }
            catch (Exception e){
                oper = mass[i];
            };
        }
        result+=res;
        System.out.println(result.replaceAll("(\\r|\\n)", ""));


        outputStream.close();
        printStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

