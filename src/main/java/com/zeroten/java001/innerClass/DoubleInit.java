 package com.zeroten.java001.innerClass;

import java.util.ArrayList;
import java.util.List;

public class DoubleInit {

    public static void main (String[] args){
        List<Integer> numbs=new ArrayList();
        numbs.add(1);
        numbs.add(2);
        numbs.add(3);
        numbs.add(4);
        numbs.add(5);
        System.out.println("numbs="+numbs);

        //局部内部类代码块初始化
        class ArrayList2 extends ArrayList{
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        }
        List<Integer> numbs2=new ArrayList2();
        System.out.println("numbs2="+numbs2);

        //双括号初始化
        List<Integer> numbs3=new ArrayList(){
            {
                add(6);
                add(7);
                add(8);
                add(9);
                add(10);
            }
        };
        System.out.println("numbs3="+numbs3);
    }

}
