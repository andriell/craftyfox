package com.github.andriell.processor;

/**
 * Created by Andrey on 05.02.2016
 */
public interface RunnableListenerInterface {
    void onStart(Runnable r);
    void onException(Runnable r, Exception e);
    void onComplete(Runnable r);
}
