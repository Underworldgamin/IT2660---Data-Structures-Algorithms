public interface MyMap<K, V> {
    // Adds a key-value pair to the map
    void put(K key, V value);

    // Retrieves the value associated with the key
    V get(K key);

    // Checks if the map contains the specified key
    boolean containsKey(K key);

    // Removes the key-value pair from the map
    void remove(K key);

    // Returns the size of the map
    int size();

    // Checks if the map is empty
    boolean isEmpty();

    // Returns an iterable collection of all keys in the map
    Iterable<K> keySet();  // Added method
}
