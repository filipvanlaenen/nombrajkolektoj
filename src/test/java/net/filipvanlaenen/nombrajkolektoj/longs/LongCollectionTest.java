package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.LongCollection} class.
 */
public final class LongCollectionTest extends LongCollectionTestBase<LongCollection> {
    @Override
    protected LongCollection createEmptyLongCollection() {
        return LongCollection.empty();
    }

    @Override
    protected LongCollection createLongCollection(final NumericCollection<Long> source) {
        return LongCollection.of(source);
    }

    @Override
    protected LongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return LongCollection.of(elementCardinality, numbers);
    }

    @Override
    protected LongCollection createLongCollection(final Long... numbers) {
        return LongCollection.of(numbers);
    }
}
