package com.csj.hadoop.controller;


import com.csj.api.api.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.csj.hadoop.service.FileService;



@RestController
@RequestMapping("/file")
@Api(tags = "Hadoop文件管理")
@AllArgsConstructor
@Slf4j
public class FileController {

    @Autowired
    private  FileService fileService;

    @GetMapping("/mkdir/{path}")
    public Result<?> createDir(@PathVariable("path") String path) {
        System.out.println("0000");
        System.out.println(path);
        if(fileService.createDir(path)==1){
            return Result.success();
        }
        return Result.error("File Path Ilegal！！");
    }



    @GetMapping("/test")
    public Result<?> test(){
        System.out.println("111");
        return Result.success();
    }

}
