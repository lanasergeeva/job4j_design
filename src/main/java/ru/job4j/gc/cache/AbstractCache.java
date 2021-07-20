package ru.job4j.gc.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        if (value != null && value != "") {
            SoftReference<V> softReference = new SoftReference<>(value);
            cache.put(key, softReference);
        } else {
            System.out.println("Value is empty or null");
        }
    }

    public V get(K key) {
        SoftReference<V> temp = new SoftReference<>(null);
        V rsl = cache.getOrDefault(key, temp).get();
        if (rsl == null) {
            try {
                rsl = load(key);
                put(key, rsl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rsl;
    }


    protected abstract V load(K key) throws IOException;
}
