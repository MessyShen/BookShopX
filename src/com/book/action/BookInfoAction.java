package com.book.action;

import com.book.entity.Books;
import com.book.entity.Categories;
import com.book.service.BookInfoService;
import com.book.service.CategoriesService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;

import java.util.List;
import java.util.Map;

public class BookInfoAction extends ActionSupport implements RequestAware {
    int stPage;

    public int getStPage() {
        return stPage;
    }

    public void setStPage(int stPage) {
        this.stPage = stPage;
    }

    int cate;

    public int getCate() {
        return cate;
    }

    public void setCate(int cate) {
        this.cate = cate;
    }

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

    Books bk;

    public Books getBk() {
        return bk;
    }

    public void setBk(Books bk) {
        this.bk = bk;
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
        List<Books> booksList = bookInfoService.getAllBookInfo();
        if (booksList.size() > 0) {
            System.out.println("bookslist" + booksList.get(0).getPublishers().getName());
            request.put("booksList", booksList);
        }
        return "index";
    }

    public String show() throws Exception {
        List<Categories> categoriesList = categoriesService.getAllCates();
        if (categoriesList.size() > 0) {
            request.put("categoriesList", categoriesList);
        }
        //System.out.println("?+" + bk.getId());
        Books detailedBook = bookInfoService.getBookInfoById(bk.getId());
        request.put("detailedBook", detailedBook);
        return "show";
    }

    public String listBookByPage() throws Exception {
        request.remove("BOOKS_LIST");
        List<Books> booksList = bookInfoService.getAllBookInfoByStPage(stPage);
        request.put("BOOKS_LIST", booksList);
        return "list";
    }

    public String listBookByCates() throws Exception {
        List<Categories> categoriesList = categoriesService.getAllCates();
        if (categoriesList.size() > 0) {
            request.put("categoriesList", categoriesList);
        }

        request.remove("booksList");
        List<Books> booksList = bookInfoService.getAllBookInfoByCates(cate);

        request.put("cate", cate);
        request.put("booksList", booksList);
        if (booksList.size()>0) {
            request.put("cateName", booksList.get(0).getCategories().getName());
        }
        return "index";
    }


    public String listCate() throws Exception {
        List<Categories> categoriesList = categoriesService.getAllCates();
        if (categoriesList.size() > 0) {
            request.put("categoriesList", categoriesList);
        }
        return "list";
    }

    String searchInfo;

    public String getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(String searchInfo) {
        this.searchInfo = searchInfo;
    }

    public String searchBy() throws Exception {
        List<Categories> categoriesList = categoriesService.getAllCates();
        if (categoriesList.size() > 0) {
            request.put("categoriesList", categoriesList);
        }

        request.remove("booksList");
        List<Books> booksList = bookInfoService.searchForBookInfo(searchInfo);
        request.put("booksList", booksList);
        return "list";
    }


}
