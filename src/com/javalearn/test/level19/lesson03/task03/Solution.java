package com.javalearn.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости
*/

import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA","Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");

        IncomeData incomeData = new IncomeData()
        {


            @Override
            public String getCountryCode()
            {
                return "UA";
            }

            @Override
            public String getCompany()
            {
                return "javalearn Ltd.";
            }

            @Override
            public String getContactFirstName()
            {
                return "Ivan";
            }

            @Override
            public String getContactLastName()
            {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode()
            {
                return 38;
            }

            @Override
            public int getPhoneNumber()
            {
                return 501234567;
            }
        };

        Customer customer = new IncomeDataAdapter(incomeData);
        Contact contact = new IncomeDataAdapter(incomeData);

        System.out.println(customer.getCompanyName());
        System.out.println(customer.getCountryName());
        System.out.println(contact.getPhoneNumber());
        System.out.println(contact.getName());

    }



    public static class IncomeDataAdapter implements Customer,Contact{
        IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData)
        {
            this.incomeData = incomeData;
        }

        @Override
        public String getName()
        {
            return incomeData.getContactLastName()+", "+incomeData.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {
           String allnumber = Integer.toString(incomeData.getPhoneNumber());
            while (allnumber.length()<10)
                allnumber="0"+allnumber;

            String result = "+"+incomeData.getCountryPhoneCode()
                    +"("+ allnumber.substring(0,3)+")"
                    +allnumber.substring(3,6)
                    +"-"+allnumber.substring(6,8)
                    +"-"+allnumber.substring(8,10);

            return result;
        }

        @Override
        public String getCompanyName()
        {
            return incomeData.getCompany();
        }

        @Override
        public String getCountryName()
        {
            return countries.get( incomeData.getCountryCode());
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA
        String getCompany();            //example javalearn Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        int getCountryPhoneCode();      //example 38
        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example javalearn Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}