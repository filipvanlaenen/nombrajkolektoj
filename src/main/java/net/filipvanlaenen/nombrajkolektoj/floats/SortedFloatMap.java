package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.SortedMap;
import net.filipvanlaenen.kolektoj.array.SortedArrayMap;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericMap;

/**
 * A sorted numeric map containing floats. It doesn't support any new functionality in addition to the functionality of
 * sorted maps in general and floats maps.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericMap} interface binding the
 * type parameter to Float. It contains two nested classes implementing this interface, one backed by an
 * {@link net.filipvanlaenen.kolektoj.array.SortedArrayMap} and one backed by
 * {@link net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap}, and factory methods mirroring the factory methods of
 * {@link net.filipvanlaenen.kolektoj.SortedMap}.
 *
 * @param <K> The key type.
 */
public interface SortedFloatMap<K> extends SortedNumericMap<K, Float>, FloatMap<K> {
    /**
     * A sorted numeric map containing floats and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.floats.SortedFloatMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.SortedArrayMap}.
     *
     * @param <K> The key type.
     */
    public static final class ArrayMap<K> extends SortedFloatMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private SortedArrayMap<K, Float> decoratedMap;

        /**
         * Constructs a sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public ArrayMap(final Comparator<? super K> comparator, final Entry<K, Float>... entries) {
            decoratedMap = new SortedArrayMap<K, Float>(comparator, entries);
        }

        /**
         * Constructs a sorted map from another map, with the same keys and Floats and the same key and value
         * cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public ArrayMap(final Comparator<? super K> comparator, final Map<? extends K, Float> source) {
            decoratedMap = new SortedArrayMap<K, Float>(comparator, source);
        }

        /**
         * Constructs a sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public ArrayMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<? super K> comparator,
                final Entry<K, Float>... entries) {
            decoratedMap = new SortedArrayMap<K, Float>(keyAndValueCardinality, comparator, entries);
        }

        /**
         * Constructs a sorted map from another matp with the given key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param source                 The map to create a new map from.
         */
        public ArrayMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<? super K> comparator,
                final Map<? extends K, Float> source) {
            decoratedMap = new SortedArrayMap<K, Float>(keyAndValueCardinality, comparator, source);
        }

        @Override
        SortedMap<K, Float> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * A sorted numeric map containing floats and backed by a sorted tree. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.floats.SortedFloatMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap}.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends SortedFloatMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Float> decoratedMap;

        /**
         * Constructs a sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Entry<K, Float>... entries) {
            decoratedMap = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Float>(comparator, entries);
        }

        /**
         * Constructs a sorted map from another map, with the same keys and Floats and the same key and value
         * cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Map<? extends K, Float> source) {
            decoratedMap = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Float>(comparator, source);
        }

        /**
         * Constructs a sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality,
                final Comparator<? super K> comparator, final Entry<K, Float>... entries) {
            decoratedMap = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Float>(keyAndValueCardinality,
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
                final Comparator<? super K> comparator, final Map<? extends K, Float> source) {
            decoratedMap = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, Float>(keyAndValueCardinality,
                    comparator, source);
        }

        @Override
        SortedMap<K, Float> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * Returns a new empty floats map.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty floats map.
     */
    static <L> SortedFloatMap<L> empty(final Comparator<? super L> comparator) {
        return new ArrayMap<L>(comparator);
    }

    /**
     * Returns a new sorted floats map with the specified entries.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param entries    The entries for the new map.
     * @return A new sorted floats map with the specified entries.
     */
    static <L> SortedFloatMap<L> of(final Comparator<? super L> comparator, final Entry<L, Float>... entries) {
        return new SortedTreeMap<L>(comparator, entries);
    }

    /**
     * Returns a new sorted floats map containing an entry with the key and the value.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key        The key for the entry.
     * @param value      The value for the entry.
     * @return A new sorted floats map containing an entry with the key and the value.
     */
    static <L> SortedFloatMap<L> of(final Comparator<? super L> comparator, final L key, final Float value) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Float>(key, value));
    }

    /**
     * Returns a new sorted floats map containing two entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @return A new sorted floats map containing two entries using the provided keys and values.
     */
    static <L> SortedFloatMap<L> of(final Comparator<? super L> comparator, final L key1, final Float value1,
            final L key2, final Float value2) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Float>(key1, value1), new Entry<L, Float>(key2, value2));
    }

    /**
     * Returns a new sorted floats map containing three entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @return A new sorted floats map containing three entries using the provided keys and values.
     */
    static <L> SortedFloatMap<L> of(final Comparator<? super L> comparator, final L key1, final Float value1,
            final L key2, final Float value2, final L key3, final Float value3) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Float>(key1, value1), new Entry<L, Float>(key2, value2),
                new Entry<L, Float>(key3, value3));
    }

    /**
     * Returns a new sorted floats map containing four entries using the provided keys and values.
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
     * @return A new sorted floats map containing four entries using the provided keys and values.
     */
    static <L> SortedFloatMap<L> of(final Comparator<? super L> comparator, final L key1, final Float value1,
            final L key2, final Float value2, final L key3, final Float value3, final L key4, final Float value4) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Float>(key1, value1), new Entry<L, Float>(key2, value2),
                new Entry<L, Float>(key3, value3), new Entry<L, Float>(key4, value4));
    }

    /**
     * Returns a new sorted floats map containing five entries using the provided keys and values.
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
     * @return A new sorted floats map containing five entries using the provided keys and values.
     */
    static <L> SortedFloatMap<L> of(final Comparator<? super L> comparator, final L key1, final Float value1,
            final L key2, final Float value2, final L key3, final Float value3, final L key4, final Float value4,
            final L key5, final Float value5) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Float>(key1, value1), new Entry<L, Float>(key2, value2),
                new Entry<L, Float>(key3, value3), new Entry<L, Float>(key4, value4),
                new Entry<L, Float>(key5, value5));
    }

    /**
     * Returns a new sorted floats map cloned from the provided floats map but sorted according to the comparator.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param map        The original floats map.
     * @return A new sorted floats map cloned from the provided floats map but sorted according to the comparator.
     */
    static <L> SortedFloatMap<L> of(final Comparator<? super L> comparator,
            final NumericMap<? extends L, Float> map) {
        return new SortedTreeMap<L>(comparator, map);
    }

    /**
     * Returns a new sorted floats map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param entries                The entries for the new map.
     * @return A new sorted floats map with the specified entries.
     */
    static <L> SortedFloatMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Entry<L, Float>... entries) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new sorted floats map cloned from the provided floats map with the specified key and value
     * cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param map                    The original floats map.
     * @return A new sorted floats map cloned from the provided floats map with the specified key and value
     *         cardinality.
     */
    static <L> SortedFloatMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final NumericMap<? extends L, Float> map) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, map);
    }

    /**
     * Returns a new sorted floats map cloned from the provided sorted floats map.
     *
     * @param <L> The key type.
     * @param map The original sorted floats map.
     * @return A new sorted floats map cloned from the provided sorted floats map.
     */
    static <L> SortedFloatMap<L> of(final SortedNumericMap<L, Float> map) {
        return new SortedTreeMap<L>(map.getComparator(), map);
    }

    /**
     * Returns a new sorted floats map cloned from the provided sorted floats map.
     *
     * @param <L>   The key type.
     * @param map   The original sorted floats map.
     * @param range The range.
     * @return A new sorted floats map cloned from the provided sorted floats map.
     */
    static <L> SortedFloatMap<L> of(final SortedNumericMap<L, Float> map, final Range<L> range) {
        ModifiableSortedFloatMap<L> slice =
                ModifiableSortedFloatMap.<L>of(map.getKeyAndValueCardinality(), map.getComparator());
        boolean below = true;
        for (Entry<L, Float> entry : map) {
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
