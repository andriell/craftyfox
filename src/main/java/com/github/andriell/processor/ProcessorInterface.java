package com.github.andriell.processor;

/**
 * Created by Rybalko on 06.04.2016.
 */
public interface ProcessorInterface {
    void setManagers(Iterable<ManagerInterface> managers);
    Iterable<ManagerInterface> getManagers();
    ManagerInterface getManager(String processBeanId);
}
