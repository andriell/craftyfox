package com.github.andriell.processor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Rybalko on 06.04.2016.
 */
public class Processor implements ProcessorInterface, ApplicationContextAware {
    private HashMap<String, ManagerInterface> managers = new HashMap<String, ManagerInterface>();
    private ApplicationContext applicationContext;

    public void setManagers(Iterable<ManagerInterface> managers) {
        for (ManagerInterface manager:managers) {
            this.managers.put(manager.getProcessBeanId(), manager);
            new Thread(manager).start();
        }
    }

    public Collection<ManagerInterface> getManagers() {
        return this.managers.values();
    }

    public ManagerInterface getManager(String processBeanId) {
        return this.managers.get(processBeanId);
    }

    public Object newData(String processBeanId) {
        ManagerInterface manager = getManager(processBeanId);
        if (manager == null) {
            return null;
        }
        return applicationContext.getBean(manager.getDataBeanId());
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
