package com.javarush.test.level20.lesson02.task02;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
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

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setBirthDate(new Date(1988, 10, 10));
            user.setFirstName("Павлик");
            user.setLastName("Морозов");
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);
            javaRush.users.add(new User());
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
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

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            PrintWriter printWriter = new PrintWriter(outputStream);
            Integer num = users.size();


            String sToWrite = num + "";
            for (User user : users)
            {
                sToWrite += "/div";
                sToWrite += user.getFirstName() + " " + user.getLastName();
                SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
                Date db = user.getBirthDate();
                if (db != null)
                    sToWrite += " " + df.format(user.getBirthDate());
                else sToWrite += " " + "null";
                sToWrite += " " + user.isMale();
                if (user.getCountry() != (null))
                    sToWrite += " " + user.getCountry().getDisplayedName();
                else
                    sToWrite += " " + "null";
            }
            printWriter.println(sToWrite);

            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String S = reader.readLine();
            String[] arr = S.split("/div");
            if (arr.length > 0)
            {
                Integer num = Integer.parseInt(arr[0]);
                for (int i = 1; i <= num; i++)
                {
                    String[] sparams = arr[i].split(" ");
                    User nUser = new User();
                    if (!sparams[0].equals("null"))
                    nUser.setFirstName(sparams[0]);
                    if (!sparams[1].equals("null"))
                    nUser.setLastName(sparams[1]);
                    if (!sparams[2].equals("null"))
                    {
                        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH );

                        Date db =  df.parse(sparams[2]);
                        nUser.setBirthDate(db);
                    }
                    nUser.setMale(Boolean.parseBoolean(sparams[3]));
                    String sCountry = sparams[4];
                    if (sCountry.equals("Ukraine"))
                        nUser.setCountry(User.Country.UKRAINE);
                    else if (sCountry.equals("Russia"))
                        nUser.setCountry(User.Country.RUSSIA);
                    else if (sCountry.equals("Other"))
                        nUser.setCountry(User.Country.OTHER);
                    else nUser.setCountry(null);

                    users.add(nUser);
                }
            }
            reader.close();
        }
    }
}
