package io.file;

import java.io.File;

/**
 * @author yanyuchi
 * @date 2019-06-16 16:50
 */
public class FileApi {
    public static void main(String[] args) {

        //构造一
        File file = new File("C:\\Users\\60403\\Desktop\\DesktopPic\\10592196_p0.jpg");


        //构造二

        file = new File("C:\\Users\\60403\\Desktop\\DesktopPic","10592196_p0.jpg");

        file  = new File("C:\\Users\\60403\\Desktop","DesktopPic\\10592196_p0.jpg");

        //构造三

        file = new File(new File("C:\\Users\\60403\\Desktop\\DesktopPic"),"10592196_p0.jpg");

        System.out.println(file.getName());


        //相对路径,已项目路径为出发点
        System.out.println(System.getProperty("user.dir"));
        file =  new File("pom.xml");
        System.out.println(file.getName());

    }
}
