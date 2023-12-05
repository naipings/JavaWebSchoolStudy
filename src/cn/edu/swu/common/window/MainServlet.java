package cn.edu.swu.common.window;

import cn.edu.swu.book.BookRepo;
import cn.edu.swu.common.style.Conf;
import cn.edu.swu.common.tool.PageTools;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import cn.edu.swu.book.model.Book;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        try {
            String page = request.getParameter("page");
            String size = request.getParameter("pageSize");
            int currentPage = page != null ? Integer.parseInt(page) : 1;
            int pageSize = size != null ? Integer.parseInt(size) : Conf.Conf_PAGE_SIZE;

            int offset = (currentPage - 1) * pageSize;
            int total = BookRepo.getInstance().totalBooks();

            String sql = String.format("select * from book order by id desc limit %d offset %s", pageSize, offset);
            List<Book> books = BookRepo.getInstance().queryBook(sql);

            String table = PageTools.warpBookTable(books);

            Pager pager = new Pager();
            pager.setUrl("./main?");
            pager.setTotal(BookRepo.getInstance().totalBooks());
            pager.setCurrentPage(currentPage);
            pager.setPageSize(pageSize);

            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            try (Writer writer = response.getWriter()) {
                writer.write(PageTools.warp(table + pager.toHtml()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
