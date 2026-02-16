package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableShortCollection} class.
 */
public final class ModifiableShortCollectionTest
        extends ModifiableShortCollectionTestBase<ModifiableShortCollection> {
    @Override
    protected ModifiableShortCollection createEmptyShortCollection() {
        return ModifiableShortCollection.empty();
    }

    @Override
    protected ModifiableShortCollection createShortCollection(final NumericCollection<Short> source) {
        return ModifiableShortCollection.of(source);
    }

    @Override
    protected ModifiableShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return ModifiableShortCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableShortCollection createShortCollection(final Short... numbers) {
        return ModifiableShortCollection.of(numbers);
    }
}
