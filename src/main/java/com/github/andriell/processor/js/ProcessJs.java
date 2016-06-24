package com.github.andriell.processor.js;

import com.github.andriell.nashorn.Nashorn;
import com.github.andriell.processor.ProcessInterface;

import javax.script.ScriptException;

public class ProcessJs implements ProcessInterface {
    private ProcessJsDataInterface data;
    private Nashorn nashorn;

    public ProcessJsDataInterface getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = (ProcessJsDataInterface) data;
    }

    public Nashorn getNashorn() {
        return nashorn;
    }

    public void setNashorn(Nashorn nashorn) {
        this.nashorn = nashorn;
    }

    public void run() {
        try {
            nashorn.runProcess(getData());
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        data = null;
        nashorn = null;
    }
}
