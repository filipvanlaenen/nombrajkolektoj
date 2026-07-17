package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

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
    private final ShortCollection collection012 = ShortCollection.of((short) 0, (short) 1, (short) 2);
    /**
     * Collection with the shorts 1, 2 and 3.
     */
    private final ShortCollection collection123 = ShortCollection.of((short) 1, (short) 2, (short) 3);

    /**
     * Verifies that the constructor of the ArrayCollection class creates a short collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateAShortCollection() {
        assertTrue(new ShortCollection.ArrayCollection((short) 1, (short) 2, SHORT_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the HashCollection class creates a short collection.
     */
    @Test
    public void constructorOfHashCollectionShouldCreateAShortCollection() {
        assertTrue(new ShortCollection.HashCollection((short) 1, (short) 2, SHORT_THREE).containsAll(collection123));
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
            final ShortCollection source) {
        return ShortCollection.of(elementCardinality, source);
    }

    @Override
    protected ShortCollection createShortCollection(final ShortCollection source) {
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
        assertTrue(ShortCollection.of((short) 1, (short) 2)
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
        assertTrue(ShortCollection.of((short) 0, (short) 1, (short) 2, (short) 1, (short) 2, SHORT_THREE)
                .containsSame(ShortCollection.unionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertTrue(ShortCollection.of((short) 0, (short) 1, (short) 2, SHORT_THREE)
                .containsSame(ShortCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123)));
    }
}
