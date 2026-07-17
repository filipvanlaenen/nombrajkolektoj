package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.kolektoj.SortedMap;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.doubles.SortedDoubleMap} interface.
 *
 * @param <K> The key type.
 */
abstract class SortedDoubleMapDecorator<K> extends DoubleMapDecorator<K> implements SortedDoubleMap<K> {
    @Override
    public Comparator<? super K> getComparator() {
        return getDecoratedMap().getComparator();
    }

    @Override
    abstract SortedMap<K, Double> getDecoratedMap();

    @Override
    public Entry<K, Double> getGreaterThan(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getGreaterThan(key);
    }

    @Override
    public Entry<K, Double> getGreaterThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getGreaterThanOrEqualTo(key);
    }

    @Override
    public Entry<K, Double> getGreatest() {
        return getDecoratedMap().getGreatest();
    }

    @Override
    public K getGreatestKey() {
        return getDecoratedMap().getGreatestKey();
    }

    @Override
    public OrderedDoubleCollection getValues() {
        return new OrderedDoubleCollection.ArrayCollection(getDecoratedMap().getValues());
    }

    @Override
    public K getKeyGreaterThan(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getKeyGreaterThan(key);
    }

    @Override
    public K getKeyGreaterThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getKeyGreaterThanOrEqualTo(key);
    }

    @Override
    public K getKeyLessThan(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getKeyLessThan(key);
    }

    @Override
    public K getKeyLessThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getKeyLessThanOrEqualTo(key);
    }

    @Override
    public SortedCollection<K> getKeys() {
        return getDecoratedMap().getKeys();
    }

    @Override
    public Entry<K, Double> getLeast() {
        return getDecoratedMap().getLeast();
    }

    @Override
    public K getLeastKey() {
        return getDecoratedMap().getLeastKey();
    }

    @Override
    public Entry<K, Double> getLessThan(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getLessThan(key);
    }

    @Override
    public Entry<K, Double> getLessThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getLessThanOrEqualTo(key);
    }
}
