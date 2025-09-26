package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableSortedShortCollection} class.
 */
public final class ModifiableSortedShortCollectionTest
        extends ModifiableShortCollectionTestBase<ModifiableSortedShortCollection> {
    @Override
    protected ModifiableSortedShortCollection createShortCollection(final Collection<Short> source) {
        return new ModifiableSortedShortCollection.SortedTreeCollection(Comparator.naturalOrder(),
                ShortCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS)));
    }

    @Override
    protected ModifiableSortedShortCollection createShortCollection(final Short... numbers) {
        return ModifiableSortedShortCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return ModifiableSortedShortCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedShortCollection createEmptyShortCollection() {
        return ModifiableSortedShortCollection.empty(Comparator.naturalOrder());
    }
}
