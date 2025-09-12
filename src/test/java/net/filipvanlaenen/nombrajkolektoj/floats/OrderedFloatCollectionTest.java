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
            final Float... numbers) {
        return OrderedFloatCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedFloatCollection createFloatCollection(final Float... numbers) {
        return OrderedFloatCollection.of(numbers);
    }

    @Override
    protected OrderedFloatCollection createOrderedFloatCollection(final Float... numbers) {
        return OrderedFloatCollection.of(numbers);
    }

    @Override
    protected OrderedFloatCollection createOrderedFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return OrderedFloatCollection.of(elementCardinality, numbers);
    }
}
