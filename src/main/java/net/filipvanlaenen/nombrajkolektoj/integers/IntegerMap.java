package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * A numeric map containing integers. In addition to the functionality of maps in general, it supports calculating the
 * sum and the product of the map's values, and finding their maximum and the minimum.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} interface binding the type
 * parameter for the values to Integer. It contains one nested class implementing this interface, backed by
 * {@link net.filipvanlaenen.kolektoj.hash.HashMap}, and factory methods mirroring the factory methods of
 * {@link net.filipvanlaenen.kolektoj.Map}.
 *
 * @param <K> The key type.
 */
public interface IntegerMap<K> extends NumericMap<K, Integer> {
    /**
     * A numeric map containing integers and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.HashMap}.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends IntegerMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private net.filipvanlaenen.kolektoj.hash.HashMap<K, Integer> decoratedMap;

        /**
         * Constructs a map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, Integer>... entries) {
            decoratedMap = new net.filipvanlaenen.kolektoj.hash.HashMap<K, Integer>(entries);
        }

        /**
         * Constructs a map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, Integer>... entries) {
            decoratedMap = new net.filipvanlaenen.kolektoj.hash.HashMap<K, Integer>(keyAndValueCardinality, entries);
        }

        /**
         * Constructs a map from another map with the specified key and value cardinality cloned from another map.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param source                 The map to create a new map from.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Map<? extends K, Integer> source) {
            decoratedMap = new net.filipvanlaenen.kolektoj.hash.HashMap<K, Integer>(keyAndValueCardinality, source);
        }

        /**
         * Constructs a map from another map, with the same keys and Integers and the same key and value cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<? extends K, Integer> source) {
            decoratedMap = new net.filipvanlaenen.kolektoj.hash.HashMap<K, Integer>(source);
        }

        @Override
        Map<K, Integer> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * Returns a new empty integers map.
     *
     * @param <K> The key type.
     * @return A new empty integers map.
     */
    static <K> IntegerMap<K> empty() {
        return new HashMap<K>();
    }

    /**
     * Returns a new integers map with the specified entries.
     *
     * @param <L>     The key type.
     * @param entries The entries for the new map.
     * @return A new integers map with the specified entries.
     */
    static <L> IntegerMap<L> of(final Entry<L, Integer>... entries) {
        return new HashMap<L>(entries);
    }

    /**
     * Returns a new integers map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries for the new map.
     * @return A new integers map with the specified entries.
     */
    static <L> IntegerMap<L> of(final KeyAndValueCardinality keyAndValueCardinality, final Entry<L, Integer>... entries) {
        return new HashMap<L>(keyAndValueCardinality, entries);
    }

    /**
     * Returns a new integers map with the specified key and value cardinality cloned from the provided integers map.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param map                    The original integers map.
     * @return A new integers map with the specified key and value cardinality cloned from the provided integers map.
     */
    static <L> IntegerMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final NumericMap<? extends L, Integer> map) {
        return new HashMap<L>(keyAndValueCardinality, map);
    }

    /**
     * Returns a new integers map containing an entry with the key and the value.
     *
     * @param <L>   The key type.
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A new integers map containing an entry with the key and the value.
     */
    static <L> IntegerMap<L> of(final L key, final Integer value) {
        return new HashMap<L>(new Entry<L, Integer>(key, value));
    }

    /**
     * Returns a new integers map containing two entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A new integers map containing two entries using the provided keys and values.
     */
    static <L> IntegerMap<L> of(final L key1, final Integer value1, final L key2, final Integer value2) {
        return new HashMap<L>(new Entry<L, Integer>(key1, value1), new Entry<L, Integer>(key2, value2));
    }

    /**
     * Returns a new integers map containing three entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A new integers map containing three entries using the provided keys and values.
     */
    static <L> IntegerMap<L> of(final L key1, final Integer value1, final L key2, final Integer value2, final L key3,
            final Integer value3) {
        return new HashMap<L>(new Entry<L, Integer>(key1, value1), new Entry<L, Integer>(key2, value2),
                new Entry<L, Integer>(key3, value3));
    }

    /**
     * Returns a new integers map containing four entries using the provided keys and values.
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
     * @return A new integers map containing four entries using the provided keys and values.
     */
    static <L> IntegerMap<L> of(final L key1, final Integer value1, final L key2, final Integer value2, final L key3,
            final Integer value3, final L key4, final Integer value4) {
        return new HashMap<L>(new Entry<L, Integer>(key1, value1), new Entry<L, Integer>(key2, value2),
                new Entry<L, Integer>(key3, value3), new Entry<L, Integer>(key4, value4));
    }

    /**
     * Returns a new integers map containing five entries using the provided keys and values.
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
     * @return A new integers map containing five entries using the provided keys and values.
     */
    static <L> IntegerMap<L> of(final L key1, final Integer value1, final L key2, final Integer value2, final L key3,
            final Integer value3, final L key4, final Integer value4, final L key5, final Integer value5) {
        return new HashMap<L>(new Entry<L, Integer>(key1, value1), new Entry<L, Integer>(key2, value2),
                new Entry<L, Integer>(key3, value3), new Entry<L, Integer>(key4, value4),
                new Entry<L, Integer>(key5, value5));
    }

    /**
     * Returns a new integers map cloned from the provided integers map.
     *
     * @param <L> The key type.
     * @param map The original integers map.
     * @return A new integers map cloned from the provided integers map.
     */
    static <L> IntegerMap<L> of(final NumericMap<? extends L, Integer> map) {
        return new HashMap<L>(map);
    }

    /**
     * Returns a new integers map with the specified key and value cardinality containing all the entries from the
     * provided integers maps.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param maps                   The integers maps from which to copy all the entries.
     * @return A new integers map with the specified key and value cardinality containing all the entries from the
     *         provided integers maps.
     */
    static <L> IntegerMap<L> unionOf(final KeyAndValueCardinality keyAndValueCardinality,
            final NumericMap<? extends L, Integer>... maps) {
        ModifiableIntegerMap<L> result = ModifiableIntegerMap.of(keyAndValueCardinality);
        for (NumericMap<? extends L, Integer> map : maps) {
            result.addAll(map);
        }
        return new HashMap<L>(result);
    }

    /**
     * Returns a new integers map containing all the entries from the provided integers maps.
     *
     * @param <L>  The key type.
     * @param maps The integers maps from which to copy all the entries.
     * @return A new integers map containing all the entries from the provided integers maps.
     */
    static <L> IntegerMap<L> unionOf(final NumericMap<? extends L, Integer>... maps) {
        return unionOf(KeyAndValueCardinality.DISTINCT_KEYS, maps);
    }
}
