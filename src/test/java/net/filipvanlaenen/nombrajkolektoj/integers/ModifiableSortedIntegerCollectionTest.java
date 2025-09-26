package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableSortedIntegerCollection} class.
 */
public final class ModifiableSortedIntegerCollectionTest
        extends ModifiableIntegerCollectionTestBase<ModifiableSortedIntegerCollection> {
    @Override
    protected ModifiableSortedIntegerCollection createIntegerCollection(final Collection<Integer> source) {
        return new ModifiableSortedIntegerCollection.SortedTreeCollection(Comparator.naturalOrder(),
                IntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS)));
    }

    @Override
    protected ModifiableSortedIntegerCollection createIntegerCollection(final Integer... numbers) {
        return ModifiableSortedIntegerCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return ModifiableSortedIntegerCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedIntegerCollection createEmptyIntegerCollection() {
        return ModifiableSortedIntegerCollection.empty(Comparator.naturalOrder());
    }
}
