package com.javarush.test.level19.lesson10.home03;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        Date date = null;
        while (reader.ready())
        {
            String str = reader.readLine();
            String[] array = str.split(" ");
            String name = "";
            // имя
            for (int i = 0; i < array.length - 3; i++)
                name = name + array[i] + " ";

            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
            // дата рождения
            String data = (Integer.parseInt(array[array.length - 3]) + " " + Integer.parseInt(array[array.length - 2]) + " " + Integer.parseInt(array[array.length - 1]));
            // перекодируем  в UTF-8
            byte[] utf8Bytes = name.getBytes("UTF-8");
            String nameInUTF = new String(utf8Bytes, "UTF-8");
            // парсим дату
            try
            {
                date = (sdf.parse(data));
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
            PEOPLE.add(new Person(nameInUTF, date));
        }
        reader.close();
   }
}
