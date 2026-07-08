package net.filipvanlaenen.nombrajkolektoj.floats;

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
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableOrderedFloatCollection} class.
 */
public final class ModifiableOrderedFloatCollectionTest
        extends ModifiableFloatCollectionTestBase<ModifiableOrderedFloatCollection> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;
    /**
     * The float four.
     */
    private static final Float FLOAT_FOUR = 4F;
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Array with the floats one, two and three.
     */
    private static final Float[] FLOATS123 = new Float[] {1F, 2F, 3F};
    /**
     * Collection with the floats 0, 1 and 2.
     */
    private final OrderedNumericCollection<Float> collection012 = createFloatCollection(0F, 1F, 2F);
    /**
     * Collection with the floats 1, 2 and 3.
     */
    private final OrderedNumericCollection<Float> collection123 = createFloatCollection(1F, 2F, 3F);

    @Override
    protected ModifiableOrderedFloatCollection createFloatCollection(final NumericCollection<Float> source) {
        return ModifiableOrderedFloatCollection
                .of(OrderedFloatCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS)));
    }

    @Override
    protected ModifiableOrderedFloatCollection createFloatCollection(final Float... numbers) {
        return ModifiableOrderedFloatCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return ModifiableOrderedFloatCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final NumericCollection<Float> source) {
        return ModifiableOrderedFloatCollection.of(elementCardinality,
                OrderedFloatCollection.of(source.toArray(EmptyArrays.FLOATS)));
    }

    /**
     * Verifies that the <code>addAllAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedFloatCollection collection = createFloatCollection(DISTINCT_ELEMENTS, 1F, FLOAT_THREE);
        assertTrue(collection.addAllAt(1, createFloatCollection(2F)));
        assertFalse(collection.addAllAt(1, createFloatCollection(2F)));
        assertEquals(2F, collection.getAt(1));
    }

    /**
     * Verifies that the <code>addAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedFloatCollection collection = createFloatCollection(DISTINCT_ELEMENTS, 1F, FLOAT_THREE);
        assertTrue(collection.addAt(1, 2F));
        assertFalse(collection.addAt(1, 2F));
        assertEquals(2F, collection.getAt(1));
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createFloatCollection(DUPLICATE_ELEMENTS, 1F, 2F, 2F, FLOAT_THREE).firstIndexOf(2F));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2F, createFloatCollection(1F, 2F, FLOAT_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createFloatCollection(1F, 2F, FLOAT_THREE).indexOf(2F));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createFloatCollection(DUPLICATE_ELEMENTS, 1F, 2F, 2F, FLOAT_THREE).lastIndexOf(2F));
    }

    /**
     * Verifies that an ordered floats collection created as a slice from another ordered collection has the same
     * element cardinality and the correct floats in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        ModifiableOrderedFloatCollection source =
                ModifiableOrderedFloatCollection.of(DISTINCT_ELEMENTS, 1F, 2F, FLOAT_THREE, FLOAT_FOUR);
        ModifiableOrderedFloatCollection actual = ModifiableOrderedFloatCollection.of(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new Float[] {2F, FLOAT_THREE}, actual.toArray());
    }

    /**
     * Verifies that the <code>putAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void putAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedFloatCollection collection = createFloatCollection(DISTINCT_ELEMENTS, 1F, FLOAT_THREE);
        assertEquals(FLOAT_THREE, collection.putAt(1, 2F));
        assertEquals(2F, collection.getAt(1));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2F, createFloatCollection(1F, 2F, FLOAT_THREE).removeAt(1));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableOrderedFloatCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableOrderedFloatCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(FLOATS123, ModifiableOrderedFloatCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(FLOATS123,
                ModifiableOrderedFloatCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new Float[] {0F, 1F, 2F, 1F, 2F, FLOAT_THREE},
                ModifiableOrderedFloatCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new Float[] {0F, 1F, 2F, FLOAT_THREE},
                ModifiableOrderedFloatCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }

}
