package com.book.dao.impl;

import com.book.dao.UsersDAO;
import com.book.entity.Users;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

public class UsersDAOImpl implements UsersDAO {
    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public List<Users> search(Users cond) {

        String sql="from Users u where u.loginId=? and u.loginPwd=?";//HQL语句
        Session session= sessionFactory.getCurrentSession();
        Query query=session.createQuery(sql);
        query.setParameter(0, cond.getLoginId()) ;
        query.setParameter(1, cond.getLoginPwd());
        List<Users> users=query.list();

        System.out.println("searching " + cond.getLoginId() + " : " + users.size());
        return users;
    }
}
