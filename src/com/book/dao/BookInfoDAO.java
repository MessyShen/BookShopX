package com.book.dao;

import com.book.entity.Books;
import java.util.List;

public interface BookInfoDAO {
    public List<Books> getAll();
    public Books getBookInfoById(int bid);
    public List<Books> getAllByStId(int stPage);
    public List<Books> getAllByCates(int cate);
    public List<Books> getAllBySearch(String searchStr);
    public int addOneBook(Books bk);
}
