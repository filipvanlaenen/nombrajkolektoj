package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.SortedByteCollection} class.
 */
public final class SortedByteCollectionTest extends SortedByteCollectionTestBase<SortedByteCollection> {
    @Override
    protected SortedByteCollection createEmptyByteCollection() {
        return SortedByteCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedByteCollection createByteCollection(final NumericCollection<Byte> source) {
        return new SortedByteCollection.ArrayCollection(Comparator.naturalOrder(),
                ByteCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BYTES)));
    }

    @Override
    protected SortedByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return SortedByteCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedByteCollection createByteCollection(final Byte... numbers) {
        return SortedByteCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedByteCollection createOrderedByteCollection(final Byte... numbers) {
        return SortedByteCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedByteCollection createOrderedByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return SortedByteCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedByteCollection createSortedByteCollection(final Comparator<Byte> comparator,
            final Byte... numbers) {
        return SortedByteCollection.of(comparator, numbers);
    }
}
