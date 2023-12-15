package cn.edu.swu.user;

import cn.edu.swu.common.dao.LoginDao;
import cn.edu.swu.common.dao.UserDao;
import cn.edu.swu.common.style.AuthStatus;
import cn.edu.swu.security.filter.AuthFilter;
import cn.edu.swu.user.model.UserData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/registerUserData")
public class RegisterUserDataServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String introduce = request.getParameter("introduce");

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int num1 = 0;
        try {
            num1 = UserDao.getInstance().searchUserId(LoginDao.act);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if ( num1 == 0  ) {
            response.sendRedirect("./registerUserData.html");
            return;
        }

        ResultSet rs = null;
        try {
            rs = UserDao.getInstance().getUserId(LoginDao.act);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int userId = 0;
        try {
            while (rs.next()) {
                try {
                    userId = rs.getInt("userId");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        boolean star = false;
        int num = 0;
        try {
            UserData userData = new UserData();
            userData.setUserId(userId);
            userData.setNickname(nickname);
            userData.setEmail(email);
            userData.setPhone(phone);
            userData.setAddress(address);
            userData.setFirstName(firstName);
            userData.setLastName(lastName);
            userData.setCity(city);
            userData.setCountry(country);
            userData.setIntroduce(introduce);
            num = UserDao.getInstance().addUserMessage(userData);
            System.out.println("in RegisterUserDataServlet num:" + num);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if ( num == 1 ) {
            //登陆成功，在session中添加登陆成功的标记
            //session.setAttribute(AuthFilter.LOGIN_STATUS, AuthStatus.LOGIN_SUCCESS);
            //返回一个重定向
            response.sendRedirect("./registerUserData_successful.html");
            return;
        }

        //错误提示
        try (Writer writer = response.getWriter()) {
            response.setHeader("Refresh", "5;url=./registerUserData.html"); //隔5秒钟刷新到index.html这个网页
            writer.write("<center><h1 style='color:red'>用户名密码不正确，需要重新登录，5秒后自动跳转！</h1></center>");
        }

    }
}
