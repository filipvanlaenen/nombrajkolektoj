package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.SortedIntegerCollection} class.
 */
public final class SortedIntegerCollectionTest extends SortedIntegerCollectionTestBase<SortedIntegerCollection> {
    @Override
    protected SortedIntegerCollection createEmptyIntegerCollection() {
        return SortedIntegerCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedIntegerCollection createIntegerCollection(final Collection<Integer> source) {
        return new SortedIntegerCollection.ArrayCollection(Comparator.naturalOrder(),
                IntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS)));
    }

    @Override
    protected SortedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... integers) {
        return SortedIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), integers);
    }

    @Override
    protected SortedIntegerCollection createIntegerCollection(final Integer... integers) {
        return SortedIntegerCollection.of(Comparator.naturalOrder(), integers);
    }

    @Override
    protected SortedIntegerCollection createOrderedIntegerCollection(final Integer... integers) {
        return SortedIntegerCollection.of(Comparator.naturalOrder(), integers);
    }

    @Override
    protected SortedIntegerCollection createSortedIntegerCollection(final Comparator<Integer> comparator,
            final Integer... integers) {
        return SortedIntegerCollection.of(comparator, integers);
    }
}
