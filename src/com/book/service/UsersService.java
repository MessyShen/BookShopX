package com.book.service;

import com.book.entity.Users;

import java.util.List;

public interface UsersService {
    public List<Users> login(Users cond);
    public Users reg(Users userReg);
    public List<Users> getUsersByPageService(int page);
    public void deleteById(int userId);
}
