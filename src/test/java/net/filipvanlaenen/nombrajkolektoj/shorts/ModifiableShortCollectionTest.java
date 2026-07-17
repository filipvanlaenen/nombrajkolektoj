package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableShortCollection} class.
 */
public final class ModifiableShortCollectionTest
        extends ModifiableShortCollectionTestBase<ModifiableShortCollection> {
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
        assertTrue(new ModifiableShortCollection.ArrayCollection((short) 1, (short) 2, SHORT_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the HashCollection class creates a short collection.
     */
    @Test
    public void constructorOfHashCollectionShouldCreateAShortCollection() {
        assertTrue(new ModifiableShortCollection.HashCollection((short) 1, (short) 2, SHORT_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the LinkedListCollection class creates a short collection.
     */
    @Test
    public void constructorOfLinkedListCollectionShouldCreateAShortCollection() {
        assertTrue(
                new ModifiableShortCollection.LinkedListCollection((short) 1, (short) 2, SHORT_THREE).containsAll(collection123));
    }

    @Override
    protected ModifiableShortCollection createShortCollection(final Short... numbers) {
        return ModifiableShortCollection.of(numbers);
    }

    @Override
    protected ModifiableShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return ModifiableShortCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final ModifiableShortCollection source) {
        return ModifiableShortCollection.of(elementCardinality, source);
    }

    @Override
    protected ModifiableShortCollection createShortCollection(final ModifiableShortCollection source) {
        return ModifiableShortCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableShortCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableShortCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(ModifiableShortCollection.of((short) 1, (short) 2)
                .containsSame(ModifiableShortCollection.intersectionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableShortCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableShortCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableShortCollection.unionOf(collection123)));
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableShortCollection.unionOf(DISTINCT_ELEMENTS, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertTrue(ModifiableShortCollection.of((short) 0, (short) 1, (short) 2, (short) 1, (short) 2, SHORT_THREE)
                .containsSame(ModifiableShortCollection.unionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertTrue(ModifiableShortCollection.of((short) 0, (short) 1, (short) 2, SHORT_THREE)
                .containsSame(ModifiableShortCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123)));
    }

}
