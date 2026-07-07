package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.BigIntegerCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class BigIntegerCollectionDecoratorTestBase<T extends NumericCollection<BigInteger>> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the BigIntegers 1, 2 and 3.
     */
    private final NumericCollection<BigInteger> collection123 = createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3L));

    /**
     * Creates an empty BigIntegers collection.
     *
     * @return An empty BigIntegers collection.
     */
    protected abstract T createEmptyBigIntegerCollection();

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
     * Creates a BigIntegers collection containing the provided BigIntegers.
     *
     * @param numbers The BigIntegers to be included in the BigIntegers collection.
     * @return An BigIntegers collection containing the provided BigIntegers.
     */
    protected abstract T createBigIntegerCollection(BigInteger... numbers);

    /**
     * Creates a BigIntegers collection from a collection of BigIntegers.
     *
     * @param source The collection of BigIntegers.
     * @return A BigIntegers collection containing the provided BigIntegers.
     */
    protected abstract T createBigIntegerCollection(NumericCollection<BigInteger> source);

    /**
     * Verifies that an empty BigIntegers collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyBigIntegerCollection() {
        assertTrue(createEmptyBigIntegerCollection().isEmpty());
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.contains(BigInteger.ONE));
        assertFalse(collection123.contains(BigInteger.ZERO));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.containsAll(createBigIntegerCollection(BigInteger.ONE)));
        assertFalse(collection123.containsAll(createBigIntegerCollection(BigInteger.ZERO)));
    }

    /**
     * Verifies that the <code>get</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.contains(collection123.get()));
    }

    /**
     * Verifies that the <code>spliterator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void spliteratorShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(THREE, collection123.spliterator().estimateSize());
    }

    /**
     * Verifies that the <code>toArray</code> method is wired correctly to the internal collection.
     */
    @Test
    public void toArrayShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(THREE, collection123.toArray().length);
    }
}
