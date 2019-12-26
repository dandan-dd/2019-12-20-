package com.zeroten.java001.innerClass;

import org.testng.annotations.Test;

import java.util.Arrays;

public class CalcMaxMinTest {

    @Test
    public void testCalc(){
        Integer[] params={1,2,3,4,1,23,46,234,34,34,1,4};
        Integer[] result=CalcMaxMin.calc(params);
        System.out.println(Arrays.toString(result));
        System.out.println("最小值"+result[0]);
        System.out.println("最大值"+result[1]);

        CalcMaxMin.Pair pair=CalcMaxMin.calc2(params);
        System.out.println("最小值"+pair.getMin());
        System.out.println("最大值"+pair.getMax());


    }
}
