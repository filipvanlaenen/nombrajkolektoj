package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.shorts.ShortMap} interface.
 *
 * @param <K> The key type.
 */
abstract class ShortMapDecorator<K> implements ShortMap<K> {
    @Override
    public boolean contains(final Entry<K, Short> entry) {
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
    public boolean containsValue(final Short value) {
        return getDecoratedMap().containsValue(value);
    }

    @Override
    public Entry<K, Short> get() throws IndexOutOfBoundsException {
        return getDecoratedMap().get();
    }

    @Override
    public Short get(final K key) throws IllegalArgumentException {
        return getDecoratedMap().get(key);
    }

    @Override
    public ShortCollection getAll(final K key) throws IllegalArgumentException {
        return new ShortCollection.ArrayCollection(getDecoratedMap().getAll(key));
    }

    /**
     * Returns the internal decorated map.
     *
     * @return The internal decorated map
     */
    abstract Map<K, Short> getDecoratedMap();

    @Override
    public KeyAndValueCardinality getKeyAndValueCardinality() {
        return getDecoratedMap().getKeyAndValueCardinality();
    }

    @Override
    public Collection<K> getKeys() {
        return getDecoratedMap().getKeys();
    }

    @Override
    public ShortCollection getValues() {
        return new ShortCollection.ArrayCollection(getDecoratedMap().getValues());
    }

    @Override
    public Iterator<Entry<K, Short>> iterator() {
        return getDecoratedMap().iterator();
    }

    @Override
    public Short max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public Short min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public Short product() {
        return getValues().product();
    }

    @Override
    public int size() {
        return getDecoratedMap().size();
    }

    @Override
    public Spliterator<Entry<K, Short>> spliterator() {
        return getDecoratedMap().spliterator();
    }

    @Override
    public Short sum() {
        return getValues().sum();
    }

    @Override
    public Object[] toArray() {
        return getDecoratedMap().toArray();
    }
}
