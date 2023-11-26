package cn.edu.swu.repository;

import cn.edu.swu.book.BookRepo;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public abstract class BaseRepo {

    private static BasicDataSource dataSource = null;

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

    protected BaseRepo() {

    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return dataSource.getConnection();
    }

    //”增删改“可以用的
    protected boolean execute(String sql) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                return statement.execute(sql);
            }
        }
    }

    //执行一个执行查询的帮助接口
    protected void query(String sql, ResultSetVisitor visitor) throws SQLException, ClassNotFoundException {
        try ( Connection connection = dataSource.getConnection() ) {
            try ( Statement statement = connection.createStatement() ) {
                try ( ResultSet resultSet = statement.executeQuery(sql) ) {
                    while (resultSet.next()) {
                        visitor.visit(resultSet);
                    }
                }
            }

        }
    }

}
