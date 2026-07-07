package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.SortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} for bytes.
 */
abstract class SortedByteCollectionDecorator extends OrderedByteCollectionDecorator
        implements SortedByteCollection {
    @Override
    abstract SortedCollection<Byte> getDecoratedCollection();

    @Override
    public Comparator<? super Byte> getComparator() {
        return getDecoratedCollection().getComparator();
    }

    @Override
    public Byte getGreaterThan(final Byte element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThan(element);
    }

    @Override
    public Byte getGreaterThanOrEqualTo(final Byte element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getGreaterThanOrEqualTo(element);
    }

    @Override
    public Byte getLessThan(final Byte element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThan(element);
    }

    @Override
    public Byte getLessThanOrEqualTo(final Byte element) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getLessThanOrEqualTo(element);
    }
}
