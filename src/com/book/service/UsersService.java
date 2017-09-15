package com.book.service;

import com.book.entity.Users;

import java.util.List;

public interface UsersService {
    public List<Users> login(Users cond);
}
