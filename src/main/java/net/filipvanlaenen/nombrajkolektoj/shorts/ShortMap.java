package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} interface for Shorts and
 * containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class ShortMap<K> extends AbstractShortMap<K> implements NumericMap<K, Short> {
    /**
     * Inner class using a hash function backed implementation of the {@link net.filipvanlaenen.kolektoj.Map} interface.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends ShortMap<K> {
        /**
         * Constructs a map from another map, with the same keys and Shorts and the same key and value cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<? extends K, Short> source) {
            super(new net.filipvanlaenen.kolektoj.hash.HashMap<K, Short>(source));
        }

        /**
         * Constructs a map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, Short>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.HashMap<K, Short>(keyAndValueCardinality, entries));
        }

        /**
         * Constructs a map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, Short>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.HashMap<K, Short>(entries));
        }
    }

    /**
     * The map holding the keys and the shorts.
     */
    private final Map<K, Short> map;

    /**
     * Private constructor taking a map with the keys and the shorts as its parameter.
     *
     * @param map The map holding the keys and the shorts.
     */
    private ShortMap(final Map<K, Short> map) {
        this.map = map;
    }

    @Override
    public boolean contains(final Entry<K, Short> entry) {
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
    public boolean containsValue(final Short value) {
        return map.containsValue(value);
    }

    /**
     * Returns a new empty shorts map.
     *
     * @param <K> The key type.
     * @return A new empty shorts map.
     */
    public static <K> ShortMap<K> empty() {
        return new HashMap<K>();
    }

    @Override
    public Entry<K, Short> get() throws IndexOutOfBoundsException {
        return map.get();
    }

    @Override
    public Short get(final K key) throws IllegalArgumentException {
        return map.get(key);
    }

    @Override
    public NumericCollection<Short> getAll(final K key) throws IllegalArgumentException {
        return new ShortCollection.ArrayCollection(map.getAll(key));
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
    public NumericCollection<Short> getValues() {
        return new ShortCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, Short>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new shorts map cloned from the provided shorts map.
     *
     * @param <L> The key type.
     * @param map The original shorts map.
     * @return A new shorts map cloned from the provided shorts map.
     */
    public static <L> ShortMap<L> of(final NumericMap<? extends L, Short> map) {
        return new HashMap<L>(map);
    }

    /**
     * Returns a new shorts map with the specified entries.
     *
     * @param <L>     The key type.
     * @param entries The entries for the new map.
     * @return A new shorts map with the specified entries.
     */
    public static <L> ShortMap<L> of(final Entry<L, Short>... entries) {
        return new HashMap<L>(entries);
    }

    /**
     * Returns a new shorts map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries for the new map.
     * @return A new shorts map with the specified entries.
     */
    public static <L> ShortMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<L, Short>... entries) {
        return new HashMap<L>(keyAndValueCardinality, entries);
    }

    /**
     * Returns a new shorts map containing an entry with the key and the value.
     *
     * @param <L>   The key type.
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A new shorts map containing an entry with the key and the value.
     */
    public static <L> ShortMap<L> of(final L key, final Short value) {
        return new HashMap<L>(new Entry<L, Short>(key, value));
    }

    /**
     * Returns a new shorts map containing two entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A new shorts map containing two entries using the provided keys and values.
     */
    public static <L> ShortMap<L> of(final L key1, final Short value1, final L key2, final Short value2) {
        return new HashMap<L>(new Entry<L, Short>(key1, value1), new Entry<L, Short>(key2, value2));
    }

    /**
     * Returns a new shorts map containing three entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A new shorts map containing three entries using the provided keys and values.
     */
    public static <L> ShortMap<L> of(final L key1, final Short value1, final L key2, final Short value2,
            final L key3, final Short value3) {
        return new HashMap<L>(new Entry<L, Short>(key1, value1), new Entry<L, Short>(key2, value2),
                new Entry<L, Short>(key3, value3));
    }

    /**
     * Returns a new shorts map containing four entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @param key4   The fourth key for the entry.
     * @param value4 The fourth value for the entry.
     * @return A new shorts map containing four entries using the provided keys and values.
     */
    public static <L> ShortMap<L> of(final L key1, final Short value1, final L key2, final Short value2,
            final L key3, final Short value3, final L key4, final Short value4) {
        return new HashMap<L>(new Entry<L, Short>(key1, value1), new Entry<L, Short>(key2, value2),
                new Entry<L, Short>(key3, value3), new Entry<L, Short>(key4, value4));
    }

    /**
     * Returns a new shorts map containing five entries using the provided keys and values.
     *
     * @param <L>    The key type.
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
     * @return A new shorts map containing five entries using the provided keys and values.
     */
    public static <L> ShortMap<L> of(final L key1, final Short value1, final L key2, final Short value2,
            final L key3, final Short value3, final L key4, final Short value4, final L key5, final Short value5) {
        return new HashMap<L>(new Entry<L, Short>(key1, value1), new Entry<L, Short>(key2, value2),
                new Entry<L, Short>(key3, value3), new Entry<L, Short>(key4, value4),
                new Entry<L, Short>(key5, value5));
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Spliterator<Entry<K, Short>> spliterator() {
        return map.spliterator();
    }

    @Override
    public Object[] toArray() {
        return map.toArray();
    }
}
