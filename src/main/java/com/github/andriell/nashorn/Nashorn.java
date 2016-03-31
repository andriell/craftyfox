package com.github.andriell.nashorn;

import com.github.andriell.general.Files;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.InitializingBean;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;

public class Nashorn implements InitializingBean {
    private ScriptEngine engine;

    public void afterPropertiesSet() throws Exception {
        reload();
    }

    public void reload() throws Exception {
        ScriptEngineManager factory = new ScriptEngineManager();
        engine = factory.getEngineByName("nashorn");

        File[] files = Files.readDir(Files.JS_DIR);
        String fileName;
        if (files != null) {
            for (File file: files) {
                if (!file.isFile()) {
                    continue;
                }
                fileName = file.getName();
                if (!fileName.endsWith(".js")) {
                    continue;
                }
                System.out.println();
                engine.eval(Files.readFile(file));
            }
        }

        files = Files.readDir(Files.CRAFT_DIR);
        if (files != null) {
            for (File file: files) {
                file = new File(file.getPath() + File.separator + "process.js");
                if (!file.isFile()) {
                    continue;
                }
                fileName = file.getName();
                if (!fileName.endsWith(".js")) {
                    continue;
                }
                engine.eval(Files.readFile(file));
            }
        }
    }

    public ScriptEngine getEngine() {
        return engine;
    }

    public Invocable getInvocable() {
        return (Invocable) engine;
    }

    public Object runProcess(String processName, Document document) throws ScriptException, NoSuchMethodException {
        return getInvocable().invokeFunction("craftyFoxRunProcess", processName, document);
    }
}
