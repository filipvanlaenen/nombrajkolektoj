package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
    private final ModifiableOrderedLongCollection collection012 = createLongCollection(0L, 1L, 2L);
    /**
     * Collection with the longs 1, 2 and 3.
     */
    private final ModifiableOrderedLongCollection collection123 = createLongCollection(1L, 2L, 3L);

    @Override
    protected ModifiableOrderedLongCollection createLongCollection(final ModifiableOrderedLongCollection source) {
        return ModifiableOrderedLongCollection
                .of(OrderedLongCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS)));
    }

    protected ModifiableOrderedLongCollection createLongCollection(final Long... numbers) {
        return ModifiableOrderedLongCollection.of(numbers);
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
     * Verifies that the <code>addAllAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedLongCollection collection = createLongCollection(DISTINCT_ELEMENTS, 1L, LONG_THREE);
        assertTrue(collection.addAllAt(1, createLongCollection(2L)));
        assertFalse(collection.addAllAt(1, createLongCollection(2L)));
        assertEquals(2L, collection.getAt(1));
    }

    /**
     * Verifies that the <code>addAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedLongCollection collection = createLongCollection(DISTINCT_ELEMENTS, 1L, LONG_THREE);
        assertTrue(collection.addAt(1, 2L));
        assertFalse(collection.addAt(1, 2L));
        assertEquals(2L, collection.getAt(1));
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createLongCollection(DUPLICATE_ELEMENTS, 1L, 2L, 2L, LONG_THREE).firstIndexOf(2L));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2L, createLongCollection(1L, 2L, LONG_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createLongCollection(1L, 2L, LONG_THREE).indexOf(2L));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createLongCollection(DUPLICATE_ELEMENTS, 1L, 2L, 2L, LONG_THREE).lastIndexOf(2L));
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
     * Verifies that the <code>putAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void putAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedLongCollection collection = createLongCollection(DISTINCT_ELEMENTS, 1L, LONG_THREE);
        assertEquals(LONG_THREE, collection.putAt(1, 2L));
        assertEquals(2L, collection.getAt(1));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2L, createLongCollection(1L, 2L, LONG_THREE).removeAt(1));
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
