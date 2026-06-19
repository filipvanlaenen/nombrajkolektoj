package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

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
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableOrderedBigIntegerCollection} class.
 */
public final class ModifiableOrderedBigIntegerCollectionTest
        extends ModifiableBigIntegerCollectionTestBase<ModifiableOrderedBigIntegerCollection> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);
    /**
     * The BigInteger four.
     */
    private static final BigInteger BIG_INTEGER_FOUR = BigInteger.valueOf(4L);
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Array with the BigIntegers one, two and three.
     */
    private static final BigInteger[] BIG_INTEGERS123 = new BigInteger[] {BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3L)};
    /**
     * Collection with the BigIntegers 0, 1 and 2.
     */
    private final OrderedNumericCollection<BigInteger> collection012 = createBigIntegerCollection(BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO);
    /**
     * Collection with the BigIntegers 1, 2 and 3.
     */
    private final OrderedNumericCollection<BigInteger> collection123 = createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3L));

    @Override
    protected ModifiableOrderedBigIntegerCollection createBigIntegerCollection(final NumericCollection<BigInteger> source) {
        return ModifiableOrderedBigIntegerCollection
                .of(OrderedBigIntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS)));
    }

    @Override
    protected ModifiableOrderedBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return ModifiableOrderedBigIntegerCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return ModifiableOrderedBigIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final NumericCollection<BigInteger> source) {
        return ModifiableOrderedBigIntegerCollection.of(elementCardinality,
                OrderedBigIntegerCollection.of(source.toArray(EmptyArrays.BIG_INTEGERS)));
    }

    @Override
    protected ModifiableOrderedBigIntegerCollection createEmptyBigIntegerCollection() {
        return ModifiableOrderedBigIntegerCollection.empty();
    }

    /**
     * Verifies that the <code>addAllAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedBigIntegerCollection collection = createBigIntegerCollection(DISTINCT_ELEMENTS, BigInteger.ONE, BIG_INTEGER_THREE);
        assertTrue(collection.addAllAt(1, createBigIntegerCollection(BigInteger.TWO)));
        assertFalse(collection.addAllAt(1, createBigIntegerCollection(BigInteger.TWO)));
        assertEquals(BigInteger.TWO, collection.getAt(1));
    }

    /**
     * Verifies that the <code>addAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedBigIntegerCollection collection = createBigIntegerCollection(DISTINCT_ELEMENTS, BigInteger.ONE, BIG_INTEGER_THREE);
        assertTrue(collection.addAt(1, BigInteger.TWO));
        assertFalse(collection.addAt(1, BigInteger.TWO));
        assertEquals(BigInteger.TWO, collection.getAt(1));
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createBigIntegerCollection(DUPLICATE_ELEMENTS, BigInteger.ONE, BigInteger.TWO, BigInteger.TWO, BIG_INTEGER_THREE).firstIndexOf(BigInteger.TWO));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigInteger.TWO, createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).indexOf(BigInteger.TWO));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createBigIntegerCollection(DUPLICATE_ELEMENTS, BigInteger.ONE, BigInteger.TWO, BigInteger.TWO, BIG_INTEGER_THREE).lastIndexOf(BigInteger.TWO));
    }

    /**
     * Verifies that an ordered BigIntegers collection created as a slice from another ordered collection has the same
     * element cardinality and the correct BigIntegers in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        ModifiableOrderedBigIntegerCollection source =
                ModifiableOrderedBigIntegerCollection.of(DISTINCT_ELEMENTS, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE, BIG_INTEGER_FOUR);
        ModifiableOrderedBigIntegerCollection actual = ModifiableOrderedBigIntegerCollection.of(source, 1, THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new BigInteger[] {BigInteger.TWO, BIG_INTEGER_THREE}, actual.toArray());
    }

    /**
     * Verifies that the <code>putAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void putAtShouldBeWiredCorrectlyToTheInternalCollection() {
        ModifiableOrderedBigIntegerCollection collection = createBigIntegerCollection(DISTINCT_ELEMENTS, BigInteger.ONE, BIG_INTEGER_THREE);
        assertEquals(BIG_INTEGER_THREE, collection.putAt(1, BigInteger.TWO));
        assertEquals(BigInteger.TWO, collection.getAt(1));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigInteger.TWO, createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).removeAt(1));
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableOrderedBigIntegerCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(ModifiableOrderedBigIntegerCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(BIG_INTEGERS123, ModifiableOrderedBigIntegerCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(BIG_INTEGERS123,
                ModifiableOrderedBigIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE},
                ModifiableOrderedBigIntegerCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE},
                ModifiableOrderedBigIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }

}
