package com.javalearn.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> mymap = new HashMap<String, String>();

        mymap.put( "Ivanov", "Ivan" );
        mymap.put( "Petrov", "Petr" );
        mymap.put( "Sidorov", "Ivan" );
        mymap.put( "Semenov", "Sergey" );
        mymap.put( "Frolov", "Igor" );
        mymap.put( "Sergeev", "Igor" );
        mymap.put( "Kostenko", "Alexey" );
        mymap.put( "Petrenko", "Sergey" );
        mymap.put( "Dmitriev", "Sergey" );
        mymap.put( "Nikonov", "Petr" );

        return mymap;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {

        Set<String> setNames = new HashSet<String>();
        Set<String> duplicateNames = new HashSet<String>();

        for ( Map.Entry<String, String> pair : map.entrySet() )
        {
            String name = pair.getValue();

            if ( setNames.contains( name ) )
            {
                duplicateNames.add( name );
            }
            else
            {
                setNames.add( name );
            }
        }

        for ( String name : duplicateNames )
        {
            removeItemFromMapByValue( map, name );
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
