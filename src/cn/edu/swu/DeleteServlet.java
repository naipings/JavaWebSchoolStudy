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

public class DeleteServlet extends HttpServlet {

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
            response.sendRedirect("./delete.html");
            return;
        }

        int a = LoginDao.loginDelete(user, pass);
        System.out.println(a);
        if ( a == 1 ) {
            //注销成功，在session中添加注销成功的标记
            session.setAttribute(AuthFilterDelete.Delete_SUCCESS, AuthStatus.Delete_SUCCESS);
            //返回重一个定向
            response.sendRedirect("./delete_successful.html");

            return;
        } else if ( a == 3 ){
            JOptionPane.showMessageDialog(null, ">报错，请检查输入内容！", "标题",JOptionPane.WARNING_MESSAGE);
        } else if ( a == 0 ) {
            response.setHeader("Refresh", "3; url=./delete.html"); //隔3秒钟刷新到register.html这个网页
            Writer writer = response.getWriter();
            writer.write("<center><h1 style='color:red'>注销失败，此账户从未注册！3秒后将自动跳转</h1></center>");
        }



    }
}
