package com.github.andriell.processor;

import java.util.HashMap;

/**
 * Created by Андрей on 04.02.2016
 */
public class Processor {
    HashMap<String, ManagerInterface> managers = new HashMap<String, ManagerInterface>();

    public void addData(DataInterface data) {
        ManagerInterface manager = getManager(data.getProcessBeanId());
        manager.addData(data);
        manager.run();
    }

    private ManagerInterface getManager(String s) {
        synchronized (this) {
            ManagerInterface manager = managers.get(s);
            if (manager == null) {
                manager = new Manager();
                managers.put(s, manager);
            }
            return manager;
        }
    }
}
