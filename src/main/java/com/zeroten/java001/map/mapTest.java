package com.zeroten.java001.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class mapTest {

    /**
     * 内容---Map
     * 散列表相关知识
     * HashMap
     *     内部实现
     *     常用方法
     * TreeMap
     */
    /**
     * 散列表HashTable：也称哈希表
     * 根据数组可以使用下标的方式来快速随机访问来实现的
     * 比如：
     *   存放一组数据：aaa、cde、bfk.............
     *   如何快速定位和查找？
     *   String[] str
     *   哈希函数：将关键字转化成一个正整数，
     *   int hashFn(Object object)
     *   aaa-->256
     *   cde-->258
     *   bfk-->259
     *   aak-->256
     *
     * str[256]="aaa"
     * str[258]="cde"
     * str[259]="bfk"
     *
     * 哈希函数的最理想状态：
     *   1.哈希结果应该是一个正整数
     *   2.如果str1==str2,hashfn(str1)==hashfn(str2)
     *   3.如果str1!=str2,hashfn(str1)！=hashfn(str2)  此情况总存在特例
     *     所以第三种情况基本不可能，不会存在这么一个函数。如MD5、SHA、CRC等算法都可能产生重复的值
     *
     * 哈希冲突：不同的键值，通过哈希函数返回了相同的结果
     * 解决冲突：链表方式
     *     数组里面不直接存值，存一个自定义对象。
     *     Node{
     *         Node next;
     *         Node prev;
     *         Node item;
     *     }
     *     aaa-->256
     *     aak-->256
     *
     *     r如要查找aaa，计算出对应哈希值256，查找256对应的第一个节点的值为aak！=aaa，值为aak的节点指向下一层值为aaa的节点，符合
     *     str[256]={prev:指向aak,item:aaa,next:null};
     *     str[256]={prev:null,item:aak,next:指向aaa};
     *
     *     相当于数组里面的每一个位置都是一个桶，桶里面有很多层，一层指向一层，双向链表
     *     每一层包含四个值：prev，key,data,next
     *
     * HashMap
     *    1.构建
     *   2.添加
     *   3.遍历
     *   4.删除
     */

    public static void main(String[] args){

        //构建
        Map<String, Student> hashMap=new HashMap<>();

        //添加
        //new mapTest().new Student("张三",88);
        hashMap.put("001",new Student("张三",88));
        hashMap.put("002",new Student("李四",18));
        hashMap.put("003",new Student("王五",28));//put函数返回的是上一次put的值

        //遍历
        //键 -- 值
        //Map严格意义上来说，不是一个集合，但它可以返三个视图，可以把这三个视图当成集合类来操作

        //1.键视图,Set
        Set<String> keys=hashMap.keySet();
        System.out.println(keys);

        //2.值视图,Collection
        Collection<Student> values=hashMap.values();
        System.out.println(values);

        //3.键值对视图,Entry
        Set<Map.Entry<String,Student>> kv=hashMap.entrySet();
        System.out.println(kv);

        for (Map.Entry<String,Student> entry:kv){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        for (String key:keys){
            System.out.print(key+"=");
            System.out.println(hashMap.get(key));
        }

        //删除
        hashMap.remove("002");
        System.out.println(hashMap);
        //list.remove(int index);//list是有序的
        //list.remove(Object object);//list是有序的
        //set\map无序的时候，不能使用下标的方式

        //特殊元素  null，键不能重复，所以最终只添加了最后一个，相当于更新
        hashMap.put(null,new Student("无名1",88));
        hashMap.put(null,null);
        hashMap.put(null,new Student("无名2",88));
        System.out.println(hashMap);

        Map<String,Student> hashMap2=new HashMap<>(hashMap);//复制
        System.out.println(hashMap2);

        Map<String,Student> hashMap3=new HashMap<>(10);//初始化容量大小

        //构建：1.无参构造  2.使用已存在的Map作为初始化值  3.指定容量
        //put(key,values)，插入或修改
        //    key值不存在，则插入对应新值，并返回null
        //    key值已存在，将key对应的值修改为新值，并返回旧值
        //get(key),通过键获取值
        System.out.println(hashMap.get("001"));
        //  1.key存在，则返回key对应的值
        //  2.key不存在，则返回null
        //是否存在
        //   1.key是否存在     containsKey
        hashMap.put("007",null);
        if(!hashMap.containsKey("007")){
            System.out.println("007不存在");
        }else{
            System.out.println("007存在");
        }
        //   2.value是否存在    containsValue
        hashMap.put(null,new Student("无名1",88));
        if(!hashMap.containsValue(new Student("无名1",88))){
            System.out.println("new Student(\"无名1\",88)不存在");
        }else{
            System.out.println("new Student(\"无名1\",88)存在");
        }

        //遍历：可以获取集合的三种视图
        //  1.键集keySet()   2.值集values()   3.键值对集entrySet()

        //内部结构：散列表
        //put/get时，如果数组容量不足哈希值，则哈希桶的索引=hash%length
        //计算哈希值时，key.hashCode()
        //在桶内比较某个key值是否存在  使用的是 key.equals(inputKey)
        //"001":{name:"南六",age:20}
        //"001":{name:"南七",age:21}
        //hashCode()返回的值相等时，equals比较的结果应该返回true
        //equals比较的结果返回true时，hashCode()返回的值相等

        //可能出现这种情况：hashCode相等，equals返回false
        //hashCode（001）=1，1%3=1
        //hashCode（001）=1，1%3=1
        //循环链查找key
        //hash==hash&&key.equals（inputKey）==false,会造成相同的键值
        //{hash:1,key:001,value:{name:"n1",age:22}}
        //{hash:1,key:001,value:{name:"n2",age:23}}

        Map<Key,Student> hashMap4=new HashMap<>();
        hashMap4.put(new Key(1),new Student("zhangsan",25));
        hashMap4.put(new Key(1),new Student("zhangsan",25));
        System.out.println(hashMap4);
    }

    static class Key{
        private Integer i;
        public Key(Integer i){
            this.i=i;
        }
        @Override
        public int hashCode(){
            return i==null?0:i.hashCode();
        }
        @Override
        public boolean equals(Object object){
            if(object instanceof Key){
                Key key=(Key) object;
                return i!=null&i.equals(key.i);
            }
            return false;
        }
        @Override
        public String toString(){
            return i+"";
        }
    }

    static class Student{
        String name;
        Integer age;
        public Student(String name,Integer age){
            this.name=name;
            this.age=age;
        }
        @Override
        public boolean equals(Object object){
            if(this==object){
                return true;
            }
            if(object instanceof Student){
                Student stu=(Student) object;
                if(name!=null&&name.equals(stu.name)&&age!=null&&age.equals(stu.age)){
                    return true;
                }
            }
            return false;
        }
        @Override
        public String toString(){
            StringBuilder str=new StringBuilder();
            str.append(getClass().getSimpleName());
            str.append('{');
            str.append("name:");
            str.append(name);
            str.append(',');
            str.append("age:");
            str.append(age);
            str.append('}');
            return str.toString();
        }
    }

}
