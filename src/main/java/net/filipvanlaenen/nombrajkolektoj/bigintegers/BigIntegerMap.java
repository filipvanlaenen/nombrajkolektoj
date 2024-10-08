package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} interface for BigIntegers
 * and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class BigIntegerMap<K> extends AbstractBigIntegerMap<K> implements NumericMap<K, BigInteger> {
    /**
     * Inner class using a hash function backed implementation of the {@link net.filipvanlaenen.kolektoj.Map} interface.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends BigIntegerMap<K> {
        /**
         * Constructs a map from another map, with the same keys and BigIntegers and the same key and value cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<K, BigInteger> source) {
            super(new net.filipvanlaenen.kolektoj.hash.HashMap<K, BigInteger>(source));
        }

        /**
         * Constructs a map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, BigInteger>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.HashMap<K, BigInteger>(keyAndValueCardinality, entries));
        }

        /**
         * Constructs a map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, BigInteger>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.HashMap<K, BigInteger>(entries));
        }
    }

    /**
     * The map holding the keys and the BigIntegers.
     */
    private final Map<K, BigInteger> map;

    /**
     * Private constructor taking a map with the keys and the BigIntegers as its parameter.
     *
     * @param map The map holding the keys and the BigIntegers.
     */
    private BigIntegerMap(final Map<K, BigInteger> map) {
        this.map = map;
    }

    @Override
    public boolean contains(final Entry<K, BigInteger> entry) {
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
    public boolean containsValue(final BigInteger value) {
        return map.containsValue(value);
    }

    /**
     * Returns a new empty BigIntegers map.
     *
     * @param <K> The key type.
     * @return A new empty BigIntegers map.
     */
    static <K> BigIntegerMap<K> empty() {
        return new HashMap<K>();
    }

    @Override
    public Entry<K, BigInteger> get() throws IndexOutOfBoundsException {
        return map.get();
    }

    @Override
    public BigInteger get(final K key) throws IllegalArgumentException {
        return map.get(key);
    }

    @Override
    public NumericCollection<BigInteger> getAll(final K key) throws IllegalArgumentException {
        return new BigIntegerCollection.ArrayCollection(map.getAll(key));
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
    public NumericCollection<BigInteger> getValues() {
        return new BigIntegerCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, BigInteger>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new BigIntegers map with the specified entries.
     *
     * @param <K>     The key type.
     * @param entries The entries for the new map.
     * @return A new BigIntegers map with the specified entries.
     */
    static <K> BigIntegerMap<K> of(final Entry<K, BigInteger>... entries) {
        return new HashMap<K>(entries);
    }

    /**
     * Returns a new BigIntegers map with the specified entries and key and value cardinality.
     *
     * @param <K>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries for the new map.
     * @return A new BigIntegers map with the specified entries.
     */
    static <K> BigIntegerMap<K> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<K, BigInteger>... entries) {
        return new HashMap<K>(keyAndValueCardinality, entries);
    }

    /**
     * Returns a new BigIntegers map containing an entry with the key and the value.
     *
     * @param <K>   The key type.
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A new BigIntegers map containing an entry with the key and the value.
     */
    public static <K> BigIntegerMap<K> of(final K key, final BigInteger value) {
        return new HashMap<K>(new Entry<K, BigInteger>(key, value));
    }

    /**
     * Returns a new BigIntegers map containing two entries using the provided keys and values.
     *
     * @param <K>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A new BigIntegers map containing two entries using the provided keys and values.
     */
    public static <K> BigIntegerMap<K> of(final K key1, final BigInteger value1, final K key2,
            final BigInteger value2) {
        return new HashMap<K>(new Entry<K, BigInteger>(key1, value1), new Entry<K, BigInteger>(key2, value2));
    }

    /**
     * Returns a new BigIntegers map containing three entries using the provided keys and values.
     *
     * @param <K>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A new BigIntegers map containing three entries using the provided keys and values.
     */
    public static <K> BigIntegerMap<K> of(final K key1, final BigInteger value1, final K key2, final BigInteger value2,
            final K key3, final BigInteger value3) {
        return new HashMap<K>(new Entry<K, BigInteger>(key1, value1), new Entry<K, BigInteger>(key2, value2),
                new Entry<K, BigInteger>(key3, value3));
    }

    /**
     * Returns a new BigIntegers map containing four entries using the provided keys and values.
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
     * @return A new BigIntegers map containing four entries using the provided keys and values.
     */
    public static <K> BigIntegerMap<K> of(final K key1, final BigInteger value1, final K key2, final BigInteger value2,
            final K key3, final BigInteger value3, final K key4, final BigInteger value4) {
        return new HashMap<K>(new Entry<K, BigInteger>(key1, value1), new Entry<K, BigInteger>(key2, value2),
                new Entry<K, BigInteger>(key3, value3), new Entry<K, BigInteger>(key4, value4));
    }

    /**
     * Returns a new BigIntegers map containing five entries using the provided keys and values.
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
     * @return A new BigIntegers map containing five entries using the provided keys and values.
     */
    public static <K> BigIntegerMap<K> of(final K key1, final BigInteger value1, final K key2, final BigInteger value2,
            final K key3, final BigInteger value3, final K key4, final BigInteger value4, final K key5,
            final BigInteger value5) {
        return new HashMap<K>(new Entry<K, BigInteger>(key1, value1), new Entry<K, BigInteger>(key2, value2),
                new Entry<K, BigInteger>(key3, value3), new Entry<K, BigInteger>(key4, value4),
                new Entry<K, BigInteger>(key5, value5));
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Spliterator<Entry<K, BigInteger>> spliterator() {
        return map.spliterator();
    }

    @Override
    public Object[] toArray() {
        return map.toArray();
    }
}
