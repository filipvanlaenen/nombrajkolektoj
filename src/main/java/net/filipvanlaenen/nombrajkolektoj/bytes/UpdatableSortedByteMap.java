package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.kolektoj.UpdatableSortedMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap} interface for
 * Bytes and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class UpdatableSortedByteMap<K> extends AbstractUpdatableSortedByteMap<K>
        implements UpdatableSortedNumericMap<K, Byte> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.UpdatableSortedMap}
     * interface.
     *
     * @param <K> The key type.
     */
    public static final class ArrayMap<K> extends UpdatableSortedByteMap<K> {
        /**
         * Constructs an updatable sorted map from another map, with the same keys and Bytes and the same key and
         * value cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public ArrayMap(final Comparator<? super K> comparator, final Map<? extends K, Byte> source) {
            super(new net.filipvanlaenen.kolektoj.array.UpdatableSortedArrayMap<K, Byte>(comparator, source));
        }

        /**
         * Constructs an updatable sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public ArrayMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<? super K> comparator,
                final Entry<K, Byte>... entries) {
            super(new net.filipvanlaenen.kolektoj.array.UpdatableSortedArrayMap<K, Byte>(keyAndValueCardinality,
                    comparator, entries));
        }

        /**
         * Constructs an updatable sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public ArrayMap(final Comparator<? super K> comparator, final Entry<K, Byte>... entries) {
            super(new net.filipvanlaenen.kolektoj.array.UpdatableSortedArrayMap<K, Byte>(comparator, entries));
        }
    }

    /**
     * Inner class using a sorted tree backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.UpdatableSortedMap} interface.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends UpdatableSortedByteMap<K> {
        /**
         * Constructs an updatable sorted map from another map, with the same keys and Bytes and the same key and
         * value cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Map<? extends K, Byte> source) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.UpdatableSortedTreeMap<K, Byte>(comparator, source));
        }

        /**
         * Constructs an updatable sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality,
                final Comparator<? super K> comparator, final Entry<K, Byte>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.UpdatableSortedTreeMap<K, Byte>(keyAndValueCardinality,
                    comparator, entries));
        }

        /**
         * Constructs an updatable sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Entry<K, Byte>... entries) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.UpdatableSortedTreeMap<K, Byte>(comparator, entries));
        }
    }

    /**
     * The updatable sorted map holding the keys and the bytes.
     */
    private final UpdatableSortedMap<K, Byte> map;

    /**
     * Private constructor taking a map with the keys and the bytes as its parameter.
     *
     * @param map The map holding the keys and the bytes.
     */
    private UpdatableSortedByteMap(final UpdatableSortedMap<K, Byte> map) {
        this.map = map;
    }

    @Override
    public boolean contains(final Entry<K, Byte> entry) {
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
    public boolean containsValue(final Byte value) {
        return map.containsValue(value);
    }

    /**
     * Returns a new empty bytes map.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty bytes map.
     */
    public static <L> UpdatableSortedByteMap<L> empty(final Comparator<? super L> comparator) {
        return new ArrayMap<L>(comparator);
    }

    @Override
    public Entry<K, Byte> get() throws IndexOutOfBoundsException {
        return map.get();
    }

    @Override
    public Byte get(final K key) throws IllegalArgumentException {
        return map.get(key);
    }

    @Override
    public NumericCollection<Byte> getAll(final K key) throws IllegalArgumentException {
        return new ByteCollection.ArrayCollection(map.getAll(key));
    }

    @Override
    public Comparator<? super K> getComparator() {
        return map.getComparator();
    }

    @Override
    public Entry<K, Byte> getGreaterThan(final K key) throws IndexOutOfBoundsException {
        return map.getGreaterThan(key);
    }

    @Override
    public Entry<K, Byte> getGreaterThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return map.getGreaterThanOrEqualTo(key);
    }

    @Override
    public Entry<K, Byte> getGreatest() {
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
    public Entry<K, Byte> getLeast() {
        return map.getLeast();
    }

    @Override
    public K getLeastKey() {
        return map.getLeastKey();
    }

    @Override
    public Entry<K, Byte> getLessThan(final K key) throws IndexOutOfBoundsException {
        return map.getLessThan(key);
    }

    @Override
    public Entry<K, Byte> getLessThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return map.getLessThanOrEqualTo(key);
    }

    @Override
    public OrderedNumericCollection<Byte> getValues() {
        return new OrderedByteCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, Byte>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new updatable sorted bytes map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param comparator   The comparator by which to sort the keys.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new updatable sorted bytes map with the specified entries.
     */
    public static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator, final Byte defaultValue,
            final L... keys) {
        ModifiableByteMap<L> map = ModifiableByteMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new SortedTreeMap<L>(comparator, map);
    }

    /**
     * Returns a new updatable sorted bytes map cloned from the provided byte map but sorted according to the
     * comparator.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param map        The original bytes map.
     * @return A new updatable sorted bytes map cloned from the provided bytes map but sorted according to the
     *         comparator.
     */
    public static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator,
            final ByteMap<? extends L> map) {
        return new SortedTreeMap<L>(comparator, map);
    }

    /**
     * Returns a new updatable sorted bytes map with the specified entries.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param entries    The entries for the new map.
     * @return A new updatable sorted bytes map with the specified entries.
     */
    public static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator,
            final Entry<L, Byte>... entries) {
        return new SortedTreeMap<L>(comparator, entries);
    }

    /**
     * Returns a new updatable sorted bytes map containing an entry with the key and the value.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key        The key for the entry.
     * @param value      The value for the entry.
     * @return A new updatable sorted bytes map containing an entry with the key and the value.
     */
    public static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator, final L key,
            final Byte value) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Byte>(key, value));
    }

    /**
     * Returns a new updatable sorted bytes map containing two entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @return A new updatable sorted bytes map containing two entries using the provided keys and values.
     */
    public static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Byte value1, final L key2, final Byte value2) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Byte>(key1, value1), new Entry<L, Byte>(key2, value2));
    }

    /**
     * Returns a new updatable sorted bytes map containing three entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @return A new updatable sorted bytes map containing three entries using the provided keys and values.
     */
    public static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Byte value1, final L key2, final Byte value2, final L key3, final Byte value3) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Byte>(key1, value1), new Entry<L, Byte>(key2, value2),
                new Entry<L, Byte>(key3, value3));
    }

    /**
     * Returns a new updatable sorted bytes map containing four entries using the provided keys and values.
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
     * @return A new updatable sorted bytes map containing four entries using the provided keys and values.
     */
    public static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Byte value1, final L key2, final Byte value2, final L key3, final Byte value3, final L key4,
            final Byte value4) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Byte>(key1, value1), new Entry<L, Byte>(key2, value2),
                new Entry<L, Byte>(key3, value3), new Entry<L, Byte>(key4, value4));
    }

    /**
     * Returns a new updatable sorted bytes map containing five entries using the provided keys and values.
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
     * @return A new updatable sorted bytes map containing five entries using the provided keys and values.
     */
    public static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Byte value1, final L key2, final Byte value2, final L key3, final Byte value3, final L key4,
            final Byte value4, final L key5, final Byte value5) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Byte>(key1, value1), new Entry<L, Byte>(key2, value2),
                new Entry<L, Byte>(key3, value3), new Entry<L, Byte>(key4, value4),
                new Entry<L, Byte>(key5, value5));
    }

    /**
     * Returns a new updatable sorted bytes map with the specified keys with a default value and key and value
     * cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new updatable sorted bytes map with the specified entries.
     */
    public static <L> UpdatableSortedByteMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Byte defaultValue, final L... keys) {
        ModifiableByteMap<L> map = ModifiableByteMap.<L>of(keyAndValueCardinality);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new SortedTreeMap<L>(comparator, map);
    }

    /**
     * Returns a new updatable sorted bytes map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param entries                The entries for the new map.
     * @return A new updatable sorted bytes map with the specified entries.
     */
    public static <L> UpdatableSortedByteMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Entry<L, Byte>... entries) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new updatable sorted bytes map cloned from the provided sorted bytes map.
     *
     * @param <L> The key type.
     * @param map The original sorted bytes map.
     * @return A new updatable sorted bytes map cloned from the provided sorted bytes map.
     */
    public static <L> UpdatableSortedByteMap<L> of(final SortedByteMap<L> map) {
        return new SortedTreeMap<L>(map.getComparator(), map);
    }

    /**
     * Returns a new updatable sorted bytes map cloned from the provided sorted bytes map.
     *
     * @param <L>   The key type.
     * @param map   The original sorted bytes map.
     * @param range The range.
     * @return A new updatable sorted bytes map cloned from the provided sorted bytes map.
     */
    public static <L> UpdatableSortedByteMap<L> of(final SortedByteMap<L> map, final Range<L> range) {
        ModifiableSortedByteMap<L> slice =
                ModifiableSortedByteMap.<L>of(map.getKeyAndValueCardinality(), map.getComparator());
        boolean below = true;
        for (Entry<L, Byte> entry : map) {
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
    public Spliterator<Entry<K, Byte>> spliterator() {
        return map.spliterator();
    }

    @Override
    public Object[] toArray() {
        return map.toArray();
    }

    @Override
    public Byte update(final K key, final Byte value) throws IllegalArgumentException {
        return map.update(key, value);
    }

    @Override
    public boolean update(final K key, final Byte oldValye, final Byte newValue) {
        return map.update(key, oldValye, newValue);
    }
}
