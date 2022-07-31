package com.csj.account.controller;

import com.csj.account.entity.dto.UserDTO;
import com.csj.account.entity.po.User;
import com.csj.account.service.UserService;
import com.csj.account.service.feign.HadoopServiceFeign;
import com.csj.api.api.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags = "Hadoop文件管理")
@AllArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    HadoopServiceFeign hadoopServiceFeign;


    @ApiOperation(value = "用户注册")
    @PostMapping
    public Result<String> addRole(@RequestBody UserDTO userDTO){
        User user = new User()
                .setUsername(userDTO.getUsername())
                .setPassword(userDTO.getPassword())
                .setEmail(userDTO.getEmail());
        System.out.println("==========");
        if(userService.findUserByUserName(user.getUsername())!=null){
            return Result.error("用户名重复");
        }
        if(userService.insert(user)!=0){
            //为用户创建私人文件夹和回收站
            hadoopServiceFeign.createDir("/"+user.getUsername()+"/"+"userspace");
            hadoopServiceFeign.createDir("/"+user.getUsername()+"/"+"recycle_bin");

            return Result.success();
        }
        return Result.error("注册失败");
    }

    @GetMapping("/test")
    public Result<?> test(){
        System.out.println("111");


        return Result.success();
    }








}
