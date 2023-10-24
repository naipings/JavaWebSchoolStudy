package cn.edu.swu;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

        response.setContentType("text/html");

        if ( user!= null && user.equals("Tom") ) {
            if ( pass!= null && pass.equals("123456") ) {
//                try (Writer writer = response.getWriter()) {
//                    writer.write("<center><h1>Welcome " + user + " !!</h1></center>");
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }

//                response.sendRedirect("./main.html");

                try (Writer writer = response.getWriter() ) {
                    writer.write("<center>");
                    writer.write("<h1 style='color:blue'>欢迎登陆网上书城！！</h1>");
                    writer.write(this.printParameter(request));
                    writer.write("<br/><br/>");
                    writer.write(this.printHeader(request));
                    writer.write("</center>");
                }
                return;
            }
        }

//        try (Writer writer = response.getWriter()) {
//            writer.write("<center><h1>Wrong user name or password, try again !!</h1></center>");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "用户名密码不正确，请重新登录！");

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
        sb.append("<table style='width:70%' cellpadding='5px' cellspacing='20px'>");
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
