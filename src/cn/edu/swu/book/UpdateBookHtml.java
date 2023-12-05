package cn.edu.swu.book;

import cn.edu.swu.book.model.Book;
import cn.edu.swu.common.tool.PageTools;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

@WebServlet("/updateBook.html")
public class UpdateBookHtml extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        try {
            Book book = BookRepo.getInstance().getBookById(id);
            String template = """
                    <form action="./addBook" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="%s">
                        书 名： <input type="text" name="name" value="%s"><br><br>
                        作 者： <input type="text" name="author" value="%s"><br><br>
                        价 格： <input type="text" name="price" value="%s"><br><br>
                        内 容： <textarea name="content" cols="30" rows="5" value="%s"></textarea><br><br>
                        图 片：<input type="file" name="imageurl"><br><br>
                        <input type="submit" value="提 交">
                    </form>
                    """;
            String form = String.format(template, book.getId(), book.getName(), book.getAuthor(), book.getPrice(), book.getContent());
            String html = PageTools.warp(form);

            response.setContentType("text/html");
            try (Writer writer = response.getWriter()) {
                writer.write(html);
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }
}
