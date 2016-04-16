package com.github.andriell.nashorn;

import com.github.andriell.general.Files;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.script.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Nashorn implements InitializingBean, ApplicationContextAware {
    private ApplicationContext applicationContext;
    private ScriptEngine engine;

    public void afterPropertiesSet() throws Exception {
        try {
            init();
        } catch (Exception e) { // Без этого приложение вообще не запустится при ошибках в JS
            e.printStackTrace();
        }
    }

    public void reload() throws Exception {
        init();
    }

    public void init() throws Exception {
        ScriptEngineManager factory = new ScriptEngineManager();
        engine = factory.getEngineByName("nashorn");

        //<editor-fold desc="Инжекциия">
        engine.getBindings(ScriptContext.ENGINE_SCOPE).put("app", applicationContext);
        //</editor-fold>

        //<editor-fold desc="Чтение статичных Js">
        File[] files = new File(Files.JS_DIR).listFiles();
        String fileName;
        if (files != null) {
            Arrays.sort(files);
            for (File file: files) {
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
        //</editor-fold>
    }

    public void loadProject(String projectName) throws Exception {
        loadProject(projectName, null, null);
    }

    public void loadProject(String projectName, String skipCraft, String jsCraft) throws Exception {
        String projectDirString = Files.PROJECTS_DIR + File.separator + projectName;
        File projectDir = new File(projectDirString);
        if (!projectDir.isDirectory()) {
            throw new IOException("Is not dir: " + projectDirString);
        }
        //<editor-fold desc="init.js">
        File initFile = new File(projectDirString + File.separator + "init.js");
        if (initFile.isFile()) {
            engine.eval(Files.readFile(initFile));
        }
        //</editor-fold>
        //<editor-fold desc="Чтение парсеров">
        File[] files = projectDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (skipCraft != null && skipCraft.equals(file.getName())) {
                    if (jsCraft != null) {
                        engine.eval(jsCraft);
                    }
                    continue;
                }
                file = new File(file.getPath() + File.separator + "process.js");
                if (!file.isFile()) {
                    continue;
                }
                if (!file.getName().endsWith(".js")) {
                    continue;
                }
                engine.eval(Files.readFile(file));
            }
        }
        //</editor-fold>
    }

    /**
     *
     * @param skipCraft - пропустить этот крафт
     * @param jsCraft - вместо него выполнить этот js
     * @throws Exception
     */
    public void reload(String skipCraft, String jsCraft) throws Exception {

    }

    public ScriptEngine getEngine() {
        return engine;
    }

    public Invocable getInvocable() {
        return (Invocable) engine;
    }

    public Object runProcess(String processName, Object data) throws ScriptException, NoSuchMethodException {
        return getInvocable().invokeFunction("nashornRunProcess", processName, data);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
