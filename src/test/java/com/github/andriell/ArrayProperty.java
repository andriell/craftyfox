package com.github.andriell;

import com.github.andriell.processor.Manager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by Andrey on 03.04.2016
 */
public class ArrayProperty {
    private ArrayProperty[] properties;
    private String name;

    public void setProperties(ArrayProperty[] properties) {
        this.properties = properties;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayProperty[] getProperties() {
        return properties;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" + name + "=" + Arrays.toString(properties) + "}";
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:array-property.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();
        ArrayProperty manager = applicationContext.getBean("prop0", ArrayProperty.class);
        System.out.print(manager);
    }
}
