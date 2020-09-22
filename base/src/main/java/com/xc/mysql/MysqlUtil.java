package com.xc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlUtil {


//    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mysql";
//    private static final String USER = "root";
//    private static final String PSWD = "123456";

    private static final String DB_URL = "jdbc:mysql://192.168.207.110:19103/biz_data";
    private static final String USER = "test_cable";
    private static final String PSWD = "Dgzb_cable@2019";


    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(DB_URL, USER, PSWD);
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) throws SQLException {
        MysqlUtil c = new MysqlUtil();
        Connection connection = c.getConnection();

        String strSql="select * from cds_raw_material_param_model where  info_name in('金属杆')";
        ResultSet rs = connection.prepareStatement(strSql).executeQuery();


    }
    
    
    
    
    
}
