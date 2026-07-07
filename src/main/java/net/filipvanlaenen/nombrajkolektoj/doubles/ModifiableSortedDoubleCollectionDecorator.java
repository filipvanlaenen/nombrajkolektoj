package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection} for doubles.
 */
abstract class ModifiableSortedDoubleCollectionDecorator extends ModifiableDoubleCollectionDecorator
        implements ModifiableSortedDoubleCollection {
    @Override
    abstract ModifiableSortedCollection<Double> getDecoratedCollection();

    @Override
    public int firstIndexOf(final Double element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public Double getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

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

    @Override
    public int indexOf(final Double element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final Double element) {
        return getDecoratedCollection().lastIndexOf(element);
    }

    @Override
    public Double removeAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().removeAt(index);
    }
}
