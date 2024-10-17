package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.LongCollection} class.
 */
public final class LongCollectionTest extends LongCollectionTestBase<LongCollection> {
    @Override
    protected LongCollection createEmptyLongCollection() {
        return LongCollection.empty();
    }

    @Override
    protected LongCollection createLongCollection(final Collection<Long> source) {
        return new LongCollection.ArrayCollection(source);
    }

    @Override
    protected LongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... longs) {
        return LongCollection.of(elementCardinality, longs);
    }

    @Override
    protected LongCollection createLongCollection(final Long... longs) {
        return LongCollection.of(longs);
    }
}
