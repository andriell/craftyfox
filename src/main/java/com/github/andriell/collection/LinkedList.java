package com.github.andriell.collection;

import java.util.Iterator;

/**
 * Created by Vika on 06.02.2016
 */
public class LinkedList<T> implements Iterable<T> {
    private Node root;
    private Node end;

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
            return position != null;
        }

        public T next() {
            T r = position.value;
            position = position.next;
            return r;
        }
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    public void add(T v) {
        synchronized (this) {
            // TODO Проверка на уникальность
            if (root == null) {
                root = new Node(v, null);
                end = root;
            } else {
                end.next = new Node(v, null);
                end = end.next;
            }
        }
    }

    public void remove(T v) {

    }

    public int size() {
        return 10;
    }
}
