package com.book.dao.impl;

import com.book.dao.BookInfoDAO;
import com.book.entity.BookItem;
import com.book.entity.Books;
import com.book.entity.Categories;
import com.book.entity.Publishers;
import org.hibernate.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookInfoDAOImpl implements BookInfoDAO {
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    SessionFactory sessionFactory;

    @Override
    public List<Books> getAll() {
        Session session = sessionFactory.getCurrentSession();
        String sql="from Books";
        Query query=session.createQuery(sql);
        query.setMaxResults(18);
        List<Books> bkiList = query.list();
//        System.out.println("Book list size: ");
        return bkiList;
    }

    public Books getBookInfoById(int bid){
        Session session = sessionFactory.getCurrentSession();
       // System.out.println("??");
        return (Books)session.get(Books.class, bid);
    }

//    public BookItem getBookItemById(int bkid){
//        Session session = sessionFactory.getCurrentSession();
//    }


    @Override
    public List<Books> getAllByStId(int stPage) {
//        if (stPage == 0) stPage = 1;
//        Session session = sessionFactory.getCurrentSession();
//        String sql="from Books";
//        Query query=session.createQuery(sql);
//        query.setFirstResult((stPage - 1) * 10);
//        query.setMaxResults(30);
//        List<Books> bkiList = query.list(); //book info list
//        return bkiList;
        if (stPage <= 0) stPage = 1;
        int pageSize = 15;
        String sql="from Books";
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery(sql);
//        query.setFirstResult(0);
        query.setMaxResults(100);
        List<Books> booksList = query.list();
        List<Books> booksList2 = new ArrayList<Books>();
        //Iterator itor = booksList.iterator();
        int i = 0;
        int start = (stPage - 1) * pageSize;
        int end = (stPage) * pageSize;
        for (i = start; i < end; ++i) {
            if (i >= 0 && i < booksList.size()) {
                booksList2.add(booksList.get(i));
               // System.out.println(booksList.get(i).getTitle());
            } else break;
        }
        return booksList2;
    }

    @Override
    public List<Books> getAllByCates(int cate) {
        Session session = sessionFactory.getCurrentSession();
        String sql="from Books b where b.categoryId=?";

        Query query=session.createQuery(sql);
        query.setParameter(0, cate);
        query.setMaxResults(50);
        System.out.println("???" + cate);
        List<Books> bkiList = query.list();
//        System.out.println("Book list size: ");
        return bkiList;
    }

    @Override
    public List<Books> getAllBySearch(String searchStr) {
        Session session = sessionFactory.getCurrentSession();
        String sql="from Books b where b.title like :bname ";
        Query query=session.createQuery(sql);
        query.setString("bname", "%"+searchStr+"%");
        List<Books> bkiList = query.list();

        sql="from Books b where b.publishers.name like :pname ";
        query=session.createQuery(sql);
        query.setString("pname","%"+searchStr+"%");
        List<Books> bkiList2 = query.list();
        bkiList.removeAll(bkiList2);
        bkiList.addAll(bkiList2);

        sql="from Books b where b.categories.name like :cname ";
        query=session.createQuery(sql);
        query.setString("cname","%"+searchStr+"%");
        bkiList2 = query.list();
        bkiList.removeAll(bkiList2);
        bkiList.addAll(bkiList2);

        return bkiList;
    }

    public int addOneBook(BookItem bk){
        System.out.println("At DAO:  " + bk.getIsbn() + " ||| "+ bk.getCategoryId());
        Session session = sessionFactory.getCurrentSession();
        //Transaction tran = session.beginTransaction();
        int ret = (Integer) session.save(bk);
        //tran.commit();
        return ret;
    }

    @Override
    public List<Books> getAllByCondition(String condition, String searchStr) {
        Session session = sessionFactory.getCurrentSession();
        String sql="from Books";
        Query query;
        if (condition.equals("title")) {
            sql="from Books b where b.title like :bname ";
            query = session.createQuery(sql);
            query.setString("bname","%"+searchStr+"%");
        } else if (condition.equals("author")) {
            sql="from Books b where b.author like :bname";
            query = session.createQuery(sql);
            query.setString("bname","%"+searchStr+"%");
        } else if (condition.equals("isbn")) {
            sql="from Books b where b.isbn like :bname";
            query = session.createQuery(sql);
            query.setString("bname","%"+searchStr+"%");
        } else {
            sql="from Books";
            query = session.createQuery(sql);
        }
        List<Books> bkiList = query.list();
        return bkiList;
    }

    @Override
    public void deleteByCate(int cateId) {
        Session session = sessionFactory.getCurrentSession();
        String sql="from Categories c where c.id=?";
        Query query = session.createQuery(sql);
        query.setParameter(0, cateId);
        Categories cate = null;
        List list = query.list();
        Iterator iteator = list.iterator();
        if(iteator.hasNext()) {
            cate = (Categories) iteator.next();
        }
        session.delete(cate);
    }

    public void deleteBookById(int bookId){
        Session session = sessionFactory.getCurrentSession();
        String sql="from Books b where b.id=?";
        Query query = session.createQuery(sql);
        query.setParameter(0, bookId);
        Books bookItem = null;
        List list = query.list();
        Iterator iteator = list.iterator();
        if(iteator.hasNext()) {
            bookItem = (Books) iteator.next();
        }
        session.delete(bookItem);
    }

    @Override
    public void modifyBook(BookItem book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
    }

    @Override
    public BookItem getBkItemById(int bid) {
        Session session = sessionFactory.getCurrentSession();
        // System.out.println("??");
        return (BookItem)session.get(BookItem.class, bid);
    }
}
