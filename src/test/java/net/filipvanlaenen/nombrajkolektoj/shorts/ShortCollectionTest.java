package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ShortCollection} class.
 */
public final class ShortCollectionTest extends ShortCollectionTestBase<ShortCollection> {
    /**
     * Collection with the shorts 1, 2 and 3.
     */
    private final NumericCollection<Short> collection123 = createShortCollection((short) 1, (short) 2, (short) 3);

    @Override
    protected ShortCollection createEmptyShortCollection() {
        return ShortCollection.empty();
    }

    @Override
    protected ShortCollection createShortCollection(final Short... numbers) {
        return ShortCollection.of(numbers);
    }

    @Override
    protected ShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return ShortCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final NumericCollection<Short> source) {
        return ShortCollection.of(elementCardinality, source);
    }

    @Override
    protected ShortCollection createShortCollection(final NumericCollection<Short> source) {
        return ShortCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ShortCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ShortCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(createShortCollection((short) 1, (short) 2)
                .containsSame(ShortCollection.intersectionOf(createShortCollection((short) 0, (short) 1, (short) 2), collection123)));
    }
}
