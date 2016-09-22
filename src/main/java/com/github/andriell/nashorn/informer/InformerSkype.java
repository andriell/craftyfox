package com.github.andriell.nashorn.informer;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.SkypeBuilder;
import com.samczsun.skype4j.exceptions.ConnectionException;
import com.samczsun.skype4j.exceptions.InvalidCredentialsException;
import com.samczsun.skype4j.exceptions.NotParticipatingException;
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

    public void afterPropertiesSet() throws Exception {
        skype = new SkypeBuilder(login, password).withAllResources().build();
        skype.login();
        skype.subscribe();
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
                skype.login();
            } catch (InvalidCredentialsException e1) {
                e1.printStackTrace();
            } catch (ConnectionException e1) {
                e1.printStackTrace();
            } catch (NotParticipatingException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return false;
    }
}
