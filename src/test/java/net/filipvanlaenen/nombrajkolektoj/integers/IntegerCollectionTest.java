package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerCollection} class.
 */
public final class IntegerCollectionTest extends IntegerCollectionTestBase<IntegerCollection> {
    @Override
    protected IntegerCollection createEmptyIntegerCollection() {
        return IntegerCollection.empty();
    }

    @Override
    protected IntegerCollection createIntegerCollection(Collection<Integer> source) {
        return new IntegerCollection.ArrayCollection(source);
    }

    @Override
    protected IntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... integers) {
        return IntegerCollection.of(elementCardinality, integers);
    }

    @Override
    protected IntegerCollection createIntegerCollection(final Integer... integers) {
        return IntegerCollection.of(integers);
    }
}
