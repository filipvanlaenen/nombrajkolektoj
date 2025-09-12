package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} interface for BigDecimals and
 * containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class BigDecimalMap<K> extends AbstractBigDecimalMap<K> implements NumericMap<K, BigDecimal> {
    /**
     * Inner class using a hash function backed implementation of the {@link net.filipvanlaenen.kolektoj.Map} interface.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends BigDecimalMap<K> {
        /**
         * Constructs a map from another map, with the same keys and BigDecimals and the same key and value cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<K, BigDecimal> source) {
            super(new net.filipvanlaenen.kolektoj.hash.HashMap<K, BigDecimal>(source));
        }

        /**
         * Constructs a map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, BigDecimal>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.HashMap<K, BigDecimal>(keyAndValueCardinality, entries));
        }

        /**
         * Constructs a map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, BigDecimal>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.HashMap<K, BigDecimal>(entries));
        }
    }

    /**
     * The map holding the keys and the BigDecimals.
     */
    private final Map<K, BigDecimal> map;

    /**
     * Private constructor taking a map with the keys and the BigDecimals as its parameter.
     *
     * @param map The map holding the keys and the BigDecimals.
     */
    private BigDecimalMap(final Map<K, BigDecimal> map) {
        this.map = map;
    }

    @Override
    public boolean contains(final Entry<K, BigDecimal> entry) {
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
    public boolean containsValue(final BigDecimal value) {
        return map.containsValue(value);
    }

    /**
     * Returns a new empty BigDecimals map.
     *
     * @param <K> The key type.
     * @return A new empty BigDecimals map.
     */
    static <K> BigDecimalMap<K> empty() {
        return new HashMap<K>();
    }

    @Override
    public Entry<K, BigDecimal> get() throws IndexOutOfBoundsException {
        return map.get();
    }

    @Override
    public BigDecimal get(final K key) throws IllegalArgumentException {
        return map.get(key);
    }

    @Override
    public NumericCollection<BigDecimal> getAll(final K key) throws IllegalArgumentException {
        return new BigDecimalCollection.ArrayCollection(map.getAll(key));
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
    public NumericCollection<BigDecimal> getValues() {
        return new BigDecimalCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, BigDecimal>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new BigDecimals map with the specified entries.
     *
     * @param <L>     The key type.
     * @param entries The entries for the new map.
     * @return A new BigDecimals map with the specified entries.
     */
    static <L> BigDecimalMap<L> of(final Entry<L, BigDecimal>... entries) {
        return new HashMap<L>(entries);
    }

    /**
     * Returns a new BigDecimals map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries for the new map.
     * @return A new BigDecimals map with the specified entries.
     */
    static <L> BigDecimalMap<L> of(final KeyAndValueCardinality keyAndValueCardinality, final Entry<L, BigDecimal>... entries) {
        return new HashMap<L>(keyAndValueCardinality, entries);
    }

    /**
     * Returns a new BigDecimals map containing an entry with the key and the value.
     *
     * @param <L>   The key type.
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A new BigDecimals map containing an entry with the key and the value.
     */
    public static <L> BigDecimalMap<L> of(final L key, final BigDecimal value) {
        return new HashMap<L>(new Entry<L, BigDecimal>(key, value));
    }

    /**
     * Returns a new BigDecimals map containing two entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A new BigDecimals map containing two entries using the provided keys and values.
     */
    public static <L> BigDecimalMap<L> of(final L key1, final BigDecimal value1, final L key2, final BigDecimal value2) {
        return new HashMap<L>(new Entry<L, BigDecimal>(key1, value1), new Entry<L, BigDecimal>(key2, value2));
    }

    /**
     * Returns a new BigDecimals map containing three entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A new BigDecimals map containing three entries using the provided keys and values.
     */
    public static <L> BigDecimalMap<L> of(final L key1, final BigDecimal value1, final L key2, final BigDecimal value2,
            final L key3, final BigDecimal value3) {
        return new HashMap<L>(new Entry<L, BigDecimal>(key1, value1), new Entry<L, BigDecimal>(key2, value2),
                new Entry<L, BigDecimal>(key3, value3));
    }

    /**
     * Returns a new BigDecimals map containing four entries using the provided keys and values.
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
     * @return A new BigDecimals map containing four entries using the provided keys and values.
     */
    public static <L> BigDecimalMap<L> of(final L key1, final BigDecimal value1, final L key2, final BigDecimal value2,
            final L key3, final BigDecimal value3, final L key4, final BigDecimal value4) {
        return new HashMap<L>(new Entry<L, BigDecimal>(key1, value1), new Entry<L, BigDecimal>(key2, value2),
                new Entry<L, BigDecimal>(key3, value3), new Entry<L, BigDecimal>(key4, value4));
    }

    /**
     * Returns a new BigDecimals map containing five entries using the provided keys and values.
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
     * @return A new BigDecimals map containing five entries using the provided keys and values.
     */
    public static <L> BigDecimalMap<L> of(final L key1, final BigDecimal value1, final L key2, final BigDecimal value2,
            final L key3, final BigDecimal value3, final L key4, final BigDecimal value4, final L key5, final BigDecimal value5) {
        return new HashMap<L>(new Entry<L, BigDecimal>(key1, value1), new Entry<L, BigDecimal>(key2, value2),
                new Entry<L, BigDecimal>(key3, value3), new Entry<L, BigDecimal>(key4, value4),
                new Entry<L, BigDecimal>(key5, value5));
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Spliterator<Entry<K, BigDecimal>> spliterator() {
        return map.spliterator();
    }

    @Override
    public Object[] toArray() {
        return map.toArray();
    }
}
