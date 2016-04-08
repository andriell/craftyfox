package com.github.andriell.processor;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Rybalko on 06.04.2016.
 */
public class Processor implements ProcessorInterface {
    private HashMap<String, ManagerInterface> managers = new HashMap<String, ManagerInterface>();

    public void setManagers(Iterable<ManagerInterface> managers) {
        for (ManagerInterface manager:managers) {
            this.managers.put(manager.getProcessBeanId(), manager);
        }
    }

    public Collection<ManagerInterface> getManagers() {
        return this.managers.values();
    }

    public ManagerInterface getManager(String processBeanId) {
        return this.managers.get(processBeanId);
    }
}
