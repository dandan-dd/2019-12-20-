package com.zeroten.java001.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MapTool {
    public static void main(String[] args){
        //两个工具类：Arrays\Collections
        Integer[] intArr={1,3,2,4,6,5};
        System.out.println(Arrays.toString(intArr));
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));

        //数组和集合的转换

        /**1.数组————》》集合
         *asList方法，如果参数是一个基本数据类型，会将数组整体作为一个元素
         *          集合不能存放基本数据类型
         * asList 转换后的集合是不能改变结构的
         */
        List<Integer> list=Arrays.asList(intArr);
        System.out.println(list.size());
        System.out.println(list);
        //list.add(7);
        //list.remove(1);


        /**
         *集合-->数组
         *
         */
        Integer[] arr=list.toArray(new Integer[list.size()]);
        System.out.println(Arrays.toString(arr));


        /**
         * Collections
         */
        List<String> list1=new ArrayList<>();
        //List<String> list1;
        for (int i=0;i<10;i++){
            list1.add(i+"1");
        }


//        for(int i=0;i<10;i++){
//            list1.add("1");
//        }

//        list1=Collections.nCopies(10,"1");//相当于上面
        System.out.println(list1);

        List<String> subList=list1.subList(list1.size()-3,list1.size());//subList为list1的子集
        System.out.println(subList);
        subList.clear();//清空子集
        System.out.println(subList);
        System.out.println(list1);//清空子集会和父集联系，也会跟着清空相应元素

        list1.add("101");
        System.out.println(list1);

        list1=Collections.unmodifiableList(list1);//修改为不可修改的集合
        //list1.add("111");//报异常UnsupportedOperationException

        /**
         * 队列：队列/双端队列，LinkedList（链表）/ArrayDeque（双端队列）/PriorityQueue（优先级队列）
         * 两个应用场景：任务调度（内部使用优先级队列）/LRU，即最近最少使用（内部使用LinkedHashMap来实现）
         * 两个工具类：Arrays/Collections
         * 课后练习：根据课堂中的实例，自己写一个任务调度应用；写一个LRU
         */
    }
}
