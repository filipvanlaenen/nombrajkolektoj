package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericMap;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericMap} interface for integers and
 * containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class IntegerMap<K> extends AbstractIntegerMap<K> implements NumericMap<K, Integer> {
    /**
     * Inner class using a hash function backed implementation of the {@link net.filipvanlaenen.kolektoj.Map} interface.
     *
     * @param <K> The key type.
     */
    public static final class HashMap<K> extends IntegerMap<K> {
        /**
         * Constructs a map from another map, with the same keys and integers and the same key and value cardinality.
         *
         * @param source The map to create a new map from.
         */
        public HashMap(final Map<K, Integer> source) {
            this(source.getKeyAndValueCardinality(), source.toArray());
        }

        /**
         * Constructs a map with the given entries and key and value cardinality.
         *
         * @param keyAndValueCardinality The key and value cardinality.
         * @param entries                The entries of the map.
         */
        public HashMap(final KeyAndValueCardinality keyAndValueCardinality, final Entry<K, Integer>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.HashMap<K, Integer>(keyAndValueCardinality, entries));
        }

        /**
         * Constructs a map with the given entries. The key and value cardinality is defaulted to
         * <code>DISTINCT_KEYS</code>.
         *
         * @param entries The entries of the map.
         */
        public HashMap(final Entry<K, Integer>... entries) {
            super(new net.filipvanlaenen.kolektoj.hash.HashMap<K, Integer>(entries));
        }
    }

    /**
     * The map holding the keys and the integers.
     */
    private final Map<K, Integer> map;

    /**
     * Private constructor taking a map with the keys and the integers as its parameter.
     *
     * @param map The map holding the keys and the integers.
     */
    private IntegerMap(final Map<K, Integer> map) {
        this.map = map;
    }

    @Override
    public boolean contains(final Entry<K, Integer> entry) {
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
    public boolean containsValue(final Integer value) {
        return map.containsValue(value);
    }

    @Override
    public Entry<K, Integer> get() throws IndexOutOfBoundsException {
        return map.get();
    }

    @Override
    public Integer get(final K key) throws IllegalArgumentException {
        return map.get(key);
    }

    @Override
    public NumericCollection<Integer> getAll(final K key) throws IllegalArgumentException {
        return new IntegerCollection.ArrayCollection(map.getAll(key));
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
    public NumericCollection<Integer> getValues() {
        return new IntegerCollection.ArrayCollection(map.getValues());
    }

    @Override
    public Iterator<Entry<K, Integer>> iterator() {
        return map.iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Spliterator<Entry<K, Integer>> spliterator() {
        return map.spliterator();
    }

    @Override
    public Entry<K, Integer>[] toArray() {
        return map.toArray();
    }
}
