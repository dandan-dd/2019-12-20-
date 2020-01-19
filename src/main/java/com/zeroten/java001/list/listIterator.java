package com.zeroten.java001.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class listIterator {

    private static void ListIterator(){
        List<String> list=new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        ListIterator<String> listIterator=list.listIterator();
        System.out.println("havePrevious="+listIterator.hasPrevious());
        System.out.println("haveNext="+listIterator.hasNext());
        System.out.println("previousIndex="+listIterator.previousIndex());
        System.out.println("nextIndex="+listIterator.nextIndex());

        //System.out.println("next()="+listIterator.previous());//不存在的元素，抛异常NoSuchElementException
        System.out.println("next()="+listIterator.next());
        System.out.println("havePrevious="+listIterator.hasPrevious());
        System.out.println("haveNext="+listIterator.hasNext());
        System.out.println("previousIndex="+listIterator.previousIndex());
        System.out.println("nextIndex="+listIterator.nextIndex());

        System.out.println("next()="+listIterator.previous());
        listIterator.set("AA");//修改的是上次调用next/previous返回的值，remove也是和set类似
        System.out.println("havePrevious="+listIterator.hasPrevious());
        System.out.println("haveNext="+listIterator.hasNext());
        System.out.println("previousIndex="+listIterator.previousIndex());
        System.out.println("nextIndex="+listIterator.nextIndex());
        listIterator.add("first");//在迭代器之前加
        System.out.println(list);

        /**
         * 迭代器操作元素的时候
         * set/remove方法和迭代器的状态有关，更新或删除的是上一次调用next/previous返回的值
         * add之和迭代器的位置有关，在当前迭代器的位置之前添加元素
         */
    }

    public static void main(String[] args){
        ListIterator();
    }

}
