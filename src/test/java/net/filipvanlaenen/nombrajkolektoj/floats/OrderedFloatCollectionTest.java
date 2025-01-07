package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.OrderedFloatCollection} class.
 */
public final class OrderedFloatCollectionTest extends OrderedFloatCollectionTestBase<OrderedFloatCollection> {
    @Override
    protected OrderedFloatCollection createEmptyFloatCollection() {
        return OrderedFloatCollection.empty();
    }

    @Override
    protected OrderedFloatCollection createFloatCollection(final Collection<Float> source) {
        return new OrderedFloatCollection.ArrayCollection(
                OrderedCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS)));
    }

    @Override
    protected OrderedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... floats) {
        return OrderedFloatCollection.of(elementCardinality, floats);
    }

    @Override
    protected OrderedFloatCollection createFloatCollection(final Float... floats) {
        return OrderedFloatCollection.of(floats);
    }

    @Override
    protected OrderedFloatCollection createOrderedFloatCollection(final Float... floats) {
        return OrderedFloatCollection.of(floats);
    }
}
