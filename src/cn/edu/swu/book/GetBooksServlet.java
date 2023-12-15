package cn.edu.swu.book;

import cn.edu.swu.book.model.Book;
import cn.edu.swu.common.dao.BookRepo;
import cn.edu.swu.common.dao.LoginDao;
import cn.edu.swu.common.dao.UserDao;
import cn.edu.swu.user.model.UserData;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输出JSON内容Servlet类
 */
@WebServlet(name="getBooks",urlPatterns = "/getBooks")
public class GetBooksServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //根据获取所有的书籍信息
        List<Book> books = new ArrayList<>();
//        System.out.println("in getBooks");
        books = BookRepo.getAllBook();
//        books = BookRepo.getAllBook2();

        String[] bookJson = new String[books.size()];
        int i = 0;
        for (Book book : books) {
            bookJson[i] = String.format(
                    "{\n" +
                    "\t\"id\": \"%s\",\n" +
                    "\t\"name\": \"%s\",\n" +
//                    "\t\"image\": \"%s\",\n" +
                    "\t\"author\": \"%s\",\n" +
                    "\t\"price\": \"%s\",\n" +
                    "\t\"content\": \"%s\"\n" +
                    "}",
                    book.getId(), book.getName(),
                    book.getAuthor(), book.getPrice(), book.getContent());
            i++;
        }

        //返回结果
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        // 获取PrintWriter对象
        PrintWriter out = response.getWriter();
        out.print(Arrays.toString(bookJson));
        // 释放PrintWriter对象
        out.flush();
        out.close();

    }
}
