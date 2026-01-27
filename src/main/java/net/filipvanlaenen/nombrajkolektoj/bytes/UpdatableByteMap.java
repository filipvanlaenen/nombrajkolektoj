package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.UpdatableMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} interface for
 * Bytes and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class UpdatableByteMap<K> extends AbstractUpdatableByteMap<K>
        implements UpdatableNumericMap<K, Byte> {
    /**
     * Inner class using a hash function backed implementation of the {@link net.filipvanlaenen.kolektoj.UpdatableMap}
     * interface.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends UpdatableByteMap<K> {
        /**
         * Constructs an updatable map from another map, with the same keys and Bytes and the same key and value
         * cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<? extends K, Byte> source) {
            super(new net.filipvanlaenen.kolektoj.hash.UpdatableHashMap<K, Byte>(source));
        }

        /**
         * Constructs an updatable map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, Byte>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.UpdatableHashMap<K, Byte>(keyAndValueCardinality, entries));
        }

        /**
         * Constructs an updatable map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, Byte>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.UpdatableHashMap<K, Byte>(entries));
        }
    }

    /**
     * The updatable map holding the keys and the bytes.
     */
    private final UpdatableMap<K, Byte> map;

    /**
     * Private constructor taking a map with the keys and the bytes as its parameter.
     *
     * @param map The map holding the keys and the bytes.
     */
    private UpdatableByteMap(final UpdatableMap<K, Byte> map) {
        this.map = map;
    }

    @Override
    public boolean contains(final Entry<K, Byte> entry) {
        return map.contains(entry);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return map.containsAll(collection);
    }

    @Override
    public boolean containsKey(final K key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(final Byte value) {
        return map.containsValue(value);
    }

    /**
     * Returns a new empty bytes map.
     *
     * @param <L> The key type.
     * @return A new empty bytes map.
     */
    public static <L> UpdatableByteMap<L> empty() {
        return new HashMap<L>();
    }

    @Override
    public Entry<K, Byte> get() throws IndexOutOfBoundsException {
        return map.get();
    }

    @Override
    public Byte get(final K key) throws IllegalArgumentException {
        return map.get(key);
    }

    @Override
    public NumericCollection<Byte> getAll(final K key) throws IllegalArgumentException {
        return new ByteCollection.ArrayCollection(map.getAll(key));
    }

    @Override
    public KeyAndValueCardinality getKeyAndValueCardinality() {
        return map.getKeyAndValueCardinality();
    }

    @Override
    public Collection<K> getKeys() {
        return map.getKeys();
    }

    @Override
    public NumericCollection<Byte> getValues() {
        return new ByteCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, Byte>> iterator() {
        return map.iterator();
    }

    /**
     * Returns a new updatable bytes map cloned from the provided bytes map.
     *
     * @param <L> The key type.
     * @param map The original bytes map.
     * @return A new updatable bytes map cloned from the provided bytes map.
     */
    public static <L> UpdatableByteMap<L> of(final NumericMap<? extends L, Byte> map) {
        return new HashMap<L>(map);
    }

    /**
     * Returns a new bytes map with the specified entries.
     *
     * @param <L>     The key type.
     * @param entries The entries for the new map.
     * @return A new bytes map with the specified entries.
     */
    public static <L> UpdatableByteMap<L> of(final Entry<L, Byte>... entries) {
        return new HashMap<L>(entries);
    }

    /**
     * Returns a new bytes map containing an entry with the key and the value.
     *
     * @param <L>   The key type.
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A new bytes map containing an entry with the key and the value.
     */
    public static <L> UpdatableByteMap<L> of(final L key, final Byte value) {
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
    public static <L> UpdatableByteMap<L> of(final L key1, final Byte value1, final L key2, final Byte value2) {
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
    public static <L> UpdatableByteMap<L> of(final L key1, final Byte value1, final L key2, final Byte value2,
            final L key3, final Byte value3) {
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
    public static <L> UpdatableByteMap<L> of(final L key1, final Byte value1, final L key2, final Byte value2,
            final L key3, final Byte value3, final L key4, final Byte value4) {
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
    public static <L> UpdatableByteMap<L> of(final L key1, final Byte value1, final L key2, final Byte value2,
            final L key3, final Byte value3, final L key4, final Byte value4, final L key5, final Byte value5) {
        return new HashMap<L>(new Entry<L, Byte>(key1, value1), new Entry<L, Byte>(key2, value2),
                new Entry<L, Byte>(key3, value3), new Entry<L, Byte>(key4, value4),
                new Entry<L, Byte>(key5, value5));
    }

    /**
     * Returns a new updatable bytes map with the specified keys with a default value and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param defaultValue           The default value for the entries.
     * @param keys                   The keys for the new map.
     * @return A new updatable bytes map with the specified entries.
     */
    public static <L> UpdatableByteMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Byte defaultValue, final L... keys) {
        ModifiableByteMap<L> map = ModifiableByteMap.<L>of(keyAndValueCardinality);
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new HashMap<L>(map);
    }

    /**
     * Returns a new bytes map with the specified entries and key and value cardinality.
     *
     * @param <L>                    The key type.
     * @param keyAndValueCardinality The key and value cardinality.
     * @param entries                The entries for the new map.
     * @return A new bytes map with the specified entries.
     */
    public static <L> UpdatableByteMap<L> of(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<L, Byte>... entries) {
        return new HashMap<L>(keyAndValueCardinality, entries);
    }

    /**
     * Returns a new updatable bytes map with the specified keys with a default value.
     *
     * @param <L>          The key type.
     * @param defaultValue The default value for the entries.
     * @param keys         The keys for the new map.
     * @return A new updatable bytes map with the specified entries.
     */
    public static <L> UpdatableByteMap<L> of(final Byte defaultValue, final L... keys) {
        ModifiableByteMap<L> map = ModifiableByteMap.<L>empty();
        for (L key : keys) {
            map.add(key, defaultValue);
        }
        return new HashMap<L>(map);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Spliterator<Entry<K, Byte>> spliterator() {
        return map.spliterator();
    }

    @Override
    public Object[] toArray() {
        return map.toArray();
    }

    @Override
    public Byte update(final K key, final Byte value) throws IllegalArgumentException {
        return map.update(key, value);
    }

    @Override
    public boolean update(final K key, final Byte oldValye, final Byte newValue) {
        return map.update(key, oldValye, newValue);
    }
}
