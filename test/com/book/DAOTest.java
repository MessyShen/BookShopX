package com.book;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.book.entity.Books;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.book.entity.Users;

public class DAOTest {


    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        // 加载 hibernate.cfg.xml
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            // 根据 hibernate.cfg.xml 配置 ,初始化 SessionFactory
            sessionFactory = new MetadataSources(registry).buildMetadata()
                    .buildSessionFactory();
            // 创建 session
            session = sessionFactory.openSession();
            // 通过session开始事务
            transaction = session.beginTransaction();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @Test
    public void getCate(){
       // Session session = sessionFactory.getCurrentSession();
        String sql="from Books b where b.categoryId=?";
        Query query=session.createQuery(sql);
        query.setParameter(0, 1);
        query.setMaxResults(50);
        System.out.println(query);
        List<Books> bkiList = query.list();
        Iterator itor = bkiList.iterator();
        while(itor.hasNext()){
            System.out.println(((Books)itor.next()).getTitle());
        }
//        System.out.println("Book list size: ");
       // return bkiList;
    }
    /**
     * 添加数据
     */
    @Test
    public void find() {
        int page = 8;
        if (page <= 0) page = 1;
        int pageSize = 15;
        String sql="from Books";
//        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery(sql);
//        query.setFirstResult(0);
        query.setMaxResults(100);
        List<Books> booksList = query.list();
        List<Books> booksList2 = new ArrayList<Books>();
        //Iterator itor = booksList.iterator();
        int i = 0;
        int start = (page - 1) * pageSize;
        int end = (page) * pageSize;
        for (i = start; i < end; ++i) {
            if (i >= 0 && i < booksList.size()) {
                booksList2.add(booksList.get(i));
                System.out.println(booksList.get(i).getTitle());
            } else break;
        }


    }

    @Test
    public void search(){
        String searchStr = "9787111199731";
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

        sql="from Books b where b.isbn like :iname ";
        query=session.createQuery(sql);
        query.setString("iname","%"+searchStr+"%");
        bkiList2 = query.list();
        bkiList.removeAll(bkiList2);
        bkiList.addAll(bkiList2);


        Iterator itor = bkiList.iterator();

        while(itor.hasNext()){
            System.out.println(((Books)itor.next()).getTitle());
        }
    }
    @After
    public void destroy() {
        // 提交事务
        transaction.commit();
        // 关闭session
        session.close();
        // 关闭sessionFactory
        sessionFactory.close();
    }

}
