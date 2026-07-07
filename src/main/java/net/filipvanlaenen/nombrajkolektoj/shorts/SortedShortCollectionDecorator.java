package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.SortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} for shorts.
 */
abstract class SortedShortCollectionDecorator extends OrderedShortCollectionDecorator
        implements SortedShortCollection {
    @Override
    abstract SortedCollection<Short> getDecoratedCollection();

    @Override
    public Comparator<? super Short> getComparator() {
        return getDecoratedCollection().getComparator();
    }

    @Override
    public Short getGreaterThan(final Short element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThan(element);
    }

    @Override
    public Short getGreaterThanOrEqualTo(final Short element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThanOrEqualTo(element);
    }

    @Override
    public Short getLessThan(final Short element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThan(element);
    }

    @Override
    public Short getLessThanOrEqualTo(final Short element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThanOrEqualTo(element);
    }
}
