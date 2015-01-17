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
public class Solution2
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
        ArrayList<LinkedList<String>> listWithResultLists = new ArrayList<>();
        HashMap<Character, ArrayList<String>> charMap = new HashMap<>();

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

            if (charMap.containsKey(fCh))
            {
                charMap.get(fCh).add(word);
            } else
            {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(word);
                charMap.put(fCh, temp);
            }
        }


        for (String word : copiedSortedArray)
        {

               // new BuilderThread(new LinkedList<String>(), word).join();
                calculate(new LinkedList<String>(), word, listWithResultLists,  charMap);

        }

        StringBuilder result = new StringBuilder();

        int maxCount = 0;

        for (LinkedList<String> currentList : listWithResultLists)
            if (currentList.size() > maxCount)
                maxCount = currentList.size();

        LinkedList<LinkedList<String>> listWithResultListsWithMaximumLength = new LinkedList<>();
        for (LinkedList<String> currentList : listWithResultLists)
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



        static void calculate(LinkedList<String> result,String CurrentWord,ArrayList<LinkedList<String>> listWithResultLists, HashMap<Character, ArrayList<String>> charMap)
        {
            Character fCh = CurrentWord.toLowerCase().charAt(CurrentWord.length() - 1);
            result.add(CurrentWord);

            if (charMap.containsKey(fCh))
            {
                ArrayList<String> temp = charMap.get(fCh);
                for (String tempWord : temp)
                {

                    if (!result.contains(tempWord))

                            calculate(new LinkedList<String>(result), tempWord, listWithResultLists,  charMap);

                }

            }

            synchronized (listWithResultLists)
            {
                //удалим более короткие результаты? поскольку вначале длина списка результатов небольшая то эта часть
                // должна отрабатываться быстро
                //Вариант второй, в результате содержит цепочки с не максимальным количеством элементов
                // в сравнении если бы не удалять элементы вообще
                listWithResultLists.add(result);

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

            }
        }


}
