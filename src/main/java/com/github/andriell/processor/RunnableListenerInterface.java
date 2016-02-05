package com.github.andriell.processor;

/**
 * Created by Vika on 05.02.2016
 */
public interface RunnableListenerInterface {
    void onStart();
    void onException(Exception e);
    void onComplete();
}
