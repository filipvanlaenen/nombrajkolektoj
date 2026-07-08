package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.doubles.OrderedDoubleCollection} interface.
 */
abstract class OrderedDoubleCollectionDecorator extends DoubleCollectionDecorator implements OrderedDoubleCollection {
    @Override
    abstract OrderedCollection<Double> getDecoratedCollection();

    @Override
    public int firstIndexOf(final Double element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public Double getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

    @Override
    public int indexOf(final Double element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final Double element) {
        return getDecoratedCollection().lastIndexOf(element);
    }
}
