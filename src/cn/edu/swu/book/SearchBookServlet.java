package cn.edu.swu.book;

import cn.edu.swu.book.model.Book;
import cn.edu.swu.common.dao.BookRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
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
@WebServlet(name="searchBook",urlPatterns = "/searchBook")

@MultipartConfig//**加上这个注解，反射该Servlet时才知道处理的是文件上传
public class SearchBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String author = request.getParameter("author");

        System.out.println("in searchBook");
        System.out.println("id="+id+", name="+name+", author="+author);

        Integer id1 = 0;
        if ( id == null ) {
            id1 = 0;
        } else {
            id = id.trim(); // 去掉前面的空格
            id1 = Integer.parseInt(id);
        }

        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        Book book2 = new Book();
        if (id != null) {
            book1.setId(id1);
            try {
                book2 = BookRepo.getInstance().getBookById(id1);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        else if ( name != null) {
            name = name.trim(); // 去掉前面的空格
            book1.setName(name);
            try {
//                book2 = BookRepo.getInstance().getBookByName(name);
                books = BookRepo.getInstance().getBooksByName(name);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        else if (author != null) {
            author = author.trim(); // 去掉前面的空格
            book1.setAuthor(author);
            try {
                book2 = BookRepo.getInstance().getBookByAuthor(author);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

        String[] bookJson = new String[books.size()];
        int i = 0;
        for (Book book : books) {
            bookJson[i] = String.format(
                    "{\n" +
                            "\t\"id\": \"%s\",\n" +
                            "\t\"name\": \"%s\",\n" +
                            "\t\"author\": \"%s\",\n" +
                            "\t\"price\": \"%s\",\n" +
                            "\t\"content\": \"%s\"\n" +
                            "}",
                    book.getId(), book.getName(), book.getAuthor(),
                    book.getPrice(), book.getContent());
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


//        String bookJson = String.format(
//                    "{\n" +
//                            "\t\"id\": \"%s\",\n" +
//                            "\t\"name\": \"%s\",\n" +
//                            "\t\"author\": \"%s\",\n" +
//                            "\t\"price\": \"%s\",\n" +
//                            "\t\"content\": \"%s\"\n" +
//                            "}",
//                book2.getId(), book2.getName(), book2.getAuthor(),
//                book2.getPrice(), book2.getContent());
//
//        //返回结果
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        // 获取PrintWriter对象
//        PrintWriter out = response.getWriter();
//        out.print(bookJson);
//        // 释放PrintWriter对象
//        out.flush();
//        out.close();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
