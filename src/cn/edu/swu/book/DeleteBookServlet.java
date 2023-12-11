package cn.edu.swu.book;

import cn.edu.swu.common.dao.BookRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteBook")
public class DeleteBookServlet  extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        try {
            BookRepo.getInstance().deleteBook(id);
            response.sendRedirect("./main");
        } catch (SQLException | ClassNotFoundException | IOException e) {
//            throw new RuntimeException(e);
            request.setAttribute("errorInfo:", "something wrong!");
            request.getRequestDispatcher("./errorHandle").forward(request, response);
        }
    }
}
