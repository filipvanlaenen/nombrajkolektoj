package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.ModifiableMap;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap} interface for
 * Integers and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public class ModifiableIntegerMap<K> extends AbstractModifiableIntegerMap<K> implements ModifiableNumericMap<K, Integer> {
    /**
     * Inner class using a hash function backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableMap}
     * interface.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends ModifiableIntegerMap<K> {
        /**
         * Constructs a modifiable map from another map, with the same keys and Integers and the same key and value
         * cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<K, Integer> source) {
            super(new net.filipvanlaenen.kolektoj.hash.ModifiableHashMap<K, Integer>(source));
        }

        /**
         * Constructs a modifiable map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, Integer>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.ModifiableHashMap<K, Integer>(keyAndValueCardinality, entries));
        }

        /**
         * Constructs a modifiable map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, Integer>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.ModifiableHashMap<K, Integer>(entries));
        }
    }

    /**
     * The modifiable map holding the keys and the integers.
     */
    private final ModifiableMap<K, Integer> map;

    /**
     * Private constructor taking a map with the keys and the integers as its parameter.
     *
     * @param map The map holding the keys and the integers.
     */
    private ModifiableIntegerMap(final ModifiableMap<K, Integer> map) {
        this.map = map;
    }

    @Override
    public boolean add(final K key, final Integer value) {
        return map.add(key, value);
    }

    @Override
    public boolean addAll(final Map<? extends K, ? extends Integer> aMap) {
        return map.addAll(aMap);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(final Entry<K, Integer> entry) {
        return map.contains(entry);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return map.containsAll(collection);
    }

    @Override
    public boolean containsKey(final K key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(final Integer value) {
        return map.containsValue(value);
    }

    /**
     * Returns a new empty integers map.
     *
     * @param <K> The key type.
     * @return A new empty integers map.
     */
    static <K> ModifiableIntegerMap<K> empty() {
        return new HashMap<K>();
    }

    @Override
    public Entry<K, Integer> get() throws IndexOutOfBoundsException {
        return map.get();
    }

    @Override
    public Integer get(final K key) throws IllegalArgumentException {
        return map.get(key);
    }

    @Override
    public NumericCollection<Integer> getAll(final K key) throws IllegalArgumentException {
        return new IntegerCollection.ArrayCollection(map.getAll(key));
    }

    @Override
    public KeyAndValueCardinality getKeyAndValueCardinality() {
        return map.getKeyAndValueCardinality();
    }

    @Override
    public Collection<K> getKeys() {
        return map.getKeys();
    }

    @Override
    public NumericCollection<Integer> getValues() {
        return new IntegerCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, Integer>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new integers map with the specified entries.
     *
     * @param <K>     The key type.
     * @param entries The entries for the new map.
     * @return A new integers map with the specified entries.
     */
    static <K> ModifiableIntegerMap<K> of(final Entry<K, Integer>... entries) {
        return new HashMap<K>(entries);
    }

    /**
     * Returns a new integers map with the specified entries and key and value cardinality.
     *
     * @param <K>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries for the new map.
     * @return A new integers map with the specified entries.
     */
    static <K> ModifiableIntegerMap<K> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<K, Integer>... entries) {
        return new HashMap<K>(keyAndValueCardinality, entries);
    }

    /**
     * Returns a new integers map containing an entry with the key and the value.
     *
     * @param <K>   The key type.
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A new integers map containing an entry with the key and the value.
     */
    public static <K> ModifiableIntegerMap<K> of(final K key, final Integer value) {
        return new HashMap<K>(new Entry<K, Integer>(key, value));
    }

    /**
     * Returns a new integers map containing two entries using the provided keys and values.
     *
     * @param <K>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A new integers map containing two entries using the provided keys and values.
     */
    public static <K> ModifiableIntegerMap<K> of(final K key1, final Integer value1, final K key2, final Integer value2) {
        return new HashMap<K>(new Entry<K, Integer>(key1, value1), new Entry<K, Integer>(key2, value2));
    }

    /**
     * Returns a new integers map containing three entries using the provided keys and values.
     *
     * @param <K>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A new integers map containing three entries using the provided keys and values.
     */
    public static <K> ModifiableIntegerMap<K> of(final K key1, final Integer value1, final K key2, final Integer value2,
            final K key3, final Integer value3) {
        return new HashMap<K>(new Entry<K, Integer>(key1, value1), new Entry<K, Integer>(key2, value2),
                new Entry<K, Integer>(key3, value3));
    }

    /**
     * Returns a new integers map containing four entries using the provided keys and values.
     *
     * @param <K>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @param key4   The fourth key for the entry.
     * @param value4 The fourth value for the entry.
     * @return A new integers map containing four entries using the provided keys and values.
     */
    public static <K> ModifiableIntegerMap<K> of(final K key1, final Integer value1, final K key2, final Integer value2,
            final K key3, final Integer value3, final K key4, final Integer value4) {
        return new HashMap<K>(new Entry<K, Integer>(key1, value1), new Entry<K, Integer>(key2, value2),
                new Entry<K, Integer>(key3, value3), new Entry<K, Integer>(key4, value4));
    }

    /**
     * Returns a new integers map containing five entries using the provided keys and values.
     *
     * @param <K>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @param key4   The fourth key for the entry.
     * @param value4 The fourth value for the entry.
     * @param key5   The fifth key for the entry.
     * @param value5 The fifth value for the entry.
     * @return A new integers map containing five entries using the provided keys and values.
     */
    public static <K> ModifiableIntegerMap<K> of(final K key1, final Integer value1, final K key2, final Integer value2,
            final K key3, final Integer value3, final K key4, final Integer value4, final K key5, final Integer value5) {
        return new HashMap<K>(new Entry<K, Integer>(key1, value1), new Entry<K, Integer>(key2, value2),
                new Entry<K, Integer>(key3, value3), new Entry<K, Integer>(key4, value4),
                new Entry<K, Integer>(key5, value5));
    }

    @Override
    public Integer remove(final K key) throws IllegalArgumentException {
        return map.remove(key);
    }

    @Override
    public boolean removeAll(final Map<? extends K, ? extends Integer> aMap) {
        return map.removeAll(aMap);
    }

    @Override
    public boolean removeIf(final Predicate<Entry<? extends K, ? extends Integer>> predicate) {
        return map.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Map<? extends K, ? extends Integer> aMap) {
        return map.retainAll(aMap);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Spliterator<Entry<K, Integer>> spliterator() {
        return map.spliterator();
    }

    @Override
    public Object[] toArray() {
        return map.toArray();
    }

    @Override
    public Integer update(final K key, final Integer value) throws IllegalArgumentException {
        return map.update(key, value);
    }
}
