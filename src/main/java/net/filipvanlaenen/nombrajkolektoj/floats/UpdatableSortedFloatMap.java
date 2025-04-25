package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.UpdatableSortedMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap} interface for
 * Floats and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class UpdatableSortedFloatMap<K> extends AbstractUpdatableSortedFloatMap<K>
        implements UpdatableSortedNumericMap<K, Float> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.UpdatableSortedMap}
     * interface.
     *
     * @param <K> The key type.
     */
    public static final class ArrayMap<K> extends UpdatableSortedFloatMap<K> {
        /**
         * Constructs an updatable sorted map from another map, with the same keys and Floats and the same key and
         * value cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public ArrayMap(final Comparator<K> comparator, final Map<K, Float> source) {
            super(new net.filipvanlaenen.kolektoj.array.UpdatableSortedArrayMap<K, Float>(comparator, source));
        }

        /**
         * Constructs an updatable sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public ArrayMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<K> comparator,
                final Entry<K, Float>... entries) {
            super(new net.filipvanlaenen.kolektoj.array.UpdatableSortedArrayMap<K, Float>(keyAndValueCardinality,
                    comparator, entries));
        }

        /**
         * Constructs an updatable sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public ArrayMap(final Comparator<K> comparator, final Entry<K, Float>... entries) {
            super(new net.filipvanlaenen.kolektoj.array.UpdatableSortedArrayMap<K, Float>(comparator, entries));
        }
    }

    /**
     * Inner class using a sorted tree backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.UpdatableSortedMap} interface.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends UpdatableSortedFloatMap<K> {
        /**
         * Constructs an updatable sorted map from another map, with the same keys and Floats and the same key and
         * value cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<K> comparator, final Map<K, Float> source) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.UpdatableSortedTreeMap<K, Float>(comparator, source));
        }

        /**
         * Constructs an updatable sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<K> comparator,
                final Entry<K, Float>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.UpdatableSortedTreeMap<K, Float>(keyAndValueCardinality,
                    comparator, entries));
        }

        /**
         * Constructs an updatable sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<K> comparator, final Entry<K, Float>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.UpdatableSortedTreeMap<K, Float>(comparator, entries));
        }
    }

    /**
     * The updatable sorted map holding the keys and the floats.
     */
    private final UpdatableSortedMap<K, Float> map;

    /**
     * Private constructor taking a map with the keys and the floats as its parameter.
     *
     * @param map The map holding the keys and the floats.
     */
    private UpdatableSortedFloatMap(final UpdatableSortedMap<K, Float> map) {
        this.map = map;
    }

    @Override
    public boolean contains(final Entry<K, Float> entry) {
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
    public boolean containsValue(final Float value) {
        return map.containsValue(value);
    }

    /**
     * Returns a new empty floats map.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty floats map.
     */
    static <K> UpdatableSortedFloatMap<K> empty(final Comparator<K> comparator) {
        return new ArrayMap<K>(comparator);
    }

    @Override
    public Entry<K, Float> get() throws IndexOutOfBoundsException {
        return map.get();
    }

    @Override
    public Float get(final K key) throws IllegalArgumentException {
        return map.get(key);
    }

    @Override
    public NumericCollection<Float> getAll(final K key) throws IllegalArgumentException {
        return new FloatCollection.ArrayCollection(map.getAll(key));
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
    public NumericCollection<Float> getValues() {
        return new FloatCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, Float>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new updatable sorted floats map with the specified entries.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param entries    The entries for the new map.
     * @return A new updatable sorted floats map with the specified entries.
     */
    static <K> UpdatableSortedFloatMap<K> of(final Comparator<K> comparator, final Entry<K, Float>... entries) {
        return new SortedTreeMap<K>(comparator, entries);
    }

    /**
     * Returns a new updatable sorted floats map with the specified entries and key and value cardinality.
     *
     * @param <K>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param entries                The entries for the new map.
     * @return A new updatable sorted floats map with the specified entries.
     */
    static <K> UpdatableSortedFloatMap<K> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<K> comparator, final Entry<K, Float>... entries) {
        return new SortedTreeMap<K>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new updatable sorted floats map containing an entry with the key and the value.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key        The key for the entry.
     * @param value      The value for the entry.
     * @return A new updatable sorted floats map containing an entry with the key and the value.
     */
    public static <K> UpdatableSortedFloatMap<K> of(final Comparator<K> comparator, final K key, final Float value) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Float>(key, value));
    }

    /**
     * Returns a new updatable sorted floats map containing two entries using the provided keys and values.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @return A new updatable sorted floats map containing two entries using the provided keys and values.
     */
    public static <K> UpdatableSortedFloatMap<K> of(final Comparator<K> comparator, final K key1, final Float value1,
            final K key2, final Float value2) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Float>(key1, value1), new Entry<K, Float>(key2, value2));
    }

    /**
     * Returns a new updatable sorted floats map containing three entries using the provided keys and values.
     *
     * @param <K>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @return A new updatable sorted floats map containing three entries using the provided keys and values.
     */
    public static <K> UpdatableSortedFloatMap<K> of(final Comparator<K> comparator, final K key1, final Float value1,
            final K key2, final Float value2, final K key3, final Float value3) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Float>(key1, value1), new Entry<K, Float>(key2, value2),
                new Entry<K, Float>(key3, value3));
    }

    /**
     * Returns a new updatable sorted floats map containing four entries using the provided keys and values.
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
     * @return A new updatable sorted floats map containing four entries using the provided keys and values.
     */
    public static <K> UpdatableSortedFloatMap<K> of(final Comparator<K> comparator, final K key1, final Float value1,
            final K key2, final Float value2, final K key3, final Float value3, final K key4, final Float value4) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Float>(key1, value1), new Entry<K, Float>(key2, value2),
                new Entry<K, Float>(key3, value3), new Entry<K, Float>(key4, value4));
    }

    /**
     * Returns a new updatable sorted floats map containing five entries using the provided keys and values.
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
     * @return A new updatable sorted floats map containing five entries using the provided keys and values.
     */
    public static <K> UpdatableSortedFloatMap<K> of(final Comparator<K> comparator, final K key1, final Float value1,
            final K key2, final Float value2, final K key3, final Float value3, final K key4, final Float value4,
            final K key5, final Float value5) {
        return new SortedTreeMap<K>(comparator, new Entry<K, Float>(key1, value1), new Entry<K, Float>(key2, value2),
                new Entry<K, Float>(key3, value3), new Entry<K, Float>(key4, value4),
                new Entry<K, Float>(key5, value5));
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Spliterator<Entry<K, Float>> spliterator() {
        return map.spliterator();
    }

    @Override
    public Object[] toArray() {
        return map.toArray();
    }

    @Override
    public Float update(final K key, final Float value) throws IllegalArgumentException {
        return map.update(key, value);
    }
}
