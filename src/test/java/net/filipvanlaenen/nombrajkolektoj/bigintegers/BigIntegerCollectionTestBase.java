package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.BigIntegerCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class BigIntegerCollectionTestBase<T extends NumericCollection<BigInteger>> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);

    /**
     * Creates a BigIntegers collection with the provided element cardinality containing the provided BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigIntegers to be included in the BigIntegers collection.
     * @return A BigIntegers collection with the provided element cardinality containing the provided BigIntegers.
     */
    protected abstract T createBigIntegerCollection(ElementCardinality elementCardinality, BigInteger... numbers);

    /**
     * Creates a BigIntegers collection from a collection of BigIntegers with the provided element cardinality.
     *
     * @param elementCardinality The element cardinality.
     * @param source             The collection of BigIntegers.
     * @return A BigIntegers collection containing the provided BigIntegers with the provided element cardinality.
     */
    protected abstract T createBigIntegerCollection(ElementCardinality elementCardinality,
            NumericCollection<BigInteger> source);

    /**
     * Creates a BigIntegers collection from a collection of BigIntegers.
     *
     * @param source The collection of BigIntegers.
     * @return A BigIntegers collection containing the provided BigIntegers.
     */
    protected abstract T createBigIntegerCollection(NumericCollection<BigInteger> source);

    /**
     * Verifies that a BigIntegers collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnABigIntegerCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, createBigIntegerCollection(DISTINCT_ELEMENTS, BigInteger.ONE).getElementCardinality());
    }

    /**
     * Verifies that a BigIntegers collection created from another collection has the same element cardinality and BigIntegers.
     */
    @Test
    public void ofWithCollectionShouldReturnABigIntegerCollectionWithTheSameElementCardinalityAndBigIntegers() {
        BigIntegerCollection source = BigIntegerCollection.of(DISTINCT_ELEMENTS, BigInteger.ONE);
        T actual = createBigIntegerCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains(BigInteger.ONE));
    }

    /**
     * Verifies that a BigIntegers collection created from another collection has the provided element cardinality.
     */
    @Test
    public void ofWithCollectionAndElementCardinalityShouldReturnABigIntegerCollectionWithTheProvidedElementCardinality() {
        BigIntegerCollection source = BigIntegerCollection.of(DUPLICATE_ELEMENTS, BigInteger.ONE, BigInteger.TWO, BigInteger.TWO, BIG_INTEGER_THREE);
        T actual = createBigIntegerCollection(DISTINCT_ELEMENTS, source);
        BigIntegerCollection expected = BigIntegerCollection.of(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertTrue(actual.containsSame(expected));
    }
}
