package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.UpdatableMap;
import net.filipvanlaenen.kolektoj.hash.UpdatableHashMap;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An updatable numeric map containing longs. In addition to the functionality of updatable maps in general and
 * longs maps, it supports augmenting, subtracting, multiplying and dividing all the values of map with a number, and
 * negating them, and for a key only.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} interface binding
 * the type parameter to Long. It contains one nested classes implementing this interface, backed by
 * {@link net.filipvanlaenen.kolektoj.hash.HashCollection}, and factory methods mirroring the factory methods of
 * {@link net.filipvanlaenen.kolektoj.UpdatableMap}.
 *
 * @param <K> The key type.
 */
public interface UpdatableLongMap<K> extends UpdatableNumericMap<K, Long>, LongMap<K> {
    /**
     * An updatable numeric map containing longs and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.longs.UpdatableLongMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.UpdatableHashMap}.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends UpdatableLongMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private UpdatableHashMap<K, Long> decoratedMap;

        /**
         * Constructs an updatable map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, Long>... entries) {
            decoratedMap = new UpdatableHashMap<K, Long>(entries);
        }

        /**
         * Constructs an updatable map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, Long>... entries) {
            decoratedMap = new UpdatableHashMap<K, Long>(keyAndValueCardinality, entries);
        }

        /**
         * Constructs an updatable map from another map with the given key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param source                 The map to create a new map from.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Map<? extends K, Long> source) {
            decoratedMap = new UpdatableHashMap<K, Long>(keyAndValueCardinality, source);
        }

        /**
         * Constructs an updatable map from another map, with the same keys and Longs and the same key and value
         * cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<? extends K, Long> source) {
            decoratedMap = new UpdatableHashMap<K, Long>(source);
        }

        @Override
        UpdatableMap<K, Long> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * Returns a new empty longs map.
     *
     * @param <L> The key type.
     * @return A new empty longs map.
     */
    static <L> UpdatableLongMap<L> empty() {
        return new HashMap<L>();
    }

    /**
     * Returns a new updatable longs map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new updatable longs map with the specified entries.
     */
    static <L> UpdatableLongMap<L> of(final Long defaultValue, final Collection<? extends L> keys) {
        ModifiableLongMap<L> map = ModifiableLongMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new HashMap<L>(map);
    }

    /**
     * Returns a new updatable longs map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new updatable longs map with the specified entries.
     */
    static <L> UpdatableLongMap<L> of(final Long defaultValue, final L... keys) {
        ModifiableLongMap<L> map = ModifiableLongMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new HashMap<L>(map);
    }

    /**
     * Returns a new longs map with the specified entries.
     *
     * @param <L>     The key type.
     * @param entries The entries for the new map.
     * @return A new longs map with the specified entries.
     */
    static <L> UpdatableLongMap<L> of(final Entry<L, Long>... entries) {
        return new HashMap<L>(entries);
    }

    /**
     * Returns a new updatable longs map with the specified keys with a default value and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new updatable longs map with the specified entries.
     */
    static <L> UpdatableLongMap<L> of(final KeyAndValueCardinality keyAndValueCardinality, final Long defaultValue,
            final Collection<? extends L> keys) {
        ModifiableLongMap<L> map = ModifiableLongMap.<L>of(keyAndValueCardinality);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new HashMap<L>(map);
    }

    /**
     * Returns a new updatable longs map with the specified keys with a default value and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new updatable longs map with the specified entries.
     */
    static <L> UpdatableLongMap<L> of(final KeyAndValueCardinality keyAndValueCardinality, final Long defaultValue,
            final L... keys) {
        ModifiableLongMap<L> map = ModifiableLongMap.<L>of(keyAndValueCardinality);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new HashMap<L>(map);
    }

    /**
     * Returns a new longs map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries for the new map.
     * @return A new longs map with the specified entries.
     */
    static <L> UpdatableLongMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<L, Long>... entries) {
        return new HashMap<L>(keyAndValueCardinality, entries);
    }

    /**
     * Returns a new longs map cloned from the provided longs map with the specified key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param map                    The original longs map.
     * @return A new longs map cloned from the provided longs map with the specified key and value cardinality.
     */
    static <L> UpdatableLongMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
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
    static <L> UpdatableLongMap<L> of(final L key, final Long value) {
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
    static <L> UpdatableLongMap<L> of(final L key1, final Long value1, final L key2, final Long value2) {
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
    static <L> UpdatableLongMap<L> of(final L key1, final Long value1, final L key2, final Long value2,
            final L key3, final Long value3) {
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
    static <L> UpdatableLongMap<L> of(final L key1, final Long value1, final L key2, final Long value2,
            final L key3, final Long value3, final L key4, final Long value4) {
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
    static <L> UpdatableLongMap<L> of(final L key1, final Long value1, final L key2, final Long value2,
            final L key3, final Long value3, final L key4, final Long value4, final L key5, final Long value5) {
        return new HashMap<L>(new Entry<L, Long>(key1, value1), new Entry<L, Long>(key2, value2),
                new Entry<L, Long>(key3, value3), new Entry<L, Long>(key4, value4),
                new Entry<L, Long>(key5, value5));
    }

    /**
     * Returns a new updatable longs map cloned from the provided longs map.
     *
     * @param <L> The key type.
     * @param map The original longs map.
     * @return A new updatable longs map cloned from the provided longs map.
     */
    static <L> UpdatableLongMap<L> of(final NumericMap<? extends L, Long> map) {
        return new HashMap<L>(map);
    }

    /**
     * Returns a new updatable longs map with the specified key and value cardinality containing all the entries from
     * the provided longs maps.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param maps                   The longs maps from which to copy all the entries.
     * @return A new updatable longs map with the specified key and value cardinality containing all the entries from
     *         the provided longs maps.
     */
    static <L> UpdatableLongMap<L> unionOf(final KeyAndValueCardinality keyAndValueCardinality,
            final NumericMap<? extends L, Long>... maps) {
        ModifiableLongMap<L> result = ModifiableLongMap.of(keyAndValueCardinality);
        for (NumericMap<? extends L, Long> map : maps) {
            result.addAll(map);
        }
        return new HashMap<L>(result);
    }

    /**
     * Returns a new updatable longs map containing all the entries from the provided longs maps.
     *
     * @param <L>  The key type.
     * @param maps The longs maps from which to copy all the entries.
     * @return A new updatable longs map containing all the entries from the provided longs maps.
     */
    static <L> UpdatableLongMap<L> unionOf(final NumericMap<? extends L, Long>... maps) {
        return unionOf(KeyAndValueCardinality.DISTINCT_KEYS, maps);
    }
}
