package com.github.andriell;

import com.github.andriell.processor.RunnableLimiter;
import sun.plugin2.jvm.ProcessLauncher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Vika on 07.02.2016
 */
public class Executor {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 10; i++) {
            service.submit(new Runnable() {
                public void run() {
                    RunnableLimiter.sleep(1000);
                    System.out.println(123);
                }
            });
        }
        service.shutdown();
    }

}
