package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream1 = new FileInputStream(args[0]);


        byte[] buffer1 = new byte[inputStream1.available()];
        inputStream1.read(buffer1);
        inputStream1.close();

        TreeMap<Byte, Integer> map = new TreeMap<>();
        for (Byte b : buffer1)
        {
            if (map.containsKey(b))
            {
                int counts = map.get(b) + 1;
                map.put(b, counts);
            } else
                map.put(b, 1);
        }

        for (Map.Entry<Byte, Integer> entry : map.entrySet())
        {
            if (entry.getKey()!=10)
            System.out.println("" + ((char) (byte) entry.getKey()) + ' ' + entry.getValue());
        }
    }


}
