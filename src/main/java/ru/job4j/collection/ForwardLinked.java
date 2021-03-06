package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() {
        Node<T> temp;
        if (head == null) {
            throw new NoSuchElementException();
        }
        temp = head;
        head = head.next;
        return temp.value;
    }

    public T deleteLast() {
        Node<T> temp = head;
        Node<T> prev = temp;
        if (head == null) {
            throw new NoSuchElementException();
        }
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        T check = temp.value;
        prev.next = null;
        return check;
}

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

private static class Node<T> {
    T value;
    Node<T> next;


    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}
}
