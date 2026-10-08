package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * A numeric map containing bytes. In addition to the functionality of maps in general, it supports calculating the
 * sum and the product of the map's values, and finding their maximum and the minimum.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} interface binding the type
 * parameter for the values to Byte. It contains one nested class implementing this interface, backed by
 * {@link net.filipvanlaenen.kolektoj.hash.HashMap}, and factory methods mirroring the factory methods of
 * {@link net.filipvanlaenen.kolektoj.Map}.
 *
 * @param <K> The key type.
 */
public interface ByteMap<K> extends NumericMap<K, Byte> {
    /**
     * A numeric map containing bytes and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteMap} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.HashMap}.
     *
     * @param <K> The key type.
     */
    final class HashMap<K> extends ByteMapDecorator<K> {
        /**
         * The internal decorated map.
         */
        private net.filipvanlaenen.kolektoj.hash.HashMap<K, Byte> decoratedMap;

        /**
         * Constructs a map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, Byte>... entries) {
            decoratedMap = new net.filipvanlaenen.kolektoj.hash.HashMap<K, Byte>(entries);
        }

        /**
         * Constructs a map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, Byte>... entries) {
            decoratedMap = new net.filipvanlaenen.kolektoj.hash.HashMap<K, Byte>(keyAndValueCardinality, entries);
        }

        /**
         * Constructs a map from another map with the specified key and value cardinality cloned from another map.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param source                 The map to create a new map from.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Map<? extends K, Byte> source) {
            decoratedMap = new net.filipvanlaenen.kolektoj.hash.HashMap<K, Byte>(keyAndValueCardinality, source);
        }

        /**
         * Constructs a map from another map, with the same keys and Bytes and the same key and value cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<? extends K, Byte> source) {
            decoratedMap = new net.filipvanlaenen.kolektoj.hash.HashMap<K, Byte>(source);
        }

        @Override
        Map<K, Byte> getDecoratedMap() {
            return decoratedMap;
        }
    }

    /**
     * Returns a new bytes map containing all the entries present in the first bytes map, but not in any of the
     * other provided bytes maps.
     *
     * This method corresponds to the difference (or relative complement) operation in set theory, denoted by the symbol
     * ∖, with {1, 2, 3} ∖ {2, 3, 4} = {1}.
     *
     * @param <L>  The key type.
     * @param maps The bytes maps from which to calculate the difference.
     * @return A new bytes map containing all the entries present in the first bytes map, but not in any of the
     *         other provided bytes maps.
     */
    static <L> ByteMap<L> differenceOf(final NumericMap<? extends L, Byte>... maps) {
        if (maps.length == 0) {
            return empty();
        }
        ModifiableByteMap<L> result = ModifiableByteMap.of(maps[0]);
        for (int i = 1; i < maps.length; i++) {
            result.removeAll(maps[i]);
        }
        return of(result);
    }

    /**
     * Returns a new empty bytes map.
     *
     * @param <K> The key type.
     * @return A new empty bytes map.
     */
    static <K> ByteMap<K> empty() {
        return new HashMap<K>();
    }

    /**
     * Returns a new bytes map containing all the entries present in each of the provided bytes maps.
     *
     * This method corresponds to the intersection operation in set theory, denoted by the symbol ∩, with {1, 2, 3} ∩
     * {2, 3, 4} = {2, 3}.
     *
     * @param <L>  The key type.
     * @param maps The bytes maps from which to calculate the intersection.
     * @return A new bytes map containing all the entries present in each of the provided bytes maps.
     */
    static <L> ByteMap<L> intersectionOf(final NumericMap<? extends L, Byte>... maps) {
        if (maps.length == 0) {
            return empty();
        }
        ModifiableByteMap<L> result = ModifiableByteMap.of(maps[0]);
        for (int i = 1; i < maps.length; i++) {
            result.retainAll(maps[i]);
        }
        return of(result);
    }

    /**
     * Returns a new bytes map with the specified entries.
     *
     * @param <L>     The key type.
     * @param entries The entries for the new map.
     * @return A new bytes map with the specified entries.
     */
    static <L> ByteMap<L> of(final Entry<L, Byte>... entries) {
        return new HashMap<L>(entries);
    }

    /**
     * Returns a new bytes map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries for the new map.
     * @return A new bytes map with the specified entries.
     */
    static <L> ByteMap<L> of(final KeyAndValueCardinality keyAndValueCardinality, final Entry<L, Byte>... entries) {
        return new HashMap<L>(keyAndValueCardinality, entries);
    }

    /**
     * Returns a new bytes map with the specified key and value cardinality cloned from the provided bytes map.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param map                    The original bytes map.
     * @return A new bytes map with the specified key and value cardinality cloned from the provided bytes map.
     */
    static <L> ByteMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final NumericMap<? extends L, Byte> map) {
        return new HashMap<L>(keyAndValueCardinality, map);
    }

