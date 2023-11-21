package cn.edu.swu;

import cn.edu.swu.common.DBTools;
import cn.edu.swu.common.PageTools;
import cn.edu.swu.model.Book;
import cn.edu.swu.servlet.HelloServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

public class UpdateBookHtml extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        try {
            Book book = DBTools.getInstance().gitBookById(id);
            String template = """
                    <form action="./updateBook" method="post">
                        <input type="hidden" name="id" value="%s">
                        书 名： <input type="text" name="name" value="%s"><br><br>
                        作 者： <input type="text" name="author" value="%s"><br><br>
                        价 格： <input type="text" name="price" value="%s"><br><br>
                        内 容： <textarea name="content" cols="30" rows="5" value="%s"></textarea><br><br>
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
            throw new RuntimeException(e);
        }
    }
}
