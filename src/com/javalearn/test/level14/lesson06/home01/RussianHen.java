package com.javalearn.test.level14.lesson06.home01;

/**
 * Created by Admin on 05.11.2014.
 */
class RussianHen extends Hen
{
    @Override
    String getDescription()
    {
        return super.getDescription()+ " Моя страна - "+Country.RUSSIA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }

    @Override
    int getCountOfEggsPerMonth()
    {
        return 10;
    }
}
