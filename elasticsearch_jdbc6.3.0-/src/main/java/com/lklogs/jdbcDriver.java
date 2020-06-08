package com.lklogs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class jdbcDriver {
    public static void main(String[] args) {
        try {
            Class.forName("org.elasticsearch.xpack.sql.jdbc.jdbc.JdbcDriver");
            FileInputStream fileInputStream = new FileInputStream("V:/github/jdbc_database/_elasticSearch_jdbc/src/main/resources/es.properties");
            Properties pps = new Properties();
            pps.load(fileInputStream);
            Connection connection = DriverManager.getConnection(
                    pps.getProperty("url"),
                    pps.getProperty("username"),
                    pps.getProperty("password"));
            System.out.println(connection);
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet schemas = metaData.getSchemas();
            ResultSetMetaData data = schemas.getMetaData();
            for (int i = 1; i <= data.getColumnCount(); i++) {
                System.out.println(data.getColumnName(i) + " " + data.getColumnTypeName(i));
            }
        } catch (ClassNotFoundException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
