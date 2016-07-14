package com.javalearn.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "javalearn - курсы Java онлайн"

Пример вывода:
first
second
javalearn - курсы Java онлайн
third
fourth
javalearn - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintContextStream printContextStream = new PrintContextStream(new ByteArrayOutputStream(), testString);
        printContextStream.printContext();

    }
    public static class PrintContextStream extends PrintStream {
        private TestString testString;
        private ByteArrayOutputStream out;

        public PrintContextStream(ByteArrayOutputStream out, TestString testString)
        {
            super(out);
            this.out = out;
            this.testString = testString;
        }
        public void printContext() {
            PrintStream consoleStream = System.out;
            PrintStream stream = new PrintStream(out);
            System.setOut(stream);
            testString.printSomething();
            String result = out.toString();
            System.setOut(consoleStream);

           String[] strings = result.split("\n");
            for(int i = 0; i < strings.length; i++) {
                System.out.println(strings[i]);
                if(!(i%2 == 0)) {
                    System.out.println("javalearn - курсы Java онлайн");
                }
            }


        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
