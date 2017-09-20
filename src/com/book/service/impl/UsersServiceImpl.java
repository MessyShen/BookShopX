package com.book.service.impl;

import com.book.dao.UsersDAO;
import com.book.entity.Users;
import com.book.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersDAO usersDAO;

    public void setUsersDAO(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public List<Users> login(Users cond) {
        return usersDAO.search(cond);
    }

    @Override
    public Users reg(Users userReg) {
        return usersDAO.reg(userReg);
    }

    @Override
    public List<Users> getUsersByPageService(int page) {
        return usersDAO.getUsersByPage(page);
    }

    @Override
    public void deleteById(int userId) {
        usersDAO.deleteById(userId);
    }

    public void setUserRole(int userId, int newRole) {usersDAO.setUserRole(userId, newRole);}
}
