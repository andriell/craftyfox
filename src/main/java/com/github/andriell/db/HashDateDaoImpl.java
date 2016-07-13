package com.github.andriell.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * Created by Rybalko on 13.07.2016.
 */
public class HashDateDaoImpl implements HashDateDao {
    private SessionFactory sessionFactory;


    public HashDate find(String str) {
        Session session = sessionFactory.openSession();
        List<HashDate> products = session.createQuery("from HashDate where c_hash=:hash")
                .setParameter("hash", DigestUtils.md5DigestAsHex(str.getBytes()))
                .list();
        session.close();
        if (products.size() > 0) {
            return products.get(0);
        } else {
            return null;
        }
    }

    public boolean checkSec(String str, int sec) {
        HashDate hashDate = find(str);

        if (hashDate == null) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            HashDate hashDate2 = new HashDate();
            hashDate2.setString(str);
            hashDate2.setDate(System.currentTimeMillis());
            session.save(hashDate2);
            transaction.commit();
            session.close();
            return true;
        }
        if (hashDate.getDate() + sec * 1000 > System.currentTimeMillis()) {
            return false;
        }
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        hashDate.setDate(System.currentTimeMillis());
        session.update(hashDate);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean checkMinute(String str, int i) {
        return checkSec(str, i * 60);
    }

    public boolean checkHour(String str, int i) {
        return checkSec(str, i * 3600);
    }

    public boolean checkDay(String str, int i) {
        return checkSec(str, i * 86400);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
