package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableOrderedFloatCollection} class.
 */
public final class ModifiableOrderedFloatCollectionTest
        extends ModifiableFloatCollectionTestBase<ModifiableOrderedFloatCollection> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;
    /**
     * The float four.
     */
    private static final Float FLOAT_FOUR = 4F;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Array with the floats one, two and three.
     */
    private static final Float[] FLOATS123 = new Float[] {1F, 2F, 3F};
    /**
     * Collection with the floats 0, 1 and 2.
     */
    private final ModifiableOrderedFloatCollection collection012 = ModifiableOrderedFloatCollection.of(0F, 1F, 2F);
    /**
     * Collection with the floats 1, 2 and 3.
     */
    private final ModifiableOrderedFloatCollection collection123 = ModifiableOrderedFloatCollection.of(1F, 2F, 3F);

    /**
     * Verifies that the constructor of the ArrayCollection class creates a float collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateAFloatCollection() {
        assertTrue(
                new ModifiableOrderedFloatCollection.ArrayCollection(1F, 2F, FLOAT_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the LinkedListCollection class creates a float collection.
     */
    @Test
    public void constructorOfLinkedListCollectionShouldCreateAFloatCollection() {
        assertTrue(new ModifiableOrderedFloatCollection.LinkedListCollection(1F, 2F, FLOAT_THREE)
                .containsAll(collection123));
    }

    @Override
    protected ModifiableOrderedFloatCollection createFloatCollection(final ModifiableOrderedFloatCollection source) {
        return ModifiableOrderedFloatCollection
                .of(OrderedFloatCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS)));
    }

    @Override
    protected ModifiableOrderedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return ModifiableOrderedFloatCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final ModifiableOrderedFloatCollection source) {
        return ModifiableOrderedFloatCollection.of(elementCardinality,
                OrderedFloatCollection.of(source.toArray(EmptyArrays.FLOATS)));
    }

    /**
     * Verifies that empty produces an empty collection.
     */
    @Test
    public void emptyShouldProduceAnEmptyCollection() {
        assertTrue(ModifiableOrderedFloatCollection.empty().isEmpty());
    }

    /**
     * Verifies that an ordered floats collection created as a slice from another ordered collection has the same
     * element cardinality and the correct floats in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        ModifiableOrderedFloatCollection source =
                ModifiableOrderedFloatCollection.of(DISTINCT_ELEMENTS, 1F, 2F, FLOAT_THREE, FLOAT_FOUR);
        ModifiableOrderedFloatCollection actual = ModifiableOrderedFloatCollection.of(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Float[] {2F, FLOAT_THREE}, actual.toArray());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableOrderedFloatCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableOrderedFloatCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(FLOATS123, ModifiableOrderedFloatCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(FLOATS123,
                ModifiableOrderedFloatCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new Float[] {0F, 1F, 2F, 1F, 2F, FLOAT_THREE},
                ModifiableOrderedFloatCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new Float[] {0F, 1F, 2F, FLOAT_THREE},
                ModifiableOrderedFloatCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }
}
