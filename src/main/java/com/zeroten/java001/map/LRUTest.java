package com.zeroten.java001.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUTest {
    public static void main(String[] args){
        /**
         * LRU:Least Recently Used,,最近最少使用
         * 缓存：缓存热点数据，即经常使用的数据。是一种淘汰算法
         * 当缓存已满时，再向缓存内添加元素，删除掉（淘汰）缓存中已存在且最近最少使用的那个
         *
         * LinkedHashMap  支持LRU算法，具有HashMap的所有功能+可保持插入顺序（遍历）
         * LinkedHashMap 相当于：HashMap  +  双向链表
         * 双向链表：head/tail，after/before
         * LinkedHashMap 是有序的  boolean accessOrder（按什么顺序）
         *    1.插入顺序（accessOrder=false)（默认）：每次插入元素，将元素放到双向链表的末尾
         *    2.访问顺序（accessOrder=true）：每次插入元素/获取元素，将插入的元素或者访问的元素放到双向链表的末尾
         *
         */

        LRU<String,String> lru=new LRU();//调用无参构造方法
       // LRU<String,String> lru=new LRU(5);//调用有参构造方法
        lru.put("001","old one");
        lru.put("002","old two");
        lru.put("003","old three");
        lru.put("004","old four");
        lru.put("005","old five");
        lru.put("006","old six");
        System.out.println(lru);

        System.out.println(lru.get("003"));
        System.out.println(lru);

        System.out.println(lru.get("001"));
        System.out.println(lru);

        lru.put("009","old seven");
        System.out.println(lru);

        lru.put("003","old eight");
        System.out.println(lru);

    }

    static class LRU<K,V> extends LinkedHashMap<K,V> implements Map<K,V> {
        private int maxCount=6;
        public LRU(){
            super(10,0.75f,true);
        }
        public LRU(int maxCount){
            super(10,0.75f,true);
            this.maxCount=maxCount;
        }

        //参数eldest 最近最少使用的元素
        //当调用put时并且key值不存在，调用
        @Override
        protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
            boolean remove= size()>maxCount;
            if(remove){
                System.out.println("淘汰最近最少使用元素："+eldest);
            }
            return remove;
        }
    }
}
