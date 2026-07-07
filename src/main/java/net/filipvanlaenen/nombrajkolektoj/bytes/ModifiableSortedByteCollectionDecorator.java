package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection} for bytes.
 */
abstract class ModifiableSortedByteCollectionDecorator extends ModifiableByteCollectionDecorator
        implements ModifiableSortedByteCollection {
    @Override
    abstract ModifiableSortedCollection<Byte> getDecoratedCollection();

    @Override
    public int firstIndexOf(final Byte element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public Byte getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

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

    @Override
    public int indexOf(final Byte element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final Byte element) {
        return getDecoratedCollection().lastIndexOf(element);
    }

    @Override
    public Byte removeAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().removeAt(index);
    }
}
