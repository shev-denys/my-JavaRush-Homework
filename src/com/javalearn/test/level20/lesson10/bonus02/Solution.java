package com.javalearn.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        byte[][] a = new byte[][]{
                {1, 0, 1,},
                {0, 0, 1,},
                {1, 0, 1,},};
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a)
    {

        byte[][] b = a.clone();

        int dataSize = a.length;
        int count = 0;
        for (int i = 0; i < dataSize; i++)
        {
            for (int j = 0; j < dataSize; j++)
            {
                if (b[i][j] == 1)
                {
                    //Если нашли единицу, значит это левый верхний угол нашего прямоугольника
                    Rectangle rectangle = new Rectangle();
                    rectangle.start = new int[]{i, j};
                    //Находим правый нижний угол прямогольника
                    rectangle.end = findEndRectangle(b, rectangle.start);
                    //Чистим массив от найденного прямоугольника
                    b = rectangle.clear(b);
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] findEndRectangle(byte[][] a, int[] start)
    {
        int rightEndIndex = findRightEndIndex(a, start);
        int downEndIndex = findDownEndIndex(a, start);
        return new int[]{downEndIndex, rightEndIndex};
    }

    private static int findDownEndIndex(byte[][] a, int[] start)
    {
        int i = start[0];
        int j = start[1];
        if ((i + 1) >= a.length) return i;
        if (a[i + 1][j] == 1)
        {
            return findDownEndIndex(a, new int[]{i + 1, j});
        } else
        {
            return i;
        }
    }

    private static int findRightEndIndex(byte[][] a, int[] start)
    {
        int i = start[0];
        int j = start[1];
        if ((j + 1) >= a.length) return j;
        if (a[i][j + 1] == 1)
        {
            return findRightEndIndex(a, new int[]{i, j + 1});
        } else
        {
            return j;
        }
    }

    public static class Rectangle
    {
        int[] start;
        int[] end;

        private byte[][] clear(byte[][] a)
        {
            for (int i = start[0]; i <= end[0]; i++)
            {
                for (int j = start[1]; j <= end[1]; j++)
                {
                    a[i][j] = 0;
                }
            }
            return a;
        }
    }
}
