package com.zeroten.java001.innerClass;

public class CalcMaxMin {

    public static Integer[] calc(Integer[] numbs){
        Integer min=null;
        Integer max=null;

        for(int numb:numbs){
            if(min==null||min>numb){
                min=numb;
            }
            if(max==null||max<numb){
                max=numb;
            }
        }
        return new Integer[]{min,max};
    }

    public static Pair calc2(Integer[] numbs){
        Integer min=null;
        Integer max=null;

        for(int numb:numbs){
            if(min==null||min>numb){
                min=numb;
            }
            if(max==null||max<numb){
                max=numb;
            }
        }
        return new Pair(min,max);
    }

    public static class Pair {

        private Integer min;
        private Integer max;

        public Pair(Integer min,Integer max){
            this.min=min;
            this.max=max;
        }

        public Integer getMin() {
            return min;
        }

        public Integer getMax() {
            return max;
        }
    }


}
