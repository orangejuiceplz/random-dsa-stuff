package types.generic;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashSet;

public class Map_2_KShiven<K, V> {

    ArrayList<K> keys;
    ArrayList<V> values;

    public Map_2_KShiven() {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public void clear() {
        keys.clear();
        values.clear();
    }

    public boolean isEmpty() {
        return keys.isEmpty();
    }

    boolean add(K key, V value) {
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
            return true;
        }
        return false;
    }

    public V remove(K key) {
        int index = keys.indexOf(key);
        if (!keys.contains(key)) {
            throw new IllegalArgumentException();
        }
        keys.remove(index);
        return values.remove(index);
    }

    public V get(K key) {

        if (!keys.contains(key)) {
            throw new IllegalArgumentException();
        }

        return values.get(keys.indexOf(key));
    }

    public HashSet<K> getKeys() {
        return new HashSet<>(keys);
    }

    public V set(K key, V value) {
        if (!keys.contains(key)) {
            throw new IllegalArgumentException();
        }
        return values.set(keys.indexOf(key), value);
    }

    public int size() {
        return keys.size();
    }

    public String toString() {
        String toReturn = "";
//        for (K key : keys) {
//            toReturn += (key.toString() + ", " + get(key).toString()) + "\n";
//        }
        for (int i = 0; i < keys.size(); i++) {
            toReturn += keys.get(i) + ": " + values.get(i) + "\n";
        }
        return "{" + "\n" + toReturn + "}";
    }




}
