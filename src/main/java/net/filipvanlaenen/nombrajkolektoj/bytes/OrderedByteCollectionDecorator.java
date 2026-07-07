package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} for bytes.
 */
abstract class OrderedByteCollectionDecorator extends ByteCollectionDecorator implements OrderedByteCollection {
    @Override
    abstract OrderedCollection<Byte> getDecoratedCollection();

    @Override
    public int firstIndexOf(final Byte element) {
        return getDecoratedCollection().firstIndexOf(element);
    }

    @Override
    public Byte getAt(final int index) throws IndexOutOfBoundsException {
        return getDecoratedCollection().getAt(index);
    }

    @Override
    public int indexOf(final Byte element) {
        return getDecoratedCollection().indexOf(element);
    }

    @Override
    public int lastIndexOf(final Byte element) {
        return getDecoratedCollection().lastIndexOf(element);
    }
}
