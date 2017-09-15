package com.book.action;

import com.book.entity.Categories;
import com.book.service.CategoriesService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;

import java.util.List;
import java.util.Map;

public class BookInfoAction extends ActionSupport implements RequestAware {
    CategoriesService categoriesService;

    public CategoriesService getCategoriesService() {
        return categoriesService;
    }

    public void setCategoriesService(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }
    Map<String, Object> request;
    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }

    public String list() throws Exception {
        List<Categories> categoriesList = categoriesService.getAllCates();
        if (categoriesList.size() > 0) {
            request.put("categoriesList", categoriesList);
        }
        return "index";
    }
}
