package com.book.dao;

import com.book.entity.Users;

import java.util.List;

public interface UsersDAO {
    public List<Users> search(Users cond);
}
