package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.UpdatableMap;
import net.filipvanlaenen.kolektoj.hash.UpdatableHashMap;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An updatable numeric map containing floats. In addition to the functionality of updatable maps in general and
 * floats maps, it supports augmenting, subtracting, multiplying and dividing all the values of map with a number, and
 * negating them, and for a key only.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} interface binding
 * the type parameter to Float. It contains one nested classes implementing this interface, backed by
 * {@link net.filipvanlaenen.kolektoj.hash.HashCollection}, and factory methods mirroring the factory methods of
 * {@link net.filipvanlaenen.kolektoj.UpdatableMap}.
 *
 * @param <K> The key type.
 */
public interface UpdatableFloatMap<K> extends UpdatableNumericMap<K, Float>, FloatMap<K> {
    /**
     * An updatable numeric map containing floats and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.floats.UpdatableFloatMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.UpdatableHashMap}.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends UpdatableFloatMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private UpdatableHashMap<K, Float> decoratedMap;

        /**
         * Constructs an updatable map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, Float>... entries) {
            decoratedMap = new UpdatableHashMap<K, Float>(entries);
        }

        /**
         * Constructs an updatable map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, Float>... entries) {
            decoratedMap = new UpdatableHashMap<K, Float>(keyAndValueCardinality, entries);
        }

        /**
         * Constructs an updatable map from another map with the given key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param source                 The map to create a new map from.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Map<? extends K, Float> source) {
            decoratedMap = new UpdatableHashMap<K, Float>(keyAndValueCardinality, source);
        }

        /**
         * Constructs an updatable map from another map, with the same keys and Floats and the same key and value
         * cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<? extends K, Float> source) {
            decoratedMap = new UpdatableHashMap<K, Float>(source);
        }

        @Override
        UpdatableMap<K, Float> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * Returns a new empty floats map.
     *
     * @param <L> The key type.
     * @return A new empty floats map.
     */
    static <L> UpdatableFloatMap<L> empty() {
        return new HashMap<L>();
    }

    /**
     * Returns a new updatable floats map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new updatable floats map with the specified entries.
     */
    static <L> UpdatableFloatMap<L> of(final Float defaultValue, final Collection<? extends L> keys) {
        ModifiableFloatMap<L> map = ModifiableFloatMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new HashMap<L>(map);
    }

    /**
     * Returns a new updatable floats map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new updatable floats map with the specified entries.
     */
    static <L> UpdatableFloatMap<L> of(final Float defaultValue, final L... keys) {
        ModifiableFloatMap<L> map = ModifiableFloatMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new HashMap<L>(map);
    }

    /**
     * Returns a new floats map with the specified entries.
     *
     * @param <L>     The key type.
     * @param entries The entries for the new map.
     * @return A new floats map with the specified entries.
     */
    static <L> UpdatableFloatMap<L> of(final Entry<L, Float>... entries) {
        return new HashMap<L>(entries);
    }

    /**
     * Returns a new updatable floats map with the specified keys with a default value and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new updatable floats map with the specified entries.
     */
    static <L> UpdatableFloatMap<L> of(final KeyAndValueCardinality keyAndValueCardinality, final Float defaultValue,
            final Collection<? extends L> keys) {
        ModifiableFloatMap<L> map = ModifiableFloatMap.<L>of(keyAndValueCardinality);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new HashMap<L>(map);
    }

    /**
     * Returns a new updatable floats map with the specified keys with a default value and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new updatable floats map with the specified entries.
     */
    static <L> UpdatableFloatMap<L> of(final KeyAndValueCardinality keyAndValueCardinality, final Float defaultValue,
            final L... keys) {
        ModifiableFloatMap<L> map = ModifiableFloatMap.<L>of(keyAndValueCardinality);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new HashMap<L>(map);
    }

