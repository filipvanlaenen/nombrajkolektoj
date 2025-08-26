package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.SortedMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericMap;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericMap} interface for Integers
 * and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class SortedIntegerMap<K> extends AbstractSortedIntegerMap<K> implements SortedNumericMap<K, Integer> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedMap} interface.
     *
     * @param <K> The key type.
     */
    public static final class ArrayMap<K> extends SortedIntegerMap<K> {
        /**
         * Constructs a sorted map from another map, with the same keys and Integers and the same key and value
         * cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public ArrayMap(final Comparator<K> comparator, final Map<K, Integer> source) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayMap<K, Integer>(comparator, source));
        }

        /**
         * Constructs a sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public ArrayMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<K> comparator,
                final Entry<K, Integer>... entries) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayMap<K, Integer>(keyAndValueCardinality, comparator,
                    entries));
        }

        /**
         * Constructs a sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public ArrayMap(final Comparator<K> comparator, final Entry<K, Integer>... entries) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayMap<K, Integer>(comparator, entries));
        }
    }

    /**
     * Inner class using a sorted tree backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedMap}
     * interface.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends SortedIntegerMap<K> {
        /**
         * Constructs a sorted map from another map, with the same keys and Integers and the same key and value
         * cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<K> comparator, final Map<K, Integer> source) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Integer>(comparator, source));
        }

        /**
         * Constructs a sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<K> comparator,
                final Entry<K, Integer>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Integer>(keyAndValueCardinality,
                    comparator, entries));
        }

        /**
         * Constructs a sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<K> comparator, final Entry<K, Integer>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Integer>(comparator, entries));
        }
    }

    /**
     * The sorted map holding the keys and the integers.
     */
    private final SortedMap<K, Integer> map;

    /**
     * Private constructor taking a map with the keys and the integers as its parameter.
     *
     * @param map The map holding the keys and the integers.
     */
    private SortedIntegerMap(final SortedMap<K, Integer> map) {
        this.map = map;
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
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty integers map.
     */
    static <K> SortedIntegerMap<K> empty(final Comparator<K> comparator) {
        return new ArrayMap<K>(comparator);
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
    public Comparator<? super K> getComparator() {
        return map.getComparator();
    }

    @Override
    public Entry<K, Integer> getGreatest() {
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
    public Collection<K> getKeys() {
        return map.getKeys();
    }

    @Override
    public Entry<K, Integer> getLeast() {
        return map.getLeast();
    }

    @Override
    public K getLeastKey() {
        return map.getLeastKey();
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
     * Returns a new sorted integers map with the specified entries.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param entries    The entries for the new map.
     * @return A new sorted integers map with the specified entries.
     */
    static <K> SortedIntegerMap<K> of(final Comparator<K> comparator, final Entry<K, Integer>... entries) {
        return new SortedTreeMap<K>(comparator, entries);
    }

    /**
     * Returns a new sorted integers map with the specified entries and key and value cardinality.
     *
     * @param <K>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param entries                The entries for the new map.
     * @return A new sorted integers map with the specified entries.
     */
    static <K> SortedIntegerMap<K> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<K> comparator, final Entry<K, Integer>... entries) {
        return new SortedTreeMap<K>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new sorted integers map containing an entry with the key and the value.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key        The key for the entry.
     * @param value      The value for the entry.
     * @return A new sorted integers map containing an entry with the key and the value.
     */
    public static <K> SortedIntegerMap<K> of(final Comparator<K> comparator, final K key, final Integer value) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Integer>(key, value));
    }

    /**
     * Returns a new sorted integers map containing two entries using the provided keys and values.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @return A new sorted integers map containing two entries using the provided keys and values.
     */
    public static <K> SortedIntegerMap<K> of(final Comparator<K> comparator, final K key1, final Integer value1,
            final K key2, final Integer value2) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Integer>(key1, value1), new Entry<K, Integer>(key2, value2));
    }

    /**
     * Returns a new sorted integers map containing three entries using the provided keys and values.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @return A new sorted integers map containing three entries using the provided keys and values.
     */
    public static <K> SortedIntegerMap<K> of(final Comparator<K> comparator, final K key1, final Integer value1,
            final K key2, final Integer value2, final K key3, final Integer value3) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Integer>(key1, value1), new Entry<K, Integer>(key2, value2),
                new Entry<K, Integer>(key3, value3));
    }

    /**
     * Returns a new sorted integers map containing four entries using the provided keys and values.
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
     * @return A new sorted integers map containing four entries using the provided keys and values.
     */
    public static <K> SortedIntegerMap<K> of(final Comparator<K> comparator, final K key1, final Integer value1,
            final K key2, final Integer value2, final K key3, final Integer value3, final K key4, final Integer value4) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Integer>(key1, value1), new Entry<K, Integer>(key2, value2),
                new Entry<K, Integer>(key3, value3), new Entry<K, Integer>(key4, value4));
    }

    /**
     * Returns a new sorted integers map containing five entries using the provided keys and values.
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
     * @return A new sorted integers map containing five entries using the provided keys and values.
     */
    public static <K> SortedIntegerMap<K> of(final Comparator<K> comparator, final K key1, final Integer value1,
            final K key2, final Integer value2, final K key3, final Integer value3, final K key4, final Integer value4,
            final K key5, final Integer value5) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Integer>(key1, value1), new Entry<K, Integer>(key2, value2),
                new Entry<K, Integer>(key3, value3), new Entry<K, Integer>(key4, value4),
                new Entry<K, Integer>(key5, value5));
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
}
