package cn.edu.swu.ShoppingCart;

import cn.edu.swu.common.dao.BookRepo;
import cn.edu.swu.common.dao.ShoppingChatDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteChatData")

@MultipartConfig//**加上这个注解，反射该Servlet时才知道处理的是文件上传
public class DeleteChatDataServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer id1 = Integer.parseInt(id);
        System.out.println("in deleteBook id="+id1);
        try {
            ShoppingChatDao.getInstance().deleteChatData(id1);
            response.sendRedirect("http://10.69.34.196:8081/#/");
        } catch (SQLException | ClassNotFoundException | IOException e) {
//            throw new RuntimeException(e);
            request.setAttribute("errorInfo:", "something wrong!");
            request.getRequestDispatcher("./errorHandle").forward(request, response);
        }
    }

}
