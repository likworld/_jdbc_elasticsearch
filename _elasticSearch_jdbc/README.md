# ElasticSearch-jdbc

## 第一步，找到es-jdbc的jar

1. 查看自己本地elasticsearch的版本

   在官网中找到符合自己版本的jdbc client.jar<font color='red'> 如果版本出错的话，会有明确的错误信息指出的</font>

   官网地址:https://www.elastic.co/cn/downloads/past-releases#jdbc-client

2. 下载jar包

![](https://likworld.gitee.io/openimage/jdbc/elasticsearch/es-jdbc.png)

<font color='red'>项目中添加依赖</font>

```xml
<dependency>
    <groupId>org.elasticesearch-plugin</groupId>
    <artifactId>x-pack-sql-jdbc</artifactId>
    <version>6.7.0</version>
</dependency>

<repositories>
  <repository>
    <id>elastic.co</id>
    <url>https://artifacts.elastic.co/maven</url>
  </repository>
</repositories>
```

但是maven仓库中是不存在这个jar的，还是需要自己手动下载

## 第二步，加载es驱动

esDriver引入：<font color='red'>org.elasticsearch.xpack.sql.jdbc.EsDriver</font>

url语法：

```xml
jdbc:es://[http|https]?[host[:port]]*/[prefix]*[?[option=value]&]*
```

这里就不赘述相关的连接配置了，如果有需要[传送门][https://github.com/jprante/elasticsearch-jdbc]

## 第三步，启动elasticsearch

找到es的目录，点击<font color='red'>elasticsearch.bat</font>启动，访问http://127.0.0.1:9200

![](https://likworld.gitee.io/openimage/jdbc/elasticsearch/es-start.png)

## 第四步，编写代码进行测试

```java
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
```

项目上传到GitHub中，如需要查看项目代码，[请点击][http://https://github.com/likworld/jdbc_database]