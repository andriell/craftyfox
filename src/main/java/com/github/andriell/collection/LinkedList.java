package com.github.andriell.collection;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Vika on 06.02.2016
 */
public class LinkedList<T> implements Iterable<T> {
    private Node root;

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class Node {
        T value;
        Node next;

        private Node(T v, Node n) {
            value = v;
            next = n;
        }
    }

    private class ListIterator implements Iterator<T> {
        Node position;

        public ListIterator() {
            position = root;
        }

        public boolean hasNext() {
            return position != null && position.next != null;
        }

        public T next() {
            position = position.next;
            return position.value;
        }
    }

    public void add(T v) {
        synchronized (this) {
            root = new Node(v, root);
        }
    }
}
