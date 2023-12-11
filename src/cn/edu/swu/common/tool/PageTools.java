package cn.edu.swu.common.tool;

import cn.edu.swu.book.model.Book;

import java.util.List;

public class PageTools {

    private static String Template = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>网上书城</title>
                <link rel="stylesheet" type="text/css" href="css/bookstore.css" />
                <link rel="stylesheet" type="text/css" href="css/a.css" />
            </head>
            <body>
            <div style="float: right">
                <a href="./logout" methods="post">退出系统</a>
            </div>
            <center>
                <h1 style='color:blue'>欢迎访问SWU网上书城</h1>
                <hr>
                <div style="font-size:16px display:inline-block">
                <a href="./main">首&nbsp;&nbsp;页</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="./add.html">添&nbsp;&nbsp;加</a></div>
                <div style="display:inline-block">
                <form action="./searchBook" method="post">
                <select name='type'>
                <option value="name">书 名</option>
                <option value="author">作 者</option>
                <option value='content'>内 容</option>
                </select>
                <input type="text" name='key'>&nbsp;&nbsp;
                <input type='submit' value='查 询'>
                </form></div>
                <br><br>
                 %s
                 
            </center>
            <center><div class='footer'>版权所有 2023 西南大学计算机学院</div></center>
            </body>
            </html>
                  
            """;

    public static String warp(String body) {
        return String.format(Template, body);
    }

    public static String warpBookTable(List<Book> books) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table class='tb-book'>");
        sb.append("<tr><th>编号</th><th>书名</th><th>作者</th><th>价格</th><th>内容</th><th>图片</th><th></th><th></th></tr>");
        for (Book book : books) {
            sb.append(String.format("<tr><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td><a href='./image/upload/%s' target=_blank><img src='./image/upload/%s' class='book-pic'></a></td>" +
                            "<td><a href='./deleteBook?id=%d'>删除</a></td>" +
                            "<td><a href='./updateBook.html?id=%d'>修改</a></td>" +
                            "</tr>",
                    book.getId(), book.getName(), book.getAuthor(), book.getPrice(),
                    book.getContent(),
                    book.getImageUrl(),
                    book.getImageUrl(),
                    book.getId(), book.getId()));
        }
        sb.append("</table>");
        return sb.toString();
    }
}
