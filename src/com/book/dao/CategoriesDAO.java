package com.book.dao;

import com.book.entity.Categories;

import java.util.List;

public interface CategoriesDAO {
    public List<Categories> getAll();//change this name!!
    public int addCate(String cateName);
}
