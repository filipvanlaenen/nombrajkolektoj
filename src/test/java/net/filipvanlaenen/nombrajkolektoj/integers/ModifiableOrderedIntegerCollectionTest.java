package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

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
    private final OrderedNumericCollection<Integer> collection012 = createIntegerCollection(0, 1, 2);
    /**
     * Collection with the integers 1, 2 and 3.
     */
    private final OrderedNumericCollection<Integer> collection123 = createIntegerCollection(1, 2, 3);

    @Override
    protected ModifiableOrderedIntegerCollection createIntegerCollection(final NumericCollection<Integer> source) {
        return ModifiableOrderedIntegerCollection
                .of(OrderedIntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS)));
    }

    @Override
    protected ModifiableOrderedIntegerCollection createIntegerCollection(final Integer... numbers) {
        return ModifiableOrderedIntegerCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return ModifiableOrderedIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedIntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final NumericCollection<Integer> source) {
        return ModifiableOrderedIntegerCollection.of(elementCardinality,
                OrderedIntegerCollection.of(source.toArray(EmptyArrays.INTEGERS)));
    }

    @Override
    protected ModifiableOrderedIntegerCollection createEmptyIntegerCollection() {
        return ModifiableOrderedIntegerCollection.empty();
    }

    /**
     * Verifies that the <code>addAllAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedIntegerCollection collection = createIntegerCollection(DISTINCT_ELEMENTS, 1, INTEGER_THREE);
        assertTrue(collection.addAllAt(1, createIntegerCollection(2)));
        assertFalse(collection.addAllAt(1, createIntegerCollection(2)));
        assertEquals(2, collection.getAt(1));
    }

    /**
     * Verifies that the <code>addAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedIntegerCollection collection = createIntegerCollection(DISTINCT_ELEMENTS, 1, INTEGER_THREE);
        assertTrue(collection.addAt(1, 2));
        assertFalse(collection.addAt(1, 2));
        assertEquals(2, collection.getAt(1));
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createIntegerCollection(DUPLICATE_ELEMENTS, 1, 2, 2, INTEGER_THREE).firstIndexOf(2));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createIntegerCollection(1, 2, INTEGER_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createIntegerCollection(1, 2, INTEGER_THREE).indexOf(2));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createIntegerCollection(DUPLICATE_ELEMENTS, 1, 2, 2, INTEGER_THREE).lastIndexOf(2));
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
     * Verifies that the <code>putAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void putAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedIntegerCollection collection = createIntegerCollection(DISTINCT_ELEMENTS, 1, INTEGER_THREE);
        assertEquals(INTEGER_THREE, collection.putAt(1, 2));
        assertEquals(2, collection.getAt(1));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createIntegerCollection(1, 2, INTEGER_THREE).removeAt(1));
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
