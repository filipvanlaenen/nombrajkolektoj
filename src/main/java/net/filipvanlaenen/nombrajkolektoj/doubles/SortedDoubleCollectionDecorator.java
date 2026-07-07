package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.SortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} for doubles.
 */
abstract class SortedDoubleCollectionDecorator extends OrderedDoubleCollectionDecorator
        implements SortedDoubleCollection {
    @Override
    abstract SortedCollection<Double> getDecoratedCollection();

    @Override
    public Comparator<? super Double> getComparator() {
        return getDecoratedCollection().getComparator();
    }

    @Override
    public Double getGreaterThan(final Double element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThan(element);
    }

    @Override
    public Double getGreaterThanOrEqualTo(final Double element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThanOrEqualTo(element);
    }

    @Override
    public Double getLessThan(final Double element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThan(element);
    }

    @Override
    public Double getLessThanOrEqualTo(final Double element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThanOrEqualTo(element);
    }
}
