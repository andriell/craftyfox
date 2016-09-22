package com.github.andriell.nashorn.informer.skype;

import com.samczsun.skype4j.exceptions.ConnectionException;
import com.samczsun.skype4j.exceptions.InvalidCredentialsException;
import com.samczsun.skype4j.exceptions.NotParticipatingException;

/**
 * Created by Rybalko on 22.09.2016.
 */
public class SkypeChat {
    private SkypeConnection connection;

    public void setConnection(SkypeConnection connection) {
        this.connection = connection;
    }

    public boolean sendMessage(String username, String message) {
        try {
            connection.getSkype()
                    .getOrLoadContact(username)
                    .getPrivateConversation()
                    .sendMessage(message);
            return true;
        } catch (Exception e) {
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
