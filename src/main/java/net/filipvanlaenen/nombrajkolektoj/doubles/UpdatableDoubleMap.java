package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.UpdatableMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} interface for
 * Doubles and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class UpdatableDoubleMap<K> extends AbstractUpdatableDoubleMap<K>
        implements UpdatableNumericMap<K, Double> {
    /**
     * Inner class using a hash function backed implementation of the {@link net.filipvanlaenen.kolektoj.UpdatableMap}
     * interface.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends UpdatableDoubleMap<K> {
        /**
         * Constructs an updatable map from another map, with the same keys and Doubles and the same key and value
         * cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<? extends K, Double> source) {
            super(new net.filipvanlaenen.kolektoj.hash.UpdatableHashMap<K, Double>(source));
        }

        /**
         * Constructs an updatable map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, Double>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.UpdatableHashMap<K, Double>(keyAndValueCardinality, entries));
        }

        /**
         * Constructs an updatable map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, Double>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.UpdatableHashMap<K, Double>(entries));
        }
    }

    /**
     * The updatable map holding the keys and the doubles.
     */
    private final UpdatableMap<K, Double> map;

    /**
     * Private constructor taking a map with the keys and the doubles as its parameter.
     *
     * @param map The map holding the keys and the doubles.
     */
    private UpdatableDoubleMap(final UpdatableMap<K, Double> map) {
        this.map = map;
    }

    @Override
    public boolean contains(final Entry<K, Double> entry) {
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
    public boolean containsValue(final Double value) {
        return map.containsValue(value);
    }

    /**
     * Returns a new empty doubles map.
     *
     * @param <L> The key type.
     * @return A new empty doubles map.
     */
    public static <L> UpdatableDoubleMap<L> empty() {
        return new HashMap<L>();
    }

    @Override
    public Entry<K, Double> get() throws IndexOutOfBoundsException {
        return map.get();
    }

    @Override
    public Double get(final K key) throws IllegalArgumentException {
        return map.get(key);
    }

    @Override
    public NumericCollection<Double> getAll(final K key) throws IllegalArgumentException {
        return new DoubleCollection.ArrayCollection(map.getAll(key));
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
    public NumericCollection<Double> getValues() {
        return new DoubleCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, Double>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new updatable doubles map cloned from the provided doubles map.
     *
     * @param <L> The key type.
     * @param map The original doubles map.
     * @return A new updatable doubles map cloned from the provided doubles map.
     */
    public static <L> UpdatableDoubleMap<L> of(final DoubleMap<? extends L> map) {
        return new HashMap<L>(map);
    }

    /**
     * Returns a new doubles map with the specified entries.
     *
     * @param <L>     The key type.
     * @param entries The entries for the new map.
     * @return A new doubles map with the specified entries.
     */
    public static <L> UpdatableDoubleMap<L> of(final Entry<L, Double>... entries) {
        return new HashMap<L>(entries);
    }

    /**
     * Returns a new doubles map containing an entry with the key and the value.
     *
     * @param <L>   The key type.
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A new doubles map containing an entry with the key and the value.
     */
    public static <L> UpdatableDoubleMap<L> of(final L key, final Double value) {
        return new HashMap<L>(new Entry<L, Double>(key, value));
    }

    /**
     * Returns a new doubles map containing two entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A new doubles map containing two entries using the provided keys and values.
     */
    public static <L> UpdatableDoubleMap<L> of(final L key1, final Double value1, final L key2, final Double value2) {
        return new HashMap<L>(new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2));
    }

    /**
     * Returns a new doubles map containing three entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A new doubles map containing three entries using the provided keys and values.
     */
    public static <L> UpdatableDoubleMap<L> of(final L key1, final Double value1, final L key2, final Double value2,
            final L key3, final Double value3) {
        return new HashMap<L>(new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2),
                new Entry<L, Double>(key3, value3));
    }

    /**
     * Returns a new doubles map containing four entries using the provided keys and values.
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
     * @return A new doubles map containing four entries using the provided keys and values.
     */
    public static <L> UpdatableDoubleMap<L> of(final L key1, final Double value1, final L key2, final Double value2,
            final L key3, final Double value3, final L key4, final Double value4) {
        return new HashMap<L>(new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2),
                new Entry<L, Double>(key3, value3), new Entry<L, Double>(key4, value4));
    }

    /**
     * Returns a new doubles map containing five entries using the provided keys and values.
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
     * @return A new doubles map containing five entries using the provided keys and values.
     */
    public static <L> UpdatableDoubleMap<L> of(final L key1, final Double value1, final L key2, final Double value2,
            final L key3, final Double value3, final L key4, final Double value4, final L key5, final Double value5) {
        return new HashMap<L>(new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2),
                new Entry<L, Double>(key3, value3), new Entry<L, Double>(key4, value4),
                new Entry<L, Double>(key5, value5));
    }

    /**
     * Returns a new updatable doubles map with the specified keys with a default value and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new updatable doubles map with the specified entries.
     */
    public static <L> UpdatableDoubleMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Double defaultValue, final L... keys) {
        ModifiableDoubleMap<L> map = ModifiableDoubleMap.<L>of(keyAndValueCardinality);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new HashMap<L>(map);
    }

    /**
     * Returns a new doubles map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries for the new map.
     * @return A new doubles map with the specified entries.
     */
    public static <L> UpdatableDoubleMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<L, Double>... entries) {
        return new HashMap<L>(keyAndValueCardinality, entries);
    }

    /**
     * Returns a new updatable doubles map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new updatable doubles map with the specified entries.
     */
    public static <L> UpdatableDoubleMap<L> of(final Double defaultValue, final L... keys) {
        ModifiableDoubleMap<L> map = ModifiableDoubleMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new HashMap<L>(map);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Spliterator<Entry<K, Double>> spliterator() {
        return map.spliterator();
    }

    @Override
    public Object[] toArray() {
        return map.toArray();
    }

    @Override
    public Double update(final K key, final Double value) throws IllegalArgumentException {
        return map.update(key, value);
    }

    @Override
    public boolean update(final K key, final Double oldValye, final Double newValue) {
        return map.update(key, oldValye, newValue);
    }
}
