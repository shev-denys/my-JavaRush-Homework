package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object  n) {

        if((n == null) || (n.getClass() != this.getClass())) { return false; }

        Solution obj = (Solution) n;

        if (first != null && last != null)
            return first.equals(obj.first) && last.equals(obj.last);
        else if (last != null && first == null)
            return last.equals(obj.last)&&obj.first==null;
        else if (first != null&& last == null)
            return first.equals(obj.first)&&obj.last==null;
        else
        return obj.last==null && obj.first==null;
    }

    public int hashCode()
    {

        return 31*(first==null?0:first.hashCode()) + (last==null?0:last.hashCode());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println((new Solution("Donald", "Duck")).equals(new Solution("Donald", "Duck")));

        System.out.println((new Solution(null, null)).equals( new Solution(null, null)));
        System.out.println((new Solution("first", null)).equals(new Solution("first", null)));
        System.out.println((new Solution(null, "last")).equals(new Solution(null, "last")));

        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
