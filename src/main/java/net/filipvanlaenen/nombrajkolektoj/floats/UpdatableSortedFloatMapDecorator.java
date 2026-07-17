package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.kolektoj.UpdatableSortedMap;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.floats.UpdatableSortedFloatMap} interface.
 *
 * @param <K> The key type.
 */
abstract class UpdatableSortedFloatMapDecorator<K> extends UpdatableFloatMapDecorator<K>
        implements UpdatableSortedFloatMap<K> {
    @Override
    public Comparator<? super K> getComparator() {
        return getDecoratedMap().getComparator();
    }

    @Override
    abstract UpdatableSortedMap<K, Float> getDecoratedMap();

    @Override
    public Entry<K, Float> getGreaterThan(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getGreaterThan(key);
    }

    @Override
    public Entry<K, Float> getGreaterThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getGreaterThanOrEqualTo(key);
    }

    @Override
    public Entry<K, Float> getGreatest() {
        return getDecoratedMap().getGreatest();
    }

    @Override
    public K getGreatestKey() {
        return getDecoratedMap().getGreatestKey();
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
    public Entry<K, Float> getLeast() {
        return getDecoratedMap().getLeast();
    }

    @Override
    public K getLeastKey() {
        return getDecoratedMap().getLeastKey();
    }

    @Override
    public Entry<K, Float> getLessThan(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getLessThan(key);
    }

    @Override
    public Entry<K, Float> getLessThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getLessThanOrEqualTo(key);
    }

    @Override
    public OrderedFloatCollection getValues() {
        return new OrderedFloatCollection.ArrayCollection(getDecoratedMap().getValues());
    }
}
