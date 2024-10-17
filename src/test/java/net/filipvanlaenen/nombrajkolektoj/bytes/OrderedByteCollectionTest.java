package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.OrderedByteCollection} class.
 */
public final class OrderedByteCollectionTest extends ByteCollectionTestBase<OrderedByteCollection> {
    @Override
    protected OrderedByteCollection createEmptyByteCollection() {
        return OrderedByteCollection.empty();
    }

    @Override
    protected OrderedByteCollection createByteCollection(final Collection<Byte> source) {
        return new OrderedByteCollection.ArrayCollection(
                OrderedCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BYTES)));
    }

    @Override
    protected OrderedByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... bytes) {
        return OrderedByteCollection.of(elementCardinality, bytes);
    }

    @Override
    protected OrderedByteCollection createByteCollection(final Byte... integers) {
        return OrderedByteCollection.of(integers);
    }
}
