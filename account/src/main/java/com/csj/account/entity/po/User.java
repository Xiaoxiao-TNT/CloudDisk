package com.csj.account.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class User {

    private  int userId;
    private  String username;
    private String password;
    private String email;
    private int permissions;


}
