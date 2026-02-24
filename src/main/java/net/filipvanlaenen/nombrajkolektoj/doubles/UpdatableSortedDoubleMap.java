package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.kolektoj.UpdatableSortedMap;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericMap;
import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap} interface for
 * Doubles and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class UpdatableSortedDoubleMap<K> extends AbstractUpdatableSortedDoubleMap<K>
        implements UpdatableSortedNumericMap<K, Double> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.UpdatableSortedMap}
     * interface.
     *
     * @param <K> The key type.
     */
    public static final class ArrayMap<K> extends UpdatableSortedDoubleMap<K> {
        /**
         * Constructs an updatable sorted map from another map, with the same keys and Doubles and the same key and
         * value cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public ArrayMap(final Comparator<? super K> comparator, final Map<? extends K, Double> source) {
            super(new net.filipvanlaenen.kolektoj.array.UpdatableSortedArrayMap<K, Double>(comparator, source));
        }

        /**
         * Constructs an updatable sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public ArrayMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<? super K> comparator,
                final Entry<K, Double>... entries) {
            super(new net.filipvanlaenen.kolektoj.array.UpdatableSortedArrayMap<K, Double>(keyAndValueCardinality,
                    comparator, entries));
        }

        /**
         * Constructs an updatable sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public ArrayMap(final Comparator<? super K> comparator, final Entry<K, Double>... entries) {
            super(new net.filipvanlaenen.kolektoj.array.UpdatableSortedArrayMap<K, Double>(comparator, entries));
        }
    }

    /**
     * Inner class using a sorted tree backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.UpdatableSortedMap} interface.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends UpdatableSortedDoubleMap<K> {
        /**
         * Constructs an updatable sorted map from another map, with the same keys and Doubles and the same key and
         * value cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Map<? extends K, Double> source) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.UpdatableSortedTreeMap<K, Double>(comparator, source));
        }

        /**
         * Constructs an updatable sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality,
                final Comparator<? super K> comparator, final Entry<K, Double>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.UpdatableSortedTreeMap<K, Double>(keyAndValueCardinality,
                    comparator, entries));
        }

        /**
         * Constructs an updatable sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Entry<K, Double>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.UpdatableSortedTreeMap<K, Double>(comparator, entries));
        }
    }

    /**
     * The updatable sorted map holding the keys and the doubles.
     */
    private final UpdatableSortedMap<K, Double> map;

    /**
     * Private constructor taking a map with the keys and the doubles as its parameter.
     *
     * @param map The map holding the keys and the doubles.
     */
    private UpdatableSortedDoubleMap(final UpdatableSortedMap<K, Double> map) {
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
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty doubles map.
     */
    public static <L> UpdatableSortedDoubleMap<L> empty(final Comparator<? super L> comparator) {
        return new ArrayMap<L>(comparator);
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
    public DoubleCollection getAll(final K key) throws IllegalArgumentException {
        return new DoubleCollection.ArrayCollection(map.getAll(key));
    }

    @Override
    public Comparator<? super K> getComparator() {
        return map.getComparator();
    }

    @Override
    public Entry<K, Double> getGreaterThan(final K key) throws IndexOutOfBoundsException {
        return map.getGreaterThan(key);
    }

    @Override
    public Entry<K, Double> getGreaterThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return map.getGreaterThanOrEqualTo(key);
    }

    @Override
    public Entry<K, Double> getGreatest() {
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
    public Entry<K, Double> getLeast() {
        return map.getLeast();
    }

    @Override
    public K getLeastKey() {
        return map.getLeastKey();
    }

    @Override
    public Entry<K, Double> getLessThan(final K key) throws IndexOutOfBoundsException {
        return map.getLessThan(key);
    }

    @Override
    public Entry<K, Double> getLessThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return map.getLessThanOrEqualTo(key);
    }

    @Override
    public OrderedDoubleCollection getValues() {
        return new OrderedDoubleCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, Double>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new updatable sorted doubles map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param comparator   The comparator by which to sort the keys.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new updatable sorted doubles map with the specified entries.
     */
    public static <L> UpdatableSortedDoubleMap<L> of(final Comparator<? super L> comparator, final Double defaultValue,
            final L... keys) {
        ModifiableDoubleMap<L> map = ModifiableDoubleMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new SortedTreeMap<L>(comparator, map);
    }

    /**
     * Returns a new updatable sorted doubles map cloned from the provided double map but sorted according to the
     * comparator.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param map        The original doubles map.
     * @return A new updatable sorted doubles map cloned from the provided doubles map but sorted according to the
     *         comparator.
     */
    public static <L> UpdatableSortedDoubleMap<L> of(final Comparator<? super L> comparator,
            final NumericMap<? extends L, Double> map) {
        return new SortedTreeMap<L>(comparator, map);
    }

    /**
     * Returns a new updatable sorted doubles map with the specified entries.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param entries    The entries for the new map.
     * @return A new updatable sorted doubles map with the specified entries.
     */
    public static <L> UpdatableSortedDoubleMap<L> of(final Comparator<? super L> comparator,
            final Entry<L, Double>... entries) {
        return new SortedTreeMap<L>(comparator, entries);
    }

    /**
     * Returns a new updatable sorted doubles map containing an entry with the key and the value.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key        The key for the entry.
     * @param value      The value for the entry.
     * @return A new updatable sorted doubles map containing an entry with the key and the value.
     */
    public static <L> UpdatableSortedDoubleMap<L> of(final Comparator<? super L> comparator, final L key,
            final Double value) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Double>(key, value));
    }

    /**
     * Returns a new updatable sorted doubles map containing two entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @return A new updatable sorted doubles map containing two entries using the provided keys and values.
     */
    public static <L> UpdatableSortedDoubleMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Double value1, final L key2, final Double value2) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2));
    }

    /**
     * Returns a new updatable sorted doubles map containing three entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @return A new updatable sorted doubles map containing three entries using the provided keys and values.
     */
    public static <L> UpdatableSortedDoubleMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Double value1, final L key2, final Double value2, final L key3, final Double value3) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2),
                new Entry<L, Double>(key3, value3));
    }

    /**
     * Returns a new updatable sorted doubles map containing four entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @param key4       The fourth key for the entry.
     * @param value4     The fourth value for the entry.
     * @return A new updatable sorted doubles map containing four entries using the provided keys and values.
     */
    public static <L> UpdatableSortedDoubleMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Double value1, final L key2, final Double value2, final L key3, final Double value3, final L key4,
            final Double value4) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2),
                new Entry<L, Double>(key3, value3), new Entry<L, Double>(key4, value4));
    }

    /**
     * Returns a new updatable sorted doubles map containing five entries using the provided keys and values.
     *
     * @param <L>        The key type.
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
     * @return A new updatable sorted doubles map containing five entries using the provided keys and values.
     */
    public static <L> UpdatableSortedDoubleMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Double value1, final L key2, final Double value2, final L key3, final Double value3, final L key4,
            final Double value4, final L key5, final Double value5) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2),
                new Entry<L, Double>(key3, value3), new Entry<L, Double>(key4, value4),
                new Entry<L, Double>(key5, value5));
    }

    /**
     * Returns a new updatable sorted doubles map with the specified keys with a default value and key and value
     * cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new updatable sorted doubles map with the specified entries.
     */
    public static <L> UpdatableSortedDoubleMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Double defaultValue, final L... keys) {
        ModifiableDoubleMap<L> map = ModifiableDoubleMap.<L>of(keyAndValueCardinality);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new SortedTreeMap<L>(comparator, map);
    }

    /**
     * Returns a new updatable sorted doubles map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param entries                The entries for the new map.
     * @return A new updatable sorted doubles map with the specified entries.
     */
    public static <L> UpdatableSortedDoubleMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Entry<L, Double>... entries) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new updatable sorted doubles map cloned from the provided sorted doubles map.
     *
     * @param <L> The key type.
     * @param map The original sorted doubles map.
     * @return A new updatable sorted doubles map cloned from the provided sorted doubles map.
     */
    public static <L> UpdatableSortedDoubleMap<L> of(final SortedNumericMap<L, Double> map) {
        return new SortedTreeMap<L>(map.getComparator(), map);
    }

    /**
     * Returns a new updatable sorted doubles map cloned from the provided sorted doubles map.
     *
     * @param <L>   The key type.
     * @param map   The original sorted doubles map.
     * @param range The range.
     * @return A new updatable sorted doubles map cloned from the provided sorted doubles map.
     */
    public static <L> UpdatableSortedDoubleMap<L> of(final SortedNumericMap<L, Double> map, final Range<L> range) {
        ModifiableSortedDoubleMap<L> slice =
                ModifiableSortedDoubleMap.<L>of(map.getKeyAndValueCardinality(), map.getComparator());
        boolean below = true;
        for (Entry<L, Double> entry : map) {
            if (below && !range.isBelow(map.getComparator(), entry.key())) {
                below = false;
            }
            if (!below) {
                if (range.isAbove(map.getComparator(), entry.key())) {
                    break;
                }
                slice.add(entry.key(), entry.value());
            }
        }
        return new SortedTreeMap<L>(map.getComparator(), slice);
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
