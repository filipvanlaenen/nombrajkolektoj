package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection} for shorts.
 */
abstract class ModifiableSortedShortCollectionDecorator extends ModifiableShortCollectionDecorator
        implements ModifiableSortedShortCollection {
    @Override
    abstract ModifiableSortedCollection<Short> getDecoratedCollection();

    @Override
    public int firstIndexOf(final Short element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public Short getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

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

    @Override
    public int indexOf(final Short element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final Short element) {
        return getDecoratedCollection().lastIndexOf(element);
    }

    @Override
    public Short removeAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().removeAt(index);
    }
}
