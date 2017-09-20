package com.book.dao;

import com.book.entity.Users;

import java.util.List;

public interface UsersDAO {
    public List<Users> search(Users cond);
    public Users reg(Users userReg);
    public List<Users> getUsersByPage(int page);
    public void deleteById(int userId);
    public Users getById(int userId);
    public void setUserRole(int userId, int newRole);
}

