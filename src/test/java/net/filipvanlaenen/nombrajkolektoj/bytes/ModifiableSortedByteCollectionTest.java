package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableSortedByteCollection} class.
 */
public final class ModifiableSortedByteCollectionTest
        extends ModifiableByteCollectionTestBase<ModifiableSortedByteCollection> {
    @Override
    protected ModifiableSortedByteCollection createByteCollection(final Collection<Byte> source) {
        return new ModifiableSortedByteCollection.SortedTreeCollection(Comparator.naturalOrder(),
                ByteCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BYTES)));
    }

    @Override
    protected ModifiableSortedByteCollection createByteCollection(final Byte... numbers) {
        return ModifiableSortedByteCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return ModifiableSortedByteCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedByteCollection createEmptyByteCollection() {
        return ModifiableSortedByteCollection.empty(Comparator.naturalOrder());
    }
}
