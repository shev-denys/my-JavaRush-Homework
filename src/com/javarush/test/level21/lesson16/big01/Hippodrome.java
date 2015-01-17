package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Admin on 04.01.2015.
 */
public class Hippodrome
{
    public static Hippodrome game;
    private ArrayList<Horse> horses = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        game.getHorses().add(new Horse("one", 3, 0));
        game.getHorses().add(new Horse("two", 3, 0));
        game.getHorses().add(new Horse("three", 3, 0));


        game.run();
        game.printWinner();
    }

    public Horse getWinner()
    {
        Horse winner = getHorses().get(0);

        for (Horse horse : getHorses())
            if (winner.getDistance() < horse.getDistance())
                winner = horse;
        return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException
    {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            Thread.sleep(10);

        }
    }

    public void move()
    {
        for (Horse horse : getHorses())
            horse.move();
    }

    public void print()
    {
        for (Horse horse : getHorses())
            horse.print();
        System.out.println();
        System.out.println();
    }


}
