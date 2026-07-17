package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.OrderedByteCollection} class.
 */
public final class SortedByteCollectionDecoratorTest
        extends SortedByteCollectionDecoratorTestBase<SortedByteCollection> {
    @Override
    protected SortedByteCollection createByteCollection(final Byte... numbers) {
        return SortedByteCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return SortedByteCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedByteCollection createEmptyByteCollection() {
        return SortedByteCollection.empty(Comparator.naturalOrder());
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
