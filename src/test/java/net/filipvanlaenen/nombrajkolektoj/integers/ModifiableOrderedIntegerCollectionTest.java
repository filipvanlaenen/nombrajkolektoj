package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableOrderedIntegerCollection} class.
 */
public final class ModifiableOrderedIntegerCollectionTest
        extends ModifiableIntegerCollectionTestBase<ModifiableOrderedIntegerCollection> {
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;
    /**
     * The int four.
     */
    private static final Integer INTEGER_FOUR = 4;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Array with the integers one, two and three.
     */
    private static final Integer[] INTEGERS123 = new Integer[] {1, 2, 3};
    /**
     * Collection with the integers 0, 1 and 2.
     */
    private final ModifiableOrderedIntegerCollection collection012 = ModifiableOrderedIntegerCollection.of(0, 1, 2);
    /**
     * Collection with the integers 1, 2 and 3.
     */
    private final ModifiableOrderedIntegerCollection collection123 = ModifiableOrderedIntegerCollection.of(1, 2, 3);

    /**
     * Verifies that the constructor of the ArrayCollection class creates a int collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateAIntegerCollection() {
        assertTrue(
                new ModifiableOrderedIntegerCollection.ArrayCollection(1, 2, INTEGER_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the LinkedListCollection class creates a int collection.
     */
    @Test
    public void constructorOfLinkedListCollectionShouldCreateAIntegerCollection() {
        assertTrue(new ModifiableOrderedIntegerCollection.LinkedListCollection(1, 2, INTEGER_THREE)
                .containsAll(collection123));
    }

    @Override
    protected ModifiableOrderedIntegerCollection createIntegerCollection(final ModifiableOrderedIntegerCollection source) {
        return ModifiableOrderedIntegerCollection
                .of(OrderedIntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS)));
    }

    @Override
    protected ModifiableOrderedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return ModifiableOrderedIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final ModifiableOrderedIntegerCollection source) {
        return ModifiableOrderedIntegerCollection.of(elementCardinality,
                OrderedIntegerCollection.of(source.toArray(EmptyArrays.INTEGERS)));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(ModifiableOrderedIntegerCollection.empty().isEmpty());
    }

    /**
     * Verifies that an ordered integers collection created as a slice from another ordered collection has the same
     * element cardinality and the correct integers in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        ModifiableOrderedIntegerCollection source =
                ModifiableOrderedIntegerCollection.of(DISTINCT_ELEMENTS, 1, 2, INTEGER_THREE, INTEGER_FOUR);
        ModifiableOrderedIntegerCollection actual = ModifiableOrderedIntegerCollection.of(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Integer[] {2, INTEGER_THREE}, actual.toArray());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableOrderedIntegerCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableOrderedIntegerCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(INTEGERS123, ModifiableOrderedIntegerCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(INTEGERS123,
                ModifiableOrderedIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new Integer[] {0, 1, 2, 1, 2, INTEGER_THREE},
                ModifiableOrderedIntegerCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new Integer[] {0, 1, 2, INTEGER_THREE},
                ModifiableOrderedIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }
}
