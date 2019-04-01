package com.lillink.parsefourtype.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private String userName;
    private String password;
    private enum  Roles{user,admin}
    private Roles roles;

    public User(String userName, String password, String roles){
        this.userName = userName;
        this.password = password;
        this.roles = Roles.valueOf(roles);

    }
}
