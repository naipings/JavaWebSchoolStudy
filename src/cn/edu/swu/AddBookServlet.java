package cn.edu.swu;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddBookServlet  extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        float price = Float.valueOf(request.getParameter("price"));
        String content = request.getParameter("content");

    }
}
