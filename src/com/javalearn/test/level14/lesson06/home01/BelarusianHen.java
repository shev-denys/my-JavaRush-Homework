package com.javalearn.test.level14.lesson06.home01;

/**
 * Created by Admin on 05.11.2014.
 */
 class BelarusianHen extends Hen
{
    @Override
    String getDescription()
    {
        return super.getDescription()+ " Моя страна - "+Country.BELARUS+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
    @Override
    int getCountOfEggsPerMonth()
    {
        return 13;
    }
}