package com.csj.hadoop.utils;

import org.apache.hadoop.fs.FileStatus;

public class FileUtil {
    public static String[] WenDangSuffix= { "txt", "pdf", "doc", "docx", "xls",
            "xlsx", "ppt", "pptx","html","wps" };
    public static String[] PictureSuffix = {"bmp","gif","jpg","pic","png","tif"};
    public static String[] VoiceSuffix = {"wav","aif","au","mp3","ram"};
    public static String[] VideoSuffix = {"avi","mpg","mov","swf","mp4"};
    public static String[] YaSuoSuffix = {"rar","zip","arj","gz","z"};


    /*
    1:文档 2：图片 3：音乐 4：影片 5 压缩 6 其他
    int [10]
    */

    public static  int typeBySuffix(String suffix){
        for(String type:WenDangSuffix){
            if(suffix.equalsIgnoreCase(type)){
                return 1;
            }
        }
        for(String type:PictureSuffix){
            if(suffix.equalsIgnoreCase(type)){
                return 2;
            }
        }
        for(String type:VoiceSuffix){
            if(suffix.equalsIgnoreCase(type)){
                return 3;
            }
        }
        for(String type:VideoSuffix){
            if(suffix.equalsIgnoreCase(type)){
                return 4;
            }
        }
        for(String type:YaSuoSuffix){
            if(suffix.equalsIgnoreCase(type)){
                return 5;
            }
        }
        return 6;



    }

    public static FileStatus[] sort(FileStatus[] fileStatuses){
        int len = fileStatuses.length;
        if(len<1){
            return fileStatuses;
        }
        for (int i = 0; i < len; ++i) {
            // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            boolean flag = false;
            for (int j = 0; j < len - i - 1; ++j) {
                if(!fileStatuses[j].isDirectory()&&fileStatuses[j+1].isDirectory()){
                    FileStatus temp = fileStatuses[j];
                    fileStatuses[j] = fileStatuses[j+1];
                    fileStatuses[j+1] = temp;
                    flag =true;
                }

            }
            if(!flag){
                break;
            }
        }
        return fileStatuses;
    }


    public static  boolean idDir(String path){
        String filename = path.substring(path.lastIndexOf("/")+1);
        return !filename.contains(".");
    }

    public static String getSuffix(String path){
        String filename = path.substring(path.lastIndexOf("/")+1);
        return filename.substring(filename.indexOf(".")+1);
    }

    public static int typeByPath(String path){
        return typeBySuffix(getSuffix(path));
    }

}
