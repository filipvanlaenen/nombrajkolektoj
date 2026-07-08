package net.filipvanlaenen.nombrajkolektoj.doubles;

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
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableOrderedDoubleCollection} class.
 */
public final class ModifiableOrderedDoubleCollectionTest
        extends ModifiableDoubleCollectionTestBase<ModifiableOrderedDoubleCollection> {
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;
    /**
     * The double four.
     */
    private static final Double DOUBLE_FOUR = 4D;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Array with the doubles one, two and three.
     */
    private static final Double[] DOUBLES123 = new Double[] {1D, 2D, 3D};
    /**
     * Collection with the doubles 0, 1 and 2.
     */
    private final ModifiableOrderedDoubleCollection collection012 = createDoubleCollection(0D, 1D, 2D);
    /**
     * Collection with the doubles 1, 2 and 3.
     */
    private final ModifiableOrderedDoubleCollection collection123 = createDoubleCollection(1D, 2D, 3D);

    @Override
    protected ModifiableOrderedDoubleCollection createDoubleCollection(final ModifiableOrderedDoubleCollection source) {
        return ModifiableOrderedDoubleCollection
                .of(OrderedDoubleCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES)));
    }

    @Override
    protected ModifiableOrderedDoubleCollection createDoubleCollection(final Double... numbers) {
        return ModifiableOrderedDoubleCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return ModifiableOrderedDoubleCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final ModifiableOrderedDoubleCollection source) {
        return ModifiableOrderedDoubleCollection.of(elementCardinality,
                OrderedDoubleCollection.of(source.toArray(EmptyArrays.DOUBLES)));
    }

    /**
     * Verifies that the <code>addAllAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedDoubleCollection collection = createDoubleCollection(DISTINCT_ELEMENTS, 1D, DOUBLE_THREE);
        assertTrue(collection.addAllAt(1, createDoubleCollection(2D)));
        assertFalse(collection.addAllAt(1, createDoubleCollection(2D)));
        assertEquals(2D, collection.getAt(1));
    }

    /**
     * Verifies that the <code>addAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedDoubleCollection collection = createDoubleCollection(DISTINCT_ELEMENTS, 1D, DOUBLE_THREE);
        assertTrue(collection.addAt(1, 2D));
        assertFalse(collection.addAt(1, 2D));
        assertEquals(2D, collection.getAt(1));
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createDoubleCollection(DUPLICATE_ELEMENTS, 1D, 2D, 2D, DOUBLE_THREE).firstIndexOf(2D));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2D, createDoubleCollection(1D, 2D, DOUBLE_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createDoubleCollection(1D, 2D, DOUBLE_THREE).indexOf(2D));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createDoubleCollection(DUPLICATE_ELEMENTS, 1D, 2D, 2D, DOUBLE_THREE).lastIndexOf(2D));
    }

    /**
     * Verifies that an ordered doubles collection created as a slice from another ordered collection has the same
     * element cardinality and the correct doubles in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        ModifiableOrderedDoubleCollection source =
                ModifiableOrderedDoubleCollection.of(DISTINCT_ELEMENTS, 1D, 2D, DOUBLE_THREE, DOUBLE_FOUR);
        ModifiableOrderedDoubleCollection actual = ModifiableOrderedDoubleCollection.of(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Double[] {2D, DOUBLE_THREE}, actual.toArray());
    }

    /**
     * Verifies that the <code>putAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void putAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedDoubleCollection collection = createDoubleCollection(DISTINCT_ELEMENTS, 1D, DOUBLE_THREE);
        assertEquals(DOUBLE_THREE, collection.putAt(1, 2D));
        assertEquals(2D, collection.getAt(1));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2D, createDoubleCollection(1D, 2D, DOUBLE_THREE).removeAt(1));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableOrderedDoubleCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableOrderedDoubleCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(DOUBLES123, ModifiableOrderedDoubleCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(DOUBLES123,
                ModifiableOrderedDoubleCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new Double[] {0D, 1D, 2D, 1D, 2D, DOUBLE_THREE},
                ModifiableOrderedDoubleCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new Double[] {0D, 1D, 2D, DOUBLE_THREE},
                ModifiableOrderedDoubleCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }

}
