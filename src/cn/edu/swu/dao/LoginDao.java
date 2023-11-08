package cn.edu.swu.dao;

import cn.edu.swu.common.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    static Connection con = DBTools.conn; //将DBUtil类中连接的conn传过来

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
            if ( rs.next() ) { //rs是表头，看他下一个是否有东西，如果里面有东西执行了，就返回true
                return true;
            } else { //如果查询失败了
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
