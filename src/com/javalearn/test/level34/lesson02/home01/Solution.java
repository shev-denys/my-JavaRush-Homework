package com.javalearn.test.level34.lesson02.home01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Рекурсия для мат.выражения
На вход подается строка - математическое выражение.
Выражение включает целые и дробные числа, скобки (), пробелы, знак отрицания -, возведение в степень ^, sin(x), cos(x), tan(x)
Для sin(x), cos(x), tan(x) выражение внутри скобок считать градусами, например, cos(3 + 19*3)=0.5
Степень задается так: a^(1+3) и так a^4, что эквивалентно a*a*a*a.
С помощью рекурсии вычислить выражение и количество математических операций. Вывести через пробел результат в консоль.
Результат выводить с точностью до двух знаков, для 0.33333 вывести 0.33, использовать стандартный принцип округления.
Не создавайте статические переменные и поля класса.
Не пишите косвенную рекурсию.
Пример, состоящий из операций sin * - + * +:
sin(2*(-5+1.5*4)+28)
Результат:
0.5 6
*/
public class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation)
    {
        Pattern pattern;// = Pattern.compile(regex);

        System.out.println("In recursion");


        final String expr = "(\\d+(\\.\\d+)?+[\\*]\\d+(\\.\\d+)?+)";
        pattern = Pattern.compile(expr);
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find())
        {
            String[] expToEval = matcher.group().split("\\*");
            String res = Double.toString(Math.round(Double.parseDouble(expToEval[0]) * Double.parseDouble(expToEval[1]) * 100.0) / 100.0);

            System.out.println("res = " + res);
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end());
            System.out.println(" Found: " + matcher.group());


            System.out.println("Matches *");
        }
        //implement
    }

    double evaluate(String expression, Character operation)
    {
        switch(operation)
        {
            case '+':
                ;
                break;
        }

    }


    public Solution()
    {
        //don't delete
    }
}
