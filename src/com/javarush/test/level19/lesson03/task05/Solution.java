package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");}

    public static void main(String[] args)
    {
        Customer customer = new Customer()
        {
            @Override
            public String getCompanyName()
            {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName()
            {
                return "Ukraine";
            }
        };
        Contact contact = new Contact()
        {
            @Override
            public String getName()
            {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber()
            {
                return "+38(050)123-45-67";
            }
        };

        RowItem rowItem = new DataAdapter(customer,contact);

        System.out.println( rowItem.getCountryCode());        //example UA
        System.out.println( rowItem.getCompany());            //example JavaRush Ltd.
        System.out.println( rowItem.getContactFirstName());   //example Ivan
        System.out.println( rowItem.getContactLastName());    //example Ivanov
        System.out.println( rowItem.getDialString());         //example callto://+380501234567
    }


    public static class DataAdapter implements RowItem{
        Customer customer;
        Contact contact;

        @Override
        public String getCountryCode()
        {
            String cn = customer.getCountryName();
            for (Map.Entry<String,String> entry: countries.entrySet())
                if (entry.getValue().equals(cn))
                    return entry.getKey();
            return null;
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            String[] names =  contact.getName().split(" ");
            return names[1];
        }

        @Override
        public String getContactLastName()
        {
            String[] names =  contact.getName().split(" ");
            return names[0].substring(0,names[0].length()-1);
        }

        @Override
        public String getDialString()
        {
            String pn = contact.getPhoneNumber();
            pn = pn.replace("(", "");
            pn = pn.replace(")" , "");
            pn = pn.replaceAll("-", "");
            return "callto://"+ pn;
        }

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}