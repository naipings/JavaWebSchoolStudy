package cn.edu.swu.book;

import cn.edu.swu.book.model.Book;
import cn.edu.swu.common.dao.BookRepo;
import cn.edu.swu.common.tool.PageTools;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String type = request.getParameter("type");
        String key = request.getParameter("key");

        try {
            String template = "select * from book where %s like '%%%s%%'";
            String sql = String.format(template, type, key);
            List<Book> books = BookRepo.getInstance().queryBook(sql);
            String table = PageTools.warpBookTable(books);
            response.setContentType("text/html");
            try (Writer writer = response.getWriter()) {
                writer.write(PageTools.warp(table));
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }
}
