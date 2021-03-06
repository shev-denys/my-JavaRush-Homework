package com.javalearn.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Admin on 16.02.2015.
 */
public class Producer implements Runnable
{
    private int i=0;
    ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String,String> map)
    {
      this.map = map;

    }

    @Override
    public void run()
    {
        try {
            while (!Thread.currentThread().isInterrupted()) {

                map.put(String.valueOf(i), "Some text for " + ++i);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
