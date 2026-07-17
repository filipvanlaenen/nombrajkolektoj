package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.ModifiableMap;
import net.filipvanlaenen.kolektoj.hash.ModifiableHashMap;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * A modifiable numeric map containing floats. It doesn't support any new functionality in addition to the
 * functionality of modifiable maps in general and updatable floats maps.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifableNumericMap} interface binding
 * the type parameter to Float. It contains one nested classes implementing this interface, backed by
 * {@link net.filipvanlaenen.kolektoj.hash.ModifiableHashMap}, and factory methods mirroring the factory methods of
 * {@link net.filipvanlaenen.kolektoj.ModifiableMap}.
 *
 * @param <K> The key type.
 */
public interface ModifiableFloatMap<K> extends ModifiableNumericMap<K, Float>, UpdatableFloatMap<K> {
    /**
     * A modifiable numeric map containing floats and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableFloatMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.ModifiableHashMap}.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends ModifiableFloatMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private ModifiableHashMap<K, Float> decoratedMap;

        /**
         * Constructs a modifiable map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, Float>... entries) {
            decoratedMap = new ModifiableHashMap<K, Float>(entries);
        }

        /**
         * Constructs a modifiable map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, Float>... entries) {
            decoratedMap = new ModifiableHashMap<K, Float>(keyAndValueCardinality, entries);
        }

        /**
         * Constructs a modifiable map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param source                 The map to create a new map from.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Map<? extends K, Float> source) {
            decoratedMap = new ModifiableHashMap<K, Float>(keyAndValueCardinality, source);
        }

        /**
         * Constructs a modifiable map from another map, with the same keys and Floats and the same key and value
         * cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<? extends K, Float> source) {
            decoratedMap = new ModifiableHashMap<K, Float>(source);
        }

        @Override
        ModifiableMap<K, Float> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * Returns a new empty floats map.
     *
     * @param <K> The key type.
     * @return A new empty floats map.
     */
    static <K> ModifiableFloatMap<K> empty() {
        return new HashMap<K>();
    }

    /**
     * Returns a new modifiable floats map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new modifiable floats map with the specified entries.
     */
    static <L> ModifiableFloatMap<L> of(final Float defaultValue, final Collection<? extends L> keys) {
        ModifiableFloatMap<L> map = ModifiableFloatMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable floats map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new modifiable floats map with the specified entries.
     */
    static <L> ModifiableFloatMap<L> of(final Float defaultValue, final L... keys) {
        ModifiableFloatMap<L> map = ModifiableFloatMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new floats map with the specified entries.
     *
     * @param <L>     The key type.
     * @param entries The entries for the new map.
     * @return A new floats map with the specified entries.
     */
    static <L> ModifiableFloatMap<L> of(final Entry<L, Float>... entries) {
        return new HashMap<L>(entries);
    }

    /**
     * Returns a new modifiable floats map with the specified keys with a default value and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new modifiable floats map with the specified entries.
     */
    static <L> ModifiableFloatMap<L> of(final KeyAndValueCardinality keyAndValueCardinality, final Float defaultValue,
            final Collection<? extends L> keys) {
        ModifiableFloatMap<L> map = ModifiableFloatMap.<L>of(keyAndValueCardinality);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable floats map with the specified keys with a default value and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new modifiable floats map with the specified entries.
     */
    static <L> ModifiableFloatMap<L> of(final KeyAndValueCardinality keyAndValueCardinality, final Float defaultValue,
            final L... keys) {
        ModifiableFloatMap<L> map = ModifiableFloatMap.<L>of(keyAndValueCardinality);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable floats map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries for the new map.
     * @return A new modifiable floats map with the specified entries.
     */
    static <L> ModifiableFloatMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<L, Float>... entries) {
        return new HashMap<L>(keyAndValueCardinality, entries);
    }

    /**
     * Returns a new modifiable floats map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param map                    The original floats map.
     * @return A new modifiable floats map with the specified entries.
     */
    static <L> ModifiableFloatMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
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
    static <L> ModifiableFloatMap<L> of(final L key, final Float value) {
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
    static <L> ModifiableFloatMap<L> of(final L key1, final Float value1, final L key2, final Float value2) {
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
    static <L> ModifiableFloatMap<L> of(final L key1, final Float value1, final L key2, final Float value2,
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
    static <L> ModifiableFloatMap<L> of(final L key1, final Float value1, final L key2, final Float value2,
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
    static <L> ModifiableFloatMap<L> of(final L key1, final Float value1, final L key2, final Float value2,
            final L key3, final Float value3, final L key4, final Float value4, final L key5, final Float value5) {
        return new HashMap<L>(new Entry<L, Float>(key1, value1), new Entry<L, Float>(key2, value2),
                new Entry<L, Float>(key3, value3), new Entry<L, Float>(key4, value4),
                new Entry<L, Float>(key5, value5));
    }

    /**
     * Returns a new modifiable floats map cloned from the provided floats map.
     *
     * @param <L> The key type.
     * @param map The original floats map.
     * @return A new modifiable floats map cloned from the provided floats map.
     */
    static <L> ModifiableFloatMap<L> of(final NumericMap<? extends L, Float> map) {
        return new HashMap<L>(map);
    }

    /**
     * Returns a new modifiable floats map with the specified key and value cardinality containing all the entries from
     * the provided floats maps.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param maps                   The floats maps from which to copy all the entries.
     * @return A new modifiable floats map with the specified key and value cardinality containing all the entries from
     *         the provided floats maps.
     */
    static <L> ModifiableFloatMap<L> unionOf(final KeyAndValueCardinality keyAndValueCardinality,
            final NumericMap<? extends L, Float>... maps) {
        ModifiableFloatMap<L> result = ModifiableFloatMap.of(keyAndValueCardinality);
        for (NumericMap<? extends L, Float> map : maps) {
            result.addAll(map);
        }
        return result;
    }

    /**
     * Returns a new modifiable map containing all the entries from the provided maps.
     *
     * @param <L>  The key type.
     * @param maps The maps from which to copy all the entries.
     * @return A new modifiable map containing all the entries from the provided maps.
     */
    static <L> ModifiableFloatMap<L> unionOf(final NumericMap<? extends L, Float>... maps) {
        return unionOf(KeyAndValueCardinality.DISTINCT_KEYS, maps);
    }
}
