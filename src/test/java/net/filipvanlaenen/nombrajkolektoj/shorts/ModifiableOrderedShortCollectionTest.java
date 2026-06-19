package net.filipvanlaenen.nombrajkolektoj.shorts;

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
    private final OrderedNumericCollection<Short> collection012 = createShortCollection((short) 0, (short) 1, (short) 2);
    /**
     * Collection with the shorts 1, 2 and 3.
     */
    private final OrderedNumericCollection<Short> collection123 = createShortCollection((short) 1, (short) 2, (short) 3);

    @Override
    protected ModifiableOrderedShortCollection createShortCollection(final NumericCollection<Short> source) {
        return ModifiableOrderedShortCollection
                .of(OrderedShortCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS)));
    }

    @Override
    protected ModifiableOrderedShortCollection createShortCollection(final Short... numbers) {
        return ModifiableOrderedShortCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return ModifiableOrderedShortCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final NumericCollection<Short> source) {
        return ModifiableOrderedShortCollection.of(elementCardinality,
                OrderedShortCollection.of(source.toArray(EmptyArrays.SHORTS)));
    }

    @Override
    protected ModifiableOrderedShortCollection createEmptyShortCollection() {
        return ModifiableOrderedShortCollection.empty();
    }

    /**
     * Verifies that the <code>addAllAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedShortCollection collection = createShortCollection(DISTINCT_ELEMENTS, (short) 1, SHORT_THREE);
        assertTrue(collection.addAllAt(1, createShortCollection((short) 2)));
        assertFalse(collection.addAllAt(1, createShortCollection((short) 2)));
        assertEquals((short) 2, collection.getAt(1));
    }

    /**
     * Verifies that the <code>addAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedShortCollection collection = createShortCollection(DISTINCT_ELEMENTS, (short) 1, SHORT_THREE);
        assertTrue(collection.addAt(1, (short) 2));
        assertFalse(collection.addAt(1, (short) 2));
        assertEquals((short) 2, collection.getAt(1));
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createShortCollection(DUPLICATE_ELEMENTS, (short) 1, (short) 2, (short) 2, SHORT_THREE).firstIndexOf((short) 2));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 2, createShortCollection((short) 1, (short) 2, SHORT_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createShortCollection((short) 1, (short) 2, SHORT_THREE).indexOf((short) 2));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createShortCollection(DUPLICATE_ELEMENTS, (short) 1, (short) 2, (short) 2, SHORT_THREE).lastIndexOf((short) 2));
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
     * Verifies that the <code>putAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void putAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedShortCollection collection = createShortCollection(DISTINCT_ELEMENTS, (short) 1, SHORT_THREE);
        assertEquals(SHORT_THREE, collection.putAt(1, (short) 2));
        assertEquals((short) 2, collection.getAt(1));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 2, createShortCollection((short) 1, (short) 2, SHORT_THREE).removeAt(1));
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
