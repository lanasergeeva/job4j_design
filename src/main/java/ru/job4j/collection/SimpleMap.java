package ru.job4j.collection;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Iterable<Node<K, V>> {
    private int modCount = 0;
    private int capacity = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int elements = 0;
    private Node<K, V>[] hashtable = new Node[capacity];

    public boolean insert(K key, V value) {
        if (elements >= capacity * DEFAULT_LOAD_FACTOR) {
            addSize();
        }
        int index = hash(key);
        hashtable[index] = new Node(key, value);
        elements++;
        modCount++;
        return hashtable[index].getKey().equals(key) && hashtable[index].getValue().equals(value);
    }

    public V get(K key) {
        return hashtable[hash(key)].getValue();
    }

    public boolean delete(K key) {
        int index = hash(key);
        if (hashtable[index] != null) {
            hashtable[index] = null;
            elements--;
        }
        return hashtable[index] == null;
    }

    public void addSize() {
        capacity *= 2;
        Node[] array = hashtable;
        hashtable = new Node[capacity];
        for (Node node : array) {
            this.insert((K) node.getKey(), (V) node.getValue());
        }
    }

    public int hash(K key) {
        return key.hashCode() % capacity;
    }


    @Override
    public Iterator<Node<K, V>> iterator() {
        Iterator<Node<K, V>> iterator = new Iterator<>() {
            private int position = 0;
            private final int expectedModCount = modCount;
            int index = 0;

            @Override
            public boolean hasNext() {
                return position < elements;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (hashtable[index] == null) {
                    index++;
                }
                position++;
                return hashtable[index++];
            }
        };
        return iterator;
    }

    @Override
    public String toString() {
        return "SimpleMap{"
                + "modCount=" + modCount
                + ", capacity=" + capacity
                + ", elements=" + elements
                + ", hashtable=" + Arrays.toString(hashtable)
                + '}';
    }
}

