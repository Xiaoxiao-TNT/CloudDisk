package com.csj.hadoop.service.impl;

import com.csj.hadoop.utils.FileUtil;
import lombok.AllArgsConstructor;
import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import com.csj.hadoop.service.FileService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService {
    private  final String hdfspath="hdfs://192.168.141.128:9000";


    @Override
    public String getHdfspath() {
        return hdfspath;
    }

    /**
     * 获取 HDFS 文件系统对象，类似于：JDBC的Connection对象，MyBatis的sqlSerssionFactory
     */
    @Override
    public FileSystem getFileSystem() {
        System.setProperty("HADOOP_USER_NAME", "root");
        FileSystem fs = null;
        try {
            fs = FileSystem.get(URI.create(hdfspath), new Configuration());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return fs;
    }

    @Override
    public int upload(String filePath, InputStream inputStream) {
        // 操作结果标识

        int flag = 0;
        FSDataOutputStream fos = null;
        try {
            // path: HDFS中的文件路径，比如：/test/a.txt
            fos = this.getFileSystem().create(new Path(filePath));
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            IOUtils.closeStream(fos);
            flag = 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag ;
    }

    @Override
    public FileStatus[] getDirs(String path) {

        FileStatus[] fileStatus=null;
        try {
            FileSystem  fileSystem =this.getFileSystem();
            //获取fileStatus
            fileStatus = fileSystem.listStatus(new Path(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileStatus;
    }

    @Override
    public int createDir(String path)  {
        int flag = 0;
        FileSystem fileSystem = this.getFileSystem();
        try {

            fileSystem.mkdirs(new Path(path));
            flag = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int deleteDir(String path) {
        int flag = 0;
        FileSystem fileSystem = this.getFileSystem();
        try {
            fileSystem.delete(new Path(path),true);
            flag = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int alterDir(String oldpath, String newpath) {
        int flag = 0;
        FileSystem fileSystem = this.getFileSystem();
        try {
            fileSystem.rename(new Path(oldpath),new Path(newpath));
            flag = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public InputStream downLoad(String path) {
        FileSystem fileSystem = this.getFileSystem();
        FSDataInputStream open = null;
        try {
            open = fileSystem.open(new Path(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return open;
    }






    //层次遍历
    @Override
    public int[] countType(String path) {
        //层次遍历所用队列
        List<String> file_queue =new ArrayList<>();
        file_queue.add(path);
        int[] types = new int[10];
        //上一层队尾
        int last = 1;
        int p=0;
        while(p<last){
            for(;p<last;p++){
                String filepath=file_queue.get(p);

                if(FileUtil.idDir(filepath)){
                    //是文件夹时则将该文件夹下的所有节点加入队列
                    FileStatus[] fileStatuses = getDirs(filepath);
                    for(FileStatus fileStatus:fileStatuses){
                        file_queue.add(fileStatus.getPath().toString());
                    }
                }else {
                    types[FileUtil.typeByPath(filepath)]++;
                }
            }
            last=file_queue.size();

        }
        return types;
    }



    //递归复制文件,将oldpath 放入targetDir下
    @Override
    public void copy(String oldpath, String targetDir) {
        String filename = oldpath.substring(oldpath.lastIndexOf("/")+1);
        if(!FileUtil.idDir(oldpath)){
            //是文件，直接复制
            InputStream inputStream = this.downLoad(oldpath);
            this.upload(targetDir+"/"+filename,inputStream);

        }else {
            //是文件夹，生成相对文件夹
            this.createDir(targetDir+"/"+filename);
            targetDir = targetDir+"/"+filename;
            FileStatus[] fileStatuses = this.getDirs(oldpath);
            for(FileStatus fileStatus:fileStatuses){
                //递归调用
                copy(fileStatus.getPath().toString(),targetDir);
            }
        }
    }
    //test finish success


    @Override
    public double getSpace() {
        FileSystem fileSystem = this.getFileSystem();
        Path p = new Path("/");
        ContentSummary contentSummary = null;
        try {
            contentSummary = fileSystem.getContentSummary(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
//集群占用空间, 一般来说是实际占用空间的几倍, 具体与配置的副本数相关.
        long clusterSpace = contentSummary.getSpaceConsumed();
//实际占用空间
        long actualSpace = contentSummary.getLength();
        System.out.println(clusterSpace+" "+actualSpace);
        return (double)((actualSpace*100)/clusterSpace);
    }
    //test finish success


}
