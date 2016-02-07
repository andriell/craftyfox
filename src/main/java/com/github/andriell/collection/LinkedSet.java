package com.github.andriell.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

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

    public boolean add(T v) {
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
                    return true;
                }
                prev = position;
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
}
