package com.lklogs.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ESJdbcFirst {
    public static void main(String[] args) {
        try {
            Class.forName("org.elasticsearch.xpack.sql.jdbc.EsDriver");
            FileInputStream fileInputStream = new FileInputStream("F:/workspace/_ElasticSearch_jdbc/src/main/resources/es.properties");
            Properties pps = new Properties();
            pps.load(fileInputStream);
            Connection connection = DriverManager.getConnection(
                    pps.getProperty("url"),
                    pps.getProperty("username"),
                    pps.getProperty("password"));
            System.out.println(connection);
        } catch (ClassNotFoundException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
