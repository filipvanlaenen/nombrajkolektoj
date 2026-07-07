package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection} for BigDecimals.
 */
abstract class ModifiableSortedBigDecimalCollectionDecorator extends ModifiableBigDecimalCollectionDecorator
        implements ModifiableSortedBigDecimalCollection {
    @Override
    abstract ModifiableSortedCollection<BigDecimal> getDecoratedCollection();

    @Override
    public int firstIndexOf(final BigDecimal element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public BigDecimal getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

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

    @Override
    public int indexOf(final BigDecimal element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final BigDecimal element) {
        return getDecoratedCollection().lastIndexOf(element);
    }

    @Override
    public BigDecimal removeAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().removeAt(index);
    }
}
