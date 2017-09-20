package com.book.service;

import com.book.entity.BookItem;
import com.book.entity.Books;

import java.awt.print.Book;
import java.util.List;

public interface BookInfoService {
    public List<Books> getAllBookInfo();
    public List<Books> getAllBookInfoByStPage(int stPage);
    public Books getBookInfoById(int bid);
    public List<Books> getAllBookInfoByCates(int cate);
    public List<Books> searchForBookInfo(String searchStr);
    public int addOneBook(BookItem bk);
    public List<Books> searchByCond(String cond, String searchStr);
    public void deleteByCateService(int cateId);
    public void updateBook(BookItem bk);
    public BookItem getBkItemById(int bkid);
    public void deleteBookById(int bkid);
}
