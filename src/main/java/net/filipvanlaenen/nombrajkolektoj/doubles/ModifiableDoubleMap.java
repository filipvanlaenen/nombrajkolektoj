package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.ModifiableMap;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap} interface for
 * Doubles and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public class ModifiableDoubleMap<K> extends AbstractModifiableDoubleMap<K> implements ModifiableNumericMap<K, Double> {
    /**
     * Inner class using a hash function backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableMap}
     * interface.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends ModifiableDoubleMap<K> {
        /**
         * Constructs a modifiable map from another map, with the same keys and Doubles and the same key and value
         * cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<K, Double> source) {
            super(new net.filipvanlaenen.kolektoj.hash.ModifiableHashMap<K, Double>(source));
        }

        /**
         * Constructs a modifiable map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, Double>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.ModifiableHashMap<K, Double>(keyAndValueCardinality, entries));
        }

        /**
         * Constructs a modifiable map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, Double>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.ModifiableHashMap<K, Double>(entries));
        }
    }

    /**
     * The modifiable map holding the keys and the doubles.
     */
    private final ModifiableMap<K, Double> map;

    /**
     * Private constructor taking a map with the keys and the doubles as its parameter.
     *
     * @param map The map holding the keys and the doubles.
     */
    private ModifiableDoubleMap(final ModifiableMap<K, Double> map) {
        this.map = map;
    }

    @Override
    public boolean add(final K key, final Double value) {
        return map.add(key, value);
    }

    @Override
    public boolean addAll(final Map<? extends K, ? extends Double> aMap) {
        return map.addAll(aMap);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(final Entry<K, Double> entry) {
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
    public boolean containsValue(final Double value) {
        return map.containsValue(value);
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

    @Override
    public Entry<K, Double> get() throws IndexOutOfBoundsException {
        return map.get();
    }

    @Override
    public Double get(final K key) throws IllegalArgumentException {
        return map.get(key);
    }

    @Override
    public NumericCollection<Double> getAll(final K key) throws IllegalArgumentException {
        return new DoubleCollection.ArrayCollection(map.getAll(key));
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
    public NumericCollection<Double> getValues() {
        return new DoubleCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, Double>> iterator() {
        return map.iterator();
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
     * Returns a new doubles map containing an entry with the key and the value.
     *
     * @param <L>   The key type.
     * @param key   The key for the entry.
     * @param value The value for the entry.
     * @return A new doubles map containing an entry with the key and the value.
     */
    public static <L> ModifiableDoubleMap<L> of(final L key, final Double value) {
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
    public static <L> ModifiableDoubleMap<L> of(final L key1, final Double value1, final L key2, final Double value2) {
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
    public static <L> ModifiableDoubleMap<L> of(final L key1, final Double value1, final L key2, final Double value2,
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
    public static <L> ModifiableDoubleMap<L> of(final L key1, final Double value1, final L key2, final Double value2,
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
    public static <L> ModifiableDoubleMap<L> of(final L key1, final Double value1, final L key2, final Double value2,
            final L key3, final Double value3, final L key4, final Double value4, final L key5, final Double value5) {
        return new HashMap<L>(new Entry<L, Double>(key1, value1), new Entry<L, Double>(key2, value2),
                new Entry<L, Double>(key3, value3), new Entry<L, Double>(key4, value4),
                new Entry<L, Double>(key5, value5));
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

    @Override
    public Double remove(final K key) throws IllegalArgumentException {
        return map.remove(key);
    }

    @Override
    public boolean remove(final K key, final Double value) {
        return map.remove(key, value);
    }

    @Override
    public boolean removeAll(final Map<? extends K, ? extends Double> aMap) {
        return map.removeAll(aMap);
    }

    @Override
    public boolean removeIf(final Predicate<Entry<? extends K, ? extends Double>> predicate) {
        return map.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Map<? extends K, ? extends Double> aMap) {
        return map.retainAll(aMap);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Spliterator<Entry<K, Double>> spliterator() {
        return map.spliterator();
    }

    @Override
    public Object[] toArray() {
        return map.toArray();
    }

    @Override
    public Double update(final K key, final Double value) throws IllegalArgumentException {
        return map.update(key, value);
    }

    @Override
    public boolean update(final K key, final Double oldValue, final Double newValue) {
        return map.update(key, oldValue, newValue);
    }
}
