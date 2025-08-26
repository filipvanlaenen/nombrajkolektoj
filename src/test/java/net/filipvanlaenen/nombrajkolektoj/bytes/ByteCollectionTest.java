package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteCollection} class.
 */
public final class ByteCollectionTest extends ByteCollectionTestBase<ByteCollection> {
    @Override
    protected ByteCollection createEmptyByteCollection() {
        return ByteCollection.empty();
    }

    @Override
    protected ByteCollection createByteCollection(final Collection<Byte> source) {
        return new ByteCollection.ArrayCollection(source);
    }

    @Override
    protected ByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return ByteCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ByteCollection createByteCollection(final Byte... numbers) {
        return ByteCollection.of(numbers);
    }
}
