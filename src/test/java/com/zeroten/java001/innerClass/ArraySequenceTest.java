package com.zeroten.java001.innerClass;

import org.testng.annotations.Test;

public class ArraySequenceTest {

    @Test
    public void testPrint(){
        ArraySequence as=new ArraySequence(5);
        as.add(1);
        as.add(2);
        as.add(3);
        as.add(4);
        as.add(5);
        as.add(6);
        as.print();

       // ArraySequence.SelectorImpl impl=as.new SelectorImpl();
//        Selector impl=as.selector();
//        while(!impl.end()){
//            System.out.println(">"+impl.current());
//            impl.next();
//        }
//
//        System.out.println("倒叙遍历");
//        Selector imp2=as.selectorReverse();
//        while(!imp2.end()){
//            System.out.println(">"+imp2.current());
//            imp2.next();
//        }

        boolean reverse=false;
        Selector selector;
        if(reverse){
            System.out.println("倒叙遍历");
            selector=as.selectorReverse();
        }else{
            System.out.println("正序遍历");
            selector=as.selector();
        }
        while(!selector.end()){
            System.out.println(">"+selector.current());
            selector.next();
        }
    }
}
