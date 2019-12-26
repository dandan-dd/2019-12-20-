package com.zeroten.java001.innerClass;

/**
 * 匿名内部类
 */
public class OuterClass3 {

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
        private Integer index;
        public InnerClass(Integer index,String name) {
            this.index=index;
            this.name = name;
        }

        public void println(){

//            class OuterClass3InterfaceImpl implements OuterClass3Interface{
//                @Override
//                public void print(){
//
//                }
//            }
//            new OuterClass3InterfaceImpl().print();

            //通过实现接口
            new OuterClass3Interface(){
                @Override
                public void print(){
                    System.out.println("匿名内部类通过实现接口输入自己的name："+name);
                    System.out.println("匿名内部类通过实现接口输入自己的index:"+index);//自己作用域没有的时候就会一层一层地向外收索
                    System.out.println("匿名内部类通过实现接口输入最外部类的name："+OuterClass3.this.name);
                    System.out.println("匿名内部类通过实现接口输入最外部类的index:"+OuterClass3.this.index);
                    System.out.println("匿名内部类通过实现接口输入直接外部类的name："+InnerClass.this.name);
                    System.out.println("匿名内部类通过实现接口输入直接外部类的index:"+InnerClass.this.index);
                }
            }.print();
        }
    }

    public static void main (String[] args){
        OuterClass3 O=new OuterClass3();
        O.setName("廖小猪");
        O.setIndex(6);
        O.println();

        OuterClass3.InnerClass I=O.new InnerClass(2,"廖肥猪");
        I.println();
    }
}