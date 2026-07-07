package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection} for integers.
 */
abstract class ModifiableSortedIntegerCollectionDecorator extends ModifiableIntegerCollectionDecorator
        implements ModifiableSortedIntegerCollection {
    @Override
    abstract ModifiableSortedCollection<Integer> getDecoratedCollection();

    @Override
    public int firstIndexOf(final Integer element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public Integer getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

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

    @Override
    public int indexOf(final Integer element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final Integer element) {
        return getDecoratedCollection().lastIndexOf(element);
    }

    @Override
    public Integer removeAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().removeAt(index);
    }
}
