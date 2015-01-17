package com.javarush.test.level22.lesson09.Others;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution
{


    public static void main(String[] args) throws IOException
    {

        Scanner reader = new Scanner(new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        String string = "";
        while (reader.hasNext())
            string += reader.nextLine() + " ";
        if (string.isEmpty())
            return;
        String[] stringArray = string.split(" ");


        StringBuilder result = getLine(stringArray);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {


        if (words == null)
            return new StringBuilder();

        TreeSet<String> sWords = new TreeSet<String>();
        for (String word : words)
        {
           if (!word.isEmpty())
            sWords.add(word);
        }
        String[] copiedSortedArray = sWords.toArray(new String[sWords.size()]);


        for (String word : copiedSortedArray)
        {


                Character fCh = word.toLowerCase().charAt(0);

            if (BuilderThread.charMap.containsKey(fCh))
            {
                BuilderThread.charMap.get(fCh).add(word);
            } else
            {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(word);
                BuilderThread.charMap.put(fCh, temp);
            }
        }


        for (String word : copiedSortedArray)
        {
            try
            {
                new BuilderThread(new LinkedList<String>(), word).join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        StringBuilder result = new StringBuilder();

        int maxCount = 0;

        for (LinkedList<String> currentList : BuilderThread.listWithResultLists)
            if (currentList.size() > maxCount)
                maxCount = currentList.size();

        LinkedList<LinkedList<String>> listWithResultListsWithMaximumLength = new LinkedList<>();
        for (LinkedList<String> currentList : BuilderThread.listWithResultLists)
            if (currentList.size() == maxCount)
                listWithResultListsWithMaximumLength.add(currentList);

        for (String currentS : listWithResultListsWithMaximumLength.getFirst())
        {
            if (result.length() > 0)
                result.append(" " + currentS);
            else
                result.append(currentS);
        }

        return result;
    }

    protected static class BuilderThread extends Thread
    {
        protected static volatile ArrayList<LinkedList<String>> listWithResultLists = new ArrayList<>();
        protected static HashMap<Character, ArrayList<String>> charMap = new HashMap<>();

        LinkedList<String> result = new LinkedList<>();
        String CurrentWord = "";

        public BuilderThread(LinkedList<String> result, String currentWord)
        {

            this.result = result;
            CurrentWord = currentWord;
            //System.out.println(this.getName());
            start();
        }


        @Override
        public void run()
        {
            super.run();
            calculate();
        }

        void calculate()
        {

            Character fCh = CurrentWord.toLowerCase().charAt(CurrentWord.length() - 1);
            result.add(CurrentWord);

            if (charMap.containsKey(fCh))
            {
                ArrayList<String> temp = charMap.get(fCh);
                for (String tempWord : temp)
                {

                    if (!result.contains(tempWord))
                        try
                        {
                            new BuilderThread((LinkedList<String>) result.clone(), tempWord).join();
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                }

            }

            synchronized (listWithResultLists)
            {
                //удалим более короткие результаты? поскольку вначале длина списка результатов небольшая то эта часть
                // должна отрабатываться быстро
                //Вариант второй, в результате содержит цепочки с не максимальным количеством элементов
                // в сравнении если бы не удалять элементы вообще
                listWithResultLists.add(result);

                int length = result.size();


                int maxCount = 0;

                for (LinkedList<String> currentList : listWithResultLists)
                    if (currentList.size() > maxCount)
                        maxCount = currentList.size();

                Iterator it = listWithResultLists.iterator();
                while (it.hasNext())
                {
                    Object temp = it.next();
                    if (((LinkedList<String>) temp).size() < maxCount)
                    {
                        it.remove();
                    }
                }
                //Вариант первый - столкнулся с тем что в цикле нельзя удалять

               /* for(LinkedList<String> temp: listWithResultLists)
                    if (temp.size()<length)
                        listWithResultLists.remove(temp);
                */

            }
        }

    }
}
