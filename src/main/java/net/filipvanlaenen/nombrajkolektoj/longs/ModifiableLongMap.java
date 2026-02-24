package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.ModifiableMap;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap} interface for
 * Longs and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public class ModifiableLongMap<K> extends AbstractModifiableLongMap<K> implements ModifiableNumericMap<K, Long> {
    /**
     * Inner class using a hash function backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableMap}
     * interface.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends ModifiableLongMap<K> {
        /**
         * Constructs a modifiable map from another map, with the same keys and Longs and the same key and value
         * cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<? extends K, Long> source) {
            super(new net.filipvanlaenen.kolektoj.hash.ModifiableHashMap<K, Long>(source));
        }

        /**
         * Constructs a modifiable map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, Long>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.ModifiableHashMap<K, Long>(keyAndValueCardinality, entries));
        }

        /**
         * Constructs a modifiable map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, Long>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.ModifiableHashMap<K, Long>(entries));
        }
    }

    /**
     * The modifiable map holding the keys and the longs.
     */
    private final ModifiableMap<K, Long> map;

    /**
     * Private constructor taking a map with the keys and the longs as its parameter.
     *
     * @param map The map holding the keys and the longs.
     */
    private ModifiableLongMap(final ModifiableMap<K, Long> map) {
        this.map = map;
    }

    @Override
    public boolean add(final K key, final Long value) {
        return map.add(key, value);
    }

    @Override
    public boolean addAll(final Map<? extends K, ? extends Long> aMap) {
        return map.addAll(aMap);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(final Entry<K, Long> entry) {
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
    public boolean containsValue(final Long value) {
        return map.containsValue(value);
    }

    /**
     * Returns a new empty longs map.
     *
     * @param <K> The key type.
     * @return A new empty longs map.
     */
    public static <K> ModifiableLongMap<K> empty() {
        return new HashMap<K>();
    }

    @Override
    public Entry<K, Long> get() throws IndexOutOfBoundsException {
        return map.get();
    }

    @Override
    public Long get(final K key) throws IllegalArgumentException {
        return map.get(key);
    }

    @Override
    public LongCollection getAll(final K key) throws IllegalArgumentException {
        return new LongCollection.ArrayCollection(map.getAll(key));
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
    public LongCollection getValues() {
        return new LongCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, Long>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new modifiable longs map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new modifiable longs map with the specified entries.
     */
    public static <L> ModifiableLongMap<L> of(final Long defaultValue, final L... keys) {
        ModifiableLongMap<L> map = ModifiableLongMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable longs map cloned from the provided longs map.
     *
     * @param <L> The key type.
     * @param map The original longs map.
     * @return A new modifiable longs map cloned from the provided longs map.
     */
    public static <L> ModifiableLongMap<L> of(final NumericMap<? extends L, Long> map) {
        return new HashMap<L>(map);
    }

    /**
     * Returns a new longs map with the specified entries.
     *
     * @param <L>     The key type.
     * @param entries The entries for the new map.
     * @return A new longs map with the specified entries.
     */
    public static <L> ModifiableLongMap<L> of(final Entry<L, Long>... entries) {
        return new HashMap<L>(entries);
    }

    /**
     * Returns a new longs map containing an entry with the key and the value.
     *
     * @param <L>   The key type.
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A new longs map containing an entry with the key and the value.
     */
    public static <L> ModifiableLongMap<L> of(final L key, final Long value) {
        return new HashMap<L>(new Entry<L, Long>(key, value));
    }

    /**
     * Returns a new longs map containing two entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A new longs map containing two entries using the provided keys and values.
     */
    public static <L> ModifiableLongMap<L> of(final L key1, final Long value1, final L key2, final Long value2) {
        return new HashMap<L>(new Entry<L, Long>(key1, value1), new Entry<L, Long>(key2, value2));
    }

    /**
     * Returns a new longs map containing three entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A new longs map containing three entries using the provided keys and values.
     */
    public static <L> ModifiableLongMap<L> of(final L key1, final Long value1, final L key2, final Long value2,
            final L key3, final Long value3) {
        return new HashMap<L>(new Entry<L, Long>(key1, value1), new Entry<L, Long>(key2, value2),
                new Entry<L, Long>(key3, value3));
    }

    /**
     * Returns a new longs map containing four entries using the provided keys and values.
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
     * @return A new longs map containing four entries using the provided keys and values.
     */
    public static <L> ModifiableLongMap<L> of(final L key1, final Long value1, final L key2, final Long value2,
            final L key3, final Long value3, final L key4, final Long value4) {
        return new HashMap<L>(new Entry<L, Long>(key1, value1), new Entry<L, Long>(key2, value2),
                new Entry<L, Long>(key3, value3), new Entry<L, Long>(key4, value4));
    }

    /**
     * Returns a new longs map containing five entries using the provided keys and values.
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
     * @return A new longs map containing five entries using the provided keys and values.
     */
    public static <L> ModifiableLongMap<L> of(final L key1, final Long value1, final L key2, final Long value2,
            final L key3, final Long value3, final L key4, final Long value4, final L key5, final Long value5) {
        return new HashMap<L>(new Entry<L, Long>(key1, value1), new Entry<L, Long>(key2, value2),
                new Entry<L, Long>(key3, value3), new Entry<L, Long>(key4, value4),
                new Entry<L, Long>(key5, value5));
    }

    /**
     * Returns a new modifiable longs map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries for the new map.
     * @return A new modifiable longs map with the specified entries.
     */
    public static <L> ModifiableLongMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<L, Long>... entries) {
        return new HashMap<L>(keyAndValueCardinality, entries);
    }

    /**
     * Returns a new modifiable longs map with the specified keys with a default value and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new modifiable longs map with the specified entries.
     */
    public static <L> ModifiableLongMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Long defaultValue, final L... keys) {
        ModifiableLongMap<L> map = ModifiableLongMap.<L>of(keyAndValueCardinality);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    @Override
    public Long remove(final K key) throws IllegalArgumentException {
        return map.remove(key);
    }

    @Override
    public boolean remove(final K key, final Long value) {
        return map.remove(key, value);
    }

    @Override
    public boolean removeAll(final Map<? extends K, ? extends Long> aMap) {
        return map.removeAll(aMap);
    }

    @Override
    public boolean removeIf(final Predicate<Entry<? extends K, ? extends Long>> predicate) {
        return map.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Map<? extends K, ? extends Long> aMap) {
        return map.retainAll(aMap);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Spliterator<Entry<K, Long>> spliterator() {
        return map.spliterator();
    }

    @Override
    public Object[] toArray() {
        return map.toArray();
    }

    @Override
    public Long update(final K key, final Long value) throws IllegalArgumentException {
        return map.update(key, value);
    }

    @Override
    public boolean update(final K key, final Long oldValue, final Long newValue) {
        return map.update(key, oldValue, newValue);
    }
}
