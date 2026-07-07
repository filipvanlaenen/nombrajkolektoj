package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection} for longs.
 */
abstract class ModifiableSortedLongCollectionDecorator extends ModifiableLongCollectionDecorator
        implements ModifiableSortedLongCollection {
    @Override
    abstract ModifiableSortedCollection<Long> getDecoratedCollection();

    @Override
    public int firstIndexOf(final Long element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public Long getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

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

    @Override
    public int indexOf(final Long element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final Long element) {
        return getDecoratedCollection().lastIndexOf(element);
    }

    @Override
    public Long removeAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().removeAt(index);
    }
}
