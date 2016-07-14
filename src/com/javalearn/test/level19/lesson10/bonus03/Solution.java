package com.javalearn.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
    static ArrayList<Pair[]> list = new ArrayList<>();
    static Stack stackofStarts = new Stack();
    static Stack stackofEnds = new Stack();

    static String startOfTag;
    static String endOfTag;


    public static void main(String[] args) {

        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner =new Scanner( new FileInputStream(reader.readLine()));
            reader.close();
            String tag = args[0];
            startOfTag = "<"+tag;
            endOfTag = "</"+tag+">";

            String htmltext="";
            while (scanner.hasNext())
                htmltext += scanner.nextLine();


            int startPoint=0;
            while (true)
            {
              startPoint = findEndOfTag( htmltext, startPoint) +1;
              if (startPoint>=htmltext.length()) break;
            }
            bubbleSort(list);

            for(Pair[] pair:list)
            {
                System.out.println(htmltext.substring(pair[0].start,pair[1].end+1));
            }

        }
        catch (IOException e){}
        ;

    }

    public static void bubbleSort(ArrayList<Pair[]> arr){

        for(int i = arr.size()-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){

            if( arr.get(j)[0].end > arr.get(j+1)[0].end ){
                Pair[] tmp = arr.get(j);
                arr.set(j, arr.get(j+1));
                arr.set(j+1,tmp );
            }
        }
    }
}


    public static class Pair {
        int start,end;

        public Pair()
        {
        }

        public Pair(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    public static class Stack
    {
        ArrayList<Pair> stack = new ArrayList<>();

        public  ArrayList<Pair> Get()
        {
            return this.stack;
        }
        public  void AddToStack(Pair pair,boolean check, ArrayList<Pair> stackofadd)
        {
            if (check)
            {
                int num = 0;
                for (Pair pairt : stackofadd)
                {
                    if (pair.end > pairt.end)
                        num++;
                }
                stack.add(stack.size()-num,pair);

            }
                else
            stack.add(pair);
        }

        public  Pair GetLastStackAndDelete()
        {
            Pair pair = stack.get(stack.size()-1);
            stack.remove(pair);
            return pair;
        }

        public  Pair GetFirstStackAndDelete()
        {
            Pair pair = stack.get(0);
            stack.remove(pair);
            return pair;
        }

        public  int GetLastPositionInStack()
        {
            int result=0;

            for(Pair pair:stack)
                if(pair.end>result)
                    result=pair.end;


             return result;
        }
        public  int Size()
        {return  stack.size();}
    }

    public static int findEndOfTag( String str, int staerp)
    {
        int startPositionStart = staerp;
        int startPositionEnd = staerp;
        while (true)
        {
            Pair tmpStartOfTag = new Pair();
            Pair tmpEndOfTag = new Pair();

            int istartOfTagstart = str.indexOf(startOfTag, startPositionStart);

            if (istartOfTagstart != -1)
            {
                int istartOfTagend = str.indexOf(">", istartOfTagstart + 1);
                if (istartOfTagend != -1)
                {
                    tmpStartOfTag.start = istartOfTagstart;
                    tmpStartOfTag.end = istartOfTagend;
                }
            } else
            {
                int a = 1;
            }

            int iendOfTag = str.indexOf(endOfTag, startPositionEnd);

            if (iendOfTag != -1)
            {
                tmpEndOfTag.start = iendOfTag;
                tmpEndOfTag.end = iendOfTag + endOfTag.length() - 1;
            } else
            {
                int a = 1;
            }

           // if (stackofEnds.GetLastPositionInStack()<tmpStartOfTag.end&&stackofEnds.GetLastPositionInStack()!=0)
           //     break;

            if(tmpEndOfTag.end> startPositionEnd)
                startPositionEnd=tmpEndOfTag.end;

            if (tmpEndOfTag.end == 0 && tmpStartOfTag.end == 0)
               break;


            stackofStarts.AddToStack(tmpStartOfTag,true,stackofEnds.Get());
            stackofEnds.AddToStack(tmpEndOfTag,false,null);

            startPositionStart = stackofStarts.GetLastPositionInStack();
            startPositionEnd = stackofEnds.GetLastPositionInStack();


        }

        while (stackofStarts.Size() > 0)
            list.add(new Pair[]{stackofStarts.GetFirstStackAndDelete(), stackofEnds.GetLastStackAndDelete()});

        return startPositionEnd;
    }
}
