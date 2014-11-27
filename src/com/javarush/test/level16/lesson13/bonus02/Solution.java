package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    static
    {
        threads.add(new Loop());
        threads.add(new InterruptedExceptionClass());
        threads.add(new Ura());
        threads.add(new MessageExt());
        threads.add(new Numbers());
    }

    public static class Loop extends  Thread
    {
        public Loop()
        {
            super();
        }

        @Override
        public void run()
        {
            while(true)
            {
                ;
            }
        }
    }

    public static class InterruptedExceptionClass extends  Thread
    {
        public InterruptedExceptionClass()
        {
            super();
        }

        @Override
        public void run()
        {
            try {
                while (!isInterrupted()) {
                }
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Ura extends  Thread
    {
        public Ura()
        {
            super();
        }

        @Override
        public void run()
        {
            while(true)
            {
                System.out.println("Ура");
                try
                {
                    sleep(500);
                }
                catch (InterruptedException e)
                {

                }
            }
        }
    }

    public static class MessageExt extends Thread implements Message
    {
        public MessageExt()
        {
            super();
        }

        @Override
        public void showWarning()
        {
            interrupt();
            try
            {
                this.join();
            }
            catch(Exception e)
            {

            }
        }
        public void run()
        {
            Thread current = Thread.currentThread();
            while(!current.interrupted())
            {

            }
        }


    }

    public static class Numbers extends Thread
    {
        public Numbers()
        {
            super();
        }

        @Override
        public void run()
        {
            int sum=0;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try
            {
                String s = reader.readLine();
                while (!s.equals("N"))
                {
                    sum+=Integer.parseInt(s);
                    s = reader.readLine();
                }
                System.out.println(sum);
            }
            catch (IOException e)
            {

            }
        }
    }
}
