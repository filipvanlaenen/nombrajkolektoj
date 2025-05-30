package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ShortCollection} class.
 */
public final class ShortCollectionTest extends ShortCollectionTestBase<ShortCollection> {
    @Override
    protected ShortCollection createEmptyShortCollection() {
        return ShortCollection.empty();
    }

    @Override
    protected ShortCollection createShortCollection(final Collection<Short> source) {
        return new ShortCollection.ArrayCollection(source);
    }

    @Override
    protected ShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... shorts) {
        return ShortCollection.of(elementCardinality, shorts);
    }

    @Override
    protected ShortCollection createShortCollection(final Short... shorts) {
        return ShortCollection.of(shorts);
    }
}
