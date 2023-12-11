package cn.edu.swu.book;

import cn.edu.swu.book.model.Book;
import cn.edu.swu.common.dao.BookRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

/**
 * 输出JSON内容Servlet类
 */
@WebServlet(name="books",urlPatterns = "/books")
public class QueryBookServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            String sql = "select * from book order by id desc";
            List<Book> books = BookRepo.getInstance().queryBook(sql);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(books);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            try(Writer writer = response.getWriter()) {
                writer.write(json);
            }
        } catch (SQLException | IOException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
