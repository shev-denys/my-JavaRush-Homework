package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Externalizable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать.
Объект всегда должен содержать актуальные на сегодняшний день данные.
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        System.out.println(new Solution(4));

        //проверка
        Solution solution = new Solution(4);
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Temp\\myTemp.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(solution);
        outputStream.flush();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C:\\Temp\\myTemp.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Solution solution1 = (Solution)inputStream.readObject();
        inputStream.close();

        System.out.println(solution);
        System.out.println(solution1);

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private  transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution()
    {

    }

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
