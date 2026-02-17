package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.OrderedBigIntegerCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class OrderedBigIntegerCollectionTestBase<T extends OrderedNumericCollection<BigInteger>>
        extends BigIntegerCollectionTestBase<T> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);
    /**
     * The BigInteger four.
     */
    private static final BigInteger BIG_INTEGER_FOUR = BigInteger.valueOf(4L);

    /**
     * Creates an ordered BigIntegers collection containing the provided BigIntegers.
     *
     * @param numbers The BigIntegers to be included in the ordered BigIntegers collection.
     * @return An ordered BigIntegers collection containing the provided BigIntegers.
     */
    protected abstract T createOrderedBigIntegerCollection(BigInteger... numbers);

    /**
     * Creates an ordered BigIntegers collection containing the provided BigIntegers.
     *
     * @param source The BigIntegers to be included in the ordered BigIntegers collection.
     * @return An ordered BigIntegers collection containing the provided BigIntegers.
     */
    protected abstract T createOrderedBigIntegerCollection(OrderedNumericCollection<BigInteger> source);

    /**
     * Creates an ordered BigIntegers collection containing the provided range of BigIntegers.
     *
     * @param source    The BigIntegers to be included in the ordered BigIntegers collection.
     * @param fromIndex The index of the first element to be included in the new ordered BigIntegers collection.
     * @param toIndex   The index of the first element not to be included in the new ordered BigIntegers collection.
     * @return An ordered BigIntegers collection containing the provided range of BigIntegers.
     */
    protected abstract T createOrderedBigIntegerCollection(OrderedNumericCollection<BigInteger> source, final int fromIndex,
            final int toIndex);

    /**
     * Creates an ordered BigIntegers collection containing the provided BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigIntegers to be included in the ordered BigIntegers collection.
     * @return An ordered BigIntegers collection containing the provided BigIntegers.
     */
    protected abstract T createOrderedBigIntegerCollection(ElementCardinality elementCardinality, BigInteger... numbers);

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedBigIntegerCollection(DUPLICATE_ELEMENTS, BigInteger.ONE, BigInteger.TWO, BigInteger.TWO, BIG_INTEGER_THREE).firstIndexOf(BigInteger.TWO));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigInteger.TWO, createOrderedBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createOrderedBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).indexOf(BigInteger.TWO));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createOrderedBigIntegerCollection(DUPLICATE_ELEMENTS, BigInteger.ONE, BigInteger.TWO, BigInteger.TWO, BIG_INTEGER_THREE).lastIndexOf(BigInteger.TWO));
    }

    /**
     * Verifies that an ordered BigIntegers collection created from another ordered collection has the same element
     * cardinality and BigIntegers in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnABigIntegerCollectionWithTheSameElementCardinalityAndBigIntegers() {
        T source = createOrderedBigIntegerCollection(DISTINCT_ELEMENTS, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE);
        T actual = createOrderedBigIntegerCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new BigInteger[] {BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE}, actual.toArray());
    }

    /**
     * Verifies that an ordered BigIntegers collection created as a slice from another ordered collection has the same
     * element cardinality and the correct BigIntegers in the same order.
     */
    @Test
    public void ofWithCollectionShouldReturnTheCorrectSlice() {
        T source = createOrderedBigIntegerCollection(DISTINCT_ELEMENTS, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE, BIG_INTEGER_FOUR);
        T actual = createOrderedBigIntegerCollection(source, 1, 3);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertArrayEquals(new BigInteger[] {BigInteger.TWO, BIG_INTEGER_THREE}, actual.toArray());
    }
}
