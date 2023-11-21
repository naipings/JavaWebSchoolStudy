package cn.edu.swu.common;

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
                <div style="font-size:16px display:inline-block"><a href="./add.html">添&nbsp;&nbsp;加</a></div>
                <div style="display:inline-block"><form action="./search" method="post">
                <select name='type'><option value="name">书 名</option><option value="author">作 者</option></select>
                <input type="text" name='key'><input type='submit' value='查 询'>
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

}
