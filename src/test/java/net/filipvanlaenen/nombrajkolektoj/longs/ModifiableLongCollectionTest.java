package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableLongCollection} class.
 */
public final class ModifiableLongCollectionTest
        extends ModifiableLongCollectionTestBase<ModifiableLongCollection> {
    @Override
    protected ModifiableLongCollection createEmptyLongCollection() {
        return ModifiableLongCollection.empty();
    }

    @Override
    protected ModifiableLongCollection createLongCollection(final Collection<Long> source) {
        return new ModifiableLongCollection.ArrayCollection(source);
    }

    @Override
    protected ModifiableLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return ModifiableLongCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableLongCollection createLongCollection(final Long... numbers) {
        return ModifiableLongCollection.of(numbers);
    }
}
