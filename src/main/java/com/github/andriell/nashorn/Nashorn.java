package com.github.andriell.nashorn;

import com.github.andriell.general.Files;

import org.springframework.beans.factory.InitializingBean;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;

public class Nashorn implements InitializingBean {
    private ScriptEngine engine;

    public void afterPropertiesSet() throws Exception {
        ScriptEngineManager factory = new ScriptEngineManager();
        engine = factory.getEngineByName("nashorn");

        File folder = new File(Files.JS_DIR);
        File[] files = folder.listFiles();
        String fileName;
        if (files != null) {
            for (File file: files) {
                if (!file.isFile()) {
                    continue;
                }
                fileName = file.getName();
                if (".js".equals(fileName.substring(fileName.length() - 3, 3))) {
                    continue;
                }
                engine.eval(Files.readFile(file));
            }
        }

        folder = new File(Files.CRAFT_DIR);
        files = folder.listFiles();
        if (files != null) {
            for (File file: files) {
                file = new File(file.getPath() + File.separator + "process.js");
                if (!file.isFile()) {
                    continue;
                }
                fileName = file.getName();
                if (".js".equals(fileName.substring(fileName.length() - 3, 3))) {
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
}
