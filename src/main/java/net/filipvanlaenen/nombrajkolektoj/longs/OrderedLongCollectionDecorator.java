package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.longs.OrderedLongCollection} interface.
 */
abstract class OrderedLongCollectionDecorator extends LongCollectionDecorator implements OrderedLongCollection {
    @Override
    abstract OrderedCollection<Long> getDecoratedCollection();

    @Override
    public int firstIndexOf(final Long element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public Long getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

    @Override
    public int indexOf(final Long element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final Long element) {
        return getDecoratedCollection().lastIndexOf(element);
    }
}
