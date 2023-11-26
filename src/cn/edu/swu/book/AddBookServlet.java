package cn.edu.swu.book;

import cn.edu.swu.book.model.Book;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(request.getParameter("price")));
        String content = request.getParameter("content");

        Book book = new Book(name, author, price, content);
        try {
            BookRepo.getInstance().addBook(book);
            response.sendRedirect("./main");
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new ServletException(e);
        }

    }
}
