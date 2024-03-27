package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableIntegerCollection} class.
 */
public final class ModifiableIntegerCollectionTest extends IntegerCollectionTestBase<ModifiableIntegerCollection> {
    @Override
    protected ModifiableIntegerCollection createEmptyIntegerCollection() {
        return ModifiableIntegerCollection.empty();
    }

    @Override
    protected ModifiableIntegerCollection createIntegerCollection(final Collection<Integer> source) {
        return new ModifiableIntegerCollection.ArrayCollection(source);
    }

    @Override
    protected ModifiableIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... integers) {
        return ModifiableIntegerCollection.of(elementCardinality, integers);
    }

    @Override
    protected ModifiableIntegerCollection createIntegerCollection(final Integer... integers) {
        return ModifiableIntegerCollection.of(integers);
    }
}
