package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} for integers.
 */
abstract class OrderedIntegerCollectionDecorator extends IntegerCollectionDecorator implements OrderedIntegerCollection {
    @Override
    abstract OrderedCollection<Integer> getDecoratedCollection();

    @Override
    public int firstIndexOf(final Integer element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public Integer getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

    @Override
    public int indexOf(final Integer element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final Integer element) {
        return getDecoratedCollection().lastIndexOf(element);
    }
}
