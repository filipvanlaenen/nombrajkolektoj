package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
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
    protected OrderedByteCollection createByteCollection(final Byte... bytes) {
        return OrderedByteCollection.of(bytes);
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((byte) 2, createByteCollection((byte) 1, (byte) 2, (byte) 3).getAt(1));
    }
}
