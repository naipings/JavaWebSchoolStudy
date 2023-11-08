package cn.edu.swu;

import cn.edu.swu.common.DBTools;
import cn.edu.swu.dao.LoginDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

public class LoginServlet extends HelloServlet {

    //user pass
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String code = request.getParameter("code");

        DBTools dbTools = new DBTools("root","20030504", "bookstore");

        response.setContentType("text/html");
        HttpSession session = request.getSession(true);

        if ( code == null || !code.equalsIgnoreCase((String)session.getAttribute(AuthCodeServlet.AUTH_CODE)) ) {
            response.sendRedirect("./index.html");
            return;
        }

        boolean star = LoginDao.loginStar(user, pass); //将获取的账号密码传过去，如果账号密码正确就会返回true
        if ( star == true ) {
            //登陆成功，在session中添加登陆成功的标记
            session.setAttribute(AuthFilter.LOGIN_STATUS, AuthStatus.LOGIN_SUCCESS);
            System.out.println(user+pass);
            //返回重一个定向
            response.sendRedirect("./main");

            return;
        }

        //错误提示
        try (Writer writer = response.getWriter()) {
            response.setHeader("Refresh", "5;url=./index.html"); //隔5秒钟刷新到index.html这个网页
            writer.write("<center><h1 style='color:red'>用户名密码不正确，需要重新登录，5秒后自动跳转！</h1></center>");
        }

    }

    private String printParameter(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder(); //字符串构造器
        sb.append("<table style='width:70%' padding='5px' spacing='20px'>");
        sb.append("<tr style='background-color:#336699; color:#FFF'><td>参数名称</td><td>参数值</td></tr>");
        Enumeration<String> names = request.getParameterNames();
        while ( names.hasMoreElements() ) {
            String name = names.nextElement();
            sb.append(String.format("<tr style='background-color:#eee'><td>%s</td><td>%s</td></tr>", name, request.getHeader(name)));
//            sb.append(name + " : " + request.getParameter(name) + "<br/>");
        }
        sb.append("</table>");
        return sb.toString();
    }

    private String printHeader(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder(); //字符串构造器
        sb.append("<table style='width:70%' padding='5px' spacing='20px'>");
        sb.append("<tr style='background-color:#336699; color:#FFF'><td>Header 名称</td><td>header 值</td></tr>");
        Enumeration<String> names = request.getHeaderNames();
        while ( names.hasMoreElements() ) {
            String name = names.nextElement();
            sb.append(String.format("<tr style='background-color:#eee'><td>%s</td><td>%s</td></tr>", name, request.getHeader(name)));
//            sb.append(name + " : " + request.getHeader(name) + "<br/>");
        }
        sb.append("</table>");
        return sb.toString();
    }

}
