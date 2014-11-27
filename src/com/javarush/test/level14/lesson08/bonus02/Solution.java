package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        System.out.println(greatestCommonDivisor(a,b));
    }

    private static int greatestCommonDivisor( int m, int n )
    {
        // Базовый случай:
        if ( m == n )
        {
            return m;
        }
        if ( m == 0 )
        {
            return n;
        }
        if ( n == 0 )
        {
            return m;
        }

        // Рекурсивный случай:
        if ( ( ~m & 1 ) == 1 ) // m четное
        {
            if ( ( n & 1 ) == 1 ) // n четное
            {
                return greatestCommonDivisor( m >> 1, n );
            }
            else // m и n четные
            {
                return greatestCommonDivisor( m >> 1, n >> 1 ) << 1;
            }
        }
        if ( ( ~n & 1 ) == 1 ) // m нечетное, n четное
        {
            return greatestCommonDivisor( m, n >> 1 );
        }

        // уменьшение большего аргумента:
        if ( m > n )
        {
            return greatestCommonDivisor( ( m - n ) >> 1, n );
        }

        return greatestCommonDivisor( ( n - m ) >> 1, m );
    }
}
