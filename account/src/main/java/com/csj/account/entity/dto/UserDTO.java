package com.csj.account.entity.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="User对象", description = "form-data 格式")
public class UserDTO {
    private  String username;
    private String password;
    private String email;
}
