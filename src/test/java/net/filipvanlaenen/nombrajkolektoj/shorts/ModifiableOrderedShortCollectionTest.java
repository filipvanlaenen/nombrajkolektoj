package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableOrderedShortCollection} class.
 */
public final class ModifiableOrderedShortCollectionTest
        extends ModifiableShortCollectionTestBase<ModifiableOrderedShortCollection> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;
    /**
     * The short four.
     */
    private static final Short SHORT_FOUR = (short) 4;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Array with the shorts one, two and three.
     */
    private static final Short[] SHORTS123 = new Short[] {(short) 1, (short) 2, (short) 3};
    /**
     * Collection with the shorts 0, 1 and 2.
     */
    private final ModifiableOrderedShortCollection collection012 = ModifiableOrderedShortCollection.of((short) 0, (short) 1, (short) 2);
    /**
     * Collection with the shorts 1, 2 and 3.
     */
    private final ModifiableOrderedShortCollection collection123 = ModifiableOrderedShortCollection.of((short) 1, (short) 2, (short) 3);

    /**
     * Verifies that the constructor of the ArrayCollection class creates a short collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateAShortCollection() {
        assertTrue(
                new ModifiableOrderedShortCollection.ArrayCollection((short) 1, (short) 2, SHORT_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the LinkedListCollection class creates a short collection.
     */
    @Test
    public void constructorOfLinkedListCollectionShouldCreateAShortCollection() {
        assertTrue(new ModifiableOrderedShortCollection.LinkedListCollection((short) 1, (short) 2, SHORT_THREE)
                .containsAll(collection123));
    }

    @Override
    protected ModifiableOrderedShortCollection createShortCollection(final ModifiableOrderedShortCollection source) {
        return ModifiableOrderedShortCollection
                .of(OrderedShortCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS)));
    }

    @Override
    protected ModifiableOrderedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return ModifiableOrderedShortCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final ModifiableOrderedShortCollection source) {
        return ModifiableOrderedShortCollection.of(elementCardinality,
                OrderedShortCollection.of(source.toArray(EmptyArrays.SHORTS)));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(ModifiableOrderedShortCollection.empty().isEmpty());
    }

    /**
     * Verifies that an ordered shorts collection created as a slice from another ordered collection has the same
     * element cardinality and the correct shorts in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        ModifiableOrderedShortCollection source =
                ModifiableOrderedShortCollection.of(DISTINCT_ELEMENTS, (short) 1, (short) 2, SHORT_THREE, SHORT_FOUR);
        ModifiableOrderedShortCollection actual = ModifiableOrderedShortCollection.of(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Short[] {(short) 2, SHORT_THREE}, actual.toArray());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableOrderedShortCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableOrderedShortCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(SHORTS123, ModifiableOrderedShortCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(SHORTS123,
                ModifiableOrderedShortCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new Short[] {(short) 0, (short) 1, (short) 2, (short) 1, (short) 2, SHORT_THREE},
                ModifiableOrderedShortCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new Short[] {(short) 0, (short) 1, (short) 2, SHORT_THREE},
                ModifiableOrderedShortCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }
}
