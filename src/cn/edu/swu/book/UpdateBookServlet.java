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
import java.math.BigDecimal;
import java.sql.SQLException;

@WebServlet("/updateBook")

@MultipartConfig//**加上这个注解，反射该Servlet时才知道处理的是文件上传
public class UpdateBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String content = request.getParameter("content");
//        String image = request.getParameter("image");
        //特殊参数用part取
//        Part part = request.getPart("file");
//      System.out.println(name+"--"+age);
//      System.out.println(part);

        Integer id1 = Integer.parseInt(id);
        BigDecimal price1 = new BigDecimal(price);
        Book book = new Book();
        book.setId(id1);
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price1);
        book.setContent(content);
//        book.setImageUrl(image);

        //获取文件名
//        String contentDisposition = part.getHeader("Content-Disposition");
//        System.out.println(contentDisposition);// form-data; name="file"; filename="User.sql"
//        int filenameIndex = contentDisposition.indexOf("filename=");
//        String filename = contentDisposition.substring(filenameIndex+10, contentDisposition.length()-1);
//        part.write(getServletContext().getRealPath("/files")+"/"+filename);

        try {
            BookRepo.getInstance().updateBook(book);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("http://10.69.34.196:8081/#/");


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
