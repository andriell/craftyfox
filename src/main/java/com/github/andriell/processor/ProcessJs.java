package com.github.andriell.processor;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ProcessJs implements ProcessInterface {
    private DataInterface data;
    private String script = "print('Hello, World!');";
    public void setData(DataInterface data) {
        this.data = data;
    }

    public DataInterface getData() {
        return this.data;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public void run() {
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a Nashorn script engine
        ScriptEngine engine = factory.getEngineByName("nashorn");
        // evaluate JavaScript statement
        try {
            engine.eval(script);
        } catch (final ScriptException se) { se.printStackTrace(); }
    }
}
