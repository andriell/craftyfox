package com.github.andriell.processor;

import java.util.Collection;

/**
 * Created by Rybalko on 06.04.2016.
 */
public interface ProcessorInterface {
    void setManagers(Iterable<ManagerInterface> managers);
    Collection<ManagerInterface> getManagers();
    ManagerInterface getManager(String processBeanId);
}
