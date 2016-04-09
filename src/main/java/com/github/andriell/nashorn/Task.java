package com.github.andriell.nashorn;

import com.github.andriell.processor.ManagerInterface;
import com.github.andriell.processor.ProcessorInterface;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

/**
 * Created by Vika on 03.04.2016
 */
public class Task {
    ProcessorInterface processor;

    public boolean add(String processBeanId, ScriptObjectMirror data) {
        ManagerInterface manager = processor.getManager(processBeanId);
        if (manager == null) {
            return false;
        }
        return manager.addData(data);
    }

    public ProcessorInterface getProcessor() {
        return processor;
    }

    public void setProcessor(ProcessorInterface processor) {
        this.processor = processor;
    }
}
