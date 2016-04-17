package com.github.andriell.processor;

import java.util.Collection;

/**
 * Created by Rybalko on 06.04.2016.
 */
public interface ProcessorInterface {
    void setManagers(Collection<ManagerInterface> managers);
    Collection<ManagerInterface> getManagers();
    ManagerInterface getManager(String processBeanId);
    boolean add(DataInterface data);
    boolean add(String processBeanId, Object data);
}
