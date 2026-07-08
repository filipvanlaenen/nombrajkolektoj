package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

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
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableOrderedBigDecimalCollection} class.
 */
public final class ModifiableOrderedBigDecimalCollectionTest
        extends ModifiableBigDecimalCollectionTestBase<ModifiableOrderedBigDecimalCollection> {
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);
    /**
     * The BigDecimal four.
     */
    private static final BigDecimal BIG_DECIMAL_FOUR = BigDecimal.valueOf(4L);
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Array with the BigDecimals one, two and three.
     */
    private static final BigDecimal[] BIG_DECIMALS123 = new BigDecimal[] {BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(3L)};
    /**
     * Collection with the BigDecimals 0, 1 and 2.
     */
    private final ModifiableOrderedBigDecimalCollection collection012 = createBigDecimalCollection(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L));
    /**
     * Collection with the BigDecimals 1, 2 and 3.
     */
    private final ModifiableOrderedBigDecimalCollection collection123 = createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(3L));

    @Override
    protected ModifiableOrderedBigDecimalCollection createBigDecimalCollection(final ModifiableOrderedBigDecimalCollection source) {
        return ModifiableOrderedBigDecimalCollection
                .of(OrderedBigDecimalCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS)));
    }

    protected ModifiableOrderedBigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return ModifiableOrderedBigDecimalCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return ModifiableOrderedBigDecimalCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final ModifiableOrderedBigDecimalCollection source) {
        return ModifiableOrderedBigDecimalCollection.of(elementCardinality,
                OrderedBigDecimalCollection.of(source.toArray(EmptyArrays.BIG_DECIMALS)));
    }

    /**
     * Verifies that the <code>addAllAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedBigDecimalCollection collection = createBigDecimalCollection(DISTINCT_ELEMENTS, BigDecimal.ONE, BIG_DECIMAL_THREE);
        assertTrue(collection.addAllAt(1, createBigDecimalCollection(BigDecimal.valueOf(2L))));
        assertFalse(collection.addAllAt(1, createBigDecimalCollection(BigDecimal.valueOf(2L))));
        assertEquals(BigDecimal.valueOf(2L), collection.getAt(1));
    }

    /**
     * Verifies that the <code>addAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedBigDecimalCollection collection = createBigDecimalCollection(DISTINCT_ELEMENTS, BigDecimal.ONE, BIG_DECIMAL_THREE);
        assertTrue(collection.addAt(1, BigDecimal.valueOf(2L)));
        assertFalse(collection.addAt(1, BigDecimal.valueOf(2L)));
        assertEquals(BigDecimal.valueOf(2L), collection.getAt(1));
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createBigDecimalCollection(DUPLICATE_ELEMENTS, BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).firstIndexOf(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigDecimal.valueOf(2L), createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).indexOf(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createBigDecimalCollection(DUPLICATE_ELEMENTS, BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).lastIndexOf(BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that an ordered BigDecimals collection created as a slice from another ordered collection has the same
     * element cardinality and the correct BigDecimals in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        ModifiableOrderedBigDecimalCollection source =
                ModifiableOrderedBigDecimalCollection.of(DISTINCT_ELEMENTS, BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE, BIG_DECIMAL_FOUR);
        ModifiableOrderedBigDecimalCollection actual = ModifiableOrderedBigDecimalCollection.of(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new BigDecimal[] {BigDecimal.valueOf(2L), BIG_DECIMAL_THREE}, actual.toArray());
    }

    /**
     * Verifies that the <code>putAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void putAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedBigDecimalCollection collection = createBigDecimalCollection(DISTINCT_ELEMENTS, BigDecimal.ONE, BIG_DECIMAL_THREE);
        assertEquals(BIG_DECIMAL_THREE, collection.putAt(1, BigDecimal.valueOf(2L)));
        assertEquals(BigDecimal.valueOf(2L), collection.getAt(1));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigDecimal.valueOf(2L), createBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE).removeAt(1));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableOrderedBigDecimalCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableOrderedBigDecimalCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(BIG_DECIMALS123, ModifiableOrderedBigDecimalCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(BIG_DECIMALS123,
                ModifiableOrderedBigDecimalCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L), BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE},
                ModifiableOrderedBigDecimalCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE},
                ModifiableOrderedBigDecimalCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }

}
