package com.zeroten.java001.collection;

import java.util.*;

public class CollectionSimpleUser {

    public static  void printAllElement(List<String> list){
        System.out.println(list.size());
        //遍历
        //1.for循环,使用元素索引的方式
        for(int i=0;i<list.size();i++){
            String str=list.get(i);

            System.out.print(str);
            if(i<list.size()-1){
                System.out.print(",");
            }else{
                System.out.print("\n");
            }

        }
        //iterator 使用迭代前期遍历
        Iterator<String> iterator=list.iterator();
        /**
         * 迭代器的位置是在元素之间
         * 存在n个元素的列表，迭代器的位置可能有n+1个
         * 获取迭代器后，迭代器的位置在第一个元素之前
         * 未调用next（）方法时，调用remove 会抛出IllegalStateException
         * 当迭代器到达最后一个元素时，抛出NoSuchElementException
         * remove方法删除的是调用next（）方法时返回的元素（越过的元素）
         * iterator.remove( )
         */
        //System.out.println(iterator.next());//每调用一次next，迭代器的位置移动一次
        // System.out.println(iterator.next());
        //System.out.println(iterator.next());
        //System.out.println(iterator.next());
        while(iterator.hasNext()){
            //next方法有两个作用
            //将迭代器位置移动一个位置
            //返回越过的元素
            System.out.println(iterator.next());
        }

        //删除，1.按索引。。2.按元素
        list.remove(1);
        list.remove("F");//删除的是第一次出现的那个
        System.out.print(list);

    }

    public static void main(String[] args){
        /**
         * 集合分两大类：
         * 1.单个元素的序列，全部都实现Collection接口
         *   1.1.List，列表，有序的，按照插入顺序排序，可以有重复元素，也可以包含null
         *   1.2.Set，集，不可以有重复元素，可以包含null
         *   1.3.Queue，队列，按一定规则进行添加/删除
         * 2.键值对，全部实现Map接口
         */

        //可以通过<>括号来知道列表里要存放的元素类型
        List<String> list=new ArrayList<>();//列表
        list.add("a");//添加元素
        list.add("c");
        list.add("d");
        list.add("F");
        list.add("c");
        list.add("d");
        list.add("F");
        printAllElement(list);

        /**
         * ArraysList<String> list=new ArrayList<>();//列表
         * LinkedList<String> list2=new LinkedList<>();//链表
         * 不通用，类型改成通用的List
         */

        List<String> list2=new LinkedList<>();//链表
        list2.add("1");//添加元素
        list2.add("3");
        list2.add("4");
        list2.add("6");
        list2.add("8");
        list2.add("3");
        list2.add("9");
        printAllElement(list2);


        List list3=new ArrayList();//没有规定类型，可任意添加类型
        list3.add(1);
        list3.add("FFF");
        list3.add(new Date());
        list3.add(new CollectionSimpleUser().new Customer());

        //如果需要数据类型转换，需要使用instanceof来判断该变量的实际类型
        for(int i=0;i<list3.size();i++){
            Object obj=list3.get(i);
            if (obj instanceof String){
                String str=(String)list3.get(i);
                System.out.println(str);
            }else if(obj instanceof Integer){
                Integer itg=(Integer) list3.get(i);
                System.out.println(itg);
            }else if(obj instanceof Date){
                Date date=(Date)obj;
                System.out.println(date);
            }else{
                System.out.println("不支持"+obj.getClass().getName());
            }
        }
    }
    class Customer{

    }
}
