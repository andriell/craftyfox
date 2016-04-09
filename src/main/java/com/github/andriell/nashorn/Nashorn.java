package com.github.andriell.nashorn;

import com.github.andriell.general.Files;

import com.github.andriell.nashorn.console.Console;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.InitializingBean;

import javax.script.*;
import java.io.File;

public class Nashorn implements InitializingBean {
    private JsItem[] jsItems;
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
        if (jsItems != null) {
            for (JsItem jsItem: jsItems) {
                engine.getBindings(ScriptContext.ENGINE_SCOPE).put(jsItem.getName(), jsItem.getObject());
            }
        }
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

    public void setJsItems(JsItem[] jsItems) {
        this.jsItems = jsItems;
    }
}
