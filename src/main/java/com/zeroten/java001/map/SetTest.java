package com.zeroten.java001.map;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args){
        /**
         * 集合类：
         *   1.Collection
         *        List 列表
         *        Set 集
         *        Queue 队列
         *   2.Map  键值对、散列
         *       Set  内部使用的是对应的Map来实现的
         *       Map的Key值里面存放的即是Set的值，
         *       key值对应的Value存放的是一个固定值static new Object（）
         *       HashSet 内部是使用 HashMap 来实现的
         *       TreeSet 内部是使用 TreeMap 来实现的
         *       Map中的Key值不可以重复。可以为null？
         *       因此Set的值不可以重复。可以为null？
         *       但是TreeSet的值不能为null
         *       TreeSet有序，但不是按插入顺序有序，而是值的顺序，如大小顺序
         *
         *
         */

        TreeSet<String> treeSet=new TreeSet();
        treeSet.add("iiiiiiii");
        treeSet.add("iiiiiiiiiiiii");
        treeSet.add("iiiiiiiiiiiiiiiiii");
        treeSet.add("str1");//内部调用的是map.put("str1",PRESENT)
        treeSet.add("str3");

        //构造TreeSet时，
        //treeSet.add(null);
        // 如果构造TreeSet时没有指定Comparator，则不能存放null，
        // add添加元素时需要调用元素对象的compareTo方法（comparable接口）去比较元素的大小，null无法和其它元素比较，因此不能存放null
        //treeSet.add("str1");//不可重复，重复会报错

        Iterator<String> iterator=treeSet.iterator();//调用的是map.keys().iterator()
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        treeSet.remove("iiiiiiiiiiiii");//实际调用的是map.remove()

        Iterator<String> iterator1=treeSet.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        /**
         * map是如何排序的：
         *          *         1.comparator接口比较2个值
         *          *         2.comparable接口比较自身和另一个对象的值
         *          *       和TreeMap类似，TreeSet内存放的元素必须实现comparable接口
         *          *       但是如果构造TreeSet时指定了Comparator，那么元素可以不用实现comparable接口
         */

        //如果构造TreeSet时指定了Comparator，那么元素可以不用实现comparable接口
        TreeSet<ComparableTest.XuHao2> treeSet2=new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                System.out.println("指定了Comparator，那么元素可以不用实现comparable接口");
                return 0;
            }
        });
        treeSet2.add(null);//如果构造TreeSet时指定了Comparator，则可以存放null
        treeSet2.add(new ComparableTest.XuHao2(1));
        treeSet2.add(null);//插入多次无效，且不会报错
        System.out.println("treeSet2="+treeSet2);

        //TreeSet内存放的元素必须实现comparable接口
//        TreeSet<ComparableTest.XuHao2> treeSet2=new TreeSet();
//        treeSet2.add(new ComparableTest.XuHao2(1));


        HashSet<String> hashSet=new HashSet<>();
        //无序（内部顺序不断变化），可以null，不能重复，插入多个不会报错，但无效
        hashSet.add(null);
        hashSet.add("aaa");
        hashSet.add("bbb");
        hashSet.add("ccc");
        hashSet.add("bbb");
        hashSet.add(null);
        System.out.println("hashSet="+hashSet);


        //Set的主要作用：判断某个元素是否存在集中、去重
        if (hashSet.contains("bbb")){
            System.out.println("包含");
        }else{
            System.out.println("不包含");
        }


        //LinkedHashSet
        //EnumSet  内部使用的是枚举类的数组
        //HashMap使用resize初始化或扩容操作？？？？？？？？
    }
}
