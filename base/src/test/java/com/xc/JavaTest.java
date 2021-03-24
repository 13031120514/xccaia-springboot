package com.xc;

import com.fasterxml.jackson.databind.JsonNode;
import com.xc.cfg.JacksonUtils;
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

       /* BigDecimal bigDecimal = new BigDecimal(9);
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

        System.out.println(String.valueOf(null));*/

        String message="{\"_id\":\"5fcdfe21df7daa2f09b29b4e\",\"createdTime\":1594720379000,\"updatedTime\":1594720379000,\"productionOrderNo\":\"MFG2005300062\",\"categoryCode\":\"10001\",\"procedureCode\":\"SCGJ\",\"DEMO\":12.88,\"JYPJHD\":\"12.12\",\"JYPXD\":\"13.13\",\"JYWD\":\"13.13\",\"NPPJHD\":\"12.12\",\"NPZXHD\":\"12.12\",\"JYZXHD\":\"12.12\",\"purchaseOrderNo\":\"0100591328\",\"supplierCode\":\"1000001713\",\"supplierName\":\"浙江晨光电缆股份有限公司\",\"materialCode\":\"500107579\",\"materialDesc\":\"test\",\"timestamp\":1594720376445,\"DSZJ\":\"13.13\",\"sadfkjhlksadf\":1,\"quality\":1,\"taskEvaluNum\":\"aaaaa77777777111\",\"tableName\":\"supplier_evaluation_data_10001_SCGJ\"}";
        JsonNode jsonNode = JacksonUtils.readTree(message);
        System.out.println(jsonNode.get("tableName"));




    }

    private static boolean isIntegerValue(BigDecimal decimalVal) {
        return decimalVal.scale() <= 0 || decimalVal.stripTrailingZeros().scale() <= 0;
    }
}



