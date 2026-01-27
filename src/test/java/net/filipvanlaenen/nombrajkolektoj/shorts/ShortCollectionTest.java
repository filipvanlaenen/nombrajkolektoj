package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ShortCollection} class.
 */
public final class ShortCollectionTest extends ShortCollectionTestBase<ShortCollection> {
    @Override
    protected ShortCollection createEmptyShortCollection() {
        return ShortCollection.empty();
    }

    @Override
    protected ShortCollection createShortCollection(final NumericCollection<Short> source) {
        return ShortCollection.of(source);
    }

    @Override
    protected ShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return ShortCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ShortCollection createShortCollection(final Short... numbers) {
        return ShortCollection.of(numbers);
    }
}
