package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * A numeric map containing longs. In addition to the functionality of maps in general, it supports calculating the
 * sum and the product of the map's values, and finding their maximum and the minimum.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} interface binding the type
 * parameter for the values to Long. It contains one nested class implementing this interface, backed by
 * {@link net.filipvanlaenen.kolektoj.hash.HashMap}, and factory methods mirroring the factory methods of
 * {@link net.filipvanlaenen.kolektoj.Map}.
 *
 * @param <K> The key type.
 */
public interface LongMap<K> extends NumericMap<K, Long> {
    /**
     * A numeric map containing longs and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.longs.LongMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.HashMap}.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends LongMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private net.filipvanlaenen.kolektoj.hash.HashMap<K, Long> decoratedMap;

        /**
         * Constructs a map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, Long>... entries) {
            decoratedMap = new net.filipvanlaenen.kolektoj.hash.HashMap<K, Long>(entries);
        }

        /**
         * Constructs a map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, Long>... entries) {
            decoratedMap = new net.filipvanlaenen.kolektoj.hash.HashMap<K, Long>(keyAndValueCardinality, entries);
        }

        /**
         * Constructs a map from another map with the specified key and value cardinality cloned from another map.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param source                 The map to create a new map from.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Map<? extends K, Long> source) {
            decoratedMap = new net.filipvanlaenen.kolektoj.hash.HashMap<K, Long>(keyAndValueCardinality, source);
        }

        /**
         * Constructs a map from another map, with the same keys and Longs and the same key and value cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<? extends K, Long> source) {
            decoratedMap = new net.filipvanlaenen.kolektoj.hash.HashMap<K, Long>(source);
        }

        @Override
        Map<K, Long> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * Returns a new empty longs map.
     *
     * @param <K> The key type.
     * @return A new empty longs map.
     */
    static <K> LongMap<K> empty() {
        return new HashMap<K>();
    }

    /**
     * Returns a new longs map with the specified entries.
     *
     * @param <L>     The key type.
     * @param entries The entries for the new map.
     * @return A new longs map with the specified entries.
     */
    static <L> LongMap<L> of(final Entry<L, Long>... entries) {
        return new HashMap<L>(entries);
    }

    /**
     * Returns a new longs map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries for the new map.
     * @return A new longs map with the specified entries.
     */
    static <L> LongMap<L> of(final KeyAndValueCardinality keyAndValueCardinality, final Entry<L, Long>... entries) {
        return new HashMap<L>(keyAndValueCardinality, entries);
    }

    /**
     * Returns a new longs map with the specified key and value cardinality cloned from the provided longs map.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param map                    The original longs map.
     * @return A new longs map with the specified key and value cardinality cloned from the provided longs map.
     */
    static <L> LongMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final NumericMap<? extends L, Long> map) {
        return new HashMap<L>(keyAndValueCardinality, map);
    }

    /**
     * Returns a new longs map containing an entry with the key and the value.
     *
     * @param <L>   The key type.
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A new longs map containing an entry with the key and the value.
     */
    static <L> LongMap<L> of(final L key, final Long value) {
        return new HashMap<L>(new Entry<L, Long>(key, value));
    }

    /**
     * Returns a new longs map containing two entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A new longs map containing two entries using the provided keys and values.
     */
    static <L> LongMap<L> of(final L key1, final Long value1, final L key2, final Long value2) {
        return new HashMap<L>(new Entry<L, Long>(key1, value1), new Entry<L, Long>(key2, value2));
    }

    /**
     * Returns a new longs map containing three entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A new longs map containing three entries using the provided keys and values.
     */
    static <L> LongMap<L> of(final L key1, final Long value1, final L key2, final Long value2, final L key3,
            final Long value3) {
        return new HashMap<L>(new Entry<L, Long>(key1, value1), new Entry<L, Long>(key2, value2),
                new Entry<L, Long>(key3, value3));
    }

    /**
     * Returns a new longs map containing four entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @param key4   The fourth key for the entry.
     * @param value4 The fourth value for the entry.
     * @return A new longs map containing four entries using the provided keys and values.
     */
    static <L> LongMap<L> of(final L key1, final Long value1, final L key2, final Long value2, final L key3,
            final Long value3, final L key4, final Long value4) {
        return new HashMap<L>(new Entry<L, Long>(key1, value1), new Entry<L, Long>(key2, value2),
                new Entry<L, Long>(key3, value3), new Entry<L, Long>(key4, value4));
    }

    /**
     * Returns a new longs map containing five entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @param key4   The fourth key for the entry.
     * @param value4 The fourth value for the entry.
     * @param key5   The fifth key for the entry.
     * @param value5 The fifth value for the entry.
     * @return A new longs map containing five entries using the provided keys and values.
     */
    static <L> LongMap<L> of(final L key1, final Long value1, final L key2, final Long value2, final L key3,
            final Long value3, final L key4, final Long value4, final L key5, final Long value5) {
        return new HashMap<L>(new Entry<L, Long>(key1, value1), new Entry<L, Long>(key2, value2),
                new Entry<L, Long>(key3, value3), new Entry<L, Long>(key4, value4),
                new Entry<L, Long>(key5, value5));
    }

    /**
     * Returns a new longs map cloned from the provided longs map.
     *
     * @param <L> The key type.
     * @param map The original longs map.
     * @return A new longs map cloned from the provided longs map.
     */
    static <L> LongMap<L> of(final NumericMap<? extends L, Long> map) {
        return new HashMap<L>(map);
    }

    /**
     * Returns a new longs map with the specified key and value cardinality containing all the entries from the
     * provided longs maps.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param maps                   The longs maps from which to copy all the entries.
     * @return A new longs map with the specified key and value cardinality containing all the entries from the
     *         provided longs maps.
     */
    static <L> LongMap<L> unionOf(final KeyAndValueCardinality keyAndValueCardinality,
            final NumericMap<? extends L, Long>... maps) {
        ModifiableLongMap<L> result = ModifiableLongMap.of(keyAndValueCardinality);
        for (NumericMap<? extends L, Long> map : maps) {
            result.addAll(map);
        }
        return new HashMap<L>(result);
    }

    /**
     * Returns a new longs map containing all the entries from the provided longs maps.
     *
     * @param <L>  The key type.
     * @param maps The longs maps from which to copy all the entries.
     * @return A new longs map containing all the entries from the provided longs maps.
     */
    static <L> LongMap<L> unionOf(final NumericMap<? extends L, Long>... maps) {
        return unionOf(KeyAndValueCardinality.DISTINCT_KEYS, maps);
    }
}
