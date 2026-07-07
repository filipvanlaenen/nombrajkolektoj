package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.SortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} for longs.
 */
abstract class SortedLongCollectionDecorator extends OrderedLongCollectionDecorator
        implements SortedLongCollection {
    @Override
    abstract SortedCollection<Long> getDecoratedCollection();

    @Override
    public Comparator<? super Long> getComparator() {
        return getDecoratedCollection().getComparator();
    }

    @Override
    public Long getGreaterThan(final Long element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThan(element);
    }

    @Override
    public Long getGreaterThanOrEqualTo(final Long element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThanOrEqualTo(element);
    }

    @Override
    public Long getLessThan(final Long element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThan(element);
    }

    @Override
    public Long getLessThanOrEqualTo(final Long element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThanOrEqualTo(element);
    }
}
