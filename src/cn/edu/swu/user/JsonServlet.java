package cn.edu.swu.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 输出JSON内容Servlet类
 */
@WebServlet(name="JsonServlet",urlPatterns = "/JsonServlet")
public class JsonServlet extends HttpServlet
{
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String json = "{\n" +
                "\t\"userId\": 1,\n" +
                "\t\"userName\": \"谢良材\",\n" +
                "\t\"blogUrl\": \" local\",\n" +
                "\t\"sex\": \"男\"\n" +
                "}";

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
