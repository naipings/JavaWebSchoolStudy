package cn.edu.swu.user;

import cn.edu.swu.common.dao.LoginDao;
import cn.edu.swu.common.dao.UserDao;
import cn.edu.swu.user.model.UserData;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 输出JSON内容Servlet类
 */
@WebServlet(name="userCenter",urlPatterns = "/userCenter")
public class UserServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //根据userId获取用户信息
        UserData userData = new UserData();
        try {
            System.out.println("in userCenter uid="+LoginDao.uid);
            userData = UserDao.getInstance().UserMessage(LoginDao.uid);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        String json = String.format(
                "{\n" +
                    "\t\"nickname\": \"%s\",\n" +
                    "\t\"email\": \"%s\",\n" +
                    "\t\"phone\": \"%s\",\n" +
                    "\t\"address\": \"%s\",\n" +
                    "\t\"city\": \"%s\",\n" +
                    "\t\"country\": \"%s\",\n" +
                    "\t\"firstName\": \"%s\",\n" +
                    "\t\"lastName\": \"%s\",\n" +
                    "\t\"introduce\": \"%s\"\n" +
                "}", userData.getNickname(), userData.getEmail(), userData.getPhone(),
                userData.getAddress(), userData.getCity(), userData.getCountry(),
                userData.getFirstName(), userData.getLastName(), userData.getIntroduce());

        //返回结果
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        // 获取PrintWriter对象
        PrintWriter out = response.getWriter();
        out.print(json);
        // 释放PrintWriter对象
        out.flush();
        out.close();

    }
}
