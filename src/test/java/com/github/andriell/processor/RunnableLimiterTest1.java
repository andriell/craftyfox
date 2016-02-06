package com.github.andriell.processor;

/**
 * Created by Vika on 06.02.2016
 */
public class RunnableLimiterTest1 {
    public static void main(String[] args) {
        RunnableLimiter limiter = new RunnableLimiter(1);
        limiter.start(new TestProcess(new TestData()));
        System.out.println(1);
        limiter.start(new TestProcess(new TestData()));
        System.out.println(2);
        limiter.start(new TestProcess(new TestData()));
        System.out.println(3);
    }
}
