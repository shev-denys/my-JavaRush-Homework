package com.javalearn.test.level27.lesson09.home01;

public class TransferObject
{
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get()
    {
        while (!isValuePresent)
            try
            {
                this.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        isValuePresent = false;
        System.out.println("Got: " + value);
        notifyAll();
        return value;


    }

    public synchronized void put(int value)
    {
        while (isValuePresent)
            try
            {

                this.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        this.value = value;
        System.out.println("Put: " + value);
        isValuePresent = true;
        this.notifyAll();

    }
}
