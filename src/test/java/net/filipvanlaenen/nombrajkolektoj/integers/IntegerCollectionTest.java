package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerCollection} class.
 */
public final class IntegerCollectionTest extends IntegerCollectionTestBase<IntegerCollection> {
    @Override
    protected IntegerCollection createEmptyIntegerCollection() {
        return IntegerCollection.empty();
    }

    @Override
    protected IntegerCollection createIntegerCollection(final NumericCollection<Integer> source) {
        return IntegerCollection.of(source);
    }

    @Override
    protected IntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return IntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected IntegerCollection createIntegerCollection(final Integer... numbers) {
        return IntegerCollection.of(numbers);
    }
}
