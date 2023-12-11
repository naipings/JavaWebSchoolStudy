package cn.edu.swu.user;

import cn.edu.swu.common.dao.UserDao;
import cn.edu.swu.security.filter.AuthFilter;
import cn.edu.swu.common.style.AuthStatus;
import cn.edu.swu.common.dao.LoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

@WebServlet("/login")
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
        //如果未更新个人信息
        int num = 0;
        try {
            num = UserDao.getInstance().searchUserId(user);
            System.out.println("num"+num);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if ( num == 0 || num == 3) {
            response.sendRedirect("./registerUserData.html");
            return;
        }
        if ( star && num!=0 ) {
            //登陆成功，在session中添加登陆成功的标记
            session.setAttribute(AuthFilter.LOGIN_STATUS, AuthStatus.LOGIN_SUCCESS);
            //返回一个重定向
//            response.sendRedirect("./main");
            response.sendRedirect("http://10.69.34.196:8081/#/");

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
