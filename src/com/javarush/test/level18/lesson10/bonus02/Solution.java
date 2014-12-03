package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();


        if ("-c".equals(args[0]) && args.length == 4)
        {
            FileInputStream inputStream = new FileInputStream(fileName);
            Integer maxId = 1;
            boolean isEmp = inputStream.available() == 0;
            if (inputStream.available() > 0)
            {
                int count = inputStream.available();
                byte[] buffer1 = new byte[count];
                inputStream.read(buffer1);

                String[] mass = new String(buffer1).split("\n");


                for (int i = 0; i < mass.length; i++)
                {
                    if (mass[i].replaceAll(" ", "").equals(""))continue;

                    String strtempid = mass[i].substring(0, 8).replaceAll(" ", "");
                    Integer idNum = Integer.parseInt(strtempid.equals("")?"0":strtempid);
                    if (idNum > maxId)
                        maxId = idNum;
                }

                inputStream.close();
                StringBuilder productName = new StringBuilder(args[1]), price = new StringBuilder(args[2]), quantity = new StringBuilder(args[3]);

                productName = setString(productName, 30);
                price = setString(price, 8);
                quantity = setString(quantity, 4);
                maxId++;
                StringBuilder idStr = setString(new StringBuilder((maxId).toString()), 8);

                BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));

                fout.write((isEmp ? "" : "\n") + idStr + productName + price + quantity);
                fout.close();
            }
        }
    }

    static StringBuilder setString(StringBuilder s, int count)
    {
        StringBuilder newString = new StringBuilder(s);
        if (newString.length() > count) newString.delete(count, newString.length());
        else while (newString.length() < count) newString.append(' ');
        return newString;
    }

}
