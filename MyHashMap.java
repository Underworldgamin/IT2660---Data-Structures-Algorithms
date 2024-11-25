import java.util.LinkedList;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;  // Default capacity of the hash table
    private LinkedList<Entry<K, V>>[] table;

    // Constructor to initialize the hash table
    @SuppressWarnings("unchecked")  // Suppressing unchecked warning for array creation
    public MyHashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Define an entry to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Method to add a key-value pair to the map
    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;  // Update the value if the key exists
                return;
            }
        }
        bucket.add(new Entry<>(key, value));  // Add new entry if key is not found
    }

    // Method to retrieve the value associated with a key
    @Override
    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;  // Return null if key is not found
    }

    // Method to check if the map contains a specific key
    @Override
    public boolean containsKey(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Method to remove a key-value pair from the map
    @Override
    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        bucket.removeIf(entry -> entry.key.equals(key));  // Remove the entry with the matching key
    }

    // Method to get the size of the map
    @Override
    public int size() {
        int size = 0;
        for (LinkedList<Entry<K, V>> bucket : table) {
            size += bucket.size();
        }
        return size;
    }

    // Method to check if the map is empty
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    // Helper method to calculate the index for a key based on its hash code
    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Method to return all keys in the map as an iterable
    @Override
    public Iterable<K> keySet() {
        LinkedList<K> keys = new LinkedList<>();
        for (LinkedList<Entry<K, V>> bucket : table) {
            for (Entry<K, V> entry : bucket) {
                keys.add(entry.key);
            }
        }
        return keys;
    }
}
