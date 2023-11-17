package cn.edu.swu.servlet;

import cn.edu.swu.common.DBTools;
import cn.edu.swu.model.Book;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public class UpdateBookServlet extends HelloServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(request.getParameter("price")));
        String content = request.getParameter("content");

        Book book = new Book(name, author, price, content);
        try {
            DBTools.getInstance().updateBook(book, id);
            response.sendRedirect("./main");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
