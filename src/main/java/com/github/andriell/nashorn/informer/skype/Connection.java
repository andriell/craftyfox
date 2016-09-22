package com.github.andriell.nashorn.informer.skype;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.SkypeBuilder;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Rybalko on 22.09.2016.
 */
public class Connection implements InitializingBean {
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
    }

    public Skype getSkype() {
        return skype;
    }
}
