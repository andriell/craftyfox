package com.github.andriell.processor;

import com.github.andriell.nashorn.Nashorn;

import javax.script.ScriptException;

public class ProcessJs implements ProcessInterface {
    private ProcessJsData data;
    private Nashorn nashorn;
    public void setData(Object data) {
        this.data = (ProcessJsData) data;
    }

    public ProcessJsData getData() {
        return this.data;
    }

    public Nashorn getNashorn() {
        return nashorn;
    }

    public void setNashorn(Nashorn nashorn) {
        this.nashorn = nashorn;
    }

    public void run() {
        try {
            nashorn.runProcess(getData().getCraftName(), getData().getDocument());
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
