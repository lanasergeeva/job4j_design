package ru.job4j.gc.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    /**
     * Если value не null  и не пустое значение, создаем SR с текстом
     * и грузим его в кеш
     *
     * @param key   название файла в папке
     * @param value текст из файла
     */
    public void put(K key, V value) {
        if (value != null && value != "") {
            SoftReference<V> softReference = new SoftReference<>(value);
            cache.put(key, softReference);
        } else {
            System.out.println("Value is empty or null");
        }
    }

    /**
     * @param key название файла
     * @return значение из sofref, либо снова грузим текст из файла и закидываем его в map
     * getOrDefault возвращает либо значение,
     * либо предложенное значение, если по ключу его нет
     */
    public V get(K key) {
        SoftReference<V> temp = new SoftReference<>(null);
        V rsl = cache.getOrDefault(key, temp).get();
        if (rsl == null) {
            rsl = load(key);
            put(key, rsl);
        }
        return rsl;
    }


    protected abstract V load(K key);
}
