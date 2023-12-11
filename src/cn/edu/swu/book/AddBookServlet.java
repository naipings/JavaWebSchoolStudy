package cn.edu.swu.book;

import cn.edu.swu.book.model.Book;
import cn.edu.swu.common.dao.BookRepo;
import cn.edu.swu.common.tool.Utils;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {

    //上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB，传输文件最大阈值
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB，文件最大体积
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB，多个文件体积最大总和

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 检测是否为多媒体上传
        if (!JakartaServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }

        // 配置上传参数
        DiskFileItemFactory.Builder builder = DiskFileItemFactory.builder();
        builder.setCharset("UTF-8");
        DiskFileItemFactory factory = builder.get();

        JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        // 中文处理
        upload.setHeaderCharset(StandardCharsets.UTF_8);

        //下载到的地址
        String uploadPath = request.getServletContext().getRealPath("./")
                + File.separator + "image" + File.separator + "upload";

        //如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                Book book = new Book();
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        if (item.getName()!=null && !item.getName().trim().equals("")) {
                            File original = new File(item.getName());
                            String fileName = UUID.randomUUID().toString() + Utils.getFileSuffix(original);
                            Path filePath = Paths.get(uploadPath, fileName);
                            // 在控制台输出文件的上传路径
                            System.out.println(filePath);
                            // 保存文件到硬盘
                            item.write(filePath);
                            book.setImageUrl(fileName);
                        }
                    }
                    else {
                        String name = item.getFieldName();
                        System.out.println(name);
                        if (name.equals("name")) {
                            book.setName(item.getString());
                        } else if (name.equals("author")) {
                            book.setAuthor(item.getString());
                        } else if (name.equals("price")) {
                            book.setPrice(BigDecimal.valueOf(Double.parseDouble(item.getString())));
                        } else if (name.equals("content")) {
                            book.setContent(item.getString());
                        } else if (name.equals("id")) {
                            book.setId(Integer.valueOf(item.getString()));
                        }
                    }
                }

                if (book.getId() == null) {
                    BookRepo.getInstance().addBook(book);
                } else {
                    BookRepo.getInstance().updateBook(book);
                }

                response.sendRedirect("./main");

            }
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            request.setAttribute("message", "错误信息: " + ex.getMessage());
        }

    }
}
