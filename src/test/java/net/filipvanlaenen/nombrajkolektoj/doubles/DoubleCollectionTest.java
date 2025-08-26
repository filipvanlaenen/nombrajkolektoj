package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleCollection} class.
 */
public final class DoubleCollectionTest extends DoubleCollectionTestBase<DoubleCollection> {
    @Override
    protected DoubleCollection createEmptyDoubleCollection() {
        return DoubleCollection.empty();
    }

    @Override
    protected DoubleCollection createDoubleCollection(final Collection<Double> source) {
        return new DoubleCollection.ArrayCollection(source);
    }

    @Override
    protected DoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return DoubleCollection.of(elementCardinality, numbers);
    }

    @Override
    protected DoubleCollection createDoubleCollection(final Double... numbers) {
        return DoubleCollection.of(numbers);
    }
}
