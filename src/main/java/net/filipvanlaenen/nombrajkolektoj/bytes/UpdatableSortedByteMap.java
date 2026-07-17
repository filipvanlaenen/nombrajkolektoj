package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.UpdatableSortedMap;
import net.filipvanlaenen.kolektoj.array.UpdatableSortedArrayMap;
import net.filipvanlaenen.kolektoj.sortedtree.UpdatableSortedTreeMap;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericMap;
import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

/**
 * An updatable sorted numeric map containing bytes. It doesn't support any new functionality in addition to the
 * functionality of updatable sorted maps in general and updatable bytes maps.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap} interface
 * binding the type parameter to Byte. It contains two nested classes implementing this interface, one backed by an
 * {@link net.filipvanlaenen.kolektoj.array.UpdatableSortedArrayMap} and one backed by
 * {@link net.filipvanlaenen.kolektoj.sortedtree.UpdatableSortedTreeMap}, and factory methods mirroring the factory
 * methods of {@link net.filipvanlaenen.kolektoj.UpdatableSortedMap}.
 *
 * @param <K> The key type.
 */
public interface UpdatableSortedByteMap<K>
        extends UpdatableSortedNumericMap<K, Byte>, UpdatableByteMap<K>, SortedByteMap<K> {
    /**
     * An updatable sorted numeric map containing bytes and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.bytes.UpdatableSortedByteMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.UpdatableSortedArrayMap}.
     *
     * @param <K> The key type.
     */
    public static final class ArrayMap<K> extends UpdatableSortedByteMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private UpdatableSortedArrayMap<K, Byte> decoratedMap;

        /**
         * Constructs an updatable sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public ArrayMap(final Comparator<? super K> comparator, final Entry<K, Byte>... entries) {
            decoratedMap = new UpdatableSortedArrayMap<K, Byte>(comparator, entries);
        }

        /**
         * Constructs an updatable sorted map from another map, with the same keys and Bytes and the same key and
         * value cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public ArrayMap(final Comparator<? super K> comparator, final Map<? extends K, Byte> source) {
            decoratedMap = new UpdatableSortedArrayMap<K, Byte>(comparator, source);
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
            decoratedMap = new UpdatableSortedArrayMap<K, Byte>(keyAndValueCardinality, comparator, entries);
        }

        /**
         * Constructs an updatable sorted map from another map with the given key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param source                 The map to create a new map from.
         */
        public ArrayMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<? super K> comparator,
                final Map<? extends K, Byte> source) {
            decoratedMap = new UpdatableSortedArrayMap<K, Byte>(keyAndValueCardinality, comparator, source);
        }

        @Override
        UpdatableSortedMap<K, Byte> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * An updatable sorted numeric map containing bytes and backed by a sorted tree. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.bytes.UpdatableSortedByteMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.sortedtree.UpdatableSortedTreeMap}.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends UpdatableSortedByteMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private UpdatableSortedTreeMap<K, Byte> decoratedMap;

        /**
         * Constructs an updatable sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Entry<K, Byte>... entries) {
            decoratedMap = new UpdatableSortedTreeMap<K, Byte>(comparator, entries);
        }

        /**
         * Constructs an updatable sorted map from another map, with the same keys and Bytes and the same key and
         * value cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Map<? extends K, Byte> source) {
            decoratedMap = new UpdatableSortedTreeMap<K, Byte>(comparator, source);
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
            decoratedMap = new UpdatableSortedTreeMap<K, Byte>(keyAndValueCardinality, comparator, entries);
        }

        /**
         * Constructs an updatable sorted map from another map with the given key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param source                 The map to create a new map from.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality,
                final Comparator<? super K> comparator, final Map<? extends K, Byte> source) {
            decoratedMap = new UpdatableSortedTreeMap<K, Byte>(keyAndValueCardinality, comparator, source);
        }

        @Override
        UpdatableSortedMap<K, Byte> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * Returns a new empty bytes map.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty bytes map.
     */
    static <L> UpdatableSortedByteMap<L> empty(final Comparator<? super L> comparator) {
        return new ArrayMap<L>(comparator);
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
    static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator, final Byte defaultValue,
            final Collection<? extends L> keys) {
        ModifiableByteMap<L> map = ModifiableByteMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new SortedTreeMap<L>(comparator, map);
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
    static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator, final Byte defaultValue,
            final L... keys) {
        ModifiableByteMap<L> map = ModifiableByteMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
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
    static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator,
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
    static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator, final L key, final Byte value) {
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
    static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator, final L key1, final Byte value1,
            final L key2, final Byte value2) {
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
    static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator, final L key1, final Byte value1,
            final L key2, final Byte value2, final L key3, final Byte value3) {
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
    static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator, final L key1, final Byte value1,
            final L key2, final Byte value2, final L key3, final Byte value3, final L key4, final Byte value4) {
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
    static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator, final L key1, final Byte value1,
            final L key2, final Byte value2, final L key3, final Byte value3, final L key4, final Byte value4,
            final L key5, final Byte value5) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Byte>(key1, value1), new Entry<L, Byte>(key2, value2),
                new Entry<L, Byte>(key3, value3), new Entry<L, Byte>(key4, value4),
                new Entry<L, Byte>(key5, value5));
    }

    /**
     * Returns a new updatable sorted bytes map cloned from the provided bytes map but sorted according to the
     * comparator.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param map        The original bytes map.
     * @return A new updatable sorted bytes map cloned from the provided bytes map but sorted according to the
     *         comparator.
     */
    static <L> UpdatableSortedByteMap<L> of(final Comparator<? super L> comparator,
            final NumericMap<? extends L, Byte> map) {
        return new SortedTreeMap<L>(comparator, map);
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
    static <L> UpdatableSortedByteMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Byte defaultValue, final Collection<? extends L> keys) {
        ModifiableByteMap<L> map = ModifiableByteMap.<L>of(keyAndValueCardinality);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new SortedTreeMap<L>(comparator, map);
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
    static <L> UpdatableSortedByteMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
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
    static <L> UpdatableSortedByteMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Entry<L, Byte>... entries) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new updatable sorted bytes map cloned from the provided bytes map with the specified key and value
     * cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param map                    The original bytes map.
     * @return A new updatable sorted bytes map cloned from the provided bytes map with the specified key and value
     *         cardinality.
     */
    static <L> UpdatableSortedByteMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final NumericMap<? extends L, Byte> map) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, map);
    }

    /**
     * Returns a new updatable sorted bytes map cloned from the provided sorted bytes map.
     *
     * @param <L> The key type.
     * @param map The original sorted bytes map.
     * @return A new updatable sorted bytes map cloned from the provided sorted bytes map.
     */
    static <L> UpdatableSortedByteMap<L> of(final SortedNumericMap<L, Byte> map) {
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
    static <L> UpdatableSortedByteMap<L> of(final SortedNumericMap<L, Byte> map, final Range<L> range) {
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
}
