package cn.edu.swu.common;

import cn.edu.swu.model.Book;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBTools {

    public static Connection conn = null;

    public DBTools(String account, String password, String database) { //三个参数分别是：数据库账号，数据库密码，数据库名字
        //连接驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功");
        } catch (Exception e) {
            System.out.println("加载驱动失败");
        }

        //连接数据库
        try {
            String url = "jdbc:mysql://localhost:3306/"+database+"?characterEncoding=utf-8&useSSL=false";
            conn = DriverManager.getConnection(url, account, password);
            System.out.println("连接数据库成功");
        }catch (SQLException e1) {
            System.out.println("——————————————————————————");
            System.out.println("连接数据库失败");
            e1.printStackTrace(); //打印报错信息
            System.out.println("——————————————————————————");
        }
    }

    public static List<Book> getAllBook() {
        List<Book> result = new ArrayList<>();
        String sql = "select id, name, author, price, content from book";
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String author = resultSet.getString("author");
                        BigDecimal price = resultSet.getBigDecimal(4);
                        String content = resultSet.getString(5);

                        Book book = new Book(id, name, author, price, content);
                        result.add(book);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ;
        return result;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/bookstore";
        String dbUser = "root";
        String dbPassword = "20030504";
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

}
