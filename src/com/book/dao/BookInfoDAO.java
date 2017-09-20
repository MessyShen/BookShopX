package com.book.dao;

import com.book.entity.BookItem;
import com.book.entity.Books;
import java.util.List;

public interface BookInfoDAO {
    public List<Books> getAll();
    public Books getBookInfoById(int bid);
    public BookItem getBkItemById(int bid);
    public List<Books> getAllByStId(int stPage);
    public List<Books> getAllByCates(int cate);
    public List<Books> getAllBySearch(String searchStr);
    public List<Books> getAllByCondition(String condition, String searchStr);
    public int addOneBook(BookItem bk);
    public void deleteByCate(int cateId);
    public void modifyBook(BookItem bk);
    public void deleteBookById(int bookId);
}
