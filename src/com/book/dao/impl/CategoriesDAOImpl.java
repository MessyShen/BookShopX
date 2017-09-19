package com.book.dao.impl;

import com.book.dao.CategoriesDAO;
import com.book.entity.Categories;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CategoriesDAOImpl implements CategoriesDAO {
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    SessionFactory sessionFactory;

    @Override
    public List<Categories> getAll() {
        Session session = sessionFactory.getCurrentSession();
        String sql="from Categories";
        Query query=session.createQuery(sql);
        List<Categories> categories=query.list();
      //  System.out.println("catesize:" + categories.size());
        return categories;
    }
}
