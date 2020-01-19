package com.zeroten.java001.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListStudy {

    /**
     * 双向链表
     * 一个节点包含data、next、previous三部分
     * 指针？
     */

    public static void linkedList(){
        List list1=new LinkedList();//链表创建和ArrayList不一样：无大小限制。无需指定大小
        list1.add("A");
        list1.add("B");
        list1.add("C");
        System.out.println(list1);

        List list2=new LinkedList(list1);
        System.out.println(list2);
        //其余操作和ArrayList类似
    }

    private static void listOptime(List<Integer> list){
        //for循环遍历
        //对于LinkedList，每次get(Index)，都会从头开始查找
        //优化：
        //    如果i<length/2,从头部开始找
        //    如果i>length/2,从尾部开始找
        long start=System.currentTimeMillis();
        for (int i=0;i<list.size();i++){
            list.get(i);
        }
        System.out.printf("[%s]for循环遍历耗时%dms\n",list.getClass().getSimpleName(),System.currentTimeMillis()-start);

        //Iterator
        start=System.currentTimeMillis();
        Iterator<Integer> iterator=list.iterator();
        while(iterator.hasNext()){
            iterator.next();
        }
        System.out.printf("[%s]迭代器循环遍历耗时%dms\n",list.getClass().getSimpleName(),System.currentTimeMillis()-start);

        //for-each
        start=System.currentTimeMillis();
        for (Integer em:list){

        }
        System.out.printf("[%s]for-each循环遍历耗时%dms\n",list.getClass().getSimpleName(),System.currentTimeMillis()-start);

        //中间插入
        start=System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            list.add(4,1);
        }
        System.out.printf("[%s]第五位插入100000个1耗时%dms\n",list.getClass().getSimpleName(),System.currentTimeMillis()-start);


        //末尾插入
        start=System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            list.add(1);
        }
        System.out.printf("[%s]末尾插入100000个1耗时%dms\n",list.getClass().getSimpleName(),System.currentTimeMillis()-start);

    }
    public static void fill(List<Integer> list){
        for (int i=0;i<10000;i++){
            list.add(i);
        }
    }
    public static void main(String[] args){
        linkedList();
        /**
         * ArrayList和LinkedList的区别
         * ArrayList长于随机快速访问，而从列表中间删除插入元素很慢
         * LinkedList长于从列表中间删除插入元素，但随即访问很慢
         * 随机访问：即list.get(Index)，通过索引访问
         */
        List<Integer> list=new ArrayList<>();
        fill(list);
        listOptime(list);

        List<Integer> list2=new LinkedList<>();
        fill(list2);
        listOptime(list2);
    }
}
