package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.FloatCollection} class.
 */
public final class FloatCollectionTest extends FloatCollectionTestBase<FloatCollection> {
    @Override
    protected FloatCollection createEmptyFloatCollection() {
        return FloatCollection.empty();
    }

    @Override
    protected FloatCollection createFloatCollection(final Collection<Float> source) {
        return new FloatCollection.ArrayCollection(source);
    }

    @Override
    protected FloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return FloatCollection.of(elementCardinality, numbers);
    }

    @Override
    protected FloatCollection createFloatCollection(final Float... numbers) {
        return FloatCollection.of(numbers);
    }
}