    /**
     * Returns a new bytes map containing an entry with the key and the value.
     *
     * @param <L>   The key type.
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A new bytes map containing an entry with the key and the value.
     */
    static <L> ByteMap<L> of(final L key, final Byte value) {
        return new HashMap<L>(new Entry<L, Byte>(key, value));
    }

    /**
     * Returns a new bytes map containing two entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @return A new bytes map containing two entries using the provided keys and values.
     */
    static <L> ByteMap<L> of(final L key1, final Byte value1, final L key2, final Byte value2) {
        return new HashMap<L>(new Entry<L, Byte>(key1, value1), new Entry<L, Byte>(key2, value2));
    }

    /**
     * Returns a new bytes map containing three entries using the provided keys and values.
     *
     * @param <L>    The key type.
     * @param key1   The first key for the entry.
     * @param value1 The first value for the entry.
     * @param key2   The second key for the entry.
     * @param value2 The second value for the entry.
     * @param key3   The third key for the entry.
     * @param value3 The third value for the entry.
     * @return A new bytes map containing three entries using the provided keys and values.
     */
    static <L> ByteMap<L> of(final L key1, final Byte value1, final L key2, final Byte value2, final L key3,
            final Byte value3) {
        return new HashMap<L>(new Entry<L, Byte>(key1, value1), new Entry<L, Byte>(key2, value2),
                new Entry<L, Byte>(key3, value3));
    }

    /**
     * Returns a new bytes map containing four entries using the provided keys and values.
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
     * @return A new bytes map containing four entries using the provided keys and values.
     */
    static <L> ByteMap<L> of(final L key1, final Byte value1, final L key2, final Byte value2, final L key3,
            final Byte value3, final L key4, final Byte value4) {
        return new HashMap<L>(new Entry<L, Byte>(key1, value1), new Entry<L, Byte>(key2, value2),
                new Entry<L, Byte>(key3, value3), new Entry<L, Byte>(key4, value4));
    }

    /**
     * Returns a new bytes map containing five entries using the provided keys and values.
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
     * @return A new bytes map containing five entries using the provided keys and values.
     */
    static <L> ByteMap<L> of(final L key1, final Byte value1, final L key2, final Byte value2, final L key3,
            final Byte value3, final L key4, final Byte value4, final L key5, final Byte value5) {
        return new HashMap<L>(new Entry<L, Byte>(key1, value1), new Entry<L, Byte>(key2, value2),
                new Entry<L, Byte>(key3, value3), new Entry<L, Byte>(key4, value4),
                new Entry<L, Byte>(key5, value5));
    }

    /**
     * Returns a new bytes map cloned from the provided bytes map.
     *
     * @param <L> The key type.
     * @param map The original bytes map.
     * @return A new bytes map cloned from the provided bytes map.
     */
    static <L> ByteMap<L> of(final NumericMap<? extends L, Byte> map) {
        return new HashMap<L>(map);
    }

    /**
     * Returns a new bytes map with the specified key and value cardinality containing all the entries from the
     * provided bytes maps.
     *
     * This method corresponds to the union operation in set theory, denoted by the symbol ∪, with {1, 2, 3} ∪ {2, 3, 4}
     * = {1, 2, 3, 4}. For multisets, allowing duplicate elements, {1, 2, 3} ∪ {2, 3, 4} = {1, 2, 2, 3, 3, 4}.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param maps                   The bytes maps from which to copy all the entries.
     * @return A new bytes map with the specified key and value cardinality containing all the entries from the
     *         provided bytes maps.
     */
    static <L> ByteMap<L> unionOf(final KeyAndValueCardinality keyAndValueCardinality,
            final NumericMap<? extends L, Byte>... maps) {
        ModifiableByteMap<L> result = ModifiableByteMap.of(keyAndValueCardinality);
        for (NumericMap<? extends L, Byte> map : maps) {
            result.addAll(map);
        }
        return of(result);
    }

    /**
     * Returns a new bytes map containing all the entries from the provided bytes maps.
     *
     * This method corresponds to the union operation in set theory, denoted by the symbol ∪, with {1, 2, 3} ∪ {2, 3, 4}
     * = {1, 2, 3, 4}. For multisets, allowing duplicate elements, {1, 2, 3} ∪ {2, 3, 4} = {1, 2, 2, 3, 3, 4}.
     *
     * @param <L>  The key type.
     * @param maps The bytes maps from which to copy all the entries.
     * @return A new bytes map containing all the entries from the provided bytes maps.
     */
    static <L> ByteMap<L> unionOf(final NumericMap<? extends L, Byte>... maps) {
        return unionOf(KeyAndValueCardinality.DISTINCT_KEYS, maps);
    }
}
