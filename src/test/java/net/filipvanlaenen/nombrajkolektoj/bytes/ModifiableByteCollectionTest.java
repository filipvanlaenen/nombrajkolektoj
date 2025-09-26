package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableByteCollection} class.
 */
public final class ModifiableByteCollectionTest
        extends ModifiableByteCollectionTestBase<ModifiableByteCollection> {
    @Override
    protected ModifiableByteCollection createEmptyByteCollection() {
        return ModifiableByteCollection.empty();
    }

    @Override
    protected ModifiableByteCollection createByteCollection(final Collection<Byte> source) {
        return new ModifiableByteCollection.ArrayCollection(source);
    }

    @Override
    protected ModifiableByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return ModifiableByteCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableByteCollection createByteCollection(final Byte... numbers) {
        return ModifiableByteCollection.of(numbers);
    }
}
