package com.book.service.impl;

import com.book.dao.BookInfoDAO;
import com.book.entity.BookItem;
import com.book.entity.Books;
import com.book.service.BookInfoService;

import java.util.List;

public class BookInfoServiceImpl implements BookInfoService {
    public BookInfoDAO getBookInfoDAO() {
        return bookInfoDAO;
    }

    public void setBookInfoDAO(BookInfoDAO bookInfoDAO) {
        this.bookInfoDAO = bookInfoDAO;
    }

    BookInfoDAO bookInfoDAO;

    @Override
    public List<Books> getAllBookInfo() {
        return bookInfoDAO.getAll();
    }

    @Override
    public Books getBookInfoById(int bid) {
        return bookInfoDAO.getBookInfoById(bid);
    }

    @Override
    public List<Books> getAllBookInfoByStPage(int stPage) {
        return bookInfoDAO.getAllByStId(stPage);
    }

    public List<Books> getAllBookInfoByCates(int cate) {
        return bookInfoDAO.getAllByCates(cate);
    }

    public List<Books> searchForBookInfo(String searchStr) {
        return bookInfoDAO.getAllBySearch(searchStr);
    }

    public int addOneBook(BookItem bk){
        return bookInfoDAO.addOneBook(bk);
    }
}
