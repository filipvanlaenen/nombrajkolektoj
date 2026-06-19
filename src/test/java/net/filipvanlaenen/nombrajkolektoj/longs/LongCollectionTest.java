package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.LongCollection} class.
 */
public final class LongCollectionTest extends LongCollectionTestBase<LongCollection> {
    /**
     * Collection with the longs 1, 2 and 3.
     */
    private final NumericCollection<Long> collection123 = createLongCollection(1L, 2L, 3L);

    @Override
    protected LongCollection createEmptyLongCollection() {
        return LongCollection.empty();
    }

    @Override
    protected LongCollection createLongCollection(final Long... numbers) {
        return LongCollection.of(numbers);
    }

    @Override
    protected LongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return LongCollection.of(elementCardinality, numbers);
    }

    @Override
    protected LongCollection createLongCollection(final ElementCardinality elementCardinality,
            final NumericCollection<Long> source) {
        return LongCollection.of(elementCardinality, source);
    }

    @Override
    protected LongCollection createLongCollection(final NumericCollection<Long> source) {
        return LongCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(LongCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(LongCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(createLongCollection(1L, 2L)
                .containsSame(LongCollection.intersectionOf(createLongCollection(0L, 1L, 2L), collection123)));
    }
}
