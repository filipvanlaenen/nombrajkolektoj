package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.OrderedIntegerCollection} class.
 */
public final class OrderedIntegerCollectionTest extends OrderedIntegerCollectionTestBase<OrderedIntegerCollection> {
    @Override
    protected OrderedIntegerCollection createEmptyIntegerCollection() {
        return OrderedIntegerCollection.empty();
    }

    @Override
    protected OrderedIntegerCollection createIntegerCollection(final NumericCollection<Integer> source) {
        return new OrderedIntegerCollection.ArrayCollection(
                OrderedCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS)));
    }

    @Override
    protected OrderedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return OrderedIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedIntegerCollection createIntegerCollection(final Integer... numbers) {
        return OrderedIntegerCollection.of(numbers);
    }

    @Override
    protected OrderedIntegerCollection createOrderedIntegerCollection(final Integer... numbers) {
        return OrderedIntegerCollection.of(numbers);
    }

    @Override
    protected OrderedIntegerCollection createOrderedIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return OrderedIntegerCollection.of(elementCardinality, numbers);
    }
}
