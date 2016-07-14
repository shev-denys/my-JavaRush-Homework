package com.javalearn.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution
{

    public static void main(String[] args) throws IOException
    {
        Scanner s = new Scanner(new File("c:\\temp.txt"));
        PersonScanner adapter = new PersonScannerAdapter(s);
        System.out.println(adapter.read());
        adapter.close();
    }

    public static class PersonScannerAdapter implements PersonScanner
    {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {   Person person = null;
            if (scanner.hasNext())
            {
                String line = scanner.nextLine();
                String[] values = line.split(" ");
                if (values.length == 6)
                {
                    int day = Integer.parseInt(values[3]);
                    int month = Integer.parseInt(values[4])-1;
                    int year = Integer.parseInt(values[5]);
                    Calendar date = new GregorianCalendar(year, month, day);

                    person = new Person( values[1], values[2],values[0], date.getTime());
                    return person;
                } else
                    return person;
            } else
                return person;
        }

        @Override
        public void close() throws IOException
        {
                scanner.close();
        }
    }
}
