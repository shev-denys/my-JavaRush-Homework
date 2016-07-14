package com.javalearn.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public int hashCode()
    {

        return 31*(first==null?0:first.hashCode()) + (last==null?0:last.hashCode());
    }

    public boolean equals(Object o) {
        if((o == null) || (o.getClass() != this.getClass())) { return false; }

        Solution obj = (Solution) o;

        if (first != null && last != null)
            return first.equals(obj.first) && last.equals(obj.last);
        else if (last != null && first == null)
            return last.equals(obj.last)&&obj.first==null;
        else if (first != null&& last == null)
            return first.equals(obj.first)&&obj.last==null;
        else
            return obj.last==null && obj.first==null;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
