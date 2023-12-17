package cn.edu.swu.common.dao;

import cn.edu.swu.book.model.Book;
import cn.edu.swu.repository.ResultSetVisitor;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookRepo extends BaseRepo {

    private static BookRepo instance = new BookRepo();

    private BookRepo() {

    }

    public static BookRepo getInstance() {
        return instance;
    }

    public boolean addBook(Book book) throws SQLException, ClassNotFoundException {
        String sql;
        if (book.getImageUrl() != null) {
            String insertTemplate = "insert into book(name, author, price, content, imageurl) values('%s', '%s', '%s', '%s', '%s')";
            sql = String.format(insertTemplate, book.getName(), book.getAuthor(), book.getPrice(), book.getContent(), book.getImageUrl());
        } else {
            String insertTemplate = "insert into book(name, author, price, content) values('%s', '%s', '%s', '%s')";
            sql = String.format(insertTemplate, book.getName(), book.getAuthor(), book.getPrice(), book.getContent());
        }
        return this.execute(sql);
    }

    public boolean deleteBook(Integer id) throws SQLException, ClassNotFoundException {
        String deleteTemplate = "delete from book where id = %d";
        String sql = String.format(deleteTemplate, id);
        return this.execute(sql);
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
                    books.add(book);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        return books;
    }

    public Book getBookById(Integer id) throws SQLException, ClassNotFoundException {
        String template = "select * from book where id = %d";
        String sql = String.format(template, id);

        List<Book> books = this.queryBook(sql);

        return books.size() > 0 ? books.get(0) : null;
    }


    public Book getBookByName(String name) throws SQLException, ClassNotFoundException {
        System.out.println("in getBookByName");
        System.out.println("name="+name);
        String template = "select * from book where name = '%s'";
        String sql = String.format(template, name);

        List<Book> books = this.queryBook(sql);

        return books.size() > 0 ? books.get(0) : null;
    }

    public List<Book> getBooksByName(String name) throws SQLException, ClassNotFoundException {
        System.out.println("in getBookByName");
        System.out.println("name="+name);
        String template = "select * from book where name = '%s'";
        String sql = String.format(template, name);

        List<Book> books = this.queryBook(sql);

        return books;
    }


    public Book getBookByAuthor(String author) throws SQLException, ClassNotFoundException {
        String template = "select * from book where author = '%s'";
        String sql = String.format(template, author);

        List<Book> books = this.queryBook(sql);

        return books.size() > 0 ? books.get(0) : null;
    }


    public boolean updateBook(Book book) throws SQLException, ClassNotFoundException {
        String sql = null;
        if (book.getImageUrl() != null) {
            String template = "update book set " +
                    "name='%s', author='%s', price=%s, content='%s', imageurl='%s' where id = %d";
            sql = String.format(template,
                    book.getName(), book.getAuthor(), book.getPrice(), book.getContent(), book.getImageUrl(),
                    book.getId());
        } else {
            String template = "update book set " +
                    "name='%s', author='%s', price=%s, content='%s' where id = %d";
            sql = String.format(template,
                    book.getName(), book.getAuthor(), book.getPrice(), book.getContent(), book.getId());
        }
      return this.execute(sql);
    }



    public int totalBooks() throws SQLException, ClassNotFoundException {
        String sql = "select count(*) from book";
        final int[] pages = {0};

        this.query(sql, new ResultSetVisitor() {
            public void visit(ResultSet resultSet) {
                try {
                    pages[0] =resultSet.getInt(1);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        return pages[0];
    }

    public int totalPagesOfBooks(int pageSize) throws SQLException, ClassNotFoundException {
        String sql = "select count(* / 4) as pages from book";
        final int[] pages = {0};

        this.query(sql, new ResultSetVisitor() {
            public void visit(ResultSet resultSet) {
                try {
                    pages[0] =resultSet.getInt("pages");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        return pages[0];
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

                        System.out.println(String.format("%d, %s, %s, %f, %s",id,name,author,price,content));

                        Book book = new Book(id, name, author, price, content);
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

    public static List<Book> getAllBook2() {
        List<Book> result = new ArrayList<>();
        String sql = "select id, name, author, price, content, imageurl from book";
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String author = resultSet.getString("author");
                        BigDecimal price = resultSet.getBigDecimal(4);
                        String content = resultSet.getString(5);
                        String image = resultSet.getString("imageurl");

                        System.out.println(String.format("%d, %s, %s, %f, %s, %s",id,name,author,price,content,image));

                        Book book = new Book(id, name, author, price, content, image);
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

    public static List<Book> getAllBook3() {
        List<Book> result = new ArrayList<>();
        String sql = "select id, name, author, price, num, content, imageurl from book";
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String author = resultSet.getString("author");
                        BigDecimal price = resultSet.getBigDecimal(4);
                        int num = resultSet.getInt("num");
                        String content = resultSet.getString(5);
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
