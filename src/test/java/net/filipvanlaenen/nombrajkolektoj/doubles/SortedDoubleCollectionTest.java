package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.SortedDoubleCollection} class.
 */
public final class SortedDoubleCollectionTest extends SortedDoubleCollectionTestBase<SortedDoubleCollection> {
    @Override
    protected SortedDoubleCollection createEmptyDoubleCollection() {
        return SortedDoubleCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedDoubleCollection createDoubleCollection(final Collection<Double> source) {
        return new SortedDoubleCollection.ArrayCollection(Comparator.naturalOrder(),
                DoubleCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES)));
    }

    @Override
    protected SortedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return SortedDoubleCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedDoubleCollection createDoubleCollection(final Double... numbers) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedDoubleCollection createOrderedDoubleCollection(final Double... numbers) {
        return SortedDoubleCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected SortedDoubleCollection createSortedDoubleCollection(final Comparator<Double> comparator,
            final Double... numbers) {
        return SortedDoubleCollection.of(comparator, numbers);
    }
}
