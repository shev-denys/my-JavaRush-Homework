package com.javalearn.test.level25.lesson09.task02;

import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Вооружаемся до зубов!
Создайте свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
UncaughtExceptionHandler должен маскать звездочками имя трэда.
"Thread-0" должно быть заменено на "********"
"Thread-4321" должно быть заменено на "***********"
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;

        class MyUnHandler implements Thread.UncaughtExceptionHandler
        {
            @Override
            public void uncaughtException(Thread t, Throwable e)
            {
                String name = t.getName();



                //Pattern pattern  = Pattern.compile("(Thread-)+[0-9]+");
                //Matcher matcher = pattern.matcher(e.getMessage());

                //String word = matcher.group();
                String zv = "";

                for (char ch:t.getName().toCharArray())
                zv+="*";
                String text = e.getLocalizedMessage().replace(name,zv);
                System.out.println(text);

                //String result = name.replace(word,zv);



                //t.setName(result);

            }
        }

        this.handler = new MyUnHandler();    //init handler here


    }


    public static void main(String[] args)
    {
        Thread th = new Thread(new Solution(new TimerTask()
        {
            @Override
            public void run()
            {
                throw new Error();
            }
        }));
        th.start();
    }


    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }
}