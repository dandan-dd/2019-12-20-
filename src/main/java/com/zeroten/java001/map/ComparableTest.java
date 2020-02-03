package com.zeroten.java001.map;

import java.util.*;

public class ComparableTest {
    public static void main(String[] args){
        //创建
        //对于TreeMap,Key值对象必须实现Comparable接口
        TreeMap<XuHao,String > map=new TreeMap();//有序，以key值排序，通过实现排序接口Comparator

        //添加
        map.put(new XuHao(1),"hwd");
        map.put(new XuHao(4),"cxc");
        map.put(new XuHao(3),"xth");
        map.put(new XuHao(2),"zjj");

        //删除
        map.remove(new XuHao(3));//返回被删除的值
        //修改
        map.put(new XuHao(4),"hYd");//返回被替换的值
        System.out.println(map);
        //
//        //Map严格来说不是一个集合，但是它有三个视图，我们可以把它当作集合来使用
//        //1.键视图,Set
//        System.out.println( map.keySet());
//
//        //2.值视图,Collection
//        System.out.println(map.values());
//
//        //3.键值对视图,Entry
//        Set<Map.Entry<XuHao,String>> kv=map.entrySet();
//        System.out.println(kv);
//
//        //遍历
//        for (Map.Entry<XuHao,String> entry:map.entrySet()){
//            System.out.println(entry.getKey()+"="+entry.getValue());
//        }
        //Comparator和Comparable两个接口的区别
        //Comparator比较的是两个传入对象的大小
        //Comparable比较的是自身与传入对象的大小
        //Comparable int compareTo(T o1，T o2)


//        TreeMap<XuHao2,String > map2=new TreeMap(XueHaoOrderFactory.getComparator(false));
//        map2.put(new XuHao(1),"11");//指定了排序器，那么Key值对象就可以不实现排序接口Comparator
//        map2.put(new XuHao2(4),"44");
//        map2.put(new XuHao2(3),"33");
//        System.out.println(map2);

        HashMap<XuHao,String> hashMap=new HashMap<>();
        hashMap.put(new XuHao(1),"老大");
        XuHao xH1=new XuHao(6);
        System.out.println("xH1的哈希值="+xH1.hashCode());
        hashMap.put(xH1,"old six");
        hashMap.put(new XuHao(3),"老幺");
        System.out.println("前："+hashMap);
        XuHao xH2=new XuHao(6);
        System.out.println("xH2的哈希值="+xH2.hashCode());
        hashMap.remove(xH2);
        /**
         * put/get/remove  Key
         * 1.计算key的hash值，即调用hashCode方法；而自定义对象默认的Object.hashCode是返回他的地址
         * 2.hash%桶数=桶索引
         * 3.比较key值是否相等，equals
         */
        System.out.println("后："+hashMap);


        /**
         * LinkedHashMap具有HashMap的所有功能，却能保持插入顺序
         * head 指向插入的第一个元素
         * tail指向插入的最后一个元素
         * before指向前一个元素的引用
         * after指向后一个元素的引用
         */
        LinkedHashMap<XuHao,String> linkedHashMap=new LinkedHashMap<>();
        linkedHashMap.put(new XuHao(2),"old two");
        linkedHashMap.put(new XuHao(1),"old big");
        linkedHashMap.put(new XuHao(5),"old five");
        linkedHashMap.put(new XuHao(4),"old four");
        for (Map.Entry<XuHao,String> entry:linkedHashMap.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

        /**
         * WeakHashMap
         * 当里面的某个元素不再被使用时，可以被垃圾回收器回收
         */
        /**
         * EnumMap
         * Key值必须是枚举类型
         */
        /**
         * IdentityHashMap
         * Key值的哈希值计算方法：别人的通常是：Key值对象.hashCode(),
         * 而IdentityHashMap中Key值的哈希值计算方法：System.identityHashCode(Key);
         */
        XuHao2 xuHao2=new XuHao2(1);
        System.out.println(xuHao2);
        System.out.println(xuHao2.hashCode());//地址的十进制数
        System.out.println(System.identityHashCode(xuHao2));//地址的十进制数
        System.out.println(Integer.toHexString(xuHao2.hashCode()));
    }

    static class XueHaoOrderFactory{
        public static Comparator getComparator(boolean isAsc){
            return new Comparator(){
                @Override
                public int compare(Object o1, Object o2) {
                    if (o1 instanceof XuHao2 && o2 instanceof XuHao2){
                        XuHao2 xuHao1=(XuHao2) o1;
                        XuHao2 xuHao2=(XuHao2) o2;
                        if(xuHao1.index<xuHao2.index){
                            return isAsc?-1:1;//决定升序or降序

                        }else if(xuHao1.index>xuHao2.index){
                            return isAsc?1:-1;
                        }else{
                            return 0;
                        }
                    }
                    return -1;
                }
            };
        }
    }

    static class XuHao2{
        protected Integer index;//学号

        public XuHao2(Integer index) {
            this.index = index;
        }

//        @Override
//        public String toString() {//不重写的话会返回类名=值
//            return "学号：" + index;
//        }
    }
    static class XuHao extends XuHao2 implements Comparable{
        public XuHao(Integer index) {
            super(index);
        }

//        @Override
//        public int hashCode(){
//            int hash= index.hashCode();
//            System.out.println("计算hash值"+index+","+hash);
//            return hash;
//        }
        @Override
        public boolean equals(Object obj){
            System.out.println("调用了equals方法");
            return true;
        }
        @Override
        public int compareTo(Object object){
            if (object instanceof XuHao){
                XuHao xuHao=(XuHao) object;
                if(this.index<xuHao.index){
                    return -1;//决定升序or降序

                }
                if(this.index>xuHao.index){
                    return 1;
                }
                if(this.index==xuHao.index){
                    System.out.println("相等了："+xuHao.index);
                    return 0;
                }
            }
            return -1;
        }
    }
}
