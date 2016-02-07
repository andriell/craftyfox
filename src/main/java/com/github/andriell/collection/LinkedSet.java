package com.github.andriell.collection;

import java.util.Iterator;

/**
 * Created by Vika on 06.02.2016
 */
public class LinkedSet<T> implements Iterable<T> {
    private Node root;
    private Node end;
    private int size = 0;

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

    public boolean addFirst(T v) {
        synchronized (this) {
            if (contains(v)) {
                return false;
            }
            root = new Node(v, root);
            size++;
        }
        return true;
    }

    public boolean addEnd(T v) {
        synchronized (this) {
            if (contains(v)) {
                return false;
            }
            if (root == null) {
                root = new Node(v, null);
                end = root;
            } else {
                end.next = new Node(v, null);
                end = end.next;
            }
            size++;
        }
        return true;
    }

    public boolean remove(Object o) {
        synchronized (this) {
            Node position = root;
            Node prev = null;
            while (position != null) {
                if (position.value.equals(o)) {
                    if (prev == null) {
                        root = position.next;
                    } else {
                        prev.next = position.next;
                    }
                    size--;
                    return true;
                }
                prev = position;
                position = position.next;
            }
            return false;
        }
    }

    public void clear() {
        root = null;
        end = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(Object o) {
        Node position = root;
        while (position != null) {
            if (position.value.equals(o)) {
                return true;
            }
            position = position.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(size() * 2 + 4);
        builder.append("[");
        Node position = root;
        while (true) {
            builder.append(position.value);
            if (position.next != null) {
                builder.append(", ");
            } else {
                break;
            }
            position = position.next;
        }
        builder.append("]");
        return builder.toString();
    }
}
