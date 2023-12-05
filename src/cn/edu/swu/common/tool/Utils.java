package cn.edu.swu.common.tool;

import java.io.File;

public class Utils {

    //取出文件后缀名
    public static String getFileSuffix(File file) {
        if (file == null || file.isDirectory()) return "";

        String name = file.getName();
        //eg: ma.test.jpg
        return name.indexOf(".") > 0 ? name.substring(name.lastIndexOf(".")) : "";
    }
}
