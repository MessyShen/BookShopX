package com.book.dao.impl;

import com.book.dao.UsersDAO;
import com.book.entity.Users;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.*;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Iterator;
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

        String sql="from Users u where u.loginId=? and u.loginPwd=?";
        Session session= sessionFactory.getCurrentSession();
        Query query=session.createQuery(sql);
        query.setParameter(0, cond.getLoginId()) ;
        query.setParameter(1, cond.getLoginPwd());
        List<Users> users=query.list();
        return users;
    }

    @Override
    public Users reg(Users userReg) {
        userReg.setUserRoleId(1);
        userReg.setUserStateId(1);
        Session session = sessionFactory.getCurrentSession();
        session.save(userReg);
        return userReg;
    }


    @Override
    public List<Users> getUsersByPage(int page) {
        if (page <= 0) page = 1;
        int pageSize = 15;
        String sql="from Users u order by u.id asc";
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery(sql);
        query.setFirstResult((page - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<Users> usersList = query.list();
//        System.out.println("size "+usersList.size());
        return usersList;
    }

    @Override
    public void deleteById(int userId) {
        Session session = sessionFactory.getCurrentSession();
        String sql="from Users u where u.id=?";
        Query query = session.createQuery(sql);
        query.setParameter(0, userId);
        Users user = null;
        List list = query.list();
        Iterator iteator = list.iterator();
        if(iteator.hasNext()) {
            user = (Users)iteator.next();
        }
        session.delete(user);
    }


    public Users getById(int userId){
        Session session = sessionFactory.getCurrentSession();
        String sql="from Users u where u.id=?";
        Query query = session.createQuery(sql);
        query.setParameter(0, userId);
        List<Users> list= query.list();
        return list.get(0);
    }


    @Override
    public void setUserRole(int userId, int newRole) {
        Session session = sessionFactory.getCurrentSession();
        Users user = getById(userId);
        user.setUserRoleId(newRole);
        session.update(user);
    }
}
