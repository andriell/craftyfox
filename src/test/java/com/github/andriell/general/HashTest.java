package com.github.andriell.general;

import org.junit.Test;
import org.springframework.util.DigestUtils;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rybalko on 13.07.2016.
 */
public class HashTest {
    @Test
    public void test() {
        String txt = "Hello World";
        assertEquals("b10a8db164e0754105b7a99be72e3fe5", DigestUtils.md5DigestAsHex(txt.getBytes()));
        assertEquals("8b1a9953c4611296a827abf8c47804d7", DigestUtils.md5DigestAsHex("Hello".getBytes()));
    }
}
