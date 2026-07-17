package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.ModifiableSortedMap;
import net.filipvanlaenen.kolektoj.SortedCollection;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableSortedByteMap} interface.
 *
 * @param <K> The key type.
 */
abstract class ModifiableSortedByteMapDecorator<K> extends ModifiableByteMapDecorator<K>
        implements ModifiableSortedByteMap<K> {

    @Override
    public Comparator<? super K> getComparator() {
        return getDecoratedMap().getComparator();
    }

    @Override
    abstract ModifiableSortedMap<K, Byte> getDecoratedMap();

    @Override
    public Entry<K, Byte> getGreaterThan(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getGreaterThan(key);
    }

    @Override
    public Entry<K, Byte> getGreaterThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getGreaterThanOrEqualTo(key);
    }

    @Override
    public Entry<K, Byte> getGreatest() {
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
    public Entry<K, Byte> getLeast() {
        return getDecoratedMap().getLeast();
    }

    @Override
    public K getLeastKey() {
        return getDecoratedMap().getLeastKey();
    }

    @Override
    public Entry<K, Byte> getLessThan(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getLessThan(key);
    }

    @Override
    public Entry<K, Byte> getLessThanOrEqualTo(final K key) throws IndexOutOfBoundsException {
        return getDecoratedMap().getLessThanOrEqualTo(key);
    }

    @Override
    public OrderedByteCollection getValues() {
        return new OrderedByteCollection.ArrayCollection(getDecoratedMap().getValues());
    }

    @Override
    public Entry<K, Byte> removeGreatest() {
        return getDecoratedMap().removeGreatest();
    }

    @Override
    public Entry<K, Byte> removeLeast() {
        return getDecoratedMap().removeLeast();
    }
}
