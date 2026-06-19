package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableLongCollection} class.
 */
public final class ModifiableLongCollectionTest
        extends ModifiableLongCollectionTestBase<ModifiableLongCollection> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;
    /**
     * Collection with the longs 0, 1 and 2.
     */
    private final NumericCollection<Long> collection012 = createLongCollection(0L, 1L, 2L);
    /**
     * Collection with the longs 1, 2 and 3.
     */
    private final NumericCollection<Long> collection123 = createLongCollection(1L, 2L, 3L);

    @Override
    protected ModifiableLongCollection createEmptyLongCollection() {
        return ModifiableLongCollection.empty();
    }

    @Override
    protected ModifiableLongCollection createLongCollection(final Long... numbers) {
        return ModifiableLongCollection.of(numbers);
    }

    @Override
    protected ModifiableLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return ModifiableLongCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final NumericCollection<Long> source) {
        return ModifiableLongCollection.of(elementCardinality, source);
    }

    @Override
    protected ModifiableLongCollection createLongCollection(final NumericCollection<Long> source) {
        return ModifiableLongCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableLongCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableLongCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(createLongCollection(1L, 2L)
                .containsSame(ModifiableLongCollection.intersectionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableLongCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableLongCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableLongCollection.unionOf(collection123)));
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableLongCollection.unionOf(DISTINCT_ELEMENTS, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertTrue(createLongCollection(0L, 1L, 2L, 1L, 2L, LONG_THREE)
                .containsSame(ModifiableLongCollection.unionOf(collection012, collection123)));
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertTrue(createLongCollection(0L, 1L, 2L, LONG_THREE)
                .containsSame(ModifiableLongCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123)));
    }

}
