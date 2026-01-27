package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableFloatCollection} class.
 */
public final class ModifiableFloatCollectionTest
        extends ModifiableFloatCollectionTestBase<ModifiableFloatCollection> {
    @Override
    protected ModifiableFloatCollection createEmptyFloatCollection() {
        return ModifiableFloatCollection.empty();
    }

    @Override
    protected ModifiableFloatCollection createFloatCollection(final NumericCollection<Float> source) {
        return new ModifiableFloatCollection.ArrayCollection(source);
    }

    @Override
    protected ModifiableFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return ModifiableFloatCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableFloatCollection createFloatCollection(final Float... numbers) {
        return ModifiableFloatCollection.of(numbers);
    }
}
