package innerClass;

/**
 * 局部内部类
 */
public class OuterClass2 {

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
            String name="局部内部类";
            class PrintClass{
                void print(){
                    System.out.println("内部类调用自己的name："+name);
                    System.out.println("内部类调用自己的index:"+index);//自己作用域没有的时候就会一层一层地向外收索
                    System.out.println("内部类调用最外部类的name："+OuterClass2.this.name);
                    System.out.println("内部类调用最外部类的index:"+OuterClass2.this.index);
                    System.out.println("内部类调用直接外部类的name："+InnerClass.this.name);
                    System.out.println("内部类调用直接外部类的index:"+InnerClass.this.index);
                }
            }
            new PrintClass().print();
        }
    }

    public static void main (String[] args){
        OuterClass2 O=new OuterClass2();
        O.setName("廖小猪");
        O.setIndex(6);
        O.println();

        OuterClass2.InnerClass I=O.new InnerClass(2,"廖肥猪");
        I.println();
    }
}