package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.OrderedLongCollection} class.
 */
public final class OrderedLongCollectionTest extends LongCollectionTestBase<OrderedLongCollection> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;

    @Override
    protected OrderedLongCollection createEmptyLongCollection() {
        return OrderedLongCollection.empty();
    }

    @Override
    protected OrderedLongCollection createLongCollection(final Collection<Long> source) {
        return new OrderedLongCollection.ArrayCollection(
                OrderedCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS)));
    }

    @Override
    protected OrderedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... longs) {
        return OrderedLongCollection.of(elementCardinality, longs);
    }

    @Override
    protected OrderedLongCollection createLongCollection(final Long... longs) {
        return OrderedLongCollection.of(longs);
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2L, createLongCollection(1L, 2L, LONG_THREE).getAt(1));
    }
}
