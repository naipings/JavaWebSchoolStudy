package cn.edu.swu.book;

import cn.edu.swu.book.model.Book;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(request.getParameter("price")));
        String content = request.getParameter("content");

        Book book = new Book(id, name, author, price, content);

        try {
            BookRepo.getInstance().updateBook(book);
            response.sendRedirect("./main");
        } catch (SQLException | IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

