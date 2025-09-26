package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableDoubleCollection} class.
 */
public final class ModifiableDoubleCollectionTest
        extends ModifiableDoubleCollectionTestBase<ModifiableDoubleCollection> {
    @Override
    protected ModifiableDoubleCollection createEmptyDoubleCollection() {
        return ModifiableDoubleCollection.empty();
    }

    @Override
    protected ModifiableDoubleCollection createDoubleCollection(final Collection<Double> source) {
        return new ModifiableDoubleCollection.ArrayCollection(source);
    }

    @Override
    protected ModifiableDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return ModifiableDoubleCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableDoubleCollection createDoubleCollection(final Double... numbers) {
        return ModifiableDoubleCollection.of(numbers);
    }
}
