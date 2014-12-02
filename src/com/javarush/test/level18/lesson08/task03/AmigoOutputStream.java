package com.javarush.test.level18.lesson08.task03;



import java.io.*;
import java.nio.channels.FileChannel;


/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream{


    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream original;



    @Override
    public void write(int b) throws IOException
    {
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        original.write(b, off, len);
    }

    @Override
    public FileChannel getChannel()
    {
        return original.getChannel();
    }

    @Override
    protected void finalize() throws IOException
    {
        super.finalize();
    }

    @Override
    public void flush() throws IOException
    {
        original.flush();
    }

    @Override
    public int hashCode()
    {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return original.equals(obj);
    }


    @Override
    public String toString()
    {
        return original.toString();
    }

    public AmigoOutputStream(FileOutputStream originalf) throws FileNotFoundException
    {
        super(fileName);
        this.original = originalf;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void close() throws IOException
    {
        original.flush();

        original.write("JavaRush © 2012-2013 All rights reserved.".getBytes());
        original.close();
    }
}
