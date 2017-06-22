package com.yubeigold.web.utils;

import java.io.File;

/**
 * File management.
 * @author xuxiaobo
 */

public class FileManagement {

    //判断文件是否存在
    public static boolean fileExists(String filePath) {
        File file = new File(filePath);
        Boolean b = file.exists();
        return b;
    }

    //判断文件是否存在，没有就新建
    public static void creatFile(String filePath) {
        if (!FileManagement.fileExists(filePath)) {
            File file = new File(filePath);
            file.mkdir();
        }
    }

    //删除目录及目录下所有文件和文件夹
    public static void deleteDirectory(String directoryPath) {
        File file = new File(directoryPath);
        if (file.isDirectory()) { //是文件夹
            File temp = null;
            String[] childsFile = file.list(); //获得该目录下的子文件及子文件夹
            for (String s : childsFile) {
                //检查folderPath是不是以"\"节尾
                if (directoryPath.endsWith(File.separator)) {
                    temp = new File(directoryPath + s);
                } else {
                    temp = new File(directoryPath + File.separator + s);
                }
                //delete file
                if (temp != null && temp.isFile()) {  //是文件
                    System.out.println(temp.delete());
                    System.out.println("delete of the fileName: " + temp.getAbsolutePath());
                } else if (temp != null && temp.isDirectory()) {  //是文件夹
                    deleteDirectory(temp.getAbsolutePath());
                }
            }
            file.delete();
        } else if (file.isFile()) {
            file.delete();
        }
    }
}
