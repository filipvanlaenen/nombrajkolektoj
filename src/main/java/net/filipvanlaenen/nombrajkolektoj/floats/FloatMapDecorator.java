package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.floats.FloatMap} interface.
 *
 * @param <K> The key type.
 */
abstract class FloatMapDecorator<K> implements FloatMap<K> {
    @Override
    public boolean contains(final Entry<K, Float> entry) {
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
    public boolean containsValue(final Float value) {
        return getDecoratedMap().containsValue(value);
    }

    @Override
    public Entry<K, Float> get() throws IndexOutOfBoundsException {
        return getDecoratedMap().get();
    }

    @Override
    public Float get(final K key) throws IllegalArgumentException {
        return getDecoratedMap().get(key);
    }

    @Override
    public FloatCollection getAll(final K key) throws IllegalArgumentException {
        return new FloatCollection.ArrayCollection(getDecoratedMap().getAll(key));
    }

    /**
     * Returns the internal decorated map.
     *
     * @return The internal decorated map
     */
    abstract Map<K, Float> getDecoratedMap();

    @Override
    public KeyAndValueCardinality getKeyAndValueCardinality() {
        return getDecoratedMap().getKeyAndValueCardinality();
    }

    @Override
    public Collection<K> getKeys() {
        return getDecoratedMap().getKeys();
    }

    @Override
    public FloatCollection getValues() {
        return new FloatCollection.ArrayCollection(getDecoratedMap().getValues());
    }

    @Override
    public Iterator<Entry<K, Float>> iterator() {
        return getDecoratedMap().iterator();
    }

    @Override
    public Float max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public Float min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public Float product() {
        return getValues().product();
    }

    @Override
    public int size() {
        return getDecoratedMap().size();
    }

    @Override
    public Spliterator<Entry<K, Float>> spliterator() {
        return getDecoratedMap().spliterator();
    }

    @Override
    public Float sum() {
        return getValues().sum();
    }

    @Override
    public Object[] toArray() {
        return getDecoratedMap().toArray();
    }
}
