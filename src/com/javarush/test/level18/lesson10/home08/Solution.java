package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution
{
    public static  Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = "";
            ArrayList<Thread> threads = new ArrayList<>();
            while (true)
            {
                fileName = reader.readLine();
                if (fileName.equals("exit")) break;
                Thread thread = new ReadThread(fileName);
                threads.add(thread);
                thread.start();
            }
            for (Thread t : threads)
                t.join();
            reader.close();
        }
        catch (IOException e)
        {
        }
        catch (InterruptedException e)
        {

        }

    }

    public static class ReadThread extends Thread
    {
        private String fileName;

        public ReadThread(String fileName)
        {
            this.fileName = fileName;

        }

        @Override
        public void run()
        {

            try
            {
              FileInputStream inputStream = new FileInputStream(fileName);
                Integer maxB = 0;
                Integer max = 0;

                HashMap<Byte, Integer> table = new HashMap<Byte, Integer>();
                byte[] buffer = new byte[1000];
                int countbuf = 0;
                while (inputStream.available() > 0)
                {
                    countbuf = inputStream.read(buffer);
                    for (byte b : buffer)
                    {
                        Integer count = 1;
                        if (table.containsKey(b))
                        {
                            count = table.get(b) + 1;
                            table.put(b, count);
                        } else table.put(b, 1);

                        if (count >= max)
                        {
                            maxB = (int) b;
                            max = count;
                        }

                        countbuf--;
                        if (countbuf == 0)
                            break;
                    }
                }

                inputStream.close();

                synchronized (resultMap)
                {
                    resultMap.put(this.fileName, maxB);
                }
            }
            catch (IOException e)
            {
            }


        }


    }
}
