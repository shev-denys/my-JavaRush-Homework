package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        String type = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];
        String xorKey = "goodwin";

        Encryptor encryptor = new Encryptor(fileName, fileOutputName, xorKey);

        if (type.equals("-e"))
            encryptor.Encrypt();
        else if (type.equals("-d"))
            encryptor.Decrypt();
    }

    public static class Encryptor
    {

        private String filename;
        private String fileOutputName;
        private String xorKey;

        public Encryptor(String filename, String fileOutputName, String xorKey)
        {
            this.filename = filename;
            this.fileOutputName = fileOutputName;
            this.xorKey = xorKey;
        }

        public void Encrypt() throws Exception
        {

            FileInputStream fileInputStream = new FileInputStream(filename);
            byte[] bytes = new byte[fileInputStream.available()];
            byte[] encryptbytes = new byte[(fileInputStream.available())];
            byte[] key = xorKey.getBytes();

            if (fileInputStream.available() > 0)
                fileInputStream.read(bytes);
            fileInputStream.close();

            for (int i = 0; i < bytes.length; i++)
            {
                encryptbytes[i] = (byte) (bytes[i] ^ key[i % key.length]);
            }

            FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
            fileOutputStream.write(encryptbytes);
            fileOutputStream.close();

        }

        public void Decrypt() throws Exception
        {

            FileInputStream fileInputStream = new FileInputStream(filename);
            byte[] bytes = new byte[fileInputStream.available()];
            byte[] decryptbytes = new byte[(fileInputStream.available())];
            byte[] key = xorKey.getBytes();

            if (fileInputStream.available() > 0)
                fileInputStream.read(bytes);
            fileInputStream.close();

            for (int i = 0; i < bytes.length; i++)
            {
                decryptbytes[i] = (byte) (bytes[i] ^ key[i % key.length]);

                FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
                fileOutputStream.write(decryptbytes);
                fileOutputStream.close();
            }
        }
    }
}
