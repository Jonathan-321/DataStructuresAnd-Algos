package hashtable;

import java.util.ArrayList;

public class hashtableDH<K, V> {
    class Entry<V> {
        int key;
        V value;

        public Entry(int key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<Entry<V>> table;
    private int size;

    public hashtableDH(int size) {
        this.size = size;
        table = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            table.add(null);
        }
    }

    private int hash(K key) {
        return (3 * (Integer) key + 5) % size;
    }

    private int doubleHash(K key) {
        return 7 - ((Integer) key % 7);
    }

    public int put(K key, V value) {
        int collisions = 0;
        int index = hash(key);
        int i = 0;
        while (table.get(index) != null && table.get(index).key != (Integer) key) {
            collisions++;
            i++;
            index = (hash(key) + i * doubleHash(key)) % size;
        }
        table.set(index, new Entry<>((Integer) key, value));
        return collisions;
    }

    public V get(K key) {
        int index = hash(key);
        int i = 0;
        while (table.get(index) != null) {
            if (table.get(index).key == (Integer) key) {
                return table.get(index).value;
            }
            i++;
            index = (index + i * doubleHash(key)) % size;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        int i = 0;
        while (table.get(index) != null) {
            if (table.get(index).key == (Integer) key) {
                V value = table.get(index).value;
                table.set(index, null);
                return value;
            }
            i++;
            index = (index + i * doubleHash(key)) % size;
        }
        return null;
    }
}