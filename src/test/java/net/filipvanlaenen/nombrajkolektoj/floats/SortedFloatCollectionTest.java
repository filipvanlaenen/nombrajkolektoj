package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.SortedFloatCollection} class.
 */
public final class SortedFloatCollectionTest extends SortedFloatCollectionTestBase<SortedFloatCollection> {
    @Override
    protected SortedFloatCollection createEmptyFloatCollection() {
        return SortedFloatCollection.empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedFloatCollection createFloatCollection(final Collection<Float> source) {
        return new SortedFloatCollection.ArrayCollection(Comparator.naturalOrder(),
                FloatCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS)));
    }

    @Override
    protected SortedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... floats) {
        return SortedFloatCollection.of(elementCardinality, Comparator.naturalOrder(), floats);
    }

    @Override
    protected SortedFloatCollection createFloatCollection(final Float... floats) {
        return SortedFloatCollection.of(Comparator.naturalOrder(), floats);
    }

    @Override
    protected SortedFloatCollection createOrderedFloatCollection(final Float... floats) {
        return SortedFloatCollection.of(Comparator.naturalOrder(), floats);
    }

    @Override
    protected SortedFloatCollection createSortedFloatCollection(final Comparator<Float> comparator,
            final Float... floats) {
        return SortedFloatCollection.of(comparator, floats);
    }
}
