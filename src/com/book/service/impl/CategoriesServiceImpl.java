package com.book.service.impl;

import com.book.dao.CategoriesDAO;
import com.book.entity.Categories;
import com.book.service.CategoriesService;

import java.util.ArrayList;
import java.util.List;

public class CategoriesServiceImpl implements CategoriesService {

    CategoriesDAO categoriesDAO;
    public CategoriesDAO getCategoriesDAO() {
        return categoriesDAO;
    }

    public void setCategoriesDAO(CategoriesDAO categoriesDAO) {
        this.categoriesDAO = categoriesDAO;
    }

    @Override
    public List<Categories> getAllCates() {
//        List<Categories> categoriesList = categoriesDAO.getAll();
//        for (Categories categories : categoriesList) {
//            List<String> type = new ArrayList<String>();
//            Object[] pis = categories.getPis
//        }
        return categoriesDAO.getAll();
    }
}
