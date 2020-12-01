package com.xc;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;

public class JavaTest {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
//        System.out.println(CollectionUtils.isEmpty(list));
//        list.add(1);
//        System.out.println(CollectionUtils.isEmpty(list));
       /* for (Object o : list) {
            System.out.println("11111111111111");
        }
        list = null;
        for (Object o : list) {
            System.out.println("2222");
        }
        System.out.println(CollectionUtils.isEmpty(list));*/

        BigDecimal bigDecimal = new BigDecimal(9);
        System.out.println(bigDecimal);
        System.out.println(isIntegerValue(bigDecimal));
        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_DOWN));
        System.out.println(isIntegerValue(bigDecimal));
        System.out.println(bigDecimal.intValue());
        bigDecimal = new BigDecimal(9.01);
        System.out.println(bigDecimal);
        System.out.println(isIntegerValue(bigDecimal));
        System.out.println(bigDecimal.setScale(0,BigDecimal.ROUND_HALF_DOWN));
        System.out.println(bigDecimal.intValue());

        System.out.println(String.valueOf(null));

    }

    private static boolean isIntegerValue(BigDecimal decimalVal) {
        return decimalVal.scale() <= 0 || decimalVal.stripTrailingZeros().scale() <= 0;
    }
}



