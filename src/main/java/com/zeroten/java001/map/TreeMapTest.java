package com.zeroten.java001.map;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args){
        //创建、增删、遍历、改
        //对于TreeMap,Key值对象必须实现Comparable接口
        TreeMap<String,String > map=new TreeMap();//有序，以key值排序，
        //如何排序？
        //1. 构造TreeMap时，未指定排序器（即Comparator接口实现），那么Key值对象就必须实现排序接口Comparator
        //2. 构造TreeMap时，指定了排序器，那么Key值对象就可以不实现排序接口Comparator
        //存放元素时，会调用Comparable接口的compareTo方法，默认按升序排序
        //当使用put添加元素或者使用remove删除元素时并不是调用equals方法，而是使用比较器
        //优先使用构造时传入的Comparator的compare方法，通过未传入，则使用Key值对象的Comparable接口compareTo方法
        map.put("201724113114","hwd");
        map.put("201724113106","cxc");
        map.put("201724113145","xth");
        map.put("201724113160","zjj");
        System.out.println(map.remove("201724113114"));//返回Object
        System.out.println(map.remove("30","hwd"));//返回boolean

        //
        //Map严格来说不是一个集合，但是它有三个视图，我们可以把它当作集合来使用
        //1.键视图,Set
        System.out.println( map.keySet());

        //2.值视图,Collection
        System.out.println(map.values());

        //3.键值对视图,Entry
        Set<Map.Entry<String,String>> kv=map.entrySet();
        System.out.println(kv);

        //遍历
        for (Map.Entry<String,String> entry:kv){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        System.out.println();//返回Object

        //Comparator和Comparable两个接口的区别

        //Comparable int compareTo(T o)
    }
}
