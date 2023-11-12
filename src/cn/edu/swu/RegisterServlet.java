package cn.edu.swu;

import cn.edu.swu.common.DBTools;
import cn.edu.swu.dao.LoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.swing.*;
import java.io.IOException;
import java.io.Writer;

public class RegisterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String code = request.getParameter("code");

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession(true);

        DBTools dbTools = new DBTools("root","20030504", "bookstore");

        if ( code == null || !code.equalsIgnoreCase((String)session.getAttribute(AuthCodeServlet.AUTH_CODE)) ) {
            response.sendRedirect("./register.html");
            return;
        }

        int a = LoginDao.loginRegister(user, pass);
        if ( a == 1 ) {
            //注册成功，在session中添加登陆成功的标记
            session.setAttribute(AuthFilterRegister.Register_SUCCESS, AuthStatus.Register_SUCCESS);
            //返回重一个定向
            response.sendRedirect("./register_successful.html");

        } else if ( a == 3 ){
            response.setHeader("Refresh", "3;url=./register.html"); //隔3秒钟刷新到register.html这个网页
            Writer writer = response.getWriter();
            writer.write("<center><h1 style='color:red'>用户名密码不正确，需要重新注册，3秒后自动跳转！</h1></center>");
        } else if ( a == 0 ) {
            JOptionPane.showMessageDialog(null, "账号重复，请重新注册！", "标题",JOptionPane.WARNING_MESSAGE);
            response.sendRedirect("./register.html");
        }


    }
}
