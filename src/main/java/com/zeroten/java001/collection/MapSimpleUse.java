package com.zeroten.java001.collection;

import java.util.HashMap;
import java.util.Map;

public class MapSimpleUse {

    public static void main(String[] args){
        /**
         * map键值对，包括键、值
         * 可以快速通过键找到值
         * 实例：
         * 001-》{name:张三，age:20}
         * 002->{name:李四，age:30}
         * 003->{name:王五，age:15}
         * 特性：
         *   1.键不能重复
         *   2.put方法，如果键值对已存在，则会使用新值替换
         *   3.键和值都能为null
         */
        Map<Integer,String > map=new HashMap<>();
        String str1=map.put(1,"张三，20");
        System.out.println(str1);//返回旧值为空
        String str2=map.put(1,"李四，30");//替换
        System.out.println(str2);//返回旧值张三
        map.put(2,"王五，15");

        String val1=map.get(1);
        System.out.println(val1);

        for (Map.Entry<Integer,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

        map.put(3,null);
        map.put(null,null);
        map.remove(2);
        System.out.println(map);
    }

}
