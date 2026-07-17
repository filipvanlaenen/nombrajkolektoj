package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.ModifiableSortedMap;
import net.filipvanlaenen.kolektoj.SortedCollection;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableSortedIntegerMap} interface.
 *
 * @param <K> The key type.
 */
abstract class ModifiableSortedIntegerMapDecorator<K> extends ModifiableIntegerMapDecorator<K>
        implements ModifiableSortedIntegerMap<K> {

    @Override
    public Comparator<? super K> getComparator() {
        return getDecoratedMap().getComparator();
    }

    @Override
    abstract ModifiableSortedMap<K, Integer> getDecoratedMap();

    @Override
    public Entry<K, Integer> getGreaterThan(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getGreaterThan(key);
    }

    @Override
    public Entry<K, Integer> getGreaterThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getGreaterThanOrEqualTo(key);
    }

    @Override
    public Entry<K, Integer> getGreatest() {
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
    public Entry<K, Integer> getLeast() {
        return getDecoratedMap().getLeast();
    }

    @Override
    public K getLeastKey() {
        return getDecoratedMap().getLeastKey();
    }

    @Override
    public Entry<K, Integer> getLessThan(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getLessThan(key);
    }

    @Override
    public Entry<K, Integer> getLessThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getLessThanOrEqualTo(key);
    }

    @Override
    public OrderedIntegerCollection getValues() {
        return new OrderedIntegerCollection.ArrayCollection(getDecoratedMap().getValues());
    }

    @Override
    public Entry<K, Integer> removeGreatest() {
        return getDecoratedMap().removeGreatest();
    }

    @Override
    public Entry<K, Integer> removeLeast() {
        return getDecoratedMap().removeLeast();
    }
}
