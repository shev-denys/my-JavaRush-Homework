package com.javalearn.test.level21.lesson08.task02;

import java.io.*;
import java.util.ArrayList;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
*/
public class Solution
{
    public static void main(String[] args)
    {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try
        {
            clone = tree.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant
    {
        private String name;

        public Plant()
        {
        }

        public Plant(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable
    {
        private String[] branches;

        public Tree clone() throws CloneNotSupportedException
        {
            Tree newSolution = null;
            if (branches!=null)
            {
                ArrayList<String> branchesCopy = new ArrayList<>();
                for (String branch : branches)
                    branchesCopy.add(new String(branch));
                newSolution = new Tree(new String(getName()), branchesCopy.toArray(new String[branchesCopy.size()]));
            }
            else
                newSolution = new Tree(new String(getName()),null);

            return newSolution;

        }


        public Tree(String name, String[] branches)
        {
            super(name);
            this.branches = branches;
        }


        public String[] getBranches()
        {
            return branches;
        }
    }

}
