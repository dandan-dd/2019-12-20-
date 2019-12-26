package com.zeroten.java001.innerClass;

public class Outer {

    interface Inter {
        void show();
    }

    public static Inter create(){
        return new Inter(){
            public void show(){
                System.out.println("helloworld");
            }
        };
    }

    public static void main(String[] args) {
        Outer.create().show();
    }

}
