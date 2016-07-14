package com.javalearn.test.level17.lesson10.home02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Admin on 26.11.2014.
 */
public class sol
{
    public static void main(String[] args) {
        Beach beach1=new Beach("bang",20,3);
        Beach beach2=new Beach("ang",19,2);
        Beach beach3=new Beach("ang",19,3);
        Beach beach4=new Beach("mng",20,3);
        Beach beach5=new Beach("mng",20,5);
        List<Beach> beachList=new ArrayList<Beach>();
        beachList.add(beach1);
        beachList.add(beach2);
        beachList.add(beach3);
        beachList.add(beach4);
        beachList.add(beach5);
        System.out.println(beachList);
        Collections.sort(beachList);
        System.out.println(beachList);
    }
}
