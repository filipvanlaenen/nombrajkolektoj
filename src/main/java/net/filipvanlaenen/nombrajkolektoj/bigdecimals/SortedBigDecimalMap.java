package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.kolektoj.SortedMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericMap;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericMap} interface for BigDecimals
 * and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class SortedBigDecimalMap<K> extends AbstractSortedBigDecimalMap<K> implements SortedNumericMap<K, BigDecimal> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedMap} interface.
     *
     * @param <K> The key type.
     */
    public static final class ArrayMap<K> extends SortedBigDecimalMap<K> {
        /**
         * Constructs a sorted map from another map, with the same keys and BigDecimals and the same key and value
         * cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public ArrayMap(final Comparator<K> comparator, final Map<K, BigDecimal> source) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayMap<K, BigDecimal>(comparator, source));
        }

        /**
         * Constructs a sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public ArrayMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<K> comparator,
                final Entry<K, BigDecimal>... entries) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayMap<K, BigDecimal>(keyAndValueCardinality, comparator,
                    entries));
        }

        /**
         * Constructs a sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public ArrayMap(final Comparator<K> comparator, final Entry<K, BigDecimal>... entries) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayMap<K, BigDecimal>(comparator, entries));
        }
    }

    /**
     * Inner class using a sorted tree backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedMap}
     * interface.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends SortedBigDecimalMap<K> {
        /**
         * Constructs a sorted map from another map, with the same keys and BigDecimals and the same key and value
         * cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<K> comparator, final Map<K, BigDecimal> source) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, BigDecimal>(comparator, source));
        }

        /**
         * Constructs a sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<K> comparator,
                final Entry<K, BigDecimal>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, BigDecimal>(keyAndValueCardinality,
                    comparator, entries));
        }

        /**
         * Constructs a sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<K> comparator, final Entry<K, BigDecimal>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, BigDecimal>(comparator, entries));
        }
    }

    /**
     * The sorted map holding the keys and the BigDecimals.
     */
    private final SortedMap<K, BigDecimal> map;

    /**
     * Private constructor taking a map with the keys and the BigDecimals as its parameter.
     *
     * @param map The map holding the keys and the BigDecimals.
     */
    private SortedBigDecimalMap(final SortedMap<K, BigDecimal> map) {
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
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty BigDecimals map.
     */
    static <K> SortedBigDecimalMap<K> empty(final Comparator<K> comparator) {
        return new ArrayMap<K>(comparator);
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
    public Comparator<? super K> getComparator() {
        return map.getComparator();
    }

    @Override
    public Entry<K, BigDecimal> getGreaterThan(final K key) throws IndexOutOfBoundsException {
        return map.getGreaterThan(key);
    }

    @Override
    public Entry<K, BigDecimal> getGreaterThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return map.getGreaterThanOrEqualTo(key);
    }

    @Override
    public Entry<K, BigDecimal> getGreatest() {
        return map.getGreatest();
    }

    @Override
    public K getGreatestKey() {
        return map.getGreatestKey();
    }

    @Override
    public KeyAndValueCardinality getKeyAndValueCardinality() {
        return map.getKeyAndValueCardinality();
    }

    @Override
    public K getKeyGreaterThan(final K key) throws IndexOutOfBoundsException {
        return map.getKeyGreaterThan(key);
    }

    @Override
    public K getKeyGreaterThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return map.getKeyGreaterThanOrEqualTo(key);
    }

    @Override
    public K getKeyLessThan(final K key) throws IndexOutOfBoundsException {
        return map.getKeyLessThan(key);
    }

    @Override
    public K getKeyLessThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return map.getKeyLessThanOrEqualTo(key);
    }

    @Override
    public SortedCollection<K> getKeys() {
        return map.getKeys();
    }

    @Override
    public Entry<K, BigDecimal> getLeast() {
        return map.getLeast();
    }

    @Override
    public K getLeastKey() {
        return map.getLeastKey();
    }

    @Override
    public Entry<K, BigDecimal> getLessThan(final K key) throws IndexOutOfBoundsException {
        return map.getLessThan(key);
    }

    @Override
    public Entry<K, BigDecimal> getLessThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return map.getLessThanOrEqualTo(key);
    }

    @Override
    public OrderedNumericCollection<BigDecimal> getValues() {
        return new OrderedBigDecimalCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, BigDecimal>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new sorted BigDecimals map with the specified entries.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param entries    The entries for the new map.
     * @return A new sorted BigDecimals map with the specified entries.
     */
    static <K> SortedBigDecimalMap<K> of(final Comparator<K> comparator, final Entry<K, BigDecimal>... entries) {
        return new SortedTreeMap<K>(comparator, entries);
    }

    /**
     * Returns a new sorted BigDecimals map with the specified entries and key and value cardinality.
     *
     * @param <K>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param entries                The entries for the new map.
     * @return A new sorted BigDecimals map with the specified entries.
     */
    static <K> SortedBigDecimalMap<K> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<K> comparator, final Entry<K, BigDecimal>... entries) {
        return new SortedTreeMap<K>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new sorted BigDecimals map containing an entry with the key and the value.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key        The key for the entry.
     * @param value      The value for the entry.
     * @return A new sorted BigDecimals map containing an entry with the key and the value.
     */
    public static <K> SortedBigDecimalMap<K> of(final Comparator<K> comparator, final K key, final BigDecimal value) {
        return new SortedTreeMap<K>(comparator, new Entry<K, BigDecimal>(key, value));
    }

    /**
     * Returns a new sorted BigDecimals map containing two entries using the provided keys and values.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @return A new sorted BigDecimals map containing two entries using the provided keys and values.
     */
    public static <K> SortedBigDecimalMap<K> of(final Comparator<K> comparator, final K key1, final BigDecimal value1,
            final K key2, final BigDecimal value2) {
        return new SortedTreeMap<K>(comparator, new Entry<K, BigDecimal>(key1, value1), new Entry<K, BigDecimal>(key2, value2));
    }

    /**
     * Returns a new sorted BigDecimals map containing three entries using the provided keys and values.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @return A new sorted BigDecimals map containing three entries using the provided keys and values.
     */
    public static <K> SortedBigDecimalMap<K> of(final Comparator<K> comparator, final K key1, final BigDecimal value1,
            final K key2, final BigDecimal value2, final K key3, final BigDecimal value3) {
        return new SortedTreeMap<K>(comparator, new Entry<K, BigDecimal>(key1, value1), new Entry<K, BigDecimal>(key2, value2),
                new Entry<K, BigDecimal>(key3, value3));
    }

    /**
     * Returns a new sorted BigDecimals map containing four entries using the provided keys and values.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @param key4       The fourth key for the entry.
     * @param value4     The fourth value for the entry.
     * @return A new sorted BigDecimals map containing four entries using the provided keys and values.
     */
    public static <K> SortedBigDecimalMap<K> of(final Comparator<K> comparator, final K key1, final BigDecimal value1,
            final K key2, final BigDecimal value2, final K key3, final BigDecimal value3, final K key4, final BigDecimal value4) {
        return new SortedTreeMap<K>(comparator, new Entry<K, BigDecimal>(key1, value1), new Entry<K, BigDecimal>(key2, value2),
                new Entry<K, BigDecimal>(key3, value3), new Entry<K, BigDecimal>(key4, value4));
    }

    /**
     * Returns a new sorted BigDecimals map containing five entries using the provided keys and values.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @param key4       The fourth key for the entry.
     * @param value4     The fourth value for the entry.
     * @param key5       The fifth key for the entry.
     * @param value5     The fifth value for the entry.
     * @return A new sorted BigDecimals map containing five entries using the provided keys and values.
     */
    public static <K> SortedBigDecimalMap<K> of(final Comparator<K> comparator, final K key1, final BigDecimal value1,
            final K key2, final BigDecimal value2, final K key3, final BigDecimal value3, final K key4, final BigDecimal value4,
            final K key5, final BigDecimal value5) {
        return new SortedTreeMap<K>(comparator, new Entry<K, BigDecimal>(key1, value1), new Entry<K, BigDecimal>(key2, value2),
                new Entry<K, BigDecimal>(key3, value3), new Entry<K, BigDecimal>(key4, value4),
                new Entry<K, BigDecimal>(key5, value5));
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
