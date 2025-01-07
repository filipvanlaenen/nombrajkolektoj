package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.SortedByteCollection} class.
 */
public final class SortedByteCollectionTest extends OrderedByteCollectionTestBase<SortedByteCollection> {
    @Override
    protected SortedByteCollection createEmptyByteCollection() {
        return SortedByteCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedByteCollection createByteCollection(final Collection<Byte> source) {
        return new SortedByteCollection.ArrayCollection(Comparator.naturalOrder(),
                ByteCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BYTES)));
    }

    @Override
    protected SortedByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... bytes) {
        return SortedByteCollection.of(elementCardinality, Comparator.naturalOrder(), bytes);
    }

    @Override
    protected SortedByteCollection createByteCollection(final Byte... bytes) {
        return SortedByteCollection.of(Comparator.naturalOrder(), bytes);
    }

    @Override
    protected SortedByteCollection createOrderedByteCollection(final Byte... bytes) {
        return SortedByteCollection.of(Comparator.naturalOrder(), bytes);
    }
}
