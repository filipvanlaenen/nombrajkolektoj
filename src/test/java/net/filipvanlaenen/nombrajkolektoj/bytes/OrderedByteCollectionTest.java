package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.OrderedByteCollection} class.
 */
public final class OrderedByteCollectionTest extends OrderedByteCollectionTestBase<OrderedByteCollection> {
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
            final Byte... numbers) {
        return OrderedByteCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedByteCollection createByteCollection(final Byte... numbers) {
        return OrderedByteCollection.of(numbers);
    }

    @Override
    protected OrderedByteCollection createOrderedByteCollection(final Byte... numbers) {
        return OrderedByteCollection.of(numbers);
    }

    @Override
    protected OrderedByteCollection createOrderedByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return OrderedByteCollection.of(elementCardinality, numbers);
    }
}
