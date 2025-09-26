package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

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

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap} interface
 * for BigIntegers and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class ModifiableSortedBigIntegerMap<K> extends AbstractModifiableSortedBigIntegerMap<K>
        implements ModifiableSortedNumericMap<K, BigInteger> {
    /**
     * Inner class using a sorted tree backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableSortedMap} interface.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends ModifiableSortedBigIntegerMap<K> {
        /**
         * Constructs a modifiable sorted map from another map, with the same keys and BigIntegers and the same key and
         * value cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<K> comparator, final Map<K, BigInteger> source) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap<K, BigInteger>(comparator, source));
        }

        /**
         * Constructs a modifiable sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<K> comparator,
                final Entry<K, BigInteger>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap<K, BigInteger>(keyAndValueCardinality,
                    comparator, entries));
        }

        /**
         * Constructs a modifiable sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<K> comparator, final Entry<K, BigInteger>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap<K, BigInteger>(comparator, entries));
        }
    }

    /**
     * The modifiable sorted map holding the keys and the BigIntegers.
     */
    private final ModifiableSortedMap<K, BigInteger> map;

    /**
     * Private constructor taking a map with the keys and the BigIntegers as its parameter.
     *
     * @param map The map holding the keys and the BigIntegers.
     */
    private ModifiableSortedBigIntegerMap(final ModifiableSortedMap<K, BigInteger> map) {
        this.map = map;
    }

    @Override
    public boolean add(final K key, final BigInteger value) {
        return map.add(key, value);
    }

    @Override
    public boolean addAll(final Map<? extends K, ? extends BigInteger> aMap) {
        return map.addAll(aMap);
    }

    @Override
    public void clear() {
        map.clear();
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
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty BigIntegers map.
     */
    static <L> ModifiableSortedBigIntegerMap<L> empty(final Comparator<L> comparator) {
        return new SortedTreeMap<L>(comparator);
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
    public Comparator<? super K> getComparator() {
        return map.getComparator();
    }

    @Override
    public Entry<K, BigInteger> getGreatest() {
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
    public Entry<K, BigInteger> getLeast() {
        return map.getLeast();
    }

    @Override
    public K getLeastKey() {
        return map.getLeastKey();
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
     * Returns a new modifiable sorted BigIntegers map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param comparator   The comparator by which to sort the keys.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new modifiable sorted BigIntegers map with the specified entries.
     */
    static <L> ModifiableSortedBigIntegerMap<L> of(final Comparator<L> comparator, final BigInteger defaultValue,
            final L... keys) {
        ModifiableSortedBigIntegerMap<L> map = ModifiableSortedBigIntegerMap.<L>empty(comparator);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable sorted BigIntegers map with the specified entries.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param entries    The entries for the new map.
     * @return A new modifiable sorted BigIntegers map with the specified entries.
     */
    static <L> ModifiableSortedBigIntegerMap<L> of(final Comparator<L> comparator, final Entry<L, BigInteger>... entries) {
        return new SortedTreeMap<L>(comparator, entries);
    }

    /**
     * Returns a new modifiable sorted BigIntegers map with the specified keys with a default value and key and value
     * cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new modifiable sorted BigIntegers map with the specified entries.
     */
    static <L> ModifiableSortedBigIntegerMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<L> comparator, final BigInteger defaultValue, final L... keys) {
        ModifiableSortedBigIntegerMap<L> map = ModifiableSortedBigIntegerMap.<L>of(keyAndValueCardinality, comparator);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable sorted BigIntegers map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param entries                The entries for the new map.
     * @return A new modifiable sorted BigIntegers map with the specified entries.
     */
    static <L> ModifiableSortedBigIntegerMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<L> comparator, final Entry<L, BigInteger>... entries) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new modifiable sorted BigIntegers map containing an entry with the key and the value.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key        The key for the entry.
     * @param value      The value for the entry.
     * @return A new modifiable sorted BigIntegers map containing an entry with the key and the value.
     */
    public static <L> ModifiableSortedBigIntegerMap<L> of(final Comparator<L> comparator, final L key, final BigInteger value) {
        return new SortedTreeMap<L>(comparator, new Entry<L, BigInteger>(key, value));
    }

    /**
     * Returns a new modifiable sorted BigIntegers map containing two entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @return A new modifiable sorted BigIntegers map containing two entries using the provided keys and values.
     */
    public static <L> ModifiableSortedBigIntegerMap<L> of(final Comparator<L> comparator, final L key1, final BigInteger value1,
            final L key2, final BigInteger value2) {
        return new SortedTreeMap<L>(comparator, new Entry<L, BigInteger>(key1, value1), new Entry<L, BigInteger>(key2, value2));
    }

    /**
     * Returns a new modifiable sorted BigIntegers map containing three entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @return A new modifiable sorted BigIntegers map containing three entries using the provided keys and values.
     */
    public static <L> ModifiableSortedBigIntegerMap<L> of(final Comparator<L> comparator, final L key1, final BigInteger value1,
            final L key2, final BigInteger value2, final L key3, final BigInteger value3) {
        return new SortedTreeMap<L>(comparator, new Entry<L, BigInteger>(key1, value1), new Entry<L, BigInteger>(key2, value2),
                new Entry<L, BigInteger>(key3, value3));
    }

    /**
     * Returns a new modifiable sorted BigIntegers map containing four entries using the provided keys and values.
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
     * @return A new modifiable sorted BigIntegers map containing four entries using the provided keys and values.
     */
    public static <L> ModifiableSortedBigIntegerMap<L> of(final Comparator<L> comparator, final L key1, final BigInteger value1,
            final L key2, final BigInteger value2, final L key3, final BigInteger value3, final L key4, final BigInteger value4) {
        return new SortedTreeMap<L>(comparator, new Entry<L, BigInteger>(key1, value1), new Entry<L, BigInteger>(key2, value2),
                new Entry<L, BigInteger>(key3, value3), new Entry<L, BigInteger>(key4, value4));
    }

    /**
     * Returns a new modifiable sorted BigIntegers map containing five entries using the provided keys and values.
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
     * @return A new modifiable sorted BigIntegers map containing five entries using the provided keys and values.
     */
    public static <L> ModifiableSortedBigIntegerMap<L> of(final Comparator<L> comparator, final L key1, final BigInteger value1,
            final L key2, final BigInteger value2, final L key3, final BigInteger value3, final L key4, final BigInteger value4,
            final L key5, final BigInteger value5) {
        return new SortedTreeMap<L>(comparator, new Entry<L, BigInteger>(key1, value1), new Entry<L, BigInteger>(key2, value2),
                new Entry<L, BigInteger>(key3, value3), new Entry<L, BigInteger>(key4, value4),
                new Entry<L, BigInteger>(key5, value5));
    }

    @Override
    public BigInteger remove(final K key) throws IllegalArgumentException {
        return map.remove(key);
    }

    @Override
    public boolean removeAll(final Map<? extends K, ? extends BigInteger> aMap) {
        return map.removeAll(aMap);
    }

    @Override
    public Entry<K, BigInteger> removeGreatest() {
        return map.removeGreatest();
    }

    @Override
    public boolean removeIf(final Predicate<Entry<? extends K, ? extends BigInteger>> predicate) {
        return map.removeIf(predicate);
    }

    @Override
    public Entry<K, BigInteger> removeLeast() {
        return map.removeLeast();
    }

    @Override
    public boolean retainAll(final Map<? extends K, ? extends BigInteger> aMap) {
        return map.retainAll(aMap);
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

    @Override
    public BigInteger update(final K key, final BigInteger value) throws IllegalArgumentException {
        return map.update(key, value);
    }
}
