package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.OrderedFloatCollection} class.
 */
public final class OrderedFloatCollectionTest extends FloatCollectionTestBase<OrderedFloatCollection> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;

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

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2F, createFloatCollection(1F, 2F, FLOAT_THREE).getAt(1));
    }
}
