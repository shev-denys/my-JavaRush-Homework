package com.javalearn.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        if (args.length == 0)
            return;

        Map<String, Double> map = new HashMap<>();
        Scanner sc = new Scanner(new File(args[0]));


        while(sc.hasNextLine()) {
            String[] pair = sc.nextLine().split(" ");
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], Double.parseDouble(pair[1]));
            } else {
               Double value = map.get(pair[0]) + Double.parseDouble(pair[1]);
               map.put(pair[0], value);
            }
        }

        sc.close();

        ValueComparator vc = new ValueComparator(map);
        Map<String, Double> maxMap = new TreeMap<String, Double>(vc);
        maxMap.putAll(map);
        Double maxval = null;
        for (Map.Entry<String, Double> entry : maxMap.entrySet()) {
             {
                 if (maxval!=null)
                 if (!maxval.equals(entry.getValue()) )
                     break;
                maxval= entry.getValue();
                System.out.print(entry.getKey() + " ");

            }
        }
    }

    static class ValueComparator implements Comparator<Object> {
        Map<String, Double> base;
        public ValueComparator(Map<String, Double> base) {
            this.base = base;
        }

        @Override
        public int compare(Object o1, Object o2)
        {
            if (base.get(o1) > base.get(o2))
                return -1;
            else if (base.get(o1) == base.get(o2))
            {
                return o1.toString().compareTo(o2.toString());
            }
            else
                return 1;
        }
    }
}
