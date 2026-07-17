package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.ModifiableMap;
import net.filipvanlaenen.kolektoj.hash.ModifiableHashMap;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * A modifiable numeric map containing doubles. It doesn't support any new functionality in addition to the
 * functionality of modifiable maps in general and updatable doubles maps.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifableNumericMap} interface binding
 * the type parameter to Double. It contains one nested classes implementing this interface, backed by
 * {@link net.filipvanlaenen.kolektoj.hash.ModifiableHashMap}, and factory methods mirroring the factory methods of
 * {@link net.filipvanlaenen.kolektoj.ModifiableMap}.
 *
 * @param <K> The key type.
 */
public interface ModifiableDoubleMap<K> extends ModifiableNumericMap<K, Double>, UpdatableDoubleMap<K> {
    /**
     * A modifiable numeric map containing doubles and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableDoubleMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.ModifiableHashMap}.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends ModifiableDoubleMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private ModifiableHashMap<K, Double> decoratedMap;

        /**
         * Constructs a modifiable map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, Double>... entries) {
            decoratedMap = new ModifiableHashMap<K, Double>(entries);
        }

        /**
         * Constructs a modifiable map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, Double>... entries) {
            decoratedMap = new ModifiableHashMap<K, Double>(keyAndValueCardinality, entries);
        }

        /**
         * Constructs a modifiable map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param source                 The map to create a new map from.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Map<? extends K, Double> source) {
            decoratedMap = new ModifiableHashMap<K, Double>(keyAndValueCardinality, source);
        }

        /**
         * Constructs a modifiable map from another map, with the same keys and Doubles and the same key and value
         * cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<? extends K, Double> source) {
            decoratedMap = new ModifiableHashMap<K, Double>(source);
        }

        @Override
        ModifiableMap<K, Double> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * Returns a new empty doubles map.
     *
     * @param <K> The key type.
     * @return A new empty doubles map.
     */
    static <K> ModifiableDoubleMap<K> empty() {
        return new HashMap<K>();
    }

    /**
     * Returns a new modifiable doubles map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new modifiable doubles map with the specified entries.
     */
    static <L> ModifiableDoubleMap<L> of(final Double defaultValue, final Collection<? extends L> keys) {
        ModifiableDoubleMap<L> map = ModifiableDoubleMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable doubles map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new modifiable doubles map with the specified entries.
     */
    static <L> ModifiableDoubleMap<L> of(final Double defaultValue, final L... keys) {
        ModifiableDoubleMap<L> map = ModifiableDoubleMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new doubles map with the specified entries.
     *
     * @param <L>     The key type.
     * @param entries The entries for the new map.
     * @return A new doubles map with the specified entries.
     */
    static <L> ModifiableDoubleMap<L> of(final Entry<L, Double>... entries) {
        return new HashMap<L>(entries);
    }

    /**
     * Returns a new modifiable doubles map with the specified keys with a default value and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new modifiable doubles map with the specified entries.
     */
    static <L> ModifiableDoubleMap<L> of(final KeyAndValueCardinality keyAndValueCardinality, final Double defaultValue,
            final Collection<? extends L> keys) {
        ModifiableDoubleMap<L> map = ModifiableDoubleMap.<L>of(keyAndValueCardinality);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable doubles map with the specified keys with a default value and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new modifiable doubles map with the specified entries.
     */
    static <L> ModifiableDoubleMap<L> of(final KeyAndValueCardinality keyAndValueCardinality, final Double defaultValue,
            final L... keys) {
        ModifiableDoubleMap<L> map = ModifiableDoubleMap.<L>of(keyAndValueCardinality);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return map;
    }

    /**
     * Returns a new modifiable doubles map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries for the new map.
     * @return A new modifiable doubles map with the specified entries.
     */
    static <L> ModifiableDoubleMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<L, Double>... entries) {
        return new HashMap<L>(keyAndValueCardinality, entries);
    }

    /**
     * Returns a new modifiable doubles map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param map                    The original doubles map.
     * @return A new modifiable doubles map with the specified entries.
     */
    static <L> ModifiableDoubleMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final NumericMap<? extends L, Double> map) {
        return new HashMap<L>(keyAndValueCardinality, map);
    }

    /**
     * Returns a new doubles map containing an entry with the key and the value.
     *
     * @param <L>   The key type.
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A new doubles map containing an entry with the key and the value.
     */
    static <L> ModifiableDoubleMap<L> of(final L key, final Double value) {
        return new HashMap<L>(new Entry<L, Double>(key, value));
    }

    /**
     * Returns a new doubles map containing two entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A new doubles map containing two entries using the provided keys and values.
     */
    static <L> ModifiableDoubleMap<L> of(final L key1, final Double value1, final L key2, final Double value2) {
        return new HashMap<L>(new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2));
    }

    /**
     * Returns a new doubles map containing three entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A new doubles map containing three entries using the provided keys and values.
     */
    static <L> ModifiableDoubleMap<L> of(final L key1, final Double value1, final L key2, final Double value2,
            final L key3, final Double value3) {
        return new HashMap<L>(new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2),
                new Entry<L, Double>(key3, value3));
    }

    /**
     * Returns a new doubles map containing four entries using the provided keys and values.
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
     * @return A new doubles map containing four entries using the provided keys and values.
     */
    static <L> ModifiableDoubleMap<L> of(final L key1, final Double value1, final L key2, final Double value2,
            final L key3, final Double value3, final L key4, final Double value4) {
        return new HashMap<L>(new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2),
                new Entry<L, Double>(key3, value3), new Entry<L, Double>(key4, value4));
    }

    /**
     * Returns a new doubles map containing five entries using the provided keys and values.
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
     * @return A new doubles map containing five entries using the provided keys and values.
     */
    static <L> ModifiableDoubleMap<L> of(final L key1, final Double value1, final L key2, final Double value2,
            final L key3, final Double value3, final L key4, final Double value4, final L key5, final Double value5) {
        return new HashMap<L>(new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2),
                new Entry<L, Double>(key3, value3), new Entry<L, Double>(key4, value4),
                new Entry<L, Double>(key5, value5));
    }

    /**
     * Returns a new modifiable doubles map cloned from the provided doubles map.
     *
     * @param <L> The key type.
     * @param map The original doubles map.
     * @return A new modifiable doubles map cloned from the provided doubles map.
     */
    static <L> ModifiableDoubleMap<L> of(final NumericMap<? extends L, Double> map) {
        return new HashMap<L>(map);
    }

    /**
     * Returns a new modifiable doubles map with the specified key and value cardinality containing all the entries from
     * the provided doubles maps.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param maps                   The doubles maps from which to copy all the entries.
     * @return A new modifiable doubles map with the specified key and value cardinality containing all the entries from
     *         the provided doubles maps.
     */
    static <L> ModifiableDoubleMap<L> unionOf(final KeyAndValueCardinality keyAndValueCardinality,
            final NumericMap<? extends L, Double>... maps) {
        ModifiableDoubleMap<L> result = ModifiableDoubleMap.of(keyAndValueCardinality);
        for (NumericMap<? extends L, Double> map : maps) {
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
    static <L> ModifiableDoubleMap<L> unionOf(final NumericMap<? extends L, Double>... maps) {
        return unionOf(KeyAndValueCardinality.DISTINCT_KEYS, maps);
    }
}
