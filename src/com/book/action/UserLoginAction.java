package com.book.action;

import com.book.entity.Users;
import com.book.service.UsersService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
public class UserLoginAction extends ActionSupport implements SessionAware {
    Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    int pageID;

    public int getPageID() {
        return pageID;
    }

    public void setPageID(int pageID) {
        this.pageID = pageID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    int userId;

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    int role;

    @Autowired
    UsersService usersService;

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }


    Map<String, Object> session;
    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;
    }

    public String doLogin() throws Exception {

        List<Users> usersList = usersService.login(users);
//        System.out.println("searching " + users.getLoginId() + " " + users.getLoginPwd() +  " "
//         + usersList.size());
        if (usersList.size() > 0) {
            session.put("CURRENT_USER",usersList.get(0));
            return "index";
        } else {
            return "login";
        }
    }

    public String doRegister() throws Exception {
        Users user = usersService.reg(users);
        if (user != null) {
            session.put("CURRENT_USER", user);
            return "index";
        } else {
            return "register";
        }
    }

    public String logOut(){
        Users user=(Users)session.get("CURRENT_USER");
        if (user!=null) {
            session.remove("CURRENT_USER");
        }
        return "index";

    }

    public String usersListByPage(){
        List<Users> usersList = usersService.getUsersByPageService(pageID);
        if (usersList.size() > 0) {
          //  System.out.println("Putting Users List");
            session.put("USERS_LIST", usersList);
        }
        return "list";

    }


    public String usersListByPageState(){
        List<Users> usersList = usersService.getUsersByPageService(pageID);
        if (usersList.size() > 0) {
          //  System.out.println("Putting Users List");
            session.put("USERS_LIST", usersList);
        }
        return "list";
    }


    public String deleteById(){
        usersService.deleteById(users.getId());
        return "list";
    }


    public String setUserRole(){
        usersService.setUserRole(userId, role);
        return "success";
    }

}
