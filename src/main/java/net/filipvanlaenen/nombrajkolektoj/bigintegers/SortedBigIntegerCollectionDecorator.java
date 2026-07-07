package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.SortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} for BigIntegers.
 */
abstract class SortedBigIntegerCollectionDecorator extends OrderedBigIntegerCollectionDecorator
        implements SortedBigIntegerCollection {
    @Override
    abstract SortedCollection<BigInteger> getDecoratedCollection();

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
}
