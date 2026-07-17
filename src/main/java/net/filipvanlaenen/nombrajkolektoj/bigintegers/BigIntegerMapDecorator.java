package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.BigIntegerMap} interface.
 *
 * @param <K> The key type.
 */
abstract class BigIntegerMapDecorator<K> implements BigIntegerMap<K> {
    @Override
    public boolean contains(final Entry<K, BigInteger> entry) {
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
    public boolean containsValue(final BigInteger value) {
        return getDecoratedMap().containsValue(value);
    }

    @Override
    public Entry<K, BigInteger> get() throws IndexOutOfBoundsException {
        return getDecoratedMap().get();
    }

    @Override
    public BigInteger get(final K key) throws IllegalArgumentException {
        return getDecoratedMap().get(key);
    }

    @Override
    public BigIntegerCollection getAll(final K key) throws IllegalArgumentException {
        return new BigIntegerCollection.ArrayCollection(getDecoratedMap().getAll(key));
    }

    /**
     * Returns the internal decorated map.
     *
     * @return The internal decorated map
     */
    abstract Map<K, BigInteger> getDecoratedMap();

    @Override
    public KeyAndValueCardinality getKeyAndValueCardinality() {
        return getDecoratedMap().getKeyAndValueCardinality();
    }

    @Override
    public Collection<K> getKeys() {
        return getDecoratedMap().getKeys();
    }

    @Override
    public BigIntegerCollection getValues() {
        return new BigIntegerCollection.ArrayCollection(getDecoratedMap().getValues());
    }

    @Override
    public Iterator<Entry<K, BigInteger>> iterator() {
        return getDecoratedMap().iterator();
    }

    @Override
    public BigInteger max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public BigInteger min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public BigInteger product() {
        return getValues().product();
    }

    @Override
    public int size() {
        return getDecoratedMap().size();
    }

    @Override
    public Spliterator<Entry<K, BigInteger>> spliterator() {
        return getDecoratedMap().spliterator();
    }

    @Override
    public BigInteger sum() {
        return getValues().sum();
    }

    @Override
    public Object[] toArray() {
        return getDecoratedMap().toArray();
    }
}
