package com.zeroten.java001.innerClass;

public class OuterClass {

    private Integer index;
    private String name;

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void println(){
        System.out.println("外部类调用的name："+name);
        System.out.println("外部类调用的index:"+index);
    }
    //定义在其它类中的类为内部类
    public class InnerClass{
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public void println(){
            System.out.println("内部类调用自己的name："+name);
            System.out.println("内部类调用自己的index:"+index);//自己没有的时候就会去调用外围类的
            System.out.println("内部类调用外部类的name："+OuterClass.this.name);
            System.out.println("内部类调用外部类的index:"+OuterClass.this.index);
        }
    }

    public static void main (String[] args){
        OuterClass O=new OuterClass();
        O.setName("廖小猪");
        O.setIndex(6);
        O.println();

        OuterClass.InnerClass I=O.new InnerClass();
        I.setName("廖肥猪");
        I.println();
    }



}
