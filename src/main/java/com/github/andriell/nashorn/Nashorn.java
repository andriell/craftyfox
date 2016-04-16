package com.github.andriell.nashorn;

import com.github.andriell.general.Files;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.script.*;
import java.io.File;
import java.util.Arrays;

public class Nashorn implements InitializingBean, ApplicationContextAware {
    private ApplicationContext applicationContext;
    private ScriptEngine engine;

    public void afterPropertiesSet() throws Exception {
        try {
            reload();
        } catch (Exception e) { // Без этого приложение вообще не запустится при ошибках в JS
            e.printStackTrace();
        }
    }

    public void reload() throws Exception {
        reload(null, null);
    }

    /**
     *
     * @param skipCraft - пропустить этот крафт
     * @param jsCraft - вместо него выполнить этот js
     * @throws Exception
     */
    public void reload(String skipCraft, String jsCraft) throws Exception {
        ScriptEngineManager factory = new ScriptEngineManager();
        engine = factory.getEngineByName("nashorn");

        //<editor-fold desc="Инжекциия">
        engine.getBindings(ScriptContext.ENGINE_SCOPE).put("app", applicationContext);
        //</editor-fold>

        //<editor-fold desc="Чтение статичных Js">
        File[] files = Files.readDir(Files.JS_DIR);
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
                System.out.println();
                engine.eval(Files.readFile(file));
            }
        }
        //</editor-fold>

        //<editor-fold desc="Чтение парсеров">
        files = Files.readDir(Files.CRAFT_DIR);
        if (files != null) {
            Arrays.sort(files);
            for (File file: files) {
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
                fileName = file.getName();
                if (!fileName.endsWith(".js")) {
                    continue;
                }
                engine.eval(Files.readFile(file));
            }
        }
        //</editor-fold>
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
