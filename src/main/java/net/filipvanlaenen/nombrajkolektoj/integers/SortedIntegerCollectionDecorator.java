package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.SortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} for integers.
 */
abstract class SortedIntegerCollectionDecorator extends OrderedIntegerCollectionDecorator
        implements SortedIntegerCollection {
    @Override
    abstract SortedCollection<Integer> getDecoratedCollection();

    @Override
    public Comparator<? super Integer> getComparator() {
        return getDecoratedCollection().getComparator();
    }

    @Override
    public Integer getGreaterThan(final Integer element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThan(element);
    }

    @Override
    public Integer getGreaterThanOrEqualTo(final Integer element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThanOrEqualTo(element);
    }

    @Override
    public Integer getLessThan(final Integer element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThan(element);
    }

    @Override
    public Integer getLessThanOrEqualTo(final Integer element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThanOrEqualTo(element);
    }
}
