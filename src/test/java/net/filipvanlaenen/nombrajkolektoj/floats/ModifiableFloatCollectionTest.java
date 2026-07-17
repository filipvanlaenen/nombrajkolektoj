package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableFloatCollection} class.
 */
public final class ModifiableFloatCollectionTest
        extends ModifiableFloatCollectionTestBase<ModifiableFloatCollection> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;
    /**
     * Collection with the floats 0, 1 and 2.
     */
    private final FloatCollection collection012 = FloatCollection.of(0F, 1F, 2F);
    /**
     * Collection with the floats 1, 2 and 3.
     */
    private final FloatCollection collection123 = FloatCollection.of(1F, 2F, 3F);

    /**
     * Verifies that the constructor of the ArrayCollection class creates a float collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateAFloatCollection() {
        assertTrue(new ModifiableFloatCollection.ArrayCollection(1F, 2F, FLOAT_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the HashCollection class creates a float collection.
     */
    @Test
    public void constructorOfHashCollectionShouldCreateAFloatCollection() {
        assertTrue(new ModifiableFloatCollection.HashCollection(1F, 2F, FLOAT_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the LinkedListCollection class creates a float collection.
     */
    @Test
    public void constructorOfLinkedListCollectionShouldCreateAFloatCollection() {
        assertTrue(
                new ModifiableFloatCollection.LinkedListCollection(1F, 2F, FLOAT_THREE).containsAll(collection123));
    }

    @Override
    protected ModifiableFloatCollection createFloatCollection(final Float... numbers) {
        return ModifiableFloatCollection.of(numbers);
    }

    @Override
    protected ModifiableFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return ModifiableFloatCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final ModifiableFloatCollection source) {
        return ModifiableFloatCollection.of(elementCardinality, source);
    }

    @Override
    protected ModifiableFloatCollection createFloatCollection(final ModifiableFloatCollection source) {
        return ModifiableFloatCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableFloatCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableFloatCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(ModifiableFloatCollection.of(1F, 2F)
                .containsSame(ModifiableFloatCollection.intersectionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableFloatCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableFloatCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableFloatCollection.unionOf(collection123)));
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableFloatCollection.unionOf(DISTINCT_ELEMENTS, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertTrue(ModifiableFloatCollection.of(0F, 1F, 2F, 1F, 2F, FLOAT_THREE)
                .containsSame(ModifiableFloatCollection.unionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertTrue(ModifiableFloatCollection.of(0F, 1F, 2F, FLOAT_THREE)
                .containsSame(ModifiableFloatCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123)));
    }

}
