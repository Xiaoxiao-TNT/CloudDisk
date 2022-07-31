package com.csj.hadoop.service;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;

import java.io.InputStream;


public interface FileService {
    public static  final String ROOT="/yunpan/";
    String getHdfspath();
    FileSystem getFileSystem();
    int upload(String filePath, InputStream inputStream);
    FileStatus[] getDirs(String path);
    int createDir(String path) ;
    int deleteDir(String path) ;
    int alterDir(String path1,String path2);
    InputStream downLoad(String path );

    double getSpace();



    /**
     *文件复制
     * 将oldpath复制到newpath内
     * Param 规定 newpath必须是文件夹
     * 递归调用
     */
    void copy(String oldpath,String newpath);



    /**
     *统计文件类型
     * 层次遍历
     */
    int[] countType(String path);




}
