package com.github.andriell.nashorn.informer;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.SkypeBuilder;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Rybalko on 22.09.2016.
 */
public class InformerSkype implements InitializingBean {
    private Skype skype;
    private String login;
    private String password;

    public void setUsername(String username) {
        this.login = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void connect() throws Exception {
        skype = new SkypeBuilder(login, password).withAllResources().build();
        skype.login();
        skype.subscribe();
    }

    public void afterPropertiesSet() throws Exception {
        connect();
    }

    public Skype getSkype() {
        return skype;
    }

    public boolean sendMessage(String username, String message) {
        try {
            skype.getOrLoadContact(username)
                    .getPrivateConversation()
                    .sendMessage(message);
            return true;
        } catch (Exception e) {
            try {
                connect();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return false;
    }
}
