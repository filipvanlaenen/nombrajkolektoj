package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection} for BigIntegers.
 */
abstract class ModifiableSortedBigIntegerCollectionDecorator extends ModifiableBigIntegerCollectionDecorator
        implements ModifiableSortedBigIntegerCollection {
    @Override
    abstract ModifiableSortedCollection<BigInteger> getDecoratedCollection();

    @Override
    public int firstIndexOf(final BigInteger element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public BigInteger getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

    @Override
    public Comparator<? super BigInteger> getComparator() {
        return getDecoratedCollection().getComparator();
    }

    @Override
    public BigInteger getGreaterThan(final BigInteger element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThan(element);
    }

    @Override
    public BigInteger getGreaterThanOrEqualTo(final BigInteger element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThanOrEqualTo(element);
    }

    @Override
    public BigInteger getLessThan(final BigInteger element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThan(element);
    }

    @Override
    public BigInteger getLessThanOrEqualTo(final BigInteger element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThanOrEqualTo(element);
    }

    @Override
    public int indexOf(final BigInteger element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final BigInteger element) {
        return getDecoratedCollection().lastIndexOf(element);
    }

    @Override
    public BigInteger removeAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().removeAt(index);
    }
}
