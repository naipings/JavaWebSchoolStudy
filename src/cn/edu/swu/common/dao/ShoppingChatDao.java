package cn.edu.swu.common.dao;

import cn.edu.swu.book.model.Book;
import cn.edu.swu.repository.ResultSetVisitor;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingChatDao extends BaseRepo{
    private static ShoppingChatDao instance = new ShoppingChatDao();

    private ShoppingChatDao() {

    }

    public static ShoppingChatDao getInstance() {
        return instance;
    }

    public boolean addChatData(Book book) throws SQLException, ClassNotFoundException {
        String sql;
        if (book.getImageUrl() != null) {
            String insertTemplate = "insert into shoppingchat(name, author, price, content, imageurl, num) values('%s', '%s', '%s', '%s', '%s', %d)";
            sql = String.format(insertTemplate, book.getName(), book.getAuthor(), book.getPrice(), book.getContent(), book.getImageUrl(), book.getNum());
        } else {
            String insertTemplate = "insert into shoppingchat(name, author, price, content, num) values('%s', '%s', '%s', '%s', %d)";
            sql = String.format(insertTemplate, book.getName(), book.getAuthor(), book.getPrice(), book.getContent(), book.getNum());
        }
//        System.out.println("this.execute(sql):"+this.execute(sql));
        return this.execute(sql);
    }

    public Book getChatDataNum(Book book) throws SQLException, ClassNotFoundException {
        String template = "select * from shoppingchat where (name='%s' and author='%s') or id = %d";
        String sql = String.format(template, book.getName(), book.getAuthor(), book.getId());

        List<Book> books = this.queryBook(sql);

        return books.size() > 0 ? books.get(0) : null;
    }

    public boolean updateChatData(Book book) throws SQLException, ClassNotFoundException {
        String sql = null;
        if (book.getImageUrl() != null) {
            String template = "update shoppingchat set " +
                    "name='%s', author='%s', price=%s, content='%s', imageurl='%s', num=%d where (name='%s' and author='%s') or id = %d";
            sql = String.format(template,
                    book.getName(), book.getAuthor(), book.getPrice(), book.getContent(), book.getImageUrl(), book.getNum(),
                    book.getName(), book.getAuthor(),
                    book.getId());
        } else {
            String template = "update shoppingchat set " +
                    "name='%s', author='%s', price=%s, content='%s', num=%d where (name='%s' and author='%s') or id = %d";
            sql = String.format(template,
                    book.getName(), book.getAuthor(), book.getPrice(), book.getContent(), book.getNum(),
                    book.getName(), book.getAuthor(),
                    book.getId());
        }
//        System.out.println("this.execute(sql):"+this.execute(sql));
        return this.execute(sql);
    }

    public int SearchChatData(Book book) throws SQLException, ClassNotFoundException {
        String template = "select * from shoppingchat where (name='%s' and author='%s') or id = %d";
        String sql = String.format(template, book.getName(), book.getAuthor(), book.getId());

        List<Book> books = this.queryBook(sql);

        return books.size();
    }

    public List<Book> queryBook(String sql) throws SQLException, ClassNotFoundException {
        final List<Book> books = new ArrayList<>();
        this.query(sql, new ResultSetVisitor() {

            public void visit(ResultSet resultSet) {
                Book book = new Book();
                try {
                    book.setId(resultSet.getInt("id"));
                    book.setName(resultSet.getString("name"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setPrice(BigDecimal.valueOf(resultSet.getDouble("price")));
                    book.setContent(resultSet.getString("content"));
                    book.setImageUrl(resultSet.getString("imageurl"));
                    book.setNum(resultSet.getInt("num"));
                    books.add(book);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return books;
    }

    public boolean deleteChatData(Integer id) throws SQLException, ClassNotFoundException {
        String deleteTemplate = "delete from shoppingchat where id = %d";
        String sql = String.format(deleteTemplate, id);
        return this.execute(sql);
    }

    public static List<Book> getChatBooks() {
        List<Book> result = new ArrayList<>();
        String sql = "select id, name, author, price, num, content, imageurl from shoppingchat";
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String author = resultSet.getString("author");
                        BigDecimal price = resultSet.getBigDecimal(4);
                        String content = resultSet.getString("content");
                        int num = resultSet.getInt("num");
                        String image = resultSet.getString("imageurl");

                        System.out.println(String.format("%d, %s, %s, %f, %d, %s, %s",id,name,author,price,num,content,image));

                        Book book = new Book(id, name, author, price, num, content, image);
                        result.add(book);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


}
