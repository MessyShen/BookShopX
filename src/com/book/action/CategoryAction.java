package com.book.action;

import com.book.entity.Books;
import com.book.entity.Categories;
import com.book.service.BookInfoService;
import com.book.service.CategoriesService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;

import java.util.List;
import java.util.Map;

public class CategoryAction extends ActionSupport implements RequestAware {

    CategoriesService categoriesService;

    public CategoriesService getCategoriesService() {
        return categoriesService;
    }

    public void setCategoriesService(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    BookInfoService bookInfoService;

    public BookInfoService getBookInfoService() {
        return bookInfoService;
    }

    public void setBookInfoService(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    Map<String, Object> request;
    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    String cateName;

    public String addCateAction() throws Exception {
        categoriesService.addCate(cateName);
        return "added";
    }


}
