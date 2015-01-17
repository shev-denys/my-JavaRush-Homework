package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {

            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human
    {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human()
        {
        }

        public Human(String name, Asset... assets)
        {
            this.name = name;
            if (assets != null)
            {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception
        {

            PrintWriter printWriter = new PrintWriter(outputStream);
            String hasName = (name != null) ? "yes" : "no";
            printWriter.write(hasName);
            if ("yes".equals(hasName))
            {
                printWriter.write(" " + this.name);

                if (assets.size() > 0)
                {
                    for (Asset temp : assets)
                    {
                        printWriter.write(" " + temp.getName() + " " + temp.getPrice());
                    }
                }
            }
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String S = reader.readLine();
            String[] arr = S.split(" ");
            if (arr.length > 0)
            {
                String hasName = arr[0];
                if ("yes".equals(hasName))
                {
                    this.name = arr[1];
                    int i = 2;
                    while (i <= arr.length - 2)
                    {
                        Asset tempAsset = new Asset(arr[i]);
                        tempAsset.setPrice(Double.parseDouble(arr[i + 1]));
                        assets.add(tempAsset);
                        i=i+2;
                    }

                }
            }
            reader.close();
        }

    }
}
