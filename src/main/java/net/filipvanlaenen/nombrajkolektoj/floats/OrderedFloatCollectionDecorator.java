package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.floats.OrderedFloatCollection} interface.
 */
abstract class OrderedFloatCollectionDecorator extends FloatCollectionDecorator implements OrderedFloatCollection {
    @Override
    abstract OrderedCollection<Float> getDecoratedCollection();

    @Override
    public int firstIndexOf(final Float element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public Float getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

    @Override
    public int indexOf(final Float element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final Float element) {
        return getDecoratedCollection().lastIndexOf(element);
    }
}
