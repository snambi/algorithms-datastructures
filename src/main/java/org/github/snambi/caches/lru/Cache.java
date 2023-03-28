package org.github.snambi.caches.lru;

import java.util.Optional;

public interface Cache<K,V> {
    Optional<V> get(K key);

    boolean put(K key, V value);

    boolean isEmoty();

    int size();

    void clear();
}
