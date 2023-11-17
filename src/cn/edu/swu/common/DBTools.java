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
            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/bookstore");
            dataSource.setUsername("root");
            dataSource.setPassword("20030504");

            dataSource.setMinIdle(5);
            dataSource.setMaxIdle(10);
            dataSource.setMaxTotal(25);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private DBTools() {

    }

    public static DBTools getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        return dataSource.getConnection();
    }

    public boolean addBook(Book book) throws SQLException, ClassNotFoundException {
        String insertTemplate = "insert into book(name, author, price, content) values('%s', '%s', '%s', '%s')";
        String sql = String.format(insertTemplate, book.getName(), book.getAuthor(), book.getPrice(), book.getContent());
        return this.execute(sql);
    }

    public boolean deleteBook(Integer id) throws SQLException, ClassNotFoundException {
        String deleteTemplate = "delete from book where id = %d";
        String sql = String.format(deleteTemplate, id);
        return this.execute(sql);
    }

    public boolean updateBook(Book book, Integer id) throws SQLException, ClassNotFoundException {
        String updateTemplate = "update book set name = '%s', author = '%s', price = '%s', content = '%s' where id = %d";
        String sql = String.format(updateTemplate, book.getName(), book.getAuthor(), book.getPrice(), book.getContent(), id);
        return this.execute(sql);
    }

    //”增删改“可以用的
    private boolean execute(String sql) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                return statement.execute(sql);
            }
        }
    }

    public static List<Book> getAllBook() {
        List<Book> result = new ArrayList<>();
        String sql = "select id, name, author, price, content from book";
        try (Connection connection = DBTools.getInstance().getConnection()) {
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

        return result;
    }

}
