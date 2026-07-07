package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.SortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} for BigDecimals.
 */
abstract class SortedBigDecimalCollectionDecorator extends OrderedBigDecimalCollectionDecorator
        implements SortedBigDecimalCollection {
    @Override
    abstract SortedCollection<BigDecimal> getDecoratedCollection();

    @Override
    public Comparator<? super BigDecimal> getComparator() {
        return getDecoratedCollection().getComparator();
    }

    @Override
    public BigDecimal getGreaterThan(final BigDecimal element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThan(element);
    }

    @Override
    public BigDecimal getGreaterThanOrEqualTo(final BigDecimal element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThanOrEqualTo(element);
    }

    @Override
    public BigDecimal getLessThan(final BigDecimal element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThan(element);
    }

    @Override
    public BigDecimal getLessThanOrEqualTo(final BigDecimal element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThanOrEqualTo(element);
    }
}
