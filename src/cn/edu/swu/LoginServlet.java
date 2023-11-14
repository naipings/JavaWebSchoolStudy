package cn.edu.swu;

import cn.edu.swu.common.DBTools;
import cn.edu.swu.dao.LoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String code = request.getParameter("code");

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession(true);

        if ( code == null || !code.equalsIgnoreCase((String)session.getAttribute(AuthCodeServlet.AUTH_CODE)) ) {
            response.sendRedirect("./index.html");
            return;
        }

        boolean star = LoginDao.loginStar(user, pass); //将获取的账号密码传过去，如果账号密码正确就会返回true
        if ( star == true ) {
            //登陆成功，在session中添加登陆成功的标记
            session.setAttribute(AuthFilter.LOGIN_STATUS, AuthStatus.LOGIN_SUCCESS);
            //返回一个重定向
            response.sendRedirect("./main");

            System.out.println(user+pass);

            return;
        }

        //错误提示
        try (Writer writer = response.getWriter()) {
            response.setHeader("Refresh", "5;url=./index.html"); //隔5秒钟刷新到index.html这个网页
            writer.write("<center><h1 style='color:red'>用户名密码不正确，需要重新登录，5秒后自动跳转！</h1></center>");
        }

    }


}
