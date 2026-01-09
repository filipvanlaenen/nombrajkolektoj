package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.ModifiableSortedMap;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap} interface
 * for Integers and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class ModifiableSortedIntegerMap<K> extends AbstractModifiableSortedIntegerMap<K>
        implements ModifiableSortedNumericMap<K, Integer> {
    /**
     * Inner class using a sorted tree backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableSortedMap} interface.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends ModifiableSortedIntegerMap<K> {
        /**
         * Constructs a modifiable sorted map from another map, with the same keys and Integers and the same key and
         * value cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Map<K, Integer> source) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap<K, Integer>(comparator, source));
        }

        /**
         * Constructs a modifiable sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality,
                final Comparator<? super K> comparator, final Entry<K, Integer>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap<K, Integer>(keyAndValueCardinality,
                    comparator, entries));
        }

        /**
         * Constructs a modifiable sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Entry<K, Integer>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap<K, Integer>(comparator, entries));
        }
    }

    /**
     * The modifiable sorted map holding the keys and the integers.
     */
    private final ModifiableSortedMap<K, Integer> map;

    /**
     * Private constructor taking a map with the keys and the integers as its parameter.
     *
     * @param map The map holding the keys and the integers.
     */
    private ModifiableSortedIntegerMap(final ModifiableSortedMap<K, Integer> map) {
        this.map = map;
    }

    @Override
    public boolean add(final K key, final Integer value) {
        return map.add(key, value);
    }

    @Override
    public boolean addAll(final Map<? extends K, ? extends Integer> aMap) {
        return map.addAll(aMap);
    }

    @Override
    public void clear() {
        map.clear();
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
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty integers map.
     */
    public static <L> ModifiableSortedIntegerMap<L> empty(final Comparator<? super L> comparator) {
        return new SortedTreeMap<L>(comparator);
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
    public Entry<K, Integer> getGreaterThan(final K key) throws IndexOutOfBoundsException {
        return map.getGreaterThan(key);
    }

    @Override
    public Entry<K, Integer> getGreaterThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return map.getGreaterThanOrEqualTo(key);
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
    public Entry<K, Integer> getLeast() {
        return map.getLeast();
    }

    @Override
    public K getLeastKey() {
        return map.getLeastKey();
    }

    @Override
    public Entry<K, Integer> getLessThan(final K key) throws IndexOutOfBoundsException {
        return map.getLessThan(key);
    }

    @Override
    public Entry<K, Integer> getLessThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return map.getLessThanOrEqualTo(key);
    }

    @Override
    public OrderedNumericCollection<Integer> getValues() {
        return new OrderedIntegerCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, Integer>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new modifiable sorted integers map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param comparator   The comparator by which to sort the keys.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new modifiable sorted integers map with the specified entries.
     */
    public static <L> ModifiableSortedIntegerMap<L> of(final Comparator<? super L> comparator, final Integer defaultValue,
            final L... keys) {
        ModifiableSortedIntegerMap<L> map = ModifiableSortedIntegerMap.<L>empty(comparator);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable sorted integers map with the specified entries.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param entries    The entries for the new map.
     * @return A new modifiable sorted integers map with the specified entries.
     */
    public static <L> ModifiableSortedIntegerMap<L> of(final Comparator<? super L> comparator,
            final Entry<L, Integer>... entries) {
        return new SortedTreeMap<L>(comparator, entries);
    }

    /**
     * Returns a new modifiable sorted integers map with the specified keys with a default value and key and value
     * cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new modifiable sorted integers map with the specified entries.
     */
    public static <L> ModifiableSortedIntegerMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Integer defaultValue, final L... keys) {
        ModifiableSortedIntegerMap<L> map = ModifiableSortedIntegerMap.<L>of(keyAndValueCardinality, comparator);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable sorted integers map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param entries                The entries for the new map.
     * @return A new modifiable sorted integers map with the specified entries.
     */
    public static <L> ModifiableSortedIntegerMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Entry<L, Integer>... entries) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new modifiable sorted integers map containing an entry with the key and the value.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key        The key for the entry.
     * @param value      The value for the entry.
     * @return A new modifiable sorted integers map containing an entry with the key and the value.
     */
    public static <L> ModifiableSortedIntegerMap<L> of(final Comparator<? super L> comparator, final L key,
            final Integer value) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Integer>(key, value));
    }

    /**
     * Returns a new modifiable sorted integers map containing two entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @return A new modifiable sorted integers map containing two entries using the provided keys and values.
     */
    public static <L> ModifiableSortedIntegerMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Integer value1, final L key2, final Integer value2) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Integer>(key1, value1), new Entry<L, Integer>(key2, value2));
    }

    /**
     * Returns a new modifiable sorted integers map containing three entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @return A new modifiable sorted integers map containing three entries using the provided keys and values.
     */
    public static <L> ModifiableSortedIntegerMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Integer value1, final L key2, final Integer value2, final L key3, final Integer value3) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Integer>(key1, value1), new Entry<L, Integer>(key2, value2),
                new Entry<L, Integer>(key3, value3));
    }

    /**
     * Returns a new modifiable sorted integers map containing four entries using the provided keys and values.
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
     * @return A new modifiable sorted integers map containing four entries using the provided keys and values.
     */
    public static <L> ModifiableSortedIntegerMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Integer value1, final L key2, final Integer value2, final L key3, final Integer value3, final L key4,
            final Integer value4) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Integer>(key1, value1), new Entry<L, Integer>(key2, value2),
                new Entry<L, Integer>(key3, value3), new Entry<L, Integer>(key4, value4));
    }

    /**
     * Returns a new modifiable sorted integers map containing five entries using the provided keys and values.
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
     * @return A new modifiable sorted integers map containing five entries using the provided keys and values.
     */
    public static <L> ModifiableSortedIntegerMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Integer value1, final L key2, final Integer value2, final L key3, final Integer value3, final L key4,
            final Integer value4, final L key5, final Integer value5) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Integer>(key1, value1), new Entry<L, Integer>(key2, value2),
                new Entry<L, Integer>(key3, value3), new Entry<L, Integer>(key4, value4),
                new Entry<L, Integer>(key5, value5));
    }

    @Override
    public Integer remove(final K key) throws IllegalArgumentException {
        return map.remove(key);
    }

    @Override
    public boolean remove(final K key, final Integer value) {
        return map.remove(key, value);
    }

    @Override
    public boolean removeAll(final Map<? extends K, ? extends Integer> aMap) {
        return map.removeAll(aMap);
    }

    @Override
    public Entry<K, Integer> removeGreatest() {
        return map.removeGreatest();
    }

    @Override
    public boolean removeIf(final Predicate<Entry<? extends K, ? extends Integer>> predicate) {
        return map.removeIf(predicate);
    }

    @Override
    public Entry<K, Integer> removeLeast() {
        return map.removeLeast();
    }

    @Override
    public boolean retainAll(final Map<? extends K, ? extends Integer> aMap) {
        return map.retainAll(aMap);
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

    @Override
    public Integer update(final K key, final Integer value) throws IllegalArgumentException {
        return map.update(key, value);
    }

    @Override
    public boolean update(final K key, final Integer oldValye, final Integer newValue) {
        return map.update(key, oldValye, newValue);
    }
}
