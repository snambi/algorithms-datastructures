package org.github.snambi.caches.lru;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K,V> implements Cache<K,V>{

    private Map<K,V> map = new ConcurrentHashMap<>();
    private DoublyLinkedList<K> list = new DoublyLinkedList<>();

    private int MAX_SIZE = 0;

    public LRUCache(int maxSize ){
        MAX_SIZE = maxSize;
    }

    @Override
    public Optional get(K key) {
        V val = map.get(key);
        Optional result=null;

        if( val != null ){
            result = Optional.of(val);
        }else{
            result = Optional.empty();
        }

        return result;
    }

    @Override
    public boolean put(K key, V value) {

        if(map.size() == MAX_SIZE ){
            // evict the cache

        }

        V val = map.put(key,value);

        boolean result = false;
        if( val == value ){
            result = true;
        }

        return result;
    }

    @Override
    public boolean isEmoty() {
        return map.isEmpty();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }
}
