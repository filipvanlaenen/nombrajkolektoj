package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.OrderedDoubleCollection} class.
 */
public final class OrderedDoubleCollectionTest extends OrderedDoubleCollectionTestBase<OrderedDoubleCollection> {
    @Override
    protected OrderedDoubleCollection createEmptyDoubleCollection() {
        return OrderedDoubleCollection.empty();
    }

    @Override
    protected OrderedDoubleCollection createDoubleCollection(final Collection<Double> source) {
        return new OrderedDoubleCollection.ArrayCollection(
                OrderedCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES)));
    }

    @Override
    protected OrderedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return OrderedDoubleCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedDoubleCollection createDoubleCollection(final Double... numbers) {
        return OrderedDoubleCollection.of(numbers);
    }

    @Override
    protected OrderedDoubleCollection createOrderedDoubleCollection(final Double... numbers) {
        return OrderedDoubleCollection.of(numbers);
    }

    @Override
    protected OrderedDoubleCollection createOrderedDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return OrderedDoubleCollection.of(elementCardinality, numbers);
    }
}
