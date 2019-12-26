package innerClass;

/**
 * 匿名内部类
 */
public class OuterClass4 {

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
//            new OuterClass3Interface(){
//
//            }.print();

            //实现接口

            //局部内部类写法
//            class OuterClassAbstractIpml extends OuterClass4Abstract {
//                @Override
//                void print(){
//
//                }
//            }
//            new OuterClassAbstractIpml().print();

            //匿名内部类写法
//            new OuterClass4Abstract(){
//                @Override
//                void print(){
//                    System.out.println("匿名内部类通过抽象方法调用自己的name："+name);
//                    System.out.println("匿名内部类通过抽象方法调用自己的index:"+index);//自己作用域没有的时候就会一层一层地向外收索
//                    System.out.println("匿名内部类通过抽象方法调用最外部类的name："+OuterClass4.this.name);
//                    System.out.println("匿名内部类通过抽象方法调用最外部类的index:"+OuterClass4.this.index);
//                    System.out.println("匿名内部类通过抽象方法调用直接外部类的name："+InnerClass.this.name);
//                    System.out.println("匿名内部类通过抽象方法调用直接外部类的index:"+InnerClass.this.index);
//               }
//            }.print();

            //普通类
            //局部内部类
//            class OuterClass4ClassIpml extends OuterClass4Class{
//                @Override
//                void print(){
//
//                }
//            }

            //匿名内部类
            new OuterClass4Class(){
                @Override
                 public void print(){
                      System.out.println("匿名内部类通过普通方法调用自己的name："+name);
                      System.out.println("匿名内部类通过普通方法调用自己的index:"+index);//自己作用域没有的时候就会一层一层地向外收索
                      System.out.println("匿名内部类通过普通方法调用最外部类的name："+OuterClass4.this.name);
                      System.out.println("匿名内部类通过普通方法调用最外部类的index:"+OuterClass4.this.index);
                      System.out.println("匿名内部类通过普通方法调用直接外部类的name："+InnerClass.this.name);
                      System.out.println("匿名内部类通过普通方法调用直接外部类的index:"+InnerClass.this.index);
                 }
            }.print();
        }
    }

    public static void main (String[] args){
        OuterClass4 O=new OuterClass4();
        O.setName("廖小猪");
        O.setIndex(6);
        O.println();

        OuterClass4.InnerClass I=O.new InnerClass(2,"廖肥猪");
        I.println();
    }
}
