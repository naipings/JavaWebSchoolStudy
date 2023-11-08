package cn.edu.swu.common;

public class PageTools {

    private static String Template = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>网上书城</title>
                <link rel="stylesheet" type="text/css" href="css/bookstore.css" />
            </head>
            <body>
            <div style="float: right">
                <a href="./logout">退出系统</a>
            </div>
            <center>
                <h1 style='color:blue'>欢迎访问西大网上书城</h1>
                 %s
                 
            </center>
            <center><div class='footer'>版权所有 2023 西南大学计算机学院</div></center>
            </body>
            </html>      
                        
            """;

    public static String warp(String body) {
        return String.format(Template, body);
    }

}
