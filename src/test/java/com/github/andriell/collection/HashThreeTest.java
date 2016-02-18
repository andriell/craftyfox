package com.github.andriell.collection;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vika on 13.02.2016
 */
public class HashThreeTest {
    public static void main(String[] args) {
        HashThreeTest test = new HashThreeTest();
        test.test1();
    }

    @Test
    public void test1() {
        ObjectTest test1 = new ObjectTest(0);
        ObjectTest test2 = new ObjectTest(101);
        ObjectTest test3 = new ObjectTest(102);
        ObjectTest test4 = new ObjectTest(-103);

        HashThree<ObjectTest> three = new HashThree<ObjectTest>();
        assertEquals(0, three.getSize());
        assertEquals(true, three.add(test1));
        assertEquals(1, three.getSize());
        assertEquals(true, three.add(test2));
        assertEquals(2, three.getSize());
        assertEquals(true, three.add(test3));
        assertEquals(3, three.getSize());
        assertEquals(true, three.add(test4));
        assertEquals(4, three.getSize());

        assertEquals(false, three.add(test1));
        assertEquals(false, three.add(test2));
        assertEquals(false, three.add(test3));
        assertEquals(false, three.add(test4));

        assertEquals(true, three.replace(test1));
        assertEquals(true, three.replace(test2));
        assertEquals(true, three.replace(test3));
        assertEquals(true, three.replace(test4));
        three.remove(test2);
        //assertEquals(true, three.exist(test2));
        //assertEquals(true, three.remove(test2));
        //assertEquals(false, three.remove(test2));

        assertEquals(true, three.exist(test1));
        //assertEquals(false, three.exist(test2));
        assertEquals(true, three.exist(test3));
        assertEquals(true, three.exist(test4));
        System.out.println(three);
    }

    private class ObjectTest {
        private int hashCode;

        public ObjectTest(int hashCode) {
            this.hashCode = hashCode;
        }

        @Override
        public int hashCode() {
            return hashCode;
        }

        @Override
        public String toString() {
            return Integer.toString(hashCode);
        }
    }
}
