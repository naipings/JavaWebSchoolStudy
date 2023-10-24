package cn.edu.swu;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

public class HelloServlet extends HttpServlet  {

    public void init(ServletConfig config) {
        System.out.println("Servlet Initializing");
    }

    public void destroy() {
        System.out.println("Servlet Destroy");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Servlet doGet Service");
        response.setContentType("text/html");
        try (Writer writer = response.getWriter()) {
            writer.write("<center><h1>Hello World from Servlet In Smart Tomcat</h1></center>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
