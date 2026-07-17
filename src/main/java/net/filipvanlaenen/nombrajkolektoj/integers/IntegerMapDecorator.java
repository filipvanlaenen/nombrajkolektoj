package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerMap} interface.
 *
 * @param <K> The key type.
 */
abstract class IntegerMapDecorator<K> implements IntegerMap<K> {
    @Override
    public boolean contains(final Entry<K, Integer> entry) {
        return getDecoratedMap().contains(entry);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return getDecoratedMap().containsAll(collection);
    }

    @Override
    public boolean containsKey(final K key) {
        return getDecoratedMap().containsKey(key);
    }

    @Override
    public boolean containsValue(final Integer value) {
        return getDecoratedMap().containsValue(value);
    }

    @Override
    public Entry<K, Integer> get() throws IndexOutOfBoundsException {
        return getDecoratedMap().get();
    }

    @Override
    public Integer get(final K key) throws IllegalArgumentException {
        return getDecoratedMap().get(key);
    }

    @Override
    public IntegerCollection getAll(final K key) throws IllegalArgumentException {
        return new IntegerCollection.ArrayCollection(getDecoratedMap().getAll(key));
    }

    /**
     * Returns the internal decorated map.
     *
     * @return The internal decorated map
     */
    abstract Map<K, Integer> getDecoratedMap();

    @Override
    public KeyAndValueCardinality getKeyAndValueCardinality() {
        return getDecoratedMap().getKeyAndValueCardinality();
    }

    @Override
    public Collection<K> getKeys() {
        return getDecoratedMap().getKeys();
    }

    @Override
    public IntegerCollection getValues() {
        return new IntegerCollection.ArrayCollection(getDecoratedMap().getValues());
    }

    @Override
    public Iterator<Entry<K, Integer>> iterator() {
        return getDecoratedMap().iterator();
    }

    @Override
    public Integer max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public Integer min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public Integer product() {
        return getValues().product();
    }

    @Override
    public int size() {
        return getDecoratedMap().size();
    }

    @Override
    public Spliterator<Entry<K, Integer>> spliterator() {
        return getDecoratedMap().spliterator();
    }

    @Override
    public Integer sum() {
        return getValues().sum();
    }

    @Override
    public Object[] toArray() {
        return getDecoratedMap().toArray();
    }
}
