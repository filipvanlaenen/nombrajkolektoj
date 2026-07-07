package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} for shorts.
 */
abstract class OrderedShortCollectionDecorator extends ShortCollectionDecorator implements OrderedShortCollection {
    @Override
    abstract OrderedCollection<Short> getDecoratedCollection();

    @Override
    public int firstIndexOf(final Short element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public Short getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

    @Override
    public int indexOf(final Short element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final Short element) {
        return getDecoratedCollection().lastIndexOf(element);
    }
}
