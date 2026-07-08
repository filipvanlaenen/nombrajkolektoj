package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableIntegerCollection} class.
 */
public final class ModifiableIntegerCollectionTest
        extends ModifiableIntegerCollectionTestBase<ModifiableIntegerCollection> {
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;
    /**
     * Collection with the integers 0, 1 and 2.
     */
    private final ModifiableIntegerCollection collection012 = ModifiableIntegerCollection.of(0, 1, 2);
    /**
     * Collection with the integers 1, 2 and 3.
     */
    private final ModifiableIntegerCollection collection123 = ModifiableIntegerCollection.of(1, 2, 3);

    /**
     * Verifies that the constructor of the ArrayCollection class creates a int collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateAIntegerCollection() {
        assertTrue(new ModifiableIntegerCollection.ArrayCollection(1, 2, INTEGER_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the HashCollection class creates a int collection.
     */
    @Test
    public void constructorOfHashCollectionShouldCreateAIntegerCollection() {
        assertTrue(new ModifiableIntegerCollection.HashCollection(1, 2, INTEGER_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the LinkedListCollection class creates a int collection.
     */
    @Test
    public void constructorOfLinkedListCollectionShouldCreateAIntegerCollection() {
        assertTrue(
                new ModifiableIntegerCollection.LinkedListCollection(1, 2, INTEGER_THREE).containsAll(collection123));
    }

    @Override
    protected ModifiableIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return ModifiableIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final ModifiableIntegerCollection source) {
        return ModifiableIntegerCollection.of(elementCardinality, source);
    }

    @Override
    protected ModifiableIntegerCollection createIntegerCollection(final ModifiableIntegerCollection source) {
        return ModifiableIntegerCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableIntegerCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableIntegerCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(ModifiableIntegerCollection.of(1, 2)
                .containsSame(ModifiableIntegerCollection.intersectionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableIntegerCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableIntegerCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableIntegerCollection.unionOf(collection123)));
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertTrue(ModifiableIntegerCollection.of(0, 1, 2, 1, 2, INTEGER_THREE)
                .containsSame(ModifiableIntegerCollection.unionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertTrue(ModifiableIntegerCollection.of(0, 1, 2, INTEGER_THREE)
                .containsSame(ModifiableIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123)));
    }

}
