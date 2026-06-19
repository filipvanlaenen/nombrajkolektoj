package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ShortCollection} class.
 */
public final class ShortCollectionTest extends ShortCollectionTestBase<ShortCollection> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;
    /**
     * Collection with the shorts 0, 1 and 2.
     */
    private final NumericCollection<Short> collection012 = createShortCollection((short) 0, (short) 1, (short) 2);
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
                .containsSame(ShortCollection.intersectionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ShortCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ShortCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ShortCollection.unionOf(collection123)));
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertTrue(collection123.containsSame(ShortCollection.unionOf(DISTINCT_ELEMENTS, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertTrue(createShortCollection((short) 0, (short) 1, (short) 2, (short) 1, (short) 2, SHORT_THREE)
                .containsSame(ShortCollection.unionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertTrue(createShortCollection((short) 0, (short) 1, (short) 2, SHORT_THREE)
                .containsSame(ShortCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123)));
    }
}
