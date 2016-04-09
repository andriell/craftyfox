package com.github.andriell.nashorn;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by Vika on 09.04.2016
 */
public class TaskTest {
    public static void main(String[] args) throws Exception {
        new TaskTest().test1();
    }

    public void test1() throws Exception {
        Object1 object1 = new Object1();
        Class aClass = object1.getClass();
        System.out.println(aClass);
        System.out.println(Arrays.toString(aClass.getDeclaredFields()));
        Field field = aClass.getDeclaredField("name");
        field.setAccessible(true);
        field.set(object1, "1");
        System.out.println(object1);
    }

    class Object1 {
        private String name;
        private int size;
        private Object1 parent;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            System.out.println("setName");
            this.name = name;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Object1 getParent() {
            return parent;
        }

        public void setParent(Object1 parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Object1{" +
                    "name='" + name + '\'' +
                    ", size=" + size +
                    ", parent=" + parent +
                    '}';
        }
    }
}
