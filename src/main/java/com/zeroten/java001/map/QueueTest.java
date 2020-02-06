package com.zeroten.java001.map;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    /**
     * Queue
     *    队列：指的是在队尾插入元素，在队头删除元素。。。如排队买票
     *    两端队列：指的是可同时在队头和队尾进行插入和删除操作
     * 队列的特点：只能在队尾和队头进行插入和删除操作，，不能对队列中间的元素进行操作
     *    先进先出：FIFO
     *    先进后出：
     * 队列的两个接口：Queue（单端队列）、Deque（双端队列）
     * 队列的实现类：
     *     1.LinkedList     具有队列、两端队列的功能，内部使用链表来实现
     *     2.ArrayDeque    具有队列、两端队列的功能，内部使用循环数组来实现；；如果LinkedList需要转换使用ArraysDeque，单词直接换就好
     *     3.PriorityQueue  优先级队列，它内部实现结构可以快速把所有元素中的最小元素单独放出来
     *          最典型的应用场景;任务调度
     * 两个应用场景：任务调度、LRU（最近最少使用）
     * 两个工具：Arrays、Collections
     */
    public static void main (String[] args){
        //队列
        TestQueueOp();

        //两端队列
        TestDequeOp();

    }
    private static void TestQueueOp(){
        /**
         * 队列
         * Queue接口的方法
         *    增删查改
         */
        //创建
        Queue<String> queue=new LinkedList<>();
        //Queue<String> queue=new ArrayDeque<>();
        /**
         * 添加：add( E)、offer( E)在队列未满的情况下添加元素到队列尾部
         * 区别：add( E)  当队列满了之后调用add（E）会抛异常IllegalStateException
         *       offer( E)  当队列满了之后调用offer（E）会放回false
         */
        queue.add("前前任");
        queue.add("前任");
        queue.offer("现任");
        queue.offer("还会有下任？");

        /**
         * 删：
         * remove（）\poll（）:如果队列不为空，删除，返回被删除的元素
         * 区别：如果队列为空，remove（） 会抛异常NoSuchElementException，如果使用remove来获取队尾元素前，需要判断队列是否为空。
         *                                size( )==0或isEmpty（推荐使用）
         *                     poll （） 不会抛异常，返回null;使用poll来获取队尾元素后，需要判断结果是否为null
         */
//        do{
//            System.out.println(queue.remove());//按插入顺序删除，返回被删除的元素
//            System.out.println(queue);
//        }while(!queue.isEmpty());

        System.out.println(queue);
//        while(queue.poll()!=null){
//            System.out.println(queue);
//        }

        /**
         * 查：仅查看而不删除队头元素
         * element\peek：如果队列不为空，返回队头元素，不删除
         * 区别：队列为空时，element：抛异常NoSuchElementException
         *                   peek：返回null
         *      调用element方法前判断队列是否为空
         *      调用peek方法后判断返回结果是否为null
         */
        queue.clear();
        System.out.println(queue);
        //System.out.println(queue.element());//抛异常NoSuchElementException
        System.out.println(queue.peek());//返回null
        System.out.println(queue);

        /**
         * 改 ：一般没有改操作
         */

        /**
         * 遍历
         */
    }
    private static void TestDequeOp(){

        /**
         * 两端队列：实现接口Deque，增删查改
         *
         */
        //创建
        Deque<String> deque=new LinkedList<>();
        Deque<String> deque2=new LinkedList<>();

        /**
         * 增：
         * （Queue：add（E）、offer（E））
         * （Deque：addFirst（E）、addLast（E）、offerFirst（E）、offerLast（E）
         * 区别：队列未满时，在队头或队尾添加元素
         *       如果队列已满，调用addFirst（E）、addLast（E）会抛异常IllegalStateException
         *                     调用offerFirst（E）、offerLast（E）会放回false
         */
        deque.addLast("str3");
        deque.addFirst("str2");
        deque.addFirst("str1");
        deque.addLast("str4");
        System.out.println(deque);

        /**
         * 删：
         * （Queue：remove（E）、poll（E））
         * （Deque：removeFirst（）、removeLast（）、pollFirst（）、pollLast（）
         * 队列非空时，在队头或队尾删除元素，返回被删除的元素
         * 区别：如果队列为空，removeFirst（）、removeLast（） 会抛异常NoSuchElementException，
         *                          如果使用remove来获取队头队尾元素前，需要判断队列是否为空。size( )==0或isEmpty（推荐使用）
         *                     pollFirst（）、pollLast（） 不会抛异常，返回null;
         *                          使用poll来获取队头队尾元素后，需要判断结果是否为null
         */
//        deque.removeFirst();
//        deque.removeLast();
//        System.out.println(deque);
//        deque.pollLast();
//        deque.poll();
//        System.out.println(deque.pollLast());
//        deque.poll();//队列为空，poll不抛异常，返回null
//        //deque.remove();//队列为空，remove抛异常；；；两端队列一般不要用队列的方法
//        System.out.println(deque);

        /**
         * 查：
         * （Queue：element（E）、peek（E））
         * （Deque：getFirst（E）、getLast（E）、peekFirst（E）、peekLast（E）
         * 队列非空时，返回队头或队尾元素，不删除
         * 区别：队列为空时，getFirst（E）、getLast（E） 抛异常NoSuchElementException
         *                   peekFirst（E）、peekLast（E）返回null
         *      调用getFirst（E）、getLast（E）方法前判断队列是否为空
         *      调用peekFirst（E）、peekLast（E）方法后判断返回结果是否为null
         */
        System.out.println(deque.getLast());
        System.out.println(deque.getFirst());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        System.out.println(deque2.peekLast());//null
        //System.out.println(deque2.getLast());//抛异常
    }
}
