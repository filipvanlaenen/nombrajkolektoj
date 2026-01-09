package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.ModifiableSortedMap;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap} interface
 * for Longs and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class ModifiableSortedLongMap<K> extends AbstractModifiableSortedLongMap<K>
        implements ModifiableSortedNumericMap<K, Long> {
    /**
     * Inner class using a sorted tree backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableSortedMap} interface.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends ModifiableSortedLongMap<K> {
        /**
         * Constructs a modifiable sorted map from another map, with the same keys and Longs and the same key and
         * value cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Map<? extends K, Long> source) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap<K, Long>(comparator, source));
        }

        /**
         * Constructs a modifiable sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality,
                final Comparator<? super K> comparator, final Entry<K, Long>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap<K, Long>(keyAndValueCardinality,
                    comparator, entries));
        }

        /**
         * Constructs a modifiable sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Entry<K, Long>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap<K, Long>(comparator, entries));
        }
    }

    /**
     * The modifiable sorted map holding the keys and the longs.
     */
    private final ModifiableSortedMap<K, Long> map;

    /**
     * Private constructor taking a map with the keys and the longs as its parameter.
     *
     * @param map The map holding the keys and the longs.
     */
    private ModifiableSortedLongMap(final ModifiableSortedMap<K, Long> map) {
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
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty longs map.
     */
    public static <L> ModifiableSortedLongMap<L> empty(final Comparator<? super L> comparator) {
        return new SortedTreeMap<L>(comparator);
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
    public Entry<K, Long> getGreaterThan(final K key) throws IndexOutOfBoundsException {
        return map.getGreaterThan(key);
    }

    @Override
    public Entry<K, Long> getGreaterThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return map.getGreaterThanOrEqualTo(key);
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
    public Entry<K, Long> getLeast() {
        return map.getLeast();
    }

    @Override
    public K getLeastKey() {
        return map.getLeastKey();
    }

    @Override
    public Entry<K, Long> getLessThan(final K key) throws IndexOutOfBoundsException {
        return map.getLessThan(key);
    }

    @Override
    public Entry<K, Long> getLessThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return map.getLessThanOrEqualTo(key);
    }

    @Override
    public OrderedNumericCollection<Long> getValues() {
        return new OrderedLongCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, Long>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new modifiable sorted longs map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param comparator   The comparator by which to sort the keys.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new modifiable sorted longs map with the specified entries.
     */
    public static <L> ModifiableSortedLongMap<L> of(final Comparator<? super L> comparator, final Long defaultValue,
            final L... keys) {
        ModifiableSortedLongMap<L> map = ModifiableSortedLongMap.<L>empty(comparator);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable sorted longs map cloned from the provided longs map but sorted according to the
     * comparator.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param map        The original longs map.
     * @return A new modifiable sorted longs map cloned from the provided longs map but sorted according to the
     *         comparator.
     */
    public static <L> ModifiableSortedLongMap<L> of(final Comparator<? super L> comparator,
            final LongMap<? extends L> map) {
        return new SortedTreeMap<L>(comparator, map);
    }

    /**
     * Returns a new modifiable sorted longs map with the specified entries.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param entries    The entries for the new map.
     * @return A new modifiable sorted longs map with the specified entries.
     */
    public static <L> ModifiableSortedLongMap<L> of(final Comparator<? super L> comparator,
            final Entry<L, Long>... entries) {
        return new SortedTreeMap<L>(comparator, entries);
    }

    /**
     * Returns a new modifiable sorted longs map containing an entry with the key and the value.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key        The key for the entry.
     * @param value      The value for the entry.
     * @return A new modifiable sorted longs map containing an entry with the key and the value.
     */
    public static <L> ModifiableSortedLongMap<L> of(final Comparator<? super L> comparator, final L key,
            final Long value) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Long>(key, value));
    }

    /**
     * Returns a new modifiable sorted longs map containing two entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @return A new modifiable sorted longs map containing two entries using the provided keys and values.
     */
    public static <L> ModifiableSortedLongMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Long value1, final L key2, final Long value2) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Long>(key1, value1), new Entry<L, Long>(key2, value2));
    }

    /**
     * Returns a new modifiable sorted longs map containing three entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @return A new modifiable sorted longs map containing three entries using the provided keys and values.
     */
    public static <L> ModifiableSortedLongMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Long value1, final L key2, final Long value2, final L key3, final Long value3) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Long>(key1, value1), new Entry<L, Long>(key2, value2),
                new Entry<L, Long>(key3, value3));
    }

    /**
     * Returns a new modifiable sorted longs map containing four entries using the provided keys and values.
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
     * @return A new modifiable sorted longs map containing four entries using the provided keys and values.
     */
    public static <L> ModifiableSortedLongMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Long value1, final L key2, final Long value2, final L key3, final Long value3, final L key4,
            final Long value4) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Long>(key1, value1), new Entry<L, Long>(key2, value2),
                new Entry<L, Long>(key3, value3), new Entry<L, Long>(key4, value4));
    }

    /**
     * Returns a new modifiable sorted longs map containing five entries using the provided keys and values.
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
     * @return A new modifiable sorted longs map containing five entries using the provided keys and values.
     */
    public static <L> ModifiableSortedLongMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Long value1, final L key2, final Long value2, final L key3, final Long value3, final L key4,
            final Long value4, final L key5, final Long value5) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Long>(key1, value1), new Entry<L, Long>(key2, value2),
                new Entry<L, Long>(key3, value3), new Entry<L, Long>(key4, value4),
                new Entry<L, Long>(key5, value5));
    }

    /**
     * Returns a new modifiable sorted longs map with the specified keys with a default value and key and value
     * cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new modifiable sorted longs map with the specified entries.
     */
    public static <L> ModifiableSortedLongMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Long defaultValue, final L... keys) {
        ModifiableSortedLongMap<L> map = ModifiableSortedLongMap.<L>of(keyAndValueCardinality, comparator);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable sorted longs map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param entries                The entries for the new map.
     * @return A new modifiable sorted longs map with the specified entries.
     */
    public static <L> ModifiableSortedLongMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Entry<L, Long>... entries) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new modifiable sorted longs map cloned from the provided sorted longs map.
     *
     * @param <L> The key type.
     * @param map The original sorted longs map.
     * @return A new modifiable sorted longs map cloned from the provided sorted longs map.
     */
    public static <L> ModifiableSortedLongMap<L> of(final SortedLongMap<L> map) {
        return new SortedTreeMap<L>(map.getComparator(), map);
    }

    /**
     * Returns a new modifiable sorted longs map cloned from the provided sorted longs map.
     *
     * @param <L>   The key type.
     * @param map   The original sorted longs map.
     * @param range The range.
     * @return A new modifiable sorted longs map cloned from the provided sorted longs map.
     */
    public static <L> ModifiableSortedLongMap<L> of(final SortedLongMap<L> map, final Range<L> range) {
        ModifiableSortedLongMap<L> result =
                ModifiableSortedLongMap.<L>of(map.getKeyAndValueCardinality(), map.getComparator());
        boolean below = true;
        for (Entry<L, Long> entry : map) {
            if (below && !range.isBelow(map.getComparator(), entry.key())) {
                below = false;
            }
            if (!below) {
                if (range.isAbove(map.getComparator(), entry.key())) {
                    break;
                }
                result.add(entry.key(), entry.value());
            }
        }
        return result;
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
    public Entry<K, Long> removeGreatest() {
        return map.removeGreatest();
    }

    @Override
    public boolean removeIf(final Predicate<Entry<? extends K, ? extends Long>> predicate) {
        return map.removeIf(predicate);
    }

    @Override
    public Entry<K, Long> removeLeast() {
        return map.removeLeast();
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
    public boolean update(final K key, final Long oldValye, final Long newValue) {
        return map.update(key, oldValye, newValue);
    }
}
