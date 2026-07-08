package net.filipvanlaenen.nombrajkolektoj.doubles;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableDoubleCollection} class.
 */
public final class ModifiableDoubleCollectionTest
        extends ModifiableDoubleCollectionTestBase<ModifiableDoubleCollection> {
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;
    /**
     * Collection with the doubles 0, 1 and 2.
     */
    private final ModifiableDoubleCollection collection012 = createDoubleCollection(0D, 1D, 2D);
    /**
     * Collection with the doubles 1, 2 and 3.
     */
    private final ModifiableDoubleCollection collection123 = createDoubleCollection(1D, 2D, 3D);

    protected ModifiableDoubleCollection createDoubleCollection(final Double... numbers) {
        return ModifiableDoubleCollection.of(numbers);
    }

    @Override
    protected ModifiableDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return ModifiableDoubleCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final ModifiableDoubleCollection source) {
        return ModifiableDoubleCollection.of(elementCardinality, source);
    }

    @Override
    protected ModifiableDoubleCollection createDoubleCollection(final ModifiableDoubleCollection source) {
        return ModifiableDoubleCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableDoubleCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableDoubleCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(createDoubleCollection(1D, 2D)
                .containsSame(ModifiableDoubleCollection.intersectionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableDoubleCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableDoubleCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableDoubleCollection.unionOf(collection123)));
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableDoubleCollection.unionOf(DISTINCT_ELEMENTS, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertTrue(createDoubleCollection(0D, 1D, 2D, 1D, 2D, DOUBLE_THREE)
                .containsSame(ModifiableDoubleCollection.unionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertTrue(createDoubleCollection(0D, 1D, 2D, DOUBLE_THREE)
                .containsSame(ModifiableDoubleCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123)));
    }

}
