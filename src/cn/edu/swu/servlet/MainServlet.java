package cn.edu.swu.servlet;

import cn.edu.swu.common.PageTools;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import cn.edu.swu.model.Book;
import cn.edu.swu.common.DBTools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

public class MainServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        List<Book> books = DBTools.getAllBook();
        StringBuilder sb = new StringBuilder();
        sb.append("<table class='tb-book'>");
        sb.append("<tr><th>编号</th><th>书名</th><th>作者</th><th>价格</th><th>内容</th><th></th></tr>");
        for (Book book : books) {
            sb.append(String.format("<tr><td>%d</td><td>%s</td><td>%s</td><td>%f</td><td>%s</td>" +
                            "<td><a href='./deleteBook?id=%d'>删除</a></td>" +
//                            "<td><a href='./updateBook?id=%d'>修改</a></td>" +
                            "</tr>",
                    book.getId(), book.getName(), book.getAuthor(), book.getPrice(), book.getContent(), book.getId()));
        }
        sb.append("</table>");

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        try (Writer writer = response.getWriter()) {
            writer.write(PageTools.warp(sb.toString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
