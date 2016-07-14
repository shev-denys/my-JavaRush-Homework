package com.javalearn.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!
Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd
id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution
{
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1

    }

    public static void main(String[] args)
    {

        {
            if (args.length == 0)
            {
                return;
            }

            if (args.length > 1)
            {

                if (args[0].equals("-c"))
                {
                    String[] r = new String[args.length - 1];
                    System.arraycopy(args, 1, r, 0, r.length);
                    create(r);
                }

                if (args[0].equals("-u"))
                {
                    String[] r = new String[args.length - 1];
                    System.arraycopy(args, 1, r, 0, r.length);
                    update(r);
                }
                if (args[0].equals("-d"))
                {
                    String[] r = new String[args.length - 1];
                    System.arraycopy(args, 1, r, 0, r.length);
                    delete(r);
                }

                if (args[0].equals("-i"))
                {
                    String[] r = new String[args.length - 1];
                    System.arraycopy(args, 1, r, 0, r.length);
                    info(r);
                }
            }

        }
    }

    public static synchronized void create(String[] mass)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        int countpers = (int) mass.length / 3;

        for (int i = 0; i < countpers; i++)
        {
            String sex = mass[3 * i + 1];
            String name = mass[3 * i];
            String date = mass[3 * i + 2];
            try
            {
                Date bd = null;
                bd = formatter.parse(date);

                if (sex.equals("м"))
                {
                    allPeople.add(Person.createMale(name, bd));
                } else
                {
                    allPeople.add(Person.createFemale(name, bd));
                }

                System.out.println(allPeople.size() - 1);
            }
            catch (ParseException e)
            {
         }
        }

    }

    public static void delete(String[] mass)
    {
        int[] ids = new int[mass.length];
        for (int i = 0; i < ids.length; i++)
        {
            ids[i] = Integer.parseInt(mass[i]);
        }
        sort(ids);

        int prevIndex = allPeople.size()+1;
        for (int id : ids)
        {
            if (id < allPeople.size() && id >= 0 && id!=prevIndex)
            {
                allPeople.remove(id);

            }
            prevIndex = id;
        }
    }

    public static synchronized void info(String[] mass)
    {
        int length = mass.length;
        if (length < 1)
            return;
        for (int i = 0; i < length; i++)
        {
            Person pers = allPeople.get(Integer.parseInt(mass[i]));
            System.out.println(pers.getName() + " " + (pers.getSex() == Sex.FEMALE ? "ж" : "м") + " " + (new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(pers.getBirthDay())));
        }
    }

    public static synchronized void update(String[] mass)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        int countpers = (int) mass.length / 4;
        for (int i = 0; i < countpers; i++)
        {

            Person pers = allPeople.get(Integer.parseInt(mass[i * 4]));
            pers.setName(mass[i * 4 + 1]);
            Sex sex = mass[i * 4 + 2].equals("м") ? Sex.MALE : Sex.FEMALE;
            pers.setSex(sex);

            Date bd;
            try
            {
                bd = formatter.parse(mass[i * 4 + 3]);
                pers.setBirthDay(bd);

            }
            catch (Exception e)
            {
            }
        }

    }

    public static void sort(int[] mass)
    {
        int[] sortmass = mass;

        for (int i = sortmass.length - 1; i >= 1; i--)
        {

            boolean sorted = true;

            for (int j = 0; j < i; j++)
            {

                if (sortmass[j] < sortmass[j + 1])
                {
                    int temp = sortmass[j];
                    sortmass[j] = sortmass[j + 1];
                    sortmass[j + 1] = temp;
                    sorted = false;
                }
            }


            if (sorted)
            {
                break;
            }
        }

    }

}