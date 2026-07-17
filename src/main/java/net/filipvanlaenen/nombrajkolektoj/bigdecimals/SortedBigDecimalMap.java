package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.SortedMap;
import net.filipvanlaenen.kolektoj.array.SortedArrayMap;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericMap;

/**
 * A sorted numeric map containing BigDecimals. It doesn't support any new functionality in addition to the functionality of
 * sorted maps in general and BigDecimals maps.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericMap} interface binding the
 * type parameter to BigDecimal. It contains two nested classes implementing this interface, one backed by an
 * {@link net.filipvanlaenen.kolektoj.array.SortedArrayMap} and one backed by
 * {@link net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap}, and factory methods mirroring the factory methods of
 * {@link net.filipvanlaenen.kolektoj.SortedMap}.
 *
 * @param <K> The key type.
 */
public interface SortedBigDecimalMap<K> extends SortedNumericMap<K, BigDecimal>, BigDecimalMap<K> {
    /**
     * A sorted numeric map containing BigDecimals and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.SortedBigDecimalMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.SortedArrayMap}.
     *
     * @param <K> The key type.
     */
    public static final class ArrayMap<K> extends SortedBigDecimalMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private SortedArrayMap<K, BigDecimal> decoratedMap;

        /**
         * Constructs a sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public ArrayMap(final Comparator<? super K> comparator, final Entry<K, BigDecimal>... entries) {
            decoratedMap = new SortedArrayMap<K, BigDecimal>(comparator, entries);
        }

        /**
         * Constructs a sorted map from another map, with the same keys and BigDecimals and the same key and value
         * cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public ArrayMap(final Comparator<? super K> comparator, final Map<? extends K, BigDecimal> source) {
            decoratedMap = new SortedArrayMap<K, BigDecimal>(comparator, source);
        }

        /**
         * Constructs a sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public ArrayMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<? super K> comparator,
                final Entry<K, BigDecimal>... entries) {
            decoratedMap = new SortedArrayMap<K, BigDecimal>(keyAndValueCardinality, comparator, entries);
        }

        /**
         * Constructs a sorted map from another matp with the given key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param source                 The map to create a new map from.
         */
        public ArrayMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<? super K> comparator,
                final Map<? extends K, BigDecimal> source) {
            decoratedMap = new SortedArrayMap<K, BigDecimal>(keyAndValueCardinality, comparator, source);
        }

        @Override
        SortedMap<K, BigDecimal> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * A sorted numeric map containing BigDecimals and backed by a sorted tree. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.SortedBigDecimalMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap}.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends SortedBigDecimalMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, BigDecimal> decoratedMap;

        /**
         * Constructs a sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Entry<K, BigDecimal>... entries) {
            decoratedMap = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, BigDecimal>(comparator, entries);
        }

        /**
         * Constructs a sorted map from another map, with the same keys and BigDecimals and the same key and value
         * cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Map<? extends K, BigDecimal> source) {
            decoratedMap = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, BigDecimal>(comparator, source);
        }

        /**
         * Constructs a sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality,
                final Comparator<? super K> comparator, final Entry<K, BigDecimal>... entries) {
            decoratedMap = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, BigDecimal>(keyAndValueCardinality,
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
                final Comparator<? super K> comparator, final Map<? extends K, BigDecimal> source) {
            decoratedMap = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeMap<K, BigDecimal>(keyAndValueCardinality,
                    comparator, source);
        }

        @Override
        SortedMap<K, BigDecimal> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * Returns a new empty BigDecimals map.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty BigDecimals map.
     */
    static <L> SortedBigDecimalMap<L> empty(final Comparator<? super L> comparator) {
        return new ArrayMap<L>(comparator);
    }

    /**
     * Returns a new sorted BigDecimals map with the specified entries.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param entries    The entries for the new map.
     * @return A new sorted BigDecimals map with the specified entries.
     */
    static <L> SortedBigDecimalMap<L> of(final Comparator<? super L> comparator, final Entry<L, BigDecimal>... entries) {
        return new SortedTreeMap<L>(comparator, entries);
    }

    /**
     * Returns a new sorted BigDecimals map containing an entry with the key and the value.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key        The key for the entry.
     * @param value      The value for the entry.
     * @return A new sorted BigDecimals map containing an entry with the key and the value.
     */
    static <L> SortedBigDecimalMap<L> of(final Comparator<? super L> comparator, final L key, final BigDecimal value) {
        return new SortedTreeMap<L>(comparator, new Entry<L, BigDecimal>(key, value));
    }

    /**
     * Returns a new sorted BigDecimals map containing two entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @return A new sorted BigDecimals map containing two entries using the provided keys and values.
     */
    static <L> SortedBigDecimalMap<L> of(final Comparator<? super L> comparator, final L key1, final BigDecimal value1,
            final L key2, final BigDecimal value2) {
        return new SortedTreeMap<L>(comparator, new Entry<L, BigDecimal>(key1, value1), new Entry<L, BigDecimal>(key2, value2));
    }

    /**
     * Returns a new sorted BigDecimals map containing three entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @return A new sorted BigDecimals map containing three entries using the provided keys and values.
     */
    static <L> SortedBigDecimalMap<L> of(final Comparator<? super L> comparator, final L key1, final BigDecimal value1,
            final L key2, final BigDecimal value2, final L key3, final BigDecimal value3) {
        return new SortedTreeMap<L>(comparator, new Entry<L, BigDecimal>(key1, value1), new Entry<L, BigDecimal>(key2, value2),
                new Entry<L, BigDecimal>(key3, value3));
    }

    /**
     * Returns a new sorted BigDecimals map containing four entries using the provided keys and values.
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
     * @return A new sorted BigDecimals map containing four entries using the provided keys and values.
     */
    static <L> SortedBigDecimalMap<L> of(final Comparator<? super L> comparator, final L key1, final BigDecimal value1,
            final L key2, final BigDecimal value2, final L key3, final BigDecimal value3, final L key4, final BigDecimal value4) {
        return new SortedTreeMap<L>(comparator, new Entry<L, BigDecimal>(key1, value1), new Entry<L, BigDecimal>(key2, value2),
                new Entry<L, BigDecimal>(key3, value3), new Entry<L, BigDecimal>(key4, value4));
    }

    /**
     * Returns a new sorted BigDecimals map containing five entries using the provided keys and values.
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
     * @return A new sorted BigDecimals map containing five entries using the provided keys and values.
     */
    static <L> SortedBigDecimalMap<L> of(final Comparator<? super L> comparator, final L key1, final BigDecimal value1,
            final L key2, final BigDecimal value2, final L key3, final BigDecimal value3, final L key4, final BigDecimal value4,
            final L key5, final BigDecimal value5) {
        return new SortedTreeMap<L>(comparator, new Entry<L, BigDecimal>(key1, value1), new Entry<L, BigDecimal>(key2, value2),
                new Entry<L, BigDecimal>(key3, value3), new Entry<L, BigDecimal>(key4, value4),
                new Entry<L, BigDecimal>(key5, value5));
    }

    /**
     * Returns a new sorted BigDecimals map cloned from the provided BigDecimals map but sorted according to the comparator.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param map        The original BigDecimals map.
     * @return A new sorted BigDecimals map cloned from the provided BigDecimals map but sorted according to the comparator.
     */
    static <L> SortedBigDecimalMap<L> of(final Comparator<? super L> comparator,
            final NumericMap<? extends L, BigDecimal> map) {
        return new SortedTreeMap<L>(comparator, map);
    }

    /**
     * Returns a new sorted BigDecimals map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param entries                The entries for the new map.
     * @return A new sorted BigDecimals map with the specified entries.
     */
    static <L> SortedBigDecimalMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Entry<L, BigDecimal>... entries) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new sorted BigDecimals map cloned from the provided BigDecimals map with the specified key and value
     * cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param map                    The original BigDecimals map.
     * @return A new sorted BigDecimals map cloned from the provided BigDecimals map with the specified key and value
     *         cardinality.
     */
    static <L> SortedBigDecimalMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final NumericMap<? extends L, BigDecimal> map) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, map);
    }

    /**
     * Returns a new sorted BigDecimals map cloned from the provided sorted BigDecimals map.
     *
     * @param <L> The key type.
     * @param map The original sorted BigDecimals map.
     * @return A new sorted BigDecimals map cloned from the provided sorted BigDecimals map.
     */
    static <L> SortedBigDecimalMap<L> of(final SortedNumericMap<L, BigDecimal> map) {
        return new SortedTreeMap<L>(map.getComparator(), map);
    }

    /**
     * Returns a new sorted BigDecimals map cloned from the provided sorted BigDecimals map.
     *
     * @param <L>   The key type.
     * @param map   The original sorted BigDecimals map.
     * @param range The range.
     * @return A new sorted BigDecimals map cloned from the provided sorted BigDecimals map.
     */
    static <L> SortedBigDecimalMap<L> of(final SortedNumericMap<L, BigDecimal> map, final Range<L> range) {
        ModifiableSortedBigDecimalMap<L> slice =
                ModifiableSortedBigDecimalMap.<L>of(map.getKeyAndValueCardinality(), map.getComparator());
        boolean below = true;
        for (Entry<L, BigDecimal> entry : map) {
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
