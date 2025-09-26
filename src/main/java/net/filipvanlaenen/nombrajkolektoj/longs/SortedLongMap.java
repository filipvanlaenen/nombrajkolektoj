package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.kolektoj.SortedMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericMap;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericMap} interface for Longs
 * and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class SortedLongMap<K> extends AbstractSortedLongMap<K> implements SortedNumericMap<K, Long> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedMap} interface.
     *
     * @param <K> The key type.
     */
    public static final class ArrayMap<K> extends SortedLongMap<K> {
        /**
         * Constructs a sorted map from another map, with the same keys and Longs and the same key and value
         * cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public ArrayMap(final Comparator<K> comparator, final Map<K, Long> source) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayMap<K, Long>(comparator, source));
        }

        /**
         * Constructs a sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public ArrayMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<K> comparator,
                final Entry<K, Long>... entries) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayMap<K, Long>(keyAndValueCardinality, comparator,
                    entries));
        }

        /**
         * Constructs a sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public ArrayMap(final Comparator<K> comparator, final Entry<K, Long>... entries) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayMap<K, Long>(comparator, entries));
        }
    }

    /**
     * Inner class using a sorted tree backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedMap}
     * interface.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends SortedLongMap<K> {
        /**
         * Constructs a sorted map from another map, with the same keys and Longs and the same key and value
         * cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<K> comparator, final Map<K, Long> source) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Long>(comparator, source));
        }

        /**
         * Constructs a sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<K> comparator,
                final Entry<K, Long>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Long>(keyAndValueCardinality,
                    comparator, entries));
        }

        /**
         * Constructs a sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<K> comparator, final Entry<K, Long>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Long>(comparator, entries));
        }
    }

    /**
     * The sorted map holding the keys and the longs.
     */
    private final SortedMap<K, Long> map;

    /**
     * Private constructor taking a map with the keys and the longs as its parameter.
     *
     * @param map The map holding the keys and the longs.
     */
    private SortedLongMap(final SortedMap<K, Long> map) {
        this.map = map;
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
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty longs map.
     */
    static <K> SortedLongMap<K> empty(final Comparator<K> comparator) {
        return new ArrayMap<K>(comparator);
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
    public NumericCollection<Long> getAll(final K key) throws IllegalArgumentException {
        return new LongCollection.ArrayCollection(map.getAll(key));
    }

    @Override
    public Comparator<? super K> getComparator() {
        return map.getComparator();
    }

    @Override
    public Entry<K, Long> getGreatest() {
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
    public SortedCollection<K> getKeys() {
        return map.getKeys();
    }

    @Override
    public Entry<K, Long> getLeast() {
        return map.getLeast();
    }

    @Override
    public K getLeastKey() {
        return map.getLeastKey();
    }

    @Override
    public NumericCollection<Long> getValues() {
        return new LongCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, Long>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new sorted longs map with the specified entries.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param entries    The entries for the new map.
     * @return A new sorted longs map with the specified entries.
     */
    static <K> SortedLongMap<K> of(final Comparator<K> comparator, final Entry<K, Long>... entries) {
        return new SortedTreeMap<K>(comparator, entries);
    }

    /**
     * Returns a new sorted longs map with the specified entries and key and value cardinality.
     *
     * @param <K>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param entries                The entries for the new map.
     * @return A new sorted longs map with the specified entries.
     */
    static <K> SortedLongMap<K> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<K> comparator, final Entry<K, Long>... entries) {
        return new SortedTreeMap<K>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new sorted longs map containing an entry with the key and the value.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key        The key for the entry.
     * @param value      The value for the entry.
     * @return A new sorted longs map containing an entry with the key and the value.
     */
    public static <K> SortedLongMap<K> of(final Comparator<K> comparator, final K key, final Long value) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Long>(key, value));
    }

    /**
     * Returns a new sorted longs map containing two entries using the provided keys and values.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @return A new sorted longs map containing two entries using the provided keys and values.
     */
    public static <K> SortedLongMap<K> of(final Comparator<K> comparator, final K key1, final Long value1,
            final K key2, final Long value2) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Long>(key1, value1), new Entry<K, Long>(key2, value2));
    }

    /**
     * Returns a new sorted longs map containing three entries using the provided keys and values.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @return A new sorted longs map containing three entries using the provided keys and values.
     */
    public static <K> SortedLongMap<K> of(final Comparator<K> comparator, final K key1, final Long value1,
            final K key2, final Long value2, final K key3, final Long value3) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Long>(key1, value1), new Entry<K, Long>(key2, value2),
                new Entry<K, Long>(key3, value3));
    }

    /**
     * Returns a new sorted longs map containing four entries using the provided keys and values.
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
     * @return A new sorted longs map containing four entries using the provided keys and values.
     */
    public static <K> SortedLongMap<K> of(final Comparator<K> comparator, final K key1, final Long value1,
            final K key2, final Long value2, final K key3, final Long value3, final K key4, final Long value4) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Long>(key1, value1), new Entry<K, Long>(key2, value2),
                new Entry<K, Long>(key3, value3), new Entry<K, Long>(key4, value4));
    }

    /**
     * Returns a new sorted longs map containing five entries using the provided keys and values.
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
     * @return A new sorted longs map containing five entries using the provided keys and values.
     */
    public static <K> SortedLongMap<K> of(final Comparator<K> comparator, final K key1, final Long value1,
            final K key2, final Long value2, final K key3, final Long value3, final K key4, final Long value4,
            final K key5, final Long value5) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Long>(key1, value1), new Entry<K, Long>(key2, value2),
                new Entry<K, Long>(key3, value3), new Entry<K, Long>(key4, value4),
                new Entry<K, Long>(key5, value5));
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
}
