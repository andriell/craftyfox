package com.github.andriell.processor;

import com.github.andriell.nashorn.Nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ProcessJs implements ProcessInterface {
    private DataInterface data;
    private Nashorn nashorn;
    public void setData(DataInterface data) {
        this.data = data;
    }

    public ProcessJsData getData() {
        return (ProcessJsData) this.data;
    }

    public Nashorn getNashorn() {
        return nashorn;
    }

    public void setNashorn(Nashorn nashorn) {
        this.nashorn = nashorn;
    }

    public void run() {
        try {
            nashorn.getInvocable().invokeFunction("process.[\"" + getData().getProcessName() + "\"]", getData().getDocument());
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
