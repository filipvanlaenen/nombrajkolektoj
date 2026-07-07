package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} for BigIntegers.
 */
abstract class OrderedBigIntegerCollectionDecorator extends BigIntegerCollectionDecorator implements OrderedBigIntegerCollection {
    @Override
    abstract OrderedCollection<BigInteger> getDecoratedCollection();

    @Override
    public int firstIndexOf(final BigInteger element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public BigInteger getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

    @Override
    public int indexOf(final BigInteger element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final BigInteger element) {
        return getDecoratedCollection().lastIndexOf(element);
    }
}
