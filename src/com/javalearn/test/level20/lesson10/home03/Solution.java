package com.javalearn.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution {

    public static class A {
        protected String name = "A";

        protected A(){ System.out.println("In A");};

        public A(String name) {
            this.name += name;
        }
    }

    public   class B extends A implements Serializable {


        private void writeObject(ObjectOutputStream out) throws IOException {
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            name = (String)in.readObject();
        }

        public B(String name) {
            super(name);
            this.name += name;
        }
    }


}
