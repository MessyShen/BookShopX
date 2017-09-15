package com.book.action;

import com.book.entity.Users;
import com.book.service.UsersService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import java.util.List;

@Controller
@Scope("prototype")
public class UserLoginAction extends ActionSupport {
    Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Autowired
    UsersService usersService;

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    public String doLogin() throws Exception {

        List<Users> usersList = usersService.login(users);
        System.out.println("searching " + users.getLoginId() + " " + users.getLoginPwd() +  " "
         + usersList.size());
        if (usersList.size() > 0) {
            return "index";
        } else {
            return "login";
        }
    }

}
