package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableSortedDoubleCollection} class.
 */
public final class ModifiableSortedDoubleCollectionTest
        extends ModifiableDoubleCollectionTestBase<ModifiableSortedDoubleCollection> {
    @Override
    protected ModifiableSortedDoubleCollection createDoubleCollection(final Collection<Double> source) {
        return new ModifiableSortedDoubleCollection.SortedTreeCollection(Comparator.naturalOrder(),
                DoubleCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES)));
    }

    @Override
    protected ModifiableSortedDoubleCollection createDoubleCollection(final Double... numbers) {
        return ModifiableSortedDoubleCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return ModifiableSortedDoubleCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedDoubleCollection createEmptyDoubleCollection() {
        return ModifiableSortedDoubleCollection.empty(Comparator.naturalOrder());
    }
}
