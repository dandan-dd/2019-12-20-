package com.zeroten.java001.map;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueTest {
    public static void main (String[] args){
        /**
         * 优先级队列：任务调度、LRU（最近最少使用）
         * 任务调度：
         *   内部使用一种堆的数据结构，是自我调整的二叉树。当向队列中添加/删除元素时，
         *   它能快速的找到队列中最小的元素，并移动到树的根部，而不用对所有元素进行排序
         * 对优先级队列进行遍历的时候，无序
         */
        PriorityQueue<String> pQ=new PriorityQueue();
        pQ.add("1");
        pQ.add("3");
        pQ.add("5");
        pQ.add("7");
        pQ.add("2");
        pQ.add("8");
        pQ.add("6");
        pQ.add("4");
        //数组或实现了Iterable接口的类才能使用foreach遍历
        for (String string:pQ){
            System.out.printf(string);//无序，顺序随机变化
        }
        System.out.printf("\n");
        System.out.println(pQ.remove());//返回被删除的元素
        System.out.println(pQ);//每次删除之后会把最小的元素调整到根部（第一个），使用每次删除的是第一个（根部）
        System.out.println(pQ.remove());
        System.out.println(pQ.remove());
        System.out.println(pQ.remove());
        System.out.println(pQ.remove());
        System.out.println(pQ.remove());
        System.out.println(pQ.remove());
        System.out.println(pQ.remove());
        System.out.println(pQ);//空
        //remove方法之前判断队列是否为空
        //System.out.println(pQ.remove());//再调用会抛异常NoSuchElementException
        /**
         * TreeMap：
         *    构造TreeMap时，指定Comparator
         *    未指定Comparator时，Key值对象必须实现Comparable接口
         * Comparator和Comparable区别？？？
         *    Comparable比较自身和另一对象，compareTo
         *    Comparator比较传入的两个对象，compare
         * 优先级队列如何寻找最小元素：构建时指定Comparator或者存放元素实现Comparable接口
         */
        PriorityQueue<Task> TestList=new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.priority<o2.priority){
                    return -1;
                }
                if (o1.priority>o2.priority){
                    return 1;
                }
                return 0;
            }
        });
        for (int i=0;i<10;i++){
            int priority=new Random().nextInt(10);
            TestList.add(new Task(priority,"任务"+(i+1)));
        }
        System.out.println(TestList);

        while(true){
            if (TestList.isEmpty()){
                System.out.println("任务执行完毕");
                break;
            }
            Task task=TestList.remove();
            //System.out.println("执行任务"+task.name+"优先级["+task.priority+"]");
            System.out.println(String.format("执行任务：%s,优先级[%d]",task.name,task.priority));//可读性
        }

    }
    static class Task {
        private int priority;
        private String name;
        public Task(int priority,String name){
            this.priority=priority;
            this.name=name;
        }
        @Override
        public String toString(){
            return name+"(优先级"+priority+")";
        }
    }
}
