package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

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
    protected ModifiableLongCollection createLongCollection(final NumericCollection<Long> source) {
        return ModifiableLongCollection.of(source);
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
