package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.SortedMap;
import net.filipvanlaenen.kolektoj.array.SortedArrayMap;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericMap;

/**
 * A sorted numeric map containing shorts. It doesn't support any new functionality in addition to the functionality of
 * sorted maps in general and shorts maps.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericMap} interface binding the
 * type parameter to Short. It contains two nested classes implementing this interface, one backed by an
 * {@link net.filipvanlaenen.kolektoj.array.SortedArrayMap} and one backed by
 * {@link net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap}, and factory methods mirroring the factory methods of
 * {@link net.filipvanlaenen.kolektoj.SortedMap}.
 *
 * @param <K> The key type.
 */
public interface SortedShortMap<K> extends SortedNumericMap<K, Short>, ShortMap<K> {
    /**
     * A sorted numeric map containing shorts and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.shorts.SortedShortMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.SortedArrayMap}.
     *
     * @param <K> The key type.
     */
    public static final class ArrayMap<K> extends SortedShortMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private SortedArrayMap<K, Short> decoratedMap;

        /**
         * Constructs a sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public ArrayMap(final Comparator<? super K> comparator, final Entry<K, Short>... entries) {
            decoratedMap = new SortedArrayMap<K, Short>(comparator, entries);
        }

        /**
         * Constructs a sorted map from another map, with the same keys and Shorts and the same key and value
         * cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public ArrayMap(final Comparator<? super K> comparator, final Map<? extends K, Short> source) {
            decoratedMap = new SortedArrayMap<K, Short>(comparator, source);
        }

        /**
         * Constructs a sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public ArrayMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<? super K> comparator,
                final Entry<K, Short>... entries) {
            decoratedMap = new SortedArrayMap<K, Short>(keyAndValueCardinality, comparator, entries);
        }

        /**
         * Constructs a sorted map from another matp with the given key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param source                 The map to create a new map from.
         */
        public ArrayMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<? super K> comparator,
                final Map<? extends K, Short> source) {
            decoratedMap = new SortedArrayMap<K, Short>(keyAndValueCardinality, comparator, source);
        }

        @Override
        SortedMap<K, Short> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * A sorted numeric map containing shorts and backed by a sorted tree. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.shorts.SortedShortMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap}.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends SortedShortMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Short> decoratedMap;

        /**
         * Constructs a sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Entry<K, Short>... entries) {
            decoratedMap = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Short>(comparator, entries);
        }

        /**
         * Constructs a sorted map from another map, with the same keys and Shorts and the same key and value
         * cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Map<? extends K, Short> source) {
            decoratedMap = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Short>(comparator, source);
        }

        /**
         * Constructs a sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality,
                final Comparator<? super K> comparator, final Entry<K, Short>... entries) {
            decoratedMap = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Short>(keyAndValueCardinality,
                    comparator, entries);
        }

        /**
         * Constructs a sorted map from another map with the given key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param source                 The map to create a new map from.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality,
                final Comparator<? super K> comparator, final Map<? extends K, Short> source) {
            decoratedMap = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Short>(keyAndValueCardinality,
                    comparator, source);
        }

        @Override
        SortedMap<K, Short> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * Returns a new empty shorts map.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty shorts map.
     */
    static <L> SortedShortMap<L> empty(final Comparator<? super L> comparator) {
        return new ArrayMap<L>(comparator);
    }

    /**
     * Returns a new sorted shorts map with the specified entries.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param entries    The entries for the new map.
     * @return A new sorted shorts map with the specified entries.
     */
    static <L> SortedShortMap<L> of(final Comparator<? super L> comparator, final Entry<L, Short>... entries) {
        return new SortedTreeMap<L>(comparator, entries);
    }

    /**
     * Returns a new sorted shorts map containing an entry with the key and the value.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key        The key for the entry.
     * @param value      The value for the entry.
     * @return A new sorted shorts map containing an entry with the key and the value.
     */
    static <L> SortedShortMap<L> of(final Comparator<? super L> comparator, final L key, final Short value) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Short>(key, value));
    }

    /**
     * Returns a new sorted shorts map containing two entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @return A new sorted shorts map containing two entries using the provided keys and values.
     */
    static <L> SortedShortMap<L> of(final Comparator<? super L> comparator, final L key1, final Short value1,
            final L key2, final Short value2) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Short>(key1, value1), new Entry<L, Short>(key2, value2));
    }

    /**
     * Returns a new sorted shorts map containing three entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @return A new sorted shorts map containing three entries using the provided keys and values.
     */
    static <L> SortedShortMap<L> of(final Comparator<? super L> comparator, final L key1, final Short value1,
            final L key2, final Short value2, final L key3, final Short value3) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Short>(key1, value1), new Entry<L, Short>(key2, value2),
                new Entry<L, Short>(key3, value3));
    }

    /**
     * Returns a new sorted shorts map containing four entries using the provided keys and values.
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
     * @return A new sorted shorts map containing four entries using the provided keys and values.
     */
    static <L> SortedShortMap<L> of(final Comparator<? super L> comparator, final L key1, final Short value1,
            final L key2, final Short value2, final L key3, final Short value3, final L key4, final Short value4) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Short>(key1, value1), new Entry<L, Short>(key2, value2),
                new Entry<L, Short>(key3, value3), new Entry<L, Short>(key4, value4));
    }

    /**
     * Returns a new sorted shorts map containing five entries using the provided keys and values.
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
     * @return A new sorted shorts map containing five entries using the provided keys and values.
     */
    static <L> SortedShortMap<L> of(final Comparator<? super L> comparator, final L key1, final Short value1,
            final L key2, final Short value2, final L key3, final Short value3, final L key4, final Short value4,
            final L key5, final Short value5) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Short>(key1, value1), new Entry<L, Short>(key2, value2),
                new Entry<L, Short>(key3, value3), new Entry<L, Short>(key4, value4),
                new Entry<L, Short>(key5, value5));
    }

    /**
     * Returns a new sorted shorts map cloned from the provided shorts map but sorted according to the comparator.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param map        The original shorts map.
     * @return A new sorted shorts map cloned from the provided shorts map but sorted according to the comparator.
     */
    static <L> SortedShortMap<L> of(final Comparator<? super L> comparator,
            final NumericMap<? extends L, Short> map) {
        return new SortedTreeMap<L>(comparator, map);
    }

    /**
     * Returns a new sorted shorts map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param entries                The entries for the new map.
     * @return A new sorted shorts map with the specified entries.
     */
    static <L> SortedShortMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Entry<L, Short>... entries) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new sorted shorts map cloned from the provided shorts map with the specified key and value
     * cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param map                    The original shorts map.
     * @return A new sorted shorts map cloned from the provided shorts map with the specified key and value
     *         cardinality.
     */
    static <L> SortedShortMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final NumericMap<? extends L, Short> map) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, map);
    }

    /**
     * Returns a new sorted shorts map cloned from the provided sorted shorts map.
     *
     * @param <L> The key type.
     * @param map The original sorted shorts map.
     * @return A new sorted shorts map cloned from the provided sorted shorts map.
     */
    static <L> SortedShortMap<L> of(final SortedNumericMap<L, Short> map) {
        return new SortedTreeMap<L>(map.getComparator(), map);
    }

    /**
     * Returns a new sorted shorts map cloned from the provided sorted shorts map.
     *
     * @param <L>   The key type.
     * @param map   The original sorted shorts map.
     * @param range The range.
     * @return A new sorted shorts map cloned from the provided sorted shorts map.
     */
    static <L> SortedShortMap<L> of(final SortedNumericMap<L, Short> map, final Range<L> range) {
        ModifiableSortedShortMap<L> slice =
                ModifiableSortedShortMap.<L>of(map.getKeyAndValueCardinality(), map.getComparator());
        boolean below = true;
        for (Entry<L, Short> entry : map) {
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
