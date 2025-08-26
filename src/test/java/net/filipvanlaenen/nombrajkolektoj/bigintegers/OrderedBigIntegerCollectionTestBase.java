package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
     * Creates an ordered BigIntegers collection containing the provided BigIntegers.
     *
     * @param numbers The BigIntegers to be included in the ordered BigIntegers collection.
     * @return An ordered BigIntegers collection containing the provided BigIntegers.
     */
    protected abstract T createOrderedBigIntegerCollection(BigInteger... numbers);

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(BigInteger.TWO, createOrderedBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE).getAt(1));
    }
}
