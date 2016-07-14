package com.javalearn.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
     Thread thread;

    @Override
    public void start(String threadName)
    {
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();
    }

    @Override
    public void stop()
    {
        thread.interrupt();


    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(0);
            while (!thread.isInterrupted())
            {


                System.out.println(Thread.currentThread().getName());
                Thread.sleep(90);

            }
        }
        catch (InterruptedException e)
        {

        }
    }
}
