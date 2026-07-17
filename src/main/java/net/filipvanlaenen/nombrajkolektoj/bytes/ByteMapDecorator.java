package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteMap} interface.
 *
 * @param <K> The key type.
 */
abstract class ByteMapDecorator<K> implements ByteMap<K> {
    @Override
    public boolean contains(final Entry<K, Byte> entry) {
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
    public boolean containsValue(final Byte value) {
        return getDecoratedMap().containsValue(value);
    }

    @Override
    public Entry<K, Byte> get() throws IndexOutOfBoundsException {
        return getDecoratedMap().get();
    }

    @Override
    public Byte get(final K key) throws IllegalArgumentException {
        return getDecoratedMap().get(key);
    }

    @Override
    public ByteCollection getAll(final K key) throws IllegalArgumentException {
        return new ByteCollection.ArrayCollection(getDecoratedMap().getAll(key));
    }

    /**
     * Returns the internal decorated map.
     *
     * @return The internal decorated map
     */
    abstract Map<K, Byte> getDecoratedMap();

    @Override
    public KeyAndValueCardinality getKeyAndValueCardinality() {
        return getDecoratedMap().getKeyAndValueCardinality();
    }

    @Override
    public Collection<K> getKeys() {
        return getDecoratedMap().getKeys();
    }

    @Override
    public ByteCollection getValues() {
        return new ByteCollection.ArrayCollection(getDecoratedMap().getValues());
    }

    @Override
    public Iterator<Entry<K, Byte>> iterator() {
        return getDecoratedMap().iterator();
    }

    @Override
    public Byte max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public Byte min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public Byte product() {
        return getValues().product();
    }

    @Override
    public int size() {
        return getDecoratedMap().size();
    }

    @Override
    public Spliterator<Entry<K, Byte>> spliterator() {
        return getDecoratedMap().spliterator();
    }

    @Override
    public Byte sum() {
        return getValues().sum();
    }

    @Override
    public Object[] toArray() {
        return getDecoratedMap().toArray();
    }
}
