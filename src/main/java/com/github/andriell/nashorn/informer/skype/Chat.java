package com.github.andriell.nashorn.informer.skype;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.chat.GroupChat;
import com.samczsun.skype4j.exceptions.ConnectionException;
import com.samczsun.skype4j.exceptions.InvalidCredentialsException;
import com.samczsun.skype4j.exceptions.NotParticipatingException;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Rybalko on 22.09.2016.
 */
public class Chat implements InitializingBean {
    private String name;
    private String[] contacts;
    private Connection connection;
    private GroupChat groupChat;

    public void setName(String name) {
        this.name = name;
    }

    public void setContacts(String[] contacts) {
        this.contacts = contacts;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void afterPropertiesSet() throws Exception {
        Skype skype = connection.getSkype();
        groupChat = skype.createGroupChat();
        for (String contact:contacts) {
            groupChat.add(skype.getOrLoadContact(contact));
        }
        groupChat.setTopic(name);
    }

    public boolean sendMessage(String message) {
        try {
            groupChat.sendMessage(message);
            return true;
        } catch (ConnectionException e) {
            try {
                connection.getSkype().login();
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
