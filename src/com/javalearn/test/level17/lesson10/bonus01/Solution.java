package com.javalearn.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {


        if (args.length == 0)
        {
            return;
        }

        if (args.length > 1)
        {
            if (args[0].equals("-c"))
            {
                Person pers;
                Sex sex = args[2].equals("м") ? Sex.MALE : Sex.FEMALE;
                String name = args[1];
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date bd = null;

                try
                {
                    bd = formatter.parse(args[3]);
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }


                if (sex == Sex.MALE)
                {
                    pers = Person.createMale(name, bd);
                } else
                {
                    pers = Person.createFemale(name, bd);
                }
                allPeople.add(pers);
                System.out.println(allPeople.size() - 1);
            }

            if (args[0].equals("-u"))
            {
                if (args.length != 5)
                    return;
                Person pers = allPeople.get(Integer.parseInt(args[1]));
                pers.setName(args[2]);
                Sex sex = args[3].equals("м") ? Sex.MALE : Sex.FEMALE;
                pers.setSex(sex);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date bd;
                try
                {
                    bd = formatter.parse(args[4]);
                    pers.setBirthDay(bd);
                }
                catch (Exception e)
                {
                }
            }
            if (args[0].equals("-d"))
            {
                Integer id = Integer.parseInt(args[1]);
                if (id < allPeople.size() && id >= 0)
                {
                    allPeople.remove(id);
                }
            }

            if (args[0].equals("-i"))
            {
                if (args.length != 2)
                    return;
                Person pers = allPeople.get(Integer.parseInt(args[1]));
                System.out.println(pers.getName() + " " + (pers.getSex() == Sex.FEMALE ? "ж" : "м") + " " + (new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(pers.getBirthDay())));
            }
        }
        ;
    }
}
