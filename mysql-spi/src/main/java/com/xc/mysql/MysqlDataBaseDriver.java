package com.xc.mysql;

import com.xc.DataBaseDriver;

/**
 * @ Author     ：xccaia
 * @ Date       ：2020-04-11
 * @ Description：
 */
public class MysqlDataBaseDriver implements DataBaseDriver {

    @Override
    public void connect(String host) {
        System.out.println("Build connect with mysql");
    }
}
