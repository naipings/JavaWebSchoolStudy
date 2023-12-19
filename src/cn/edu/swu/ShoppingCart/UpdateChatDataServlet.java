package cn.edu.swu.ShoppingCart;

import cn.edu.swu.book.model.Book;
import cn.edu.swu.common.dao.ShoppingChatDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@WebServlet(name="updateChatData",urlPatterns = "/updateChatData")

@MultipartConfig//**加上这个注解，反射该Servlet时才知道处理的是文件上传
public class UpdateChatDataServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String content = request.getParameter("content");
        String image = request.getParameter("imageurl");
        String num = request.getParameter("num");

        Integer id1 = Integer.parseInt(id);
        Integer num1 = Integer.parseInt(num);
        BigDecimal price1 = new BigDecimal(price);
        Book book = new Book();
        book.setId(id1);
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price1);
        book.setContent(content);
        book.setImageUrl(image);
        book.setNum(num1);

        System.out.println("in UpdateChatDataServlet:");
        System.out.println(book.getNum()+", "+book.getId());

        try {
            int a = ShoppingChatDao.getInstance().SearchChatData(book);
            System.out.println("a="+a);
            if ( a>0 ) {
                //更新关键：num
                Book book1 = ShoppingChatDao.getInstance().getChatDataNum(book);
                int tempNum = book1.getNum();
                System.out.println("tempNum="+tempNum);
                System.out.println("num1="+num1);
                int newNum = tempNum+num1;
                book.setNum(newNum);
                System.out.println("book.getNum()="+book.getNum());
                ShoppingChatDao.getInstance().updateChatData(book);
            } else {
                ShoppingChatDao.getInstance().addChatData(book);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("http://10.69.34.196:8081/#/");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
