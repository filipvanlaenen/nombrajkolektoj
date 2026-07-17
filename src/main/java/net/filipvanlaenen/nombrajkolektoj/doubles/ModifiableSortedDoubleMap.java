package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.ModifiableSortedMap;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap;
import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericMap;

/**
 * A modifiable sorted numeric map containing doubles. It doesn't support any new functionality in addition to the
 * functionality of modifiable sorted maps in general and updatable sorted doubles maps.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifableSortedNumericMap} interface
 * binding the type parameter to Double. It contains one nested classes implementing this interface, backed by
 * {@link net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap}, and factory methods mirroring the factory
 * methods of {@link net.filipvanlaenen.kolektoj.ModifiableSortedMap}.
 *
 * @param <K> The key type.
 */
public interface ModifiableSortedDoubleMap<K>
        extends ModifiableSortedNumericMap<K, Double>, ModifiableDoubleMap<K>, UpdatableSortedDoubleMap<K> {
    /**
     * A modifiable sorted numeric map containing doubles and backed by a sorted tree. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableSortedDoubleMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeMap}.
     *
     * @param <K> The key type.
     */
    public static final class SortedTreeMap<K> extends ModifiableSortedDoubleMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private ModifiableSortedTreeMap<K, Double> decoratedMap;

        /**
         * Constructs a modifiable sorted map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param entries    The entries of the map.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Entry<K, Double>... entries) {
            decoratedMap = new ModifiableSortedTreeMap<K, Double>(comparator, entries);
        }

        /**
         * Constructs a modifiable sorted map from another map, with the same keys and Doubles and the same key and
         * value cardinality.
         *
         * @param comparator The comparator by which to sort the keys.
         * @param source     The map to create a new map from.
         */
        public SortedTreeMap(final Comparator<? super K> comparator, final Map<? extends K, Double> source) {
            decoratedMap = new ModifiableSortedTreeMap<K, Double>(comparator, source);
        }

        /**
         * Constructs a modifiable sorted map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param entries                The entries of the map.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality,
                final Comparator<? super K> comparator, final Entry<K, Double>... entries) {
            decoratedMap = new ModifiableSortedTreeMap<K, Double>(keyAndValueCardinality, comparator, entries);
        }

        /**
         * Constructs a modifiable sorted map from another map with the provided key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param comparator             The comparator by which to sort the keys.
         * @param source                 The map to create a new map from.
         */
        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality,
                final Comparator<? super K> comparator, final Map<? extends K, Double> source) {
            decoratedMap = new ModifiableSortedTreeMap<K, Double>(keyAndValueCardinality, comparator, source);
        }

        @Override
        ModifiableSortedMap<K, Double> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * Returns a new empty doubles map.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @return A new empty doubles map.
     */
    static <L> ModifiableSortedDoubleMap<L> empty(final Comparator<? super L> comparator) {
        return new SortedTreeMap<L>(comparator);
    }

    /**
     * Returns a new modifiable sorted doubles map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param comparator   The comparator by which to sort the keys.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new modifiable sorted doubles map with the specified entries.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final Comparator<? super L> comparator, final Double defaultValue,
            final Collection<? extends L> keys) {
        ModifiableSortedDoubleMap<L> map = ModifiableSortedDoubleMap.<L>empty(comparator);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable sorted doubles map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param comparator   The comparator by which to sort the keys.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new modifiable sorted doubles map with the specified entries.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final Comparator<? super L> comparator, final Double defaultValue,
            final L... keys) {
        ModifiableSortedDoubleMap<L> map = ModifiableSortedDoubleMap.<L>empty(comparator);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable sorted doubles map with the specified entries.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param entries    The entries for the new map.
     * @return A new modifiable sorted doubles map with the specified entries.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final Comparator<? super L> comparator,
            final Entry<L, Double>... entries) {
        return new SortedTreeMap<L>(comparator, entries);
    }

    /**
     * Returns a new modifiable sorted doubles map containing an entry with the key and the value.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key        The key for the entry.
     * @param value      The value for the entry.
     * @return A new modifiable sorted doubles map containing an entry with the key and the value.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final Comparator<? super L> comparator, final L key,
            final Double value) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Double>(key, value));
    }

    /**
     * Returns a new modifiable sorted doubles map containing two entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @return A new modifiable sorted doubles map containing two entries using the provided keys and values.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Double value1, final L key2, final Double value2) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2));
    }

    /**
     * Returns a new modifiable sorted doubles map containing three entries using the provided keys and values.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param key1       The first key for the entry.
     * @param value1     The first value for the entry.
     * @param key2       The second key for the entry.
     * @param value2     The second value for the entry.
     * @param key3       The third key for the entry.
     * @param value3     The third value for the entry.
     * @return A new modifiable sorted doubles map containing three entries using the provided keys and values.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Double value1, final L key2, final Double value2, final L key3, final Double value3) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2),
                new Entry<L, Double>(key3, value3));
    }

    /**
     * Returns a new modifiable sorted doubles map containing four entries using the provided keys and values.
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
     * @return A new modifiable sorted doubles map containing four entries using the provided keys and values.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Double value1, final L key2, final Double value2, final L key3, final Double value3, final L key4,
            final Double value4) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2),
                new Entry<L, Double>(key3, value3), new Entry<L, Double>(key4, value4));
    }

    /**
     * Returns a new modifiable sorted doubles map containing five entries using the provided keys and values.
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
     * @return A new modifiable sorted doubles map containing five entries using the provided keys and values.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final Comparator<? super L> comparator, final L key1,
            final Double value1, final L key2, final Double value2, final L key3, final Double value3, final L key4,
            final Double value4, final L key5, final Double value5) {
        return new SortedTreeMap<L>(comparator, new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2),
                new Entry<L, Double>(key3, value3), new Entry<L, Double>(key4, value4),
                new Entry<L, Double>(key5, value5));
    }

    /**
     * Returns a new modifiable sorted doubles map cloned from the provided doubles map but sorted according to the
     * comparator.
     *
     * @param <L>        The key type.
     * @param comparator The comparator by which to sort the keys.
     * @param map        The original doubles map.
     * @return A new modifiable sorted doubles map cloned from the provided doubles map but sorted according to the
     *         comparator.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final Comparator<? super L> comparator,
            final NumericMap<? extends L, Double> map) {
        return new SortedTreeMap<L>(comparator, map);
    }

    /**
     * Returns a new modifiable sorted doubles map with the specified keys with a default value and key and value
     * cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new modifiable sorted doubles map with the specified entries.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Double defaultValue, final Collection<? extends L> keys) {
        ModifiableSortedDoubleMap<L> map = ModifiableSortedDoubleMap.<L>of(keyAndValueCardinality, comparator);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable sorted doubles map with the specified keys with a default value and key and value
     * cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new modifiable sorted doubles map with the specified entries.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Double defaultValue, final L... keys) {
        ModifiableSortedDoubleMap<L> map = ModifiableSortedDoubleMap.<L>of(keyAndValueCardinality, comparator);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable sorted doubles map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param entries                The entries for the new map.
     * @return A new modifiable sorted doubles map with the specified entries.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final Entry<L, Double>... entries) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, entries);
    }

    /**
     * Returns a new modifiable sorted doubles map with the specified key and value cardinality cloned from the provided
     * doubles map.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param comparator             The comparator by which to sort the keys.
     * @param map                    The original doubles map.
     * @return A new modifiable sorted doubles map with the specified key and value cardinality cloned from the provided
     *         doubles map.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Comparator<? super L> comparator, final NumericMap<? extends L, Double> map) {
        return new SortedTreeMap<L>(keyAndValueCardinality, comparator, map);
    }

    /**
     * Returns a new modifiable sorted doubles map cloned from the provided sorted doubles map.
     *
     * @param <L> The key type.
     * @param map The original sorted doubles map.
     * @return A new modifiable sorted doubles map cloned from the provided sorted doubles map.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final SortedNumericMap<L, Double> map) {
        return new SortedTreeMap<L>(map.getComparator(), map);
    }

    /**
     * Returns a new modifiable sorted doubles map cloned from the provided sorted doubles map.
     *
     * @param <L>   The key type.
     * @param map   The original sorted doubles map.
     * @param range The range.
     * @return A new modifiable sorted doubles map cloned from the provided sorted doubles map.
     */
    static <L> ModifiableSortedDoubleMap<L> of(final SortedNumericMap<L, Double> map, final Range<L> range) {
        ModifiableSortedDoubleMap<L> result =
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
                result.add(entry.key(), entry.value());
            }
        }
        return result;
    }
}
