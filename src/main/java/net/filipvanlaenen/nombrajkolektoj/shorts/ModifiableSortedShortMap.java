package net.filipvanlaenen.nombrajkolektoj.shorts;

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
 * for Shorts and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class ModifiableSortedShortMap<K> extends AbstractModifiableSortedShortMap<K>
        implements ModifiableSortedNumericMap<K, Short> {
    /**
     * Inner class using a sorted tree backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableSortedMap} interface.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends ModifiableSortedShortMap<K> {
        /**
         * Constructs a modifiable sorted map from another map, with the same keys and Shorts and the same key and
         * value cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<K> comparator, final Map<K, Short> source) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap<K, Short>(comparator, source));
        }

        /**
         * Constructs a modifiable sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<K> comparator,
                final Entry<K, Short>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap<K, Short>(keyAndValueCardinality,
                    comparator, entries));
        }

        /**
         * Constructs a modifiable sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<K> comparator, final Entry<K, Short>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap<K, Short>(comparator, entries));
        }
    }

    /**
     * The modifiable sorted map holding the keys and the shorts.
     */
    private final ModifiableSortedMap<K, Short> map;

    /**
     * Private constructor taking a map with the keys and the shorts as its parameter.
     *
     * @param map The map holding the keys and the shorts.
     */
    private ModifiableSortedShortMap(final ModifiableSortedMap<K, Short> map) {
        this.map = map;
    }

    @Override
    public boolean add(final K key, final Short value) {
        return map.add(key, value);
    }

    @Override
    public boolean addAll(final Map<? extends K, ? extends Short> aMap) {
        return map.addAll(aMap);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(final Entry<K, Short> entry) {
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
    public boolean containsValue(final Short value) {
        return map.containsValue(value);
    }

    /**
     * Returns a new empty shorts map.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty shorts map.
     */
    static <L> ModifiableSortedShortMap<L> empty(final Comparator<L> comparator) {
        return new SortedTreeMap<L>(comparator);
    }

    @Override
    public Entry<K, Short> get() throws IndexOutOfBoundsException {
        return map.get();
    }

    @Override
    public Short get(final K key) throws IllegalArgumentException {
        return map.get(key);
    }

    @Override
    public NumericCollection<Short> getAll(final K key) throws IllegalArgumentException {
        return new ShortCollection.ArrayCollection(map.getAll(key));
    }

    @Override
    public Comparator<? super K> getComparator() {
        return map.getComparator();
    }

    @Override
    public Entry<K, Short> getGreatest() {
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
    public Entry<K, Short> getLeast() {
        return map.getLeast();
    }

    @Override
    public K getLeastKey() {
        return map.getLeastKey();
    }

    @Override
    public NumericCollection<Short> getValues() {
        return new ShortCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, Short>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new modifiable sorted shorts map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param comparator   The comparator by which to sort the keys.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new modifiable sorted shorts map with the specified entries.
     */
    static <L> ModifiableSortedShortMap<L> of(final Comparator<L> comparator, final Short defaultValue,
            final L... keys) {
        ModifiableSortedShortMap<L> map = ModifiableSortedShortMap.<L>empty(comparator);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable sorted shorts map with the specified entries.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param entries    The entries for the new map.
     * @return A new modifiable sorted shorts map with the specified entries.
     */
    static <L> ModifiableSortedShortMap<L> of(final Comparator<L> comparator, final Entry<L, Short>... entries) {
        return new SortedTreeMap<L>(comparator, entries);
    }

    /**
     * Returns a new modifiable sorted shorts map with the specified keys with a default value and key and value
     * cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new modifiable sorted shorts map with the specified entries.
     */
    static <L> ModifiableSortedShortMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<L> comparator, final Short defaultValue, final L... keys) {
        ModifiableSortedShortMap<L> map = ModifiableSortedShortMap.<L>of(keyAndValueCardinality, comparator);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable sorted shorts map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param entries                The entries for the new map.
     * @return A new modifiable sorted shorts map with the specified entries.
     */
    static <L> ModifiableSortedShortMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<L> comparator, final Entry<L, Short>... entries) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new modifiable sorted shorts map containing an entry with the key and the value.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key        The key for the entry.
     * @param value      The value for the entry.
     * @return A new modifiable sorted shorts map containing an entry with the key and the value.
     */
    public static <L> ModifiableSortedShortMap<L> of(final Comparator<L> comparator, final L key, final Short value) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Short>(key, value));
    }

    /**
     * Returns a new modifiable sorted shorts map containing two entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @return A new modifiable sorted shorts map containing two entries using the provided keys and values.
     */
    public static <L> ModifiableSortedShortMap<L> of(final Comparator<L> comparator, final L key1, final Short value1,
            final L key2, final Short value2) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Short>(key1, value1), new Entry<L, Short>(key2, value2));
    }

    /**
     * Returns a new modifiable sorted shorts map containing three entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @return A new modifiable sorted shorts map containing three entries using the provided keys and values.
     */
    public static <L> ModifiableSortedShortMap<L> of(final Comparator<L> comparator, final L key1, final Short value1,
            final L key2, final Short value2, final L key3, final Short value3) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Short>(key1, value1), new Entry<L, Short>(key2, value2),
                new Entry<L, Short>(key3, value3));
    }

    /**
     * Returns a new modifiable sorted shorts map containing four entries using the provided keys and values.
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
     * @return A new modifiable sorted shorts map containing four entries using the provided keys and values.
     */
    public static <L> ModifiableSortedShortMap<L> of(final Comparator<L> comparator, final L key1, final Short value1,
            final L key2, final Short value2, final L key3, final Short value3, final L key4, final Short value4) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Short>(key1, value1), new Entry<L, Short>(key2, value2),
                new Entry<L, Short>(key3, value3), new Entry<L, Short>(key4, value4));
    }

    /**
     * Returns a new modifiable sorted shorts map containing five entries using the provided keys and values.
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
     * @return A new modifiable sorted shorts map containing five entries using the provided keys and values.
     */
    public static <L> ModifiableSortedShortMap<L> of(final Comparator<L> comparator, final L key1, final Short value1,
            final L key2, final Short value2, final L key3, final Short value3, final L key4, final Short value4,
            final L key5, final Short value5) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Short>(key1, value1), new Entry<L, Short>(key2, value2),
                new Entry<L, Short>(key3, value3), new Entry<L, Short>(key4, value4),
                new Entry<L, Short>(key5, value5));
    }

    @Override
    public Short remove(final K key) throws IllegalArgumentException {
        return map.remove(key);
    }

    @Override
    public boolean removeAll(final Map<? extends K, ? extends Short> aMap) {
        return map.removeAll(aMap);
    }

    @Override
    public Entry<K, Short> removeGreatest() {
        return map.removeGreatest();
    }

    @Override
    public boolean removeIf(final Predicate<Entry<? extends K, ? extends Short>> predicate) {
        return map.removeIf(predicate);
    }

    @Override
    public Entry<K, Short> removeLeast() {
        return map.removeLeast();
    }

    @Override
    public boolean retainAll(final Map<? extends K, ? extends Short> aMap) {
        return map.retainAll(aMap);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Spliterator<Entry<K, Short>> spliterator() {
        return map.spliterator();
    }

    @Override
    public Object[] toArray() {
        return map.toArray();
    }

    @Override
    public Short update(final K key, final Short value) throws IllegalArgumentException {
        return map.update(key, value);
    }
}
