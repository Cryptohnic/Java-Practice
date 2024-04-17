/*
 * Copyright 2023 Marc Liberatore.
 */
package hashmaps;

import hashtables.ChainingHashTable;
import java.util.Set;
import java.util.HashSet;

//  * java.util.HashMap, though it is much simpler!
//  * 
public class SimpleHashMap<K, V> implements SimpleMap<K, V> {

    ChainingHashTable<SimpleMapEntry<K, V>> ht;
    Set<K> keySet;

    public SimpleHashMap() {
        ht = new ChainingHashTable<>();
        keySet = new HashSet<>();
    }

    @Override
    public int size() {
        return ht.size();
    }

    @Override
    public void put(K k, V v) {
        ht.add(new SimpleMapEntry<K, V>(k, v));
        keySet.add(k);
    }

    @Override
    public V get(K k) {
        SimpleMapEntry<K, V> found = ht.get(new SimpleMapEntry<K, V>(k, null));
        return found != null ? found.v : null;
    }

    @Override
    public V getOrDefault(K k, V defaultValue) {
        V found = get(k);
        return found != null ? found : defaultValue;
    }

    @Override
    public V remove(K k) {
        V found = get(k);
        ht.remove(new SimpleMapEntry<>(k, null));
        keySet.remove(k);
        return found;
    }

    @Override
    public Set<K> keys() {
        return keySet;
    }
}
