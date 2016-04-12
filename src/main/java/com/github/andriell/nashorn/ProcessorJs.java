package com.github.andriell.nashorn;

import com.github.andriell.processor.ManagerInterface;
import com.github.andriell.processor.ProcessorInterface;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.lang.reflect.Method;

/**
 * Created by Vika on 03.04.2016
 */
public class ProcessorJs {
    ProcessorInterface processor;

    public boolean add(String processBeanId, Object data) {
        ManagerInterface manager = processor.getManager(processBeanId);
        if (manager == null) {
            return false;
        }
        return manager.addData(data);
    }

    public Object newData(String processBeanId) {
        return processor.newData(processBeanId);
    }

    public boolean add(String processBeanId, ScriptObjectMirror scriptObjectMirror) {
        ManagerInterface manager = processor.getManager(processBeanId);
        if (manager == null) {
            return false;
        }
        Object data = processor.newData(processBeanId);
        // TODO рефлексия для преобразования объекта ScriptObjectMirror в объект данных процесса
        //Method method = data.getClass().getDeclaredField();

        return manager.addData(data);
    }

    public ProcessorInterface getProcessor() {
        return processor;
    }

    public void setProcessor(ProcessorInterface processor) {
        this.processor = processor;
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
