package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

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
    protected ModifiableShortCollection createShortCollection(final Collection<Short> source) {
        return new ModifiableShortCollection.ArrayCollection(source);
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
