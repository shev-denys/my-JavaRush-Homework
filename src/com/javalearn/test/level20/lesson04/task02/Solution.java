package com.javalearn.test.level20.lesson04.task02;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* Как сериализовать javalearn?
Сделайте так, чтобы сериализация класса javalearn была возможной
*/
public class Solution {
    public static class javalearn implements Serializable{
        public List<User> users = new ArrayList<>();
    }
}
