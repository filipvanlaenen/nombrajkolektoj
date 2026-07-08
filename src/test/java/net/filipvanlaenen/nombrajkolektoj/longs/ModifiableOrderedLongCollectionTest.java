package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableOrderedLongCollection} class.
 */
public final class ModifiableOrderedLongCollectionTest
        extends ModifiableLongCollectionTestBase<ModifiableOrderedLongCollection> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;
    /**
     * The long four.
     */
    private static final Long LONG_FOUR = 4L;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Array with the longs one, two and three.
     */
    private static final Long[] LONGS123 = new Long[] {1L, 2L, 3L};
    /**
     * Collection with the longs 0, 1 and 2.
     */
    private final ModifiableOrderedLongCollection collection012 = ModifiableOrderedLongCollection.of(0L, 1L, 2L);
    /**
     * Collection with the longs 1, 2 and 3.
     */
    private final ModifiableOrderedLongCollection collection123 = ModifiableOrderedLongCollection.of(1L, 2L, 3L);

    /**
     * Verifies that the constructor of the ArrayCollection class creates a long collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateALongCollection() {
        assertTrue(
                new ModifiableOrderedLongCollection.ArrayCollection(1L, 2L, LONG_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the LinkedListCollection class creates a long collection.
     */
    @Test
    public void constructorOfLinkedListCollectionShouldCreateALongCollection() {
        assertTrue(new ModifiableOrderedLongCollection.LinkedListCollection(1L, 2L, LONG_THREE)
                .containsAll(collection123));
    }

    @Override
    protected ModifiableOrderedLongCollection createLongCollection(final ModifiableOrderedLongCollection source) {
        return ModifiableOrderedLongCollection
                .of(OrderedLongCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS)));
    }

    @Override
    protected ModifiableOrderedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return ModifiableOrderedLongCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final ModifiableOrderedLongCollection source) {
        return ModifiableOrderedLongCollection.of(elementCardinality,
                OrderedLongCollection.of(source.toArray(EmptyArrays.LONGS)));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(ModifiableOrderedLongCollection.empty().isEmpty());
    }

    /**
     * Verifies that an ordered longs collection created as a slice from another ordered collection has the same
     * element cardinality and the correct longs in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        ModifiableOrderedLongCollection source =
                ModifiableOrderedLongCollection.of(DISTINCT_ELEMENTS, 1L, 2L, LONG_THREE, LONG_FOUR);
        ModifiableOrderedLongCollection actual = ModifiableOrderedLongCollection.of(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Long[] {2L, LONG_THREE}, actual.toArray());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableOrderedLongCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableOrderedLongCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(LONGS123, ModifiableOrderedLongCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(LONGS123,
                ModifiableOrderedLongCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new Long[] {0L, 1L, 2L, 1L, 2L, LONG_THREE},
                ModifiableOrderedLongCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new Long[] {0L, 1L, 2L, LONG_THREE},
                ModifiableOrderedLongCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }
}
