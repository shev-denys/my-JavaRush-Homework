package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endX) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution
{
    public static Direction trueDirection;

    public static void main(String[] args)
    {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> listing = detectAllWords(crossword, "fulme");

        for (Word word : listing)
        {
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words)
    {

        ArrayList<Word> list = new ArrayList<Word>();
        for (String word : words)
        {

            char[] chars = word.toCharArray();

            char letter = chars[0];
            for (int x = 0; x < crossword.length; x++)
            {
                for (int y = 0; y < crossword[x].length; y++)
                {
                    if (crossword[x][y] == letter)
                    {
                        if (isThisReallyFirstLetter(crossword, x, y, word, 0))
                        {

                            int startX = x;
                            int startY = y;
                            int endX = x + trueDirection.x * (word.length() - 1);
                            int endY = y + trueDirection.y * (word.length() - 1);

                            Word newWord = new Word(word);
                            newWord.setStartPoint(startY, startX);
                            newWord.setEndPoint(endY, endX);
                            list.add(newWord);
                        }
                    }
                }
            }
        }

        return list;
    }

    public static boolean isThisReallyFirstLetter(int[][] crossword, int x, int y, String word, int charAt)
    {

        //Список возможных направлений, куда мы шагаем и ищем следующую букву слова в массиве


        ArrayList<Direction> directions = new ArrayList<Direction>();
        directions.add(new Direction(1, 1));
        directions.add(new Direction(0, 1));
        directions.add(new Direction(1, 0));
        directions.add(new Direction(1, -1));
        directions.add(new Direction(-1, 1));
        directions.add(new Direction(-1, 0));
        directions.add(new Direction(0, -1));
        directions.add(new Direction(-1, -1));

        char[] chars = word.toCharArray();

        for (Direction dir : directions)
        {
            int X = x, Y = y;
            for (int i = 0; i < chars.length; i++)
            {
                try
                {
                    if (((char)crossword[X][Y]) == chars[i])
                    {
                        trueDirection = dir;
                        if (i == chars.length - 1)
                            return true;
                    } else
                    {
                        break;
                    }
                }
                catch (Exception e)
                {
                    break;
                }
                X = X + dir.x;
                Y = Y + dir.y;
            }
        }
        return false;


    }

    public static class Direction
    {
        int x;
        int y;

        public Direction(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

    }

    public static class Word
    {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text)
        {
            this.text = text;
        }

        public void setStartPoint(int i, int j)
        {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j)
        {
            endX = i;
            endY = j;
        }

        @Override
        public String toString()
        {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
