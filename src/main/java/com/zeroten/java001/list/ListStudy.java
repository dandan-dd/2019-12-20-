package com.zeroten.java001.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListStudy {
    /**
     *  List主要有两种：ArrayList和LinkedList
     *  ArrayList：内部使用数组来实现
     *  LinkedList：内部使用一个双向链表来实现
     *  创建：无参数构建、有参数构建1.指定容量大小  2.复制已存在的List来创建
     *  添加：1.头插  2.尾插  3.中间插
     *  删除：1.头删  2.尾删  3.中间删
     *  遍历：
     *      1.使用for循环
     *      2.使用迭代器Iterator、ListIterator
     *      3.使用迭代器对List进行添加、删除操作
     *      4.迭代器的使用注意事项：使用迭代器对列表进行操作时，
     *        原对象不能发生结构性变化，否则迭代器操作会抛异常
     *  底层实现原理及JDK源码：内部存储结构、添加/删除/遍历操作的流程
     *  对List进行排序：冒泡、插入、选择
     */

    private static void addNumberToList(List<Integer> list,int count,int num){
        long start=System.currentTimeMillis();
        for (int i=0;i<count;i++){
            list.add(num);
        }
        System.out.println("耗时："+(System.currentTimeMillis()-start)+"ms");
    }

    private static void studyArrayList(){
        /**
         * 创建ArrayList时，如果未指定容量大小时，会创建一个空数组
         * 当第一次调用add时，扩充为初始化容量大小为10
         *
         * 数组是有容量大小的，当调用add时发现容量不足，就会引发扩容
         *          1.新的容量大小：原来容量的1.5倍
         *          2.按新的容量大小创建新数组
         *          3.将旧数组里面的原始的元素全部复制到新数组中
         *          4.丢弃旧的数组
         */
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        //插入
        list.add(2);//尾插
        System.out.println("list="+list);
        list.add(0,100);//自定义位置插，头尾中
        System.out.println("list="+list);
        list.set(1,33);//修改值
        //addNumberToList(list,10000,1);
        System.out.println("list="+list);
        //删除
        list.remove(1);//按下标删除
        System.out.println("list="+list);
        list.remove(list.size()-1);
        System.out.println("list="+list);
        //遍历
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
            if(i<list.size()-1){
                System.out.print(",");
            }else{
                System.out.println("\n");
            }
        }
        Iterator<Integer> iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        for (Integer num:list){
            System.out.println(num);
        }

        //如果在创建数组列表前可以预估数据规模，可以指定一个初始容量大小，减少扩容操作
        List<Integer> list2=new ArrayList<>(10000);
        for(Integer i:list){
            list2.add(i);
        }
        //addNumberToList(list2,10000,1);
        System.out.println("list2="+list2);

        //直接复制已存在的数组
        List<Integer> list3=new ArrayList<>(list);
        //addNumberToList(list3,10000,1);
        System.out.println("list3="+list3);


    }

    public static void main(String[] args){
        studyArrayList();

    }


}
