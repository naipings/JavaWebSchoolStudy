package cn.edu.swu.common;

import cn.edu.swu.model.Book;
import org.apache.commons.dbcp2.BasicDataSource;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBTools {

    private static BasicDataSource dataSource = null;
    private static DBTools instance = new DBTools();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/bookstore");
        dataSource.setUsername("root");
        dataSource.setPassword("20030504");

        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxTotal(25);
    }

    private DBTools() {

    }

    public static DBTools instance() {
        return instance;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        return dataSource.getConnection();
    }

    public void addBook(Book book) {
        try (Connection connection = getConnection()) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Book> getAllBook() {
        List<Book> result = new ArrayList<>();
        String sql = "select id, name, author, price, content from book";
        try (Connection connection = DBTools.instance().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String author = resultSet.getString("author");
                        BigDecimal price = resultSet.getBigDecimal(4);
                        String content = resultSet.getString(5);

                        System.out.println(String.format("%s, %s, %s, %s, %s",id,name,author,price,content));

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

}
