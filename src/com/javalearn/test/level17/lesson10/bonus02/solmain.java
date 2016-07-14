package com.javalearn.test.level17.lesson10.bonus02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 27.11.2014.
 */
public class solmain
{
    public static void main(String[] args)
    {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            final int size = 4;
            final int finalI = i;
            list.add(new Thread() {
                @Override
                public void run() {
                    String params;
                    if (finalI < (int)size/4){
                    params = "-c";
                    for (int j = 1; j <= 10; j++) {
                        params+= " Person" + (j - 1);
                        params+= " м";
                        params+= " 25/11/1989";
                    }}

                    else  if (finalI < (int)size/2)
                    {
                        params = "-u";
                        for (int j = 1; j <= 10; j++) {
                            params+= " "+finalI;
                            params+= " Person" + (j - 1);
                            params+= " м";
                            params+= " 25/11/1989";
                        }
                    }

                    else  if (finalI < (int)3*size/4)
                    {
                        params = "-d";
                        for (int j = 1; j <= 10; j++) {
                            params+= " "+1;
                        }
                    }
                    else
                    {
                        params = "-i";
                        for (int j = 1; j <= 10; j++) {
                            params+= " "+finalI;

                        }
                    }

                    Solution.main(params.split(" "));
                }
            });
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).start();
        }
    }
}
