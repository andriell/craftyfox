package com.github.andriell.processor;

/**
 * Created by Андрей on 04.02.2016.
 */
public interface ProcessFactoryInterface<T extends TaskInterface, P extends ProcessInterface<T>> {
    public P newProcess(T task);
}
