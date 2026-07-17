package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleMap} interface.
 *
 * @param <K> The key type.
 */
abstract class DoubleMapDecorator<K> implements DoubleMap<K> {
    @Override
    public boolean contains(final Entry<K, Double> entry) {
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
    public boolean containsValue(final Double value) {
        return getDecoratedMap().containsValue(value);
    }

    @Override
    public Entry<K, Double> get() throws IndexOutOfBoundsException {
        return getDecoratedMap().get();
    }

    @Override
    public Double get(final K key) throws IllegalArgumentException {
        return getDecoratedMap().get(key);
    }

    @Override
    public DoubleCollection getAll(final K key) throws IllegalArgumentException {
        return new DoubleCollection.ArrayCollection(getDecoratedMap().getAll(key));
    }

    /**
     * Returns the internal decorated map.
     *
     * @return The internal decorated map
     */
    abstract Map<K, Double> getDecoratedMap();

    @Override
    public KeyAndValueCardinality getKeyAndValueCardinality() {
        return getDecoratedMap().getKeyAndValueCardinality();
    }

    @Override
    public Collection<K> getKeys() {
        return getDecoratedMap().getKeys();
    }

    @Override
    public DoubleCollection getValues() {
        return new DoubleCollection.ArrayCollection(getDecoratedMap().getValues());
    }

    @Override
    public Iterator<Entry<K, Double>> iterator() {
        return getDecoratedMap().iterator();
    }

    @Override
    public Double max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public Double min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public Double product() {
        return getValues().product();
    }

    @Override
    public int size() {
        return getDecoratedMap().size();
    }

    @Override
    public Spliterator<Entry<K, Double>> spliterator() {
        return getDecoratedMap().spliterator();
    }

    @Override
    public Double sum() {
        return getValues().sum();
    }

    @Override
    public Object[] toArray() {
        return getDecoratedMap().toArray();
    }
}
