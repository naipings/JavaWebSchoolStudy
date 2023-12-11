package cn.edu.swu.common.dao;

import cn.edu.swu.book.model.Book;
import cn.edu.swu.repository.ResultSetVisitor;
import cn.edu.swu.user.model.UserData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseRepo {

    static Connection con;

    static {
        try {
            con = BaseRepo.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static UserDao instance = new UserDao();

    private UserDao() {

    }

    public static UserDao getInstance() {
        return instance;
    }

    public static int uid;

    //添加用户信息
    public int addUserMessage(UserData userData) throws SQLException, ClassNotFoundException {
//        String sql;
//        String insertTemplate = "update usersdata set nickname='%s', email='%s', address='%s', city='%s', country='%s', introduce='%s' where userId=%d";
//        sql = String.format(insertTemplate, userData.getNickname(), userData.getEmail(), userData.getAddress(), userData.getCity(), userData.getCountry(), userData.getIntroduce(), userData.getUserId());
//
//        return this.execute(sql);

        //采用预处理的方式
        PreparedStatement preSql; //预处理语句
        int num1 = 0; //返回不同num1的值，表示不同状态
        String sqlStr = "update usersdata set nickname=?, email=?, address=?, city=?, country=?, introduce=? where userId=?"; //?表示从外部输入的

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, userData.getNickname());
            preSql.setString(2, userData.getEmail());
            preSql.setString(3, userData.getAddress());
            preSql.setString(4, userData.getCity());
            preSql.setString(5, userData.getCountry());
            preSql.setString(6, userData.getIntroduce());
            preSql.setInt(7, userData.getUserId());

            num1 = preSql.executeUpdate(); //更新数据，返回值放到num里面
            return num1;

        } catch (SQLException e) {
            return 3;

        }
    }

    //查询用户信息
    public UserData UserMessage(Integer userId) throws SQLException, ClassNotFoundException {
        String template = "select * from usersdata where userId = %d";
        String sql = String.format(template, userId);

        List<UserData> userDatas = this.queryUserData(sql);

        return !userDatas.isEmpty() ? userDatas.get(0) : null;
    }

    //更新用户信息
    public List<UserData> queryUserData(String sql) throws SQLException, ClassNotFoundException {
        final List<UserData> userDatas = new ArrayList<>();
        this.query(sql, new ResultSetVisitor() {

            public void visit(ResultSet resultSet) {
                UserData userData = new UserData();
                try {
                    userData.setUserId(Integer.valueOf(String.valueOf(resultSet.getInt("userId"))));
                    userData.setNickname(resultSet.getString("nickname"));
                    userData.setEmail(resultSet.getString("email"));
                    userData.setAddress(resultSet.getString("address"));
                    userData.setCity(resultSet.getString("city"));
                    userData.setCountry(resultSet.getString("country"));
                    userData.setIntroduce(resultSet.getString("introduce"));
                    uid = userData.getUserId();
                    userDatas.add(userData);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        return userDatas;

    }

    //查询用户ID是否存在
    public int searchUserId(String account) throws SQLException, ClassNotFoundException {
//        boolean flag = false;
//        String template = "select userId from usersdata where account = %s";
//        String sql = String.format(template, account);
//
//        flag = this.execute(sql);
//
//        return flag;

        PreparedStatement preSql; //预处理语句
        int num = 0; //返回不同num1的值，表示不同状态
        ResultSet rs; //定义一个结果集（存放结果）
        String sqlStr = "select userId from usersdata where account=?";  //?表示从外部输入的
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, account); //相当于把上面第一个问号设置成账号

            rs = preSql.executeQuery(); //查询，返回值放到rs里面
            if ( rs.next() ) { //rs是表头，看他下一个是否有东西，如果里面有东西执行了，就返回true
                num = 1;
                return num;
            } else { //如果查询失败了
                return num;
            }
        } catch (SQLException e) {
            num = 3;
            return num;
        }


    }

    //获取用户ID
    public ResultSet getUserId(String account) throws SQLException, ClassNotFoundException {
        //采用预处理的方式
        PreparedStatement preSql; //预处理语句

        String sqlStr = "select userId from usersdata where account=?"; //?表示从外部输入的
        ResultSet rs = null; //定义一个结果集（存放结果）
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, account);
            rs = preSql.executeQuery();
            return rs;

        } catch (SQLException e) {
            return rs;
        }

    }



}
