package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.longs.LongMap} interface.
 *
 * @param <K> The key type.
 */
abstract class LongMapDecorator<K> implements LongMap<K> {
    @Override
    public boolean contains(final Entry<K, Long> entry) {
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
    public boolean containsValue(final Long value) {
        return getDecoratedMap().containsValue(value);
    }

    @Override
    public Entry<K, Long> get() throws IndexOutOfBoundsException {
        return getDecoratedMap().get();
    }

    @Override
    public Long get(final K key) throws IllegalArgumentException {
        return getDecoratedMap().get(key);
    }

    @Override
    public LongCollection getAll(final K key) throws IllegalArgumentException {
        return new LongCollection.ArrayCollection(getDecoratedMap().getAll(key));
    }

    /**
     * Returns the internal decorated map.
     *
     * @return The internal decorated map
     */
    abstract Map<K, Long> getDecoratedMap();

    @Override
    public KeyAndValueCardinality getKeyAndValueCardinality() {
        return getDecoratedMap().getKeyAndValueCardinality();
    }

    @Override
    public Collection<K> getKeys() {
        return getDecoratedMap().getKeys();
    }

    @Override
    public LongCollection getValues() {
        return new LongCollection.ArrayCollection(getDecoratedMap().getValues());
    }

    @Override
    public Iterator<Entry<K, Long>> iterator() {
        return getDecoratedMap().iterator();
    }

    @Override
    public Long max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public Long min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public Long product() {
        return getValues().product();
    }

    @Override
    public int size() {
        return getDecoratedMap().size();
    }

    @Override
    public Spliterator<Entry<K, Long>> spliterator() {
        return getDecoratedMap().spliterator();
    }

    @Override
    public Long sum() {
        return getValues().sum();
    }

    @Override
    public Object[] toArray() {
        return getDecoratedMap().toArray();
    }
}
