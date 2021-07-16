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

    public V get(K key)  {
        V rsl = null;
        SoftReference<V> softReference = cache.get(key);
        if (softReference != null) {
            rsl = softReference.get();
        } else {
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
