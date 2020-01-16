package com.zeroten.java001.collection;

import java.util.*;

public class SetSimpleUse {

    public static void main(String[] args){
        /**
         * Set,集，不能有重复元素，可以有null
         * 可能无序有序
         * HashSet,TreeSet
         * LinkedHashSet、EnumSet.....
         * 所有的集都实现了Set接口,而Set接口继承自Collection
         * 所以我们可以说所有的集都实现了Collection
         * Set和Collection接口的方法是完全一样的，仅是语义的区别
         */
        HashSet<String> Hs=new HashSet<>();
        System.out.println(Hs instanceof Set);
        System.out.println(Hs instanceof Collection);
        System.out.println(Hs instanceof List);
        //添加
        Hs.add("A");
        Hs.add("Z");
        Hs.add("V");
        Hs.add("D");
        Hs.add("K");
        Hs.add("F");
        Hs.add("L");
        Hs.add("J");
        //遍历，不能使用for循环，因为是无序的，用get（下标），每次值会不一样
        //迭代器遍历
        Iterator<String> iterator=Hs.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //List有序，指的是按插入顺序来保存元素
        //TreeSet有序，指的是元素按一定规则来排序，Comparator接口里面的规则
        TreeSet<String> Ts=new TreeSet<>();
        Ts.add("1");
        Ts.add("2");
        Ts.add("3");Ts.add("7");
        Ts.add("6");
        Ts.add("4");

        //遍历，也不能使用for循环，TreeSet，元素按一定规则来排序，可能跟输入的不一致
        Iterator<String> iterator1=Ts.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        //机能实现HashSet的高性能
        //又能按元素插入顺序来排序
        LinkedHashSet<String> LHs=new LinkedHashSet<>();
        LHs.add("8");
        LHs.add("7");
        LHs.add("5");
        LHs.add(null);
        LHs.add("5");//已经存在的则不加入
        LHs.add("4");LHs.add("0");
        LHs.add("2");
        System.out.println(LHs.add("3"));//添加成功，返回true
        System.out.println(LHs.add("2"));//已存在，添加失败，返回false
        Iterator<String> iterator2=LHs.iterator();
        System.out.println("LHs++++++++++++++++++++===============");
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

        //remove方法成功删除则返回true，失败则返回false
        Collection<String> removeSet=new HashSet<>();//删除多个元素时，可放在一个集合中，再一块删除
        removeSet.add("3");
        removeSet.add("2");
        LHs.removeAll(removeSet);

        System.out.println(LHs.remove(4));
        System.out.println(LHs.remove("100"));
        System.out.println(LHs);
        System.out.println("LHs====================================");

        List<String> list=new ArrayList<>();
        list.add(null);
        list.add("3");
        list.add("35");
        list.add("4");list.add("1");
        list.add("33");
        list.add("33");
        list.add("33");
        list.add("35");
        list.add("35");
        list.add("35");
        list.add(null);
        System.out.println(list);//有序，按插入顺序打印
        list.remove(null);//重复元素，删除第一次出现的那个
        list.remove(3);//每删除一次都重新计算下标，所以下标3的元素是1
        //list.remove(99);//越界，抛出IndexOutOfBoundsException异常
        list.remove("99");//不存在的值，返回false

        List<String> removeList=new ArrayList<>();
        removeList.add("33");
        removeList.add("35");
        list.removeAll(removeList);//删除所有在集合中的对应的元素
        System.out.println(list);




    }


}
