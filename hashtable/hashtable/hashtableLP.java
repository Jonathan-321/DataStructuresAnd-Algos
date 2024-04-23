package hashtable;

public class hashtableLP<K, V>{


    class Entry<K,V> {
        K key;
        V value;
    
    
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    
    }

    private Entry<K,V>[] table;
    private int size;


    public hashtableLP(int size){
        this.size =  size;
        table  = new Entry[size];
    }

    private int hash(K key){
        return (3 * (Integer) key + 5 ) %size;

    }

    public int put(K key, V value) {
        int collisions = 0;
        int index = hash(key);
        int i = 0;
        while (table[index] != null) {
            collisions++;
            i++;
            index = (index + 1) % size;
        }
        table[index] = new Entry<>(key, value);
        return collisions;
    }


    public V get(K key) {
        int index = hash(key);
        int i = 0;
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            i++;
            index = (index + 1) % size;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        int i = 0;
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                V value = table[index].value;
                table[index] = null;
                return value;
            }
            i++;
            index = (index + 1) % size;
        }
        return null;
    }

}