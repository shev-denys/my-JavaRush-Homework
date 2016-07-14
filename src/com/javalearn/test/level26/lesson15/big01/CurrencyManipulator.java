package com.javalearn.test.level26.lesson15.big01;

import com.javalearn.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Admin on 16.02.2015.
 */
public class CurrencyManipulator
{

    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }


    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
        {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else
        {
            denominations.put(denomination, count);
        }
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return getTotalAmount() >= expectedAmount;
    }

    public int getTotalAmount()
    {
        int result = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
        {

            result = result + (pair.getKey() * pair.getValue());
        }
        return result;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("CurrencyManipulator{");
        sb.append("currencyCode='").append(currencyCode).append('\'');
        sb.append(", denominations=").append(denominations);
        sb.append('}');
        return sb.toString();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {


        TreeMap<Integer, Integer> getCashByDesc = new TreeMap<Integer, Integer>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        });
        getCashByDesc.putAll(denominations);


        ArrayList<Map.Entry<Integer, Integer>> getCashByDescArray = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : getCashByDesc.entrySet())
        {
            getCashByDescArray.add(entry);
        }

        for (int i = 0; i < getCashByDescArray.size(); i++)
        {
            int sum = expectedAmount;
            Map<Integer, Integer> resultInner = new HashMap<>();
            for (int j = i; j < getCashByDescArray.size(); j++)
            {
                Map.Entry<Integer, Integer> entry = getCashByDescArray.get(j);

                int curAmount = 0;

                curAmount = sum / entry.getKey();
                if(curAmount<=entry.getValue()&&curAmount>0)
                {
                    resultInner.put(entry.getKey(), curAmount);
                    sum = sum - curAmount * entry.getKey();
                }
                if (sum == 0)
                {
                    for(Map.Entry<Integer,Integer> entrySet:resultInner.entrySet())
                        denominations.put(entrySet.getKey(),denominations.get(entrySet.getKey())-entrySet.getValue());
                    return resultInner;
                }
            }

        }

        throw new NotEnoughMoneyException();

    }




    public boolean hasMoney()
    {
        boolean result = true;
        if (denominations.isEmpty()) result = false;
        else
        {
            int zerosCount = 0;
            for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
            {
                if (pair.getValue() == 0) zerosCount++;
            }
            if (zerosCount == denominations.size()) result = false;
        }
        return result;
    }
}
