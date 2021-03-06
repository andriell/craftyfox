package com.samczsun.skype4j;

/*
 * Copyright 2015 Sam Sun <me@samczsun.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import com.samczsun.skype4j.chat.GroupChat;
import com.samczsun.skype4j.events.chat.user.action.OptionUpdateEvent;
import com.samczsun.skype4j.exceptions.ConnectionException;
import com.samczsun.skype4j.formatting.Message;
import com.samczsun.skype4j.formatting.Text;
import com.samczsun.skype4j.internal.StreamUtils;
import com.samczsun.skype4j.user.User;

import java.io.FileInputStream;

public class Example {
    public static void main(String[] args) throws Exception {
        try {
            String[] data = StreamUtils.readFully(new FileInputStream("C:\\credentials")).split(":");
            Skype skype = new SkypeBuilder(data[0], data[1]).withAllResources().build();
            skype.login();
            System.out.println("Logged in");

            skype.subscribe();
            System.out.println("Subscribed");
            GroupChat groupChat = (GroupChat) skype.createGroupChat(skype.getOrLoadContact("echo123"));
            groupChat.sendMessage("Hello!");
            groupChat.sendMessage(Message.create().with(Text.rich("Created with Skype4J").withBold()));
            groupChat.setTopic("Topic!");
            groupChat.setOptionEnabled(OptionUpdateEvent.Option.HISTORY_DISCLOSED, true);
            groupChat.setOptionEnabled(OptionUpdateEvent.Option.JOINING_ENABLED, true);
            groupChat.getUser("echo123").setRole(User.Role.ADMIN);
            Thread.sleep(1000);
            groupChat.kick("echo123");
            System.out.println("Join url: " + groupChat.getJoinUrl());
            Thread.sleep(1000);
            skype.logout();
            System.out.println("Logged out");
        } catch (ConnectionException e) {
            System.out.println(e.getMessage() + ", " + e.getResponseCode() + ", " + e.getResponseMessage());
            e.printStackTrace();
        }
    }
}