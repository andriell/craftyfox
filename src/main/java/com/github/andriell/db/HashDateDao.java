package com.github.andriell.db;

/**
 * Created by Rybalko on 13.07.2016.
 */
public interface HashDateDao {
    boolean checkSec(String str, int sec);
    boolean checkMinute(String str, int i);
    boolean checkHour(String str, int i);
    boolean checkDay(String str, int i);
    void update(String str);
}
