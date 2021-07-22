package com.xc;

import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ Author     ：xccaia
 * @ Date       ：2020-04-11
 * @ Description：
 */
public class DriverTest {


  public static void main(String[] args) {

    ConcurrentHashMap map = new ConcurrentHashMap();
    map.put(1, 1);
    System.out.println(map.get(1));
//        map.putVal(1, 2,false);
    map.putIfAbsent(1, 2);
    System.out.println(map.get(1));
    map.put(1, 2);
    System.out.println(map.get(1));

//        ServiceLoader<DataBaseDriver> serviceLoader = ServiceLoader
//                .load(DataBaseDriver.class);
//
//        for (DataBaseDriver dataBaseDriver : serviceLoader) {
//            dataBaseDriver.connect("lcoalhost");
//        }

  }


}
