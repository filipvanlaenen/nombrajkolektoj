package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableSortedLongCollection} class.
 */
public final class ModifiableSortedLongCollectionTest
        extends ModifiableLongCollectionTestBase<ModifiableSortedLongCollection> {
    @Override
    protected ModifiableSortedLongCollection createLongCollection(final Collection<Long> source) {
        return new ModifiableSortedLongCollection.SortedTreeCollection(Comparator.naturalOrder(),
                LongCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS)));
    }

    @Override
    protected ModifiableSortedLongCollection createLongCollection(final Long... numbers) {
        return ModifiableSortedLongCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return ModifiableSortedLongCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedLongCollection createEmptyLongCollection() {
        return ModifiableSortedLongCollection.empty(Comparator.naturalOrder());
    }
}
