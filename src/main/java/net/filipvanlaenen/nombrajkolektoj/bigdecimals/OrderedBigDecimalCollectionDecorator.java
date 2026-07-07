package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} for BigDecimals.
 */
abstract class OrderedBigDecimalCollectionDecorator extends BigDecimalCollectionDecorator implements OrderedBigDecimalCollection {
    @Override
    abstract OrderedCollection<BigDecimal> getDecoratedCollection();

    @Override
    public int firstIndexOf(final BigDecimal element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public BigDecimal getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

    @Override
    public int indexOf(final BigDecimal element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final BigDecimal element) {
        return getDecoratedCollection().lastIndexOf(element);
    }
}
