package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.BigDecimalMap} interface.
 *
 * @param <K> The key type.
 */
abstract class BigDecimalMapDecorator<K> implements BigDecimalMap<K> {
    @Override
    public boolean contains(final Entry<K, BigDecimal> entry) {
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
    public boolean containsValue(final BigDecimal value) {
        return getDecoratedMap().containsValue(value);
    }

    @Override
    public Entry<K, BigDecimal> get() throws IndexOutOfBoundsException {
        return getDecoratedMap().get();
    }

    @Override
    public BigDecimal get(final K key) throws IllegalArgumentException {
        return getDecoratedMap().get(key);
    }

    @Override
    public BigDecimalCollection getAll(final K key) throws IllegalArgumentException {
        return new BigDecimalCollection.ArrayCollection(getDecoratedMap().getAll(key));
    }

    /**
     * Returns the internal decorated map.
     *
     * @return The internal decorated map
     */
    abstract Map<K, BigDecimal> getDecoratedMap();

    @Override
    public KeyAndValueCardinality getKeyAndValueCardinality() {
        return getDecoratedMap().getKeyAndValueCardinality();
    }

    @Override
    public Collection<K> getKeys() {
        return getDecoratedMap().getKeys();
    }

    @Override
    public BigDecimalCollection getValues() {
        return new BigDecimalCollection.ArrayCollection(getDecoratedMap().getValues());
    }

    @Override
    public Iterator<Entry<K, BigDecimal>> iterator() {
        return getDecoratedMap().iterator();
    }

    @Override
    public BigDecimal max() throws IndexOutOfBoundsException {
        return getValues().max();
    }

    @Override
    public BigDecimal min() throws IndexOutOfBoundsException {
        return getValues().min();
    }

    @Override
    public BigDecimal product() {
        return getValues().product();
    }

    @Override
    public int size() {
        return getDecoratedMap().size();
    }

    @Override
    public Spliterator<Entry<K, BigDecimal>> spliterator() {
        return getDecoratedMap().spliterator();
    }

    @Override
    public BigDecimal sum() {
        return getValues().sum();
    }

    @Override
    public Object[] toArray() {
        return getDecoratedMap().toArray();
    }
}
