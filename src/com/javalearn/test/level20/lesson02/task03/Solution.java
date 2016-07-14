package com.javalearn.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap()
    {
        BufferedReader bufferedReader = null;
        FileInputStream inputStream = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            inputStream = new FileInputStream(new File(bufferedReader.readLine()));
            load(inputStream);

        }
        catch (Exception e){}
        finally
        {
            if (inputStream != null){
                try{
                    inputStream.close();
                }
                catch (Exception e){

                }

            }
        }
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {

        Properties prop = new Properties();
        for(Map.Entry<String,String> entry: properties.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            prop.setProperty(key,value);
        }
        prop.store(outputStream,null);
        outputStream.close();

        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        Enumeration<?> e = prop.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = prop.getProperty(key);
            properties.put(key,value);
        }
        inputStream.close();
    }
}
