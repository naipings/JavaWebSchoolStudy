package cn.edu.swu.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    static Connection con;

    static {
        try {
            con = BaseRepo.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String act;
    public static String act2;
    public static int uid;

    //登录状态（成功则返回true，失败则返回false）
    public static boolean loginStar(String account, String password) { //提供两个参数，第一个账号，第二个密码，采用预处理的方法
        PreparedStatement preSql; //预处理语句
        ResultSet rs; //定义一个结果集（存放结果）
        String sqlStr = "select * from users where account = ? and password = ?";  //?表示从外部输入的

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, account); //相当于把上面第一个问号设置成账号
            preSql.setString(2, password); //把上面第二个问号设置成密码

            rs = preSql.executeQuery(); //查询，返回值放到rs里面
            while ( rs.next() ) { //rs是表头，看他下一个是否有东西，如果里面有东西执行了，就返回true
                act2 = rs.getString("account");
                System.out.println(act2);
            }
            if ( getUid(act2) != 0 ) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public static int getUid(String account) throws SQLException {

        PreparedStatement preSql; //预处理语句
        ResultSet rs; //定义一个结果集（存放结果）
        String sqlStr = "select userId from usersdata where account = ?";  //?表示从外部输入的
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, account);
            rs = preSql.executeQuery(); //查询，返回值放到rs里面

            while (rs.next()) {
                uid = rs.getInt("userId");
                System.out.println("uid_01:"+uid);
            }

            return uid;
        } catch (SQLException e) {
            uid = 0;
            return uid;
        }

    }

    //注册账号
    public static int loginRegister(String account, String password) { //提供两个参数，第一个账号，第二个密码，采用预处理的方法
        PreparedStatement preSql; //预处理语句
        String sqlStr = "insert into users values(?, ?)";  //?表示从外部输入的
        int num;

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, account); //相当于把上面第一个问号设置成账号
            preSql.setString(2, password); //把上面第二个问号设置成密码

            num = preSql.executeUpdate(); //更新数据，返回值放到num里面
            int num1 = RegisterUserData(account, password);
            if ( num1 == 1 ) {
                act = account;
//                System.out.println("RegisterUserData");
            }
            return num;

        } catch (SQLException e) { //账号重复
            return 3;
        }
    }

    //注册账号时，再写一份数据到usersData表里面
    public static int RegisterUserData(String account, String password) { //提供两个参数，第一个账号，第二个密码，采用预处理的方法
        PreparedStatement preSql; //预处理语句
        String sqlStr = "insert into usersData(account, password) values(?, ?)";  //?表示从外部输入的
        int num;

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, account); //相当于把上面第一个问号设置成账号
            preSql.setString(2, password); //把上面第二个问号设置成密码

            num = preSql.executeUpdate(); //更新数据，返回值放到num里面
            return num;

        } catch (SQLException e) { //账号重复
            return 3;
        }
    }

    //注销账号
    public static int loginDelete(String account, String password) { //提供两个参数，第一个账号，第二个密码，采用预处理的方法
        PreparedStatement preSql; //预处理语句
        String sqlStr = "delete from users where account=?";  //?表示从外部输入的
        int num;

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, account); //相当于把上面第一个问号设置成账号

            num = preSql.executeUpdate(); //更新数据，返回值放到num里面
            return num;

        } catch (SQLException e) { //账号重复
            return 3;
        }
    }

    //注销账号时，查找数据库是否存在该用户，用于提示框强调
    public static boolean isDelete(String account) { //提供两个参数，第一个账号，第二个密码，采用预处理的方法
        PreparedStatement preSql; //预处理语句
        ResultSet rs; //定义一个结果集（存放结果）
        String sqlStr = "select account from users where account = ?";  //?表示从外部输入的
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, account); //相当于把上面第一个问号设置成账号

            rs = preSql.executeQuery(); //查询，返回值放到rs里面
            if (rs.next()) { //rs是表头，看他下一个是否有东西，如果里面有东西执行了，就返回true
                return true;
            } else { //如果查询失败了
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

}
