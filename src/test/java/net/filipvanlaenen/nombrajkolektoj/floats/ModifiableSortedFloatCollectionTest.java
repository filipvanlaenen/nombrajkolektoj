package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableSortedFloatCollection} class.
 */
public final class ModifiableSortedFloatCollectionTest
        extends ModifiableFloatCollectionTestBase<ModifiableSortedFloatCollection> {
    @Override
    protected ModifiableSortedFloatCollection createFloatCollection(final Collection<Float> source) {
        return new ModifiableSortedFloatCollection.SortedTreeCollection(Comparator.naturalOrder(),
                FloatCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS)));
    }

    @Override
    protected ModifiableSortedFloatCollection createFloatCollection(final Float... numbers) {
        return ModifiableSortedFloatCollection.of(Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return ModifiableSortedFloatCollection.of(elementCardinality, Comparator.naturalOrder(), numbers);
    }

    @Override
    protected ModifiableSortedFloatCollection createEmptyFloatCollection() {
        return ModifiableSortedFloatCollection.empty(Comparator.naturalOrder());
    }
}
