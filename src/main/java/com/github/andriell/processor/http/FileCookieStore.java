package com.github.andriell.processor.http;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.springframework.beans.factory.InitializingBean;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Rybalko on 14.04.2016.
 */
public class FileCookieStore implements CookieStore, FileCookieStoreInterface, InitializingBean {
    private BasicCookieStore cookieStore;
    private File file;

    public void afterPropertiesSet() throws Exception {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream oin = new ObjectInputStream(fis);
            cookieStore = (BasicCookieStore) oin.readObject();
        } catch (IOException e) {
            cookieStore = new BasicCookieStore();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            cookieStore = new BasicCookieStore();
            e.printStackTrace();
        }
    }

    public void saveCookie() {
        synchronized (this) {
            try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(cookieStore);
                oos.flush();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addCookie(Cookie cookie) {
        cookieStore.addCookie(cookie);
    }

    public List<Cookie> getCookies() {
        return cookieStore.getCookies();
    }

    public boolean clearExpired(Date date) {
        return cookieStore.clearExpired(date);
    }

    public void clear() {
        cookieStore.clear();
    }
}
