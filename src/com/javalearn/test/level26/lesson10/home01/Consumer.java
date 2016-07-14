package com.javalearn.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Admin on 13.02.2015.
 */
public class Consumer  implements Runnable
{
    protected BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            int i = 0;
            while (!queue.isEmpty()) {
                System.out.println(queue.take());//(String.valueOf(i++)););
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
