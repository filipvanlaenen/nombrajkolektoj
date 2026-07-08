package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerCollection} class.
 */
public final class IntegerCollectionTest extends IntegerCollectionTestBase<IntegerCollection> {
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;
    /**
     * Collection with the integers 0, 1 and 2.
     */
    private final NumericCollection<Integer> collection012 = IntegerCollection.of(0, 1, 2);
    /**
     * Collection with the integers 1, 2 and 3.
     */
    private final NumericCollection<Integer> collection123 = IntegerCollection.of(1, 2, 3);

    /**
     * Verifies that the constructor of the ArrayCollection class creates a int collection.
     */
    @Test
    public void constructorOfArrayCollectionShouldCreateAIntegerCollection() {
        assertTrue(new IntegerCollection.ArrayCollection(1, 2, INTEGER_THREE).containsAll(collection123));
    }

    /**
     * Verifies that the constructor of the HashCollection class creates a int collection.
     */
    @Test
    public void constructorOfHashCollectionShouldCreateAIntegerCollection() {
        assertTrue(new IntegerCollection.HashCollection(1, 2, INTEGER_THREE).containsAll(collection123));
    }

    @Override
    protected IntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return IntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected IntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final NumericCollection<Integer> source) {
        return IntegerCollection.of(elementCardinality, source);
    }

    @Override
    protected IntegerCollection createIntegerCollection(final NumericCollection<Integer> source) {
        return IntegerCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(IntegerCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(IntegerCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(IntegerCollection.of(1, 2)
                .containsSame(IntegerCollection.intersectionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(IntegerCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(IntegerCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(IntegerCollection.unionOf(collection123)));
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertTrue(collection123.containsSame(IntegerCollection.unionOf(DISTINCT_ELEMENTS, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertTrue(IntegerCollection.of(0, 1, 2, 1, 2, INTEGER_THREE)
                .containsSame(IntegerCollection.unionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertTrue(IntegerCollection.of(0, 1, 2, INTEGER_THREE)
                .containsSame(IntegerCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123)));
    }
}
