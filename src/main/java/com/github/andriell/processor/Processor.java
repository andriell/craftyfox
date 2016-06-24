package com.github.andriell.processor;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Rybalko on 06.04.2016.
 */
public class Processor implements ProcessorInterface {
    private HashMap<String, ManagerInterface> managers = new HashMap<String, ManagerInterface>();

    public boolean add(DataInterface data) {
        return add(data.getProcessBeanId(), data);
    }

    public boolean add(String processBeanId, Object data) {
        ManagerInterface manager = getManager(processBeanId);
        if (manager == null) {
            return false;
        }
        return manager.addData(data);
    }

    public Collection<ManagerInterface> getManagers() {
        return this.managers.values();
    }

    public void setManagers(Collection<ManagerInterface> managers) {
        for (ManagerInterface manager:managers) {
            this.managers.put(manager.getProcessBeanId(), manager);
        }
    }

    public ManagerInterface getManager(String processBeanId) {
        return this.managers.get(processBeanId);
    }
}
