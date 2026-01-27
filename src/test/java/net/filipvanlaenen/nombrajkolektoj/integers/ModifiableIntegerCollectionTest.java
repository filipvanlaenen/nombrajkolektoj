package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableIntegerCollection} class.
 */
public final class ModifiableIntegerCollectionTest
        extends ModifiableIntegerCollectionTestBase<ModifiableIntegerCollection> {
    @Override
    protected ModifiableIntegerCollection createEmptyIntegerCollection() {
        return ModifiableIntegerCollection.empty();
    }

    @Override
    protected ModifiableIntegerCollection createIntegerCollection(final NumericCollection<Integer> source) {
        return new ModifiableIntegerCollection.ArrayCollection(source);
    }

    @Override
    protected ModifiableIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return ModifiableIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableIntegerCollection createIntegerCollection(final Integer... numbers) {
        return ModifiableIntegerCollection.of(numbers);
    }
}