    /**
     * Returns a new floats map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries for the new map.
     * @return A new floats map with the specified entries.
     */
    static <L> UpdatableFloatMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<L, Float>... entries) {
        return new HashMap<L>(keyAndValueCardinality, entries);
    }

    /**
     * Returns a new floats map cloned from the provided floats map with the specified key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param map                    The original floats map.
     * @return A new floats map cloned from the provided floats map with the specified key and value cardinality.
     */
    static <L> UpdatableFloatMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final NumericMap<? extends L, Float> map) {
        return new HashMap<L>(keyAndValueCardinality, map);
    }

    /**
     * Returns a new floats map containing an entry with the key and the value.
     *
     * @param <L>   The key type.
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A new floats map containing an entry with the key and the value.
     */
    static <L> UpdatableFloatMap<L> of(final L key, final Float value) {
        return new HashMap<L>(new Entry<L, Float>(key, value));
    }

    /**
     * Returns a new floats map containing two entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A new floats map containing two entries using the provided keys and values.
     */
    static <L> UpdatableFloatMap<L> of(final L key1, final Float value1, final L key2, final Float value2) {
        return new HashMap<L>(new Entry<L, Float>(key1, value1), new Entry<L, Float>(key2, value2));
    }

    /**
     * Returns a new floats map containing three entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A new floats map containing three entries using the provided keys and values.
     */
    static <L> UpdatableFloatMap<L> of(final L key1, final Float value1, final L key2, final Float value2,
            final L key3, final Float value3) {
        return new HashMap<L>(new Entry<L, Float>(key1, value1), new Entry<L, Float>(key2, value2),
                new Entry<L, Float>(key3, value3));
    }

    /**
     * Returns a new floats map containing four entries using the provided keys and values.
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
     * @return A new floats map containing four entries using the provided keys and values.
     */
    static <L> UpdatableFloatMap<L> of(final L key1, final Float value1, final L key2, final Float value2,
            final L key3, final Float value3, final L key4, final Float value4) {
        return new HashMap<L>(new Entry<L, Float>(key1, value1), new Entry<L, Float>(key2, value2),
                new Entry<L, Float>(key3, value3), new Entry<L, Float>(key4, value4));
    }

    /**
     * Returns a new floats map containing five entries using the provided keys and values.
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
     * @return A new floats map containing five entries using the provided keys and values.
     */
    static <L> UpdatableFloatMap<L> of(final L key1, final Float value1, final L key2, final Float value2,
            final L key3, final Float value3, final L key4, final Float value4, final L key5, final Float value5) {
        return new HashMap<L>(new Entry<L, Float>(key1, value1), new Entry<L, Float>(key2, value2),
                new Entry<L, Float>(key3, value3), new Entry<L, Float>(key4, value4),
                new Entry<L, Float>(key5, value5));
    }

    /**
     * Returns a new updatable floats map cloned from the provided floats map.
     *
     * @param <L> The key type.
     * @param map The original floats map.
     * @return A new updatable floats map cloned from the provided floats map.
     */
    static <L> UpdatableFloatMap<L> of(final NumericMap<? extends L, Float> map) {
        return new HashMap<L>(map);
    }

    /**
     * Returns a new updatable floats map with the specified key and value cardinality containing all the entries from
     * the provided floats maps.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param maps                   The floats maps from which to copy all the entries.
     * @return A new updatable floats map with the specified key and value cardinality containing all the entries from
     *         the provided floats maps.
     */
    static <L> UpdatableFloatMap<L> unionOf(final KeyAndValueCardinality keyAndValueCardinality,
            final NumericMap<? extends L, Float>... maps) {
        ModifiableFloatMap<L> result = ModifiableFloatMap.of(keyAndValueCardinality);
        for (NumericMap<? extends L, Float> map : maps) {
            result.addAll(map);
        }
        return new HashMap<L>(result);
    }

    /**
     * Returns a new updatable floats map containing all the entries from the provided floats maps.
     *
     * @param <L>  The key type.
     * @param maps The floats maps from which to copy all the entries.
     * @return A new updatable floats map containing all the entries from the provided floats maps.
     */
    static <L> UpdatableFloatMap<L> unionOf(final NumericMap<? extends L, Float>... maps) {
        return unionOf(KeyAndValueCardinality.DISTINCT_KEYS, maps);
    }
}
